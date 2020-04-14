package it.dstech.owner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.model.Libro;
import it.dstech.model.Utente;
import it.dstech.repository.GestioneDB;

@WebServlet("/admin/stampa-utenti")
public class ListaUtenti extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			GestioneDB gestione = new GestioneDB();
			List<Utente> listaLibri = gestione.getListaUtenti();
			req.setAttribute("listaUtenti", listaLibri);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/listaUtenti.jsp").forward(req, resp);
	}
}
