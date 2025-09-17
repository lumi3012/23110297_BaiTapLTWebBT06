package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import decorator.constant.Constant;
import decorator.entity.User;
import decorator.service.UserService;
import decorator.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService = new UserServiceImpl();

    public RegisterController() {
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
            User u = new User();
            u.setUsername(req.getParameter("username"));
            u.setFullname(req.getParameter("fullname"));
            u.setPassword(req.getParameter("password"));
            u.setEmail(req.getParameter("email"));
            u.setPhone(req.getParameter("phone"));
            u.setRoleid(Constant.ROLE_USER);

            userService.register(u);
            resp.sendRedirect(req.getContextPath() + "/login");
        } catch (RuntimeException ex) {
            if ("username.exists".equals(ex.getMessage())) {
                req.setAttribute("error", Constant.MSG_USERNAME_EXISTS);
            } else if ("email.exists".equals(ex.getMessage())) {
                req.setAttribute("error", Constant.MSG_EMAIL_EXISTS);
            } else {
                req.setAttribute("error", "Registration failed!");
            }
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
        }
	}

}
