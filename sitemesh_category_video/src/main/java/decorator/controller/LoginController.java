package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import decorator.constant.Constant;
import decorator.entity.User;
import decorator.service.UserService;
import decorator.service.impl.UserServiceImpl;


@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService = new UserServiceImpl();

    public LoginController() {
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        User u = userService.login(username, password);
        if (u == null) {
            req.setAttribute("error", Constant.MSG_INVALID_LOGIN);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute(Constant.ATTR_USER, u);

        if ("on".equals(remember)) {
            Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, u.getUsername());
            cookie.setMaxAge(7 * 24 * 60 * 60);
            resp.addCookie(cookie);
        }

        resp.sendRedirect(req.getContextPath() + "/home");
	}

}
