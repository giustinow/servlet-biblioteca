package it.dstech.owner;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.repository.GestioneDB;
@WebServlet("/elimina-libro")
public class EliminaLibro extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			long id = Integer.parseInt(req.getParameter("id"));
		try {
				GestioneDB gestione = new GestioneDB();
				gestione.deleteLibro(id);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("stampa-libro").forward(req, resp);
		
	}
}
