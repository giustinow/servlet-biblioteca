package it.dstech.costumer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;

@WebServlet("/torna-al-profilo")
public class TornaAlProfiloDopoNoleggioOAcquisto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		try {
			GestioneDB gestione = new GestioneDB(); 
			gestione.deleteCarrello();
			String nome = gestione.retrieveNomeUtente(email);
			req.setAttribute("nome", nome);
			req.setAttribute("email", email);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("profiloUtente.jsp").forward(req, resp);
	}
}
