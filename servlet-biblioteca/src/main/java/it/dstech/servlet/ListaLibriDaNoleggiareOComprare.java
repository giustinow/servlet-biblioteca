package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.model.Libro;
import it.dstech.repository.GestioneDB;

@WebServlet("/stampa-libri-disponibili")
public class ListaLibriDaNoleggiareOComprare extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		try {
			GestioneDB gestione = new GestioneDB();
			List<Libro> listaLibri = gestione.getListaLibri();
			List<Libro> searchBoxLibro = null;
			req.setAttribute("listaLibri", listaLibri);
			req.setAttribute("search", searchBoxLibro);
			req.setAttribute("nome", nome);
			req.setAttribute("email", email);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("listaLibriDaNoleggiareOComprare.jsp").forward(req, resp);
	}
}
