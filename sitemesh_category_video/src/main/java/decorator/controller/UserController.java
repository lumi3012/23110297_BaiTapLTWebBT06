package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import decorator.entity.User;
import decorator.service.UserService;
import decorator.service.impl.UserServiceImpl;


@WebServlet(urlPatterns = {"/admin/users", "/admin/users/edit", "/admin/users/delete"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService = new UserServiceImpl();

    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = req.getServletPath();
        if (path.equals("/admin/users")) {
            List<User> list = userService.findAll();
            req.setAttribute("users", list);
            req.getRequestDispatcher("/WEB-INF/views/users/list.jsp").forward(req, resp);
        } else if (path.equals("/admin/users/edit")) {
            Long id = Long.valueOf(req.getParameter("id"));
            User u = userService.findById(id);
            req.setAttribute("user", u);
            req.getRequestDispatcher("/WEB-INF/views/users/edit.jsp").forward(req, resp);
        } else if (path.equals("/admin/users/delete")) {
            Long id = Long.valueOf(req.getParameter("id"));
            userService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        }
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("id");
        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        Integer roleid = Integer.valueOf(req.getParameter("roleid"));

        User u = userService.findById(Long.valueOf(id));
        u.setFullname(fullname);
        u.setPhone(phone);
        u.setEmail(email);
        u.setRoleid(roleid);

        userService.update(u);
        resp.sendRedirect(req.getContextPath() + "/admin/users");
	}

}
