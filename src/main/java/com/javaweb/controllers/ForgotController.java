package com.javaweb.controllers;

import java.io.IOException;

import com.javaweb.services.UserService;
import com.javaweb.services.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forgot-password")
public class ForgotController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			req.getRequestDispatcher("views/forgot-password.jsp").forward(req, resp);
			return;
		}
		// Check cookie
		req.getRequestDispatcher("views/forgot-password.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		UserService service = new UserServiceImpl();
		String alertMsg = "";
		if (!service.checkExistUsername(username)) {
			alertMsg = "Username không tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
			return;
		}
		if (newPassword != null && newPassword.equals(confirmPassword)) {
			if (username.isEmpty() || newPassword.isEmpty()) {
				alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
				return;
			}
			if (service.update(username, newPassword)) {
				alertMsg = "Đổi mật khẩu thành công!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			} else {
				alertMsg = "Mật khẩu mới và xác nhận mật khẩu không khớp.";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
			}
		}
	}
}