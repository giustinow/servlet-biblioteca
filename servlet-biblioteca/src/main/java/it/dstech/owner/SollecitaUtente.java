package it.dstech.owner;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;
import it.dstech.service.EmailUtility;

@WebServlet("/admin/sollecita")
public class SollecitaUtente extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String titolo = req.getParameter("titolo");
		try {
			GestioneDB gestione = new GestioneDB();
			String retrieveNomeUtente = gestione.retrieveNomeUtente(email);
			EmailUtility.sendEmail(email, "Ariconsegna il libro", generaLinkValidazioneUtente(email, retrieveNomeUtente, titolo));
		} catch (ClassNotFoundException | AddressException |IOException | SQLException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/admin/stampa-noleggi").forward(req, resp);
	}
	private  String generaLinkValidazioneUtente(String email, String nomeUtente, String titolo){
		String validationPath = "http://localhost:8080/servlet-biblioteca/";
		String testo = "Hey " + nomeUtente +"! Lo sai che '" + titolo + "' non te l'abbiamo regalato? Che aspetti a ridarcelo?";
		return testo + "Sbrigati, clicca su questo link: " + validationPath + email;
	}

}
