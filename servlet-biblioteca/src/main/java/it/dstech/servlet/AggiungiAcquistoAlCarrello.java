package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.model.Carrello;
import it.dstech.repository.GestioneDB;

@WebServlet("/acquista-libro")
public class AggiungiAcquistoAlCarrello extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String nome = req.getParameter("nome");
		int quantita = Integer.parseInt(req.getParameter("quantita"));
		double prezzo = Double.parseDouble(req.getParameter("prezzo"));
		long idLibro = Long.parseLong(req.getParameter("idLibro"));
		String titolo = req.getParameter("titolo");
		double totale = quantita * prezzo;
		try {
			Carrello carrello = new Carrello(0, email, idLibro, titolo, quantita, "Acquisto", prezzo, totale);
			GestioneDB gestione = new GestioneDB();
			if(gestione.checkQuantitaLibriResidua(idLibro, quantita)) {
			gestione.aggiungiAcquistoACarrello(carrello);
			gestione.updateQuantitaLibri(quantita, idLibro);
			gestione.updateQuantitaVenduta(quantita, idLibro);
			req.setAttribute("listaLibri", gestione.getListaLibri());
			req.setAttribute("email", email);
			req.setAttribute("nome", nome);
			req.getRequestDispatcher("listaLibriDaNoleggiareOComprare.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("listaLibri", gestione.getListaLibri());
				req.setAttribute("email", email);
				req.setAttribute("nome", nome);
				req.setAttribute("messaggio", "Errore, hai messo più libri del dovuto!");
			req.getRequestDispatcher("listaLibriDaNoleggiareOComprare.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public static String currentDate() {
		Date todaysDate = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(todaysDate);
	}
}
