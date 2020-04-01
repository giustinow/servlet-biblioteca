package it.dstech.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

public class GestioneDB extends HttpServlet{
	private String username;
	private String password;
	private String url;
	private Connection connessione;
	private Statement statement;
	private Properties properties = new Properties();
	
	public GestioneDB() throws IOException, SQLException {
		properties.load(getServletContext().getResourceAsStream("/WEB-INF/file.properties"));
		this.username = properties.getProperty("db.username");
		this.password = properties.getProperty("db.password");
		this.url = properties.getProperty("db.url");
		this.connessione = DriverManager.getConnection(url, username, password);
		this.statement = connessione.createStatement();
	}

}
