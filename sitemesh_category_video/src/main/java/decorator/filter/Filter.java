package decorator.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import decorator.constant.Constant;
import decorator.entity.User;
import decorator.service.UserService;
import decorator.service.impl.UserServiceImpl;


@WebFilter("/*")
public class Filter implements jakarta.servlet.Filter {
	private final UserService userService = new UserServiceImpl();

    public Filter() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getServletPath();

        // Cho phép truy cập login, register, forgot, waiting, css/js
        if (path.startsWith("/login") || path.startsWith("/register") ||
            path.startsWith("/forgot") || path.startsWith("/waiting") ||
            path.startsWith("/css") || path.startsWith("/js")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute(Constant.ATTR_USER) : null;

        // Nếu chưa login, kiểm tra cookie remember-me
        if (user == null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (Constant.COOKIE_REMEMBER.equals(c.getName())) {
                        User u = userService.findByUsername(c.getValue());
                        if (u != null) {
                            req.getSession().setAttribute(Constant.ATTR_USER, u);
                            user = u;
                        }
                        break;
                    }
                }
            }
        }

        // Nếu vẫn chưa login
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Kiểm soát phân quyền cho category
        if (path.startsWith("/category")) {
            if (user.getRoleid() == Constant.ROLE_USER) {
                // User thường chỉ được xem category của chính mình
                if (!"/category".equals(path)) {
                    resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
                    return;
                }
            }
        }

        chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
