package it.dstech.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;

@WebServlet("/validazione")
public class ValidazioneEmail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		try {
			GestioneDB gestione = new GestioneDB();
			gestione.updateStatoActive(email);
			gestione.close();
			req.setAttribute("message", "L'utente " + email + " è stato validato");
			req.getRequestDispatcher("home.jsp").forward(req, resp);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
