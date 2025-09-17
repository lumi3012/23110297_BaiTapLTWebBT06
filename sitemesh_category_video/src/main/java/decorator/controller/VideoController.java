package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.List;

import decorator.entity.Video;
import decorator.service.CategoryService;
import decorator.service.VideoService;
import decorator.service.impl.CategoryServiceImpl;
import decorator.service.impl.VideoServiceImpl;


@WebServlet(urlPatterns = {"/video", "/video/create", "/video/edit", "/video/delete", "/video/search"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 50 * 1024 * 1024)
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final VideoService videoService = new VideoServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/video")) {
            List<Video> list = videoService.findAll();
            req.setAttribute("videos", list);
            req.getRequestDispatcher("/WEB-INF/views/video/list.jsp").forward(req, resp);

        } else if (path.equals("/video/create")) {
            req.setAttribute("categories", categoryService.list());
            req.getRequestDispatcher("/WEB-INF/views/video/create.jsp").forward(req, resp);

        } else if (path.equals("/video/edit")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Video v = videoService.findById(id);
            req.setAttribute("video", v);
            req.setAttribute("categories", categoryService.list());
            req.getRequestDispatcher("/WEB-INF/views/video/edit.jsp").forward(req, resp);

        } else if (path.equals("/video/delete")) {
            Long id = Long.valueOf(req.getParameter("id"));
            videoService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/video");

        } else if (path.equals("/video/search")) {
            String keyword = req.getParameter("keyword");
            List<Video> list = videoService.search(keyword);
            req.setAttribute("videos", list);
            req.getRequestDispatcher("/WEB-INF/views/video/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/video/create")) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String genre = req.getParameter("genre");
            Long categoryId = Long.valueOf(req.getParameter("categoryId"));

            // xử lý upload file video
            Part filePart = req.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            String uploadDir = req.getServletContext().getRealPath("/uploads");
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            filePart.write(uploadDir + File.separator + fileName);

            Video v = new Video();
            v.setTitle(title);
            v.setDescription(description);
            v.setGenre(genre);
            v.setCategory(categoryService.findById(categoryId));
            v.setPath("/uploads/" + fileName);

            videoService.create(v);
            resp.sendRedirect(req.getContextPath() + "/video");

        } else if (path.equals("/video/edit")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Video v = videoService.findById(id);

            v.setTitle(req.getParameter("title"));
            v.setDescription(req.getParameter("description"));
            v.setGenre(req.getParameter("genre"));
            v.setCategory(categoryService.findById(Long.valueOf(req.getParameter("categoryId"))));

            Part filePart = req.getPart("file");
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = filePart.getSubmittedFileName();
                String uploadDir = req.getServletContext().getRealPath("/uploads");
                File dir = new File(uploadDir);
                if (!dir.exists()) dir.mkdirs();

                filePart.write(uploadDir + File.separator + fileName);
                v.setPath("/uploads/" + fileName);
            }

            videoService.update(v);
            resp.sendRedirect(req.getContextPath() + "/video");
        }
    }

}
