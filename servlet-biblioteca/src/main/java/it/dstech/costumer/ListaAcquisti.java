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

@WebServlet("/utente/storico-acquisti")
public class ListaAcquisti extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		try {
			GestioneDB gestione = new GestioneDB();
			req.setAttribute("restituito", gestione.getListaAcquisti(email));
			req.setAttribute("email", email);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/listaAcquisti.jsp").forward(req, resp);
	
	
	}
}
