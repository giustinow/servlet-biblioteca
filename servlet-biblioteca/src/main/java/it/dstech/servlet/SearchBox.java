package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;

@WebServlet("/search")
public class SearchBox extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String testo = req.getParameter("testo");
		try {
			GestioneDB gestione = new GestioneDB();
			req.setAttribute("search", gestione.getSearchBoxLibro(testo));
			req.setAttribute("listaLibri", null);
			req.setAttribute("nome", req.getParameter("nome"));
			req.setAttribute("email", req.getParameter("email"));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("listaLibriDaNoleggiareOComprare.jsp").forward(req, resp);
	}
}
