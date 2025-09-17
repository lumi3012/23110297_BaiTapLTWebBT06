package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import decorator.entity.Category;
import decorator.service.CategoryService;
import decorator.service.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = {"/category", "/category/create", "/category/edit", "/category/delete"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryService cateService = new CategoryServiceImpl();

    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = req.getServletPath();
        if (path.equals("/category")) {
            List<Category> list = cateService.list();
            req.setAttribute("categories", list);
            req.getRequestDispatcher("/WEB-INF/views/category/list.jsp").forward(req, resp);
        } else if (path.equals("/category/create")) {
            req.getRequestDispatcher("/WEB-INF/views/category/create.jsp").forward(req, resp);
        } else if (path.equals("/category/edit")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Category c = cateService.findById(id);
            req.setAttribute("category", c);
            req.getRequestDispatcher("/WEB-INF/views/category/edit.jsp").forward(req, resp);
        } else if (path.equals("/category/delete")) {
            Long id = Long.valueOf(req.getParameter("id"));
            cateService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/category");
        }
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = req.getServletPath();
        if (path.equals("/category/create")) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String type = req.getParameter("type");

            Category c = new Category();
            c.setName(name);
            c.setDescription(description);
            c.setType(type);
            //c.setActive(true);

            cateService.create(c);
            resp.sendRedirect(req.getContextPath() + "/category");

        } else if (path.equals("/category/edit")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Category c = cateService.findById(id);

            c.setName(req.getParameter("name"));
            c.setDescription(req.getParameter("description"));
            c.setType(req.getParameter("type"));
            //c.setActive(req.getParameter("active") != null);

            cateService.update(c);
            resp.sendRedirect(req.getContextPath() + "/category");
        }
	}

}
