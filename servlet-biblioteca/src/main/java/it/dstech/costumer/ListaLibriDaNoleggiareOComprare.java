package it.dstech.costumer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.model.Libro;
import it.dstech.repository.GestioneDB;

@WebServlet("/utente/stampa-libri-disponibili")
public class ListaLibriDaNoleggiareOComprare extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60);
		String email = (String) session.getAttribute("email");
		String nome = (String) session.getAttribute("nome");
		try {
			if (email != null) {
				GestioneDB gestione = new GestioneDB();
				List<Libro> listaLibri = gestione.getListaLibri();
				List<Libro> searchBoxLibro = null;
				req.setAttribute("listaLibri", listaLibri);
				req.setAttribute("search", searchBoxLibro);
				req.setAttribute("nome", nome);
				req.setAttribute("email", email);
				req.getRequestDispatcher("/listaLibriDaNoleggiareOComprare.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("sessioneScaduta.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
