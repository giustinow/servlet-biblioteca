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

@WebServlet("/stampa-noleggi")
public class NoleggiAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			GestioneDB gestione = new GestioneDB();
			req.setAttribute("noleggi", gestione.getListaNoleggiInCorsoAdmin());
			req.setAttribute("noleggiRestituiti", gestione.getListaNoleggiInRestituitiAdmin());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("listaLibriNoleggiatiERestituitiAdmin.jsp").forward(req, resp);
	}

	public static String currentDate() {
		Date todaysDate = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 return df.format(todaysDate); 
	}
}
