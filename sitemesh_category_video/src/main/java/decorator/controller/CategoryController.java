package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import decorator.constant.Constant;
import decorator.entity.User;
import decorator.service.CategoryService;
import decorator.service.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = {"/category", "/category/create", "/category/edit", "/category/delete"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryService categoryService = new CategoryServiceImpl();

    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = req.getServletPath();
        User u = (User) req.getSession().getAttribute(Constant.ATTR_USER);

        switch (path) {
            case "/category":
                req.setAttribute("categories", categoryService.list());
                if (u.getRoleid() == Constant.ROLE_ADMIN) {
                    req.getRequestDispatcher("/WEB-INF/views/cate_admin.jsp").forward(req, resp);
                } else if (u.getRoleid() == Constant.ROLE_MANAGER) {
                    req.getRequestDispatcher("/WEB-INF/views/cate_manager.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/WEB-INF/views/cate_user.jsp").forward(req, resp);
                }
                break;
            case "/category/create":
                req.getRequestDispatcher("/WEB-INF/views/category/create.jsp").forward(req, resp);
                break;
            case "/category/edit":
                req.setAttribute("id", req.getParameter("id"));
                req.getRequestDispatcher("/WEB-INF/views/category/edit.jsp").forward(req, resp);
                break;
            case "/category/delete":
                doPost(req, resp);
                break;
        }
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = req.getServletPath();
        User u = (User) req.getSession().getAttribute(Constant.ATTR_USER);

        if (u.getRoleid() == Constant.ROLE_USER) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
            return;
        }

        switch (path) {
            case "/category/create":
                categoryService.create(new decorator.entity.Category(null,
                        req.getParameter("name"),
                        req.getParameter("description")));
                resp.sendRedirect(req.getContextPath() + "/category");
                break;
            case "/category/edit":
                Long id = Long.valueOf(req.getParameter("id"));
                categoryService.update(new decorator.entity.Category(
                        id,
                        req.getParameter("name"),
                        req.getParameter("description")
                ));
                resp.sendRedirect(req.getContextPath() + "/category");
                break;
            case "/category/delete":
                Long delId = Long.valueOf(req.getParameter("id"));
                categoryService.delete(delId);
                resp.sendRedirect(req.getContextPath() + "/category");
                break;
        }
	}

}
