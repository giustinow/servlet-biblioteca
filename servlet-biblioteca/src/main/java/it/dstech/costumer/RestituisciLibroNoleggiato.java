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

@WebServlet("/utente/restituisci-libro-noleggiato")
public class RestituisciLibroNoleggiato extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		String nome = (String) session.getAttribute("nome");
		long idLibro = Long.parseLong(req.getParameter("idLibro"));
		try {
			GestioneDB gestione = new GestioneDB();
			req.setAttribute("email", email);
			req.setAttribute("nome", nome);
			req.setAttribute("idLibro", idLibro);
			gestione.updateStatoNoleggio(email, idLibro);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("restituzioneNoleggioRiuscita.jsp").forward(req, resp);
	}
}
