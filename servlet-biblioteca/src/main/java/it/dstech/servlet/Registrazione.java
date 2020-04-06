package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.model.Utente;
import it.dstech.repository.GestioneDB;
import it.dstech.service.EmailUtility;

@WebServlet("/registrazione")
public class Registrazione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		int eta = Integer.parseInt(req.getParameter("eta"));
		String sesso = req.getParameter("sesso");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Utente utente = new Utente(nome, cognome, eta, sesso, email, password, false);
		GestioneDB gestione = null;
		try {
			gestione = new GestioneDB();
			if (gestione.checkEsistenzaUtente(email)) {
				gestione.aggiungiNuovoUtente(utente);
				req.setAttribute("nome", nome);
				req.setAttribute("email", email);
				EmailUtility.sendEmail(utente.getEmail(), "Conferma Mail", generaLinkValidazioneUtente(utente));
				gestione.close();
				req.setAttribute("message", "Controlla la mail per attivare l'account");
				req.getRequestDispatcher("home.jsp").forward(req, resp);				
			}else {
				req.getRequestDispatcher("utenteGiaRegistrato.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException | MessagingException e) {
			try {
				gestione.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			req.setAttribute("message", "Mail già presente nel DB");
			req.getRequestDispatcher("home.jsp").forward(req, resp);

		}
	}
	private String generaLinkValidazioneUtente(Utente utente) {
		String validationPath = "http://localhost:8080/servlet-biblioteca/validazione?email=";
		return "Per attivare la mail clicca su questo link: " + validationPath + utente.getEmail();
	}
}
