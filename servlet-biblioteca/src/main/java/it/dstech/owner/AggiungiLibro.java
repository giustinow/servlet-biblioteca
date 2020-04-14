package it.dstech.owner;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.model.Libro;
import it.dstech.repository.GestioneDB;

@WebServlet("/admin/aggiunta-libro")
public class AggiungiLibro extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titolo = req.getParameter("titolo");
		String autore = req.getParameter("autore");
		int quantita = Integer.parseInt(req.getParameter("quantita"));
		double prezzo = Double.parseDouble(req.getParameter("prezzo"));
		try {
			GestioneDB gestione = new GestioneDB();
			if(gestione.checkEsistenzaTitoloLibro(titolo) && gestione.checkEsistenzaAutoreLibro(autore)) {
			gestione.aggiungiLibroSenzaId(titolo, autore, quantita, prezzo);
			long id = gestione.retrieveIdLibro();
			Libro libro = new Libro(id, titolo, autore, quantita, prezzo);
			gestione.aggiungiLibroAlleVendite(libro);
			req.getRequestDispatcher("/aggiuntaLibroRiuscita.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/erroreAggiuntaLibro.jsp").forward(req, resp);	
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
