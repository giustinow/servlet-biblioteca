package it.dstech.costumer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;
@WebServlet("/storico-noleggi")
public class ListaNoleggi extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		try {
			GestioneDB gestione = new GestioneDB();
			req.setAttribute("noleggiato", gestione.getListaNoleggiInCorso(email));
			req.setAttribute("restituito", gestione.getListaNoleggiInRestituiti(email));
			req.setAttribute("email", email);
			req.setAttribute("nome", req.getParameter("nome"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("listaNoleggi.jsp").forward(req, resp);
	
	}
}
