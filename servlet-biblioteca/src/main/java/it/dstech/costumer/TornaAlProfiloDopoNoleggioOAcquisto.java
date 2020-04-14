package it.dstech.costumer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.repository.GestioneDB;

@WebServlet("/utente/torna-al-profilo")
public class TornaAlProfiloDopoNoleggioOAcquisto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		try {
			if(email!=null) {
			GestioneDB gestione = new GestioneDB();
			gestione.deleteCarrello();
			String immagineUtente = gestione.getImmagineUtente(email);
			req.setAttribute("immagine", immagineUtente);
			req.setAttribute("nome",  gestione.retrieveNomeUtente(email));
			req.setAttribute("email", email);
			req.getRequestDispatcher("/profiloUtente.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("home").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
