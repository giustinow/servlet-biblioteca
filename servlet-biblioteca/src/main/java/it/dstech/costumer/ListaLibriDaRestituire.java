package it.dstech.costumer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;

@WebServlet("/lista-restituzione")
public class ListaLibriDaRestituire extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String nome = req.getParameter("nome");
		try {
			GestioneDB gestione = new GestioneDB();
			gestione.getListaNoleggiInCorso(email);
			req.setAttribute("noleggiato", gestione.getListaNoleggiInCorso(email));
			req.setAttribute("nome", nome);
			req.setAttribute("email", email);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("listaNoleggiDaRestituire.jsp").forward(req, resp);
	}
}
