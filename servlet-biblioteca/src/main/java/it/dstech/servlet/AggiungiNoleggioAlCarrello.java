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

import it.dstech.model.Noleggio;
import it.dstech.repository.GestioneDB;

@WebServlet("/noleggia-libro")
public class AggiungiNoleggioAlCarrello extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String nome = req.getParameter("nome");
		String titolo = req.getParameter("titolo");
		long idLibro = Long.parseLong(req.getParameter("idLibro"));
		try {
			GestioneDB gestione = new GestioneDB();
			if (gestione.checkPresenzaLibroNoleggiato(idLibro, email)) {
				gestione.aggiungiNoleggioACarrello(email, idLibro, titolo);
				gestione.updateQuantitaLibri(1, idLibro);
				gestione.updateQuantitaVenduta(1, idLibro);
				req.setAttribute("listaLibri", gestione.getListaLibri());			
				req.setAttribute("email", email);
				req.setAttribute("nome", nome);
				req.setAttribute("titolo", titolo);	
				req.getRequestDispatcher("listaLibriDaNoleggiareOComprare.jsp").forward(req, resp);
			}else {
				req.setAttribute("listaLibri", gestione.getListaLibri());
			req.setAttribute("listaLibri", gestione.getListaLibri());
			req.setAttribute("email", email);
			req.setAttribute("nome", nome);
			req.setAttribute("messaggio", "Questo libro l'hai gia noleggiato e devi restituirlo");
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
