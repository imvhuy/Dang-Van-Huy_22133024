package com.javaweb.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import com.javaweb.models.CategoryModel;
import com.javaweb.services.ICategoryService;
import com.javaweb.services.impl.CategoryServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert", "/admin/category/delete", "/admin/category/edit", "/admin/category/update"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		} else if (url.contains("/admin/categories")) {
			List<CategoryModel> list = categoryService.findAll();
			req.setAttribute("cateList", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/category/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			categoryService.delete(id);
			resp.sendRedirect(req.getContextPath()+ "/admin/categories");
		}
		else if (url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel category = categoryService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			String categoryName = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String image = req.getParameter("image");
			CategoryModel category = new CategoryModel();
			category.setCategoryName(categoryName);
			category.setImage(image);
			category.setStatus(status);
			String fname = "";
			String uploadPath = "D:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("image1");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload file
					part.write(uploadPath + "/" + fname);
					//ghi ten file vao data
					category.setImage(fname);
				
				} else if (image != null){
					category.setImage(image);
				}
				else {
					category.setImage("avata.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			categoryService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		else if (url.contains("/admin/category/update")) {
			int id = Integer.parseInt(req.getParameter("categoryid"));
			String categoryName = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String image = req.getParameter("image");
			CategoryModel category = new CategoryModel();
			String fname = "";
			String uploadPath = "D:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("image1");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload file
					part.write(uploadPath + "/" + fname);
					//ghi ten file vao data
					category.setImage(fname);
				
				} else if (image != null){
					category.setImage(image);
				}
				else {
					category.setImage("avata.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			category.setCategoryId(id);
			category.setCategoryName(categoryName);
			category.setStatus(status);
			categoryService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}
