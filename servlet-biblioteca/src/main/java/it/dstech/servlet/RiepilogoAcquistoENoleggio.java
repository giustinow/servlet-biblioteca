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

import it.dstech.repository.GestioneDB;

@WebServlet("/riepilogo-acquisto-noleggio")
public class RiepilogoAcquistoENoleggio extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			GestioneDB gestione = new GestioneDB();
			gestione.aggiuntaCarrelloAcquistoATabellaAcquisto(currentDate());
			gestione.aggiuntaCarrelloNoleggioATabellaNoleggio(currentDate());
			req.setAttribute("listaCarrello", gestione.getListaCarrello());
			req.setAttribute("email", req.getParameter("email"));
			req.setAttribute("nome", req.getParameter("nome"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("riepilogoNoleggioEAcquisto.jsp").forward(req, resp);
	}	
	public static String currentDate() {
		Date todaysDate = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(todaysDate);
	}
}
