package it.dstech.owner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/profilo")
public class ProfiloAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		if(email != null) {
			req.getRequestDispatcher("/admin.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/home").forward(req, resp);
		}
	}
}
