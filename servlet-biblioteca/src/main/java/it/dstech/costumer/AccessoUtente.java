package it.dstech.costumer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;

@WebServlet("/accesso")
public class AccessoUtente extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
			GestioneDB gestione = new GestioneDB();
			gestione.deleteCarrello();
			if (email.equals("admin@admin.it") && password.equals("password")) {
				gestione.close();
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			} else if (!gestione.checkEsistenzaUtente(email) && !gestione.checkPasswordValida(email, password)) {
				if (!gestione.checkActive(email)) {
					String nome = gestione.retrieveNomeUtente(email);
					req.setAttribute("email", email);
					req.setAttribute("nome", nome);
					gestione.close();
					req.getRequestDispatcher("profiloUtente.jsp").forward(req, resp);
				} else {
					gestione.close();
				req.getRequestDispatcher("emailNonAttiva.jsp").forward(req, resp);
				}
			} else {
				gestione.close();
			req.getRequestDispatcher("erroreAutenticazione.jsp").forward(req, resp);
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
