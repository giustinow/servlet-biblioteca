package it.dstech.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import it.dstech.model.Acquisto;
import it.dstech.model.Carrello;
import it.dstech.model.Libro;
import it.dstech.model.Noleggio;
import it.dstech.model.Utente;
import it.dstech.model.Vendite;

public class GestioneDB {
	private String username;
	private String password;
	private String url;
	private Connection connessione;
	private Statement statement;

	public GestioneDB() throws IOException, SQLException, ClassNotFoundException {
		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("file.properties"));

		Class.forName(properties.getProperty("db.drive"));
		this.username = properties.getProperty("db.username");
		this.password = properties.getProperty("db.password");
		this.url = properties.getProperty("db.url");
		this.connessione = DriverManager.getConnection(url, username, password);
		this.statement = connessione.createStatement();
	}
	public void close() throws SQLException {
		this.connessione.close();
	}

//////////////////Aggiunta
	public void aggiungiNuovoUtente(Utente utente) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.utente ( nome, cognome, eta, `sesso`, email, password, active) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setString(1, utente.getNome());
		statement.setString(2, utente.getCognome());
		statement.setInt(3, utente.getEta());
		statement.setString(4, utente.getSesso());
		statement.setString(5, utente.getEmail());
		statement.setString(6, utente.getPassword());
		statement.setBoolean(7, utente.isActive());
		statement.execute();
	}
	public void aggiuntaCarrelloAcquistoATabellaAcquisto(String data) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.acquisto ( email, idLibro, titolo, `data`, quantita, prezzo, totale) SELECT  email, idLibro, titolo,  ?, quantita, prezzo, totale FROM biblioteca.carrello WHERE tipo = 'Acquisto';";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setString(1, data);
		statement.execute();
	}

	public void aggiuntaCarrelloNoleggioATabellaNoleggio(String data) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.noleggio (email, idLibro, titolo, `data`) SELECT  email, idLibro, titolo,  ? FROM biblioteca.carrello WHERE tipo = 'Noleggio';";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setString(1, data);
		statement.execute();
	}

	public void aggiungiNoleggioACarrello(String email, long idLibro, String titolo) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.carrello (`id`, `email`, `idLibro`, titolo, tipo) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setLong(1, 0);
		statement.setString(2, email);
		statement.setLong(3, idLibro);
		statement.setString(4, titolo);
		statement.setString(5, "Noleggio");
		statement.execute();
	}

	public void aggiungiAcquistoACarrello(Carrello carrello) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.carrello (`id`, `email`, `idLibro`, titolo,  quantita, `tipo`, prezzo, totale) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setLong(1, carrello.getId());
		statement.setString(2, carrello.getEmail());
		statement.setLong(3, carrello.getIdLibro());
		statement.setString(4, carrello.getTitolo());
		statement.setInt(5, carrello.getQuantita());
		statement.setString(6, carrello.getTipo());
		statement.setDouble(7, carrello.getPrezzo());
		statement.setDouble(8, carrello.getTotale());
		statement.execute();

	}

	public void acquistaLibro(String titolo, String utente, String data, int quantita, double prezzo)
			throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.acquisto (`libro`, `utente`, `data`, quantita, `prezzo`) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setString(1, titolo);
		statement.setString(2, utente);
		statement.setString(3, data);
		statement.setDouble(4, quantita);
		statement.setDouble(5, prezzo);
		statement.execute();
	}

	public void aggiungiLibroAlleVendite(Libro libro) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.vendite (`id`, `titolo`, `autore`, `quantita`) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setLong(1, libro.getId());
		statement.setString(2, libro.getTitolo());
		statement.setString(3, libro.getAutore());
		statement.setInt(4, 0);
		statement.execute();
	}

	public void aggiungiLibroSenzaId(String titolo, String autore, int quantita, double prezzo) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.libro (`titolo`, `autore`, `quantita`, `prezzo`) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setString(1, titolo);
		statement.setString(2, autore);
		statement.setInt(3, quantita);
		statement.setDouble(4, prezzo);
		statement.execute();
	}

	public void aggiungiProdottoAlleVendite(String titolo, String autore) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.vendite (`titolo`,`autore`, `quantita`) VALUES (?, ?, ?)";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setString(1, titolo);
		statement.setString(2, autore);
		statement.setInt(3, 0);
		statement.execute();
	}

	public void noleggioLibroUtente(Noleggio noleggio) throws SQLException {
		String queryInserimento = "INSERT INTO biblioteca.noleggio (`idLibro`, `email`,`libro`, `data`) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connessione.prepareStatement(queryInserimento);
		statement.setLong(1, noleggio.getIdLibro());
		statement.setString(2, noleggio.getEmail());
		statement.setString(3, noleggio.getTitolo());
		statement.setString(4, noleggio.getData());
		statement.execute();

	}

///////////////Retrieve
	public List<Acquisto> getListaAcquisti(String indirizzoMail) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.acquisto where email = ?");
		statement.setString(1, indirizzoMail);
		ResultSet risultatoQuery = statement.executeQuery();
		List<Acquisto> elencoAcquisti = new ArrayList<Acquisto>();
		while (risultatoQuery.next()) {
			long id = risultatoQuery.getLong("id");
			String email = risultatoQuery.getString("email");
			long idLibro = risultatoQuery.getLong("idLibro");
			String titolo = risultatoQuery.getString("titolo");
			String data = risultatoQuery.getString("data");
			int quantita = risultatoQuery.getInt("quantita");
			double prezzo = risultatoQuery.getDouble("prezzo");
			double totale = risultatoQuery.getDouble("totale");
			Acquisto acquisto = new Acquisto(id, email, idLibro, titolo, data, quantita, prezzo, totale);
			elencoAcquisti.add(acquisto);
		}
		return elencoAcquisti;
	}
	public List<Noleggio> getListaNoleggiInCorso(String indirizzoMail) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.noleggio where email = ? AND stato = 'Noleggiato'");
		statement.setString(1, indirizzoMail);
		ResultSet risultatoQuery = statement.executeQuery();
		List<Noleggio> elencoNoleggiInCorso = new ArrayList<Noleggio>();
		while (risultatoQuery.next()) {
			String email = risultatoQuery.getString("email");
			long idLibro = risultatoQuery.getLong("idLibro");
			String titolo = risultatoQuery.getString("titolo");
			String data = risultatoQuery.getString("data");
			String stato = risultatoQuery.getString("stato");
			Noleggio noleggio = new Noleggio(email, idLibro, titolo, data, stato);
			elencoNoleggiInCorso.add(noleggio);
		}
		return elencoNoleggiInCorso;
	}
	public List<Noleggio> getListaNoleggiInRestituiti(String indirizzoMail) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.noleggio where email = ? AND stato = 'Restituito'");
		statement.setString(1, indirizzoMail);
		ResultSet risultatoQuery = statement.executeQuery();
		List<Noleggio> elencoNoleggiInRestituiti = new ArrayList<Noleggio>();
		while (risultatoQuery.next()) {
			String email = risultatoQuery.getString("email");
			long idLibro = risultatoQuery.getLong("idLibro");
			String titolo = risultatoQuery.getString("titolo");
			String data = risultatoQuery.getString("data");
			String stato = risultatoQuery.getString("stato");
			Noleggio noleggio = new Noleggio(email, idLibro, titolo, data, stato);
			elencoNoleggiInRestituiti.add(noleggio);
		}
		return elencoNoleggiInRestituiti;
	}
	public List<Vendite> getListaVendite() throws SQLException, ClassNotFoundException {
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.vendite");
		List<Vendite> elencoVendite = new ArrayList<Vendite>();
		ResultSet risultatoQuery = statement.executeQuery();
		while (risultatoQuery.next()) {
			String titolo = risultatoQuery.getString("titolo");
			String autore = risultatoQuery.getString("autore");
			int quantita = risultatoQuery.getInt("quantita");
			Vendite vendite = new Vendite(titolo, autore, quantita);
			elencoVendite.add(vendite);
		}
		return elencoVendite;
	}

	public List<Libro> getListaLibri() throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.libro");
		List<Libro> elencoMagazzino = new ArrayList<Libro>();
		ResultSet risultatoQuery = statement.executeQuery();
		while (risultatoQuery.next()) {
			long id = risultatoQuery.getLong("id");
			String titolo = risultatoQuery.getString("titolo");
			String autore = risultatoQuery.getString("autore");
			int quantita = risultatoQuery.getInt("quantita");
			double prezzo = risultatoQuery.getInt("prezzo");
			Libro libro = new Libro(id, titolo, autore, quantita, prezzo);
			elencoMagazzino.add(libro);
		}
		return elencoMagazzino;
	}

	public List<Utente> getListaUtenti() throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.utente");
		List<Utente> elencoMagazzino = new ArrayList<Utente>();
		ResultSet risultatoQuery = statement.executeQuery();
		while (risultatoQuery.next()) {
			String nome = risultatoQuery.getString("nome");
			String cognome = risultatoQuery.getString("cognome");
			int eta = risultatoQuery.getInt("eta");
			String sesso = risultatoQuery.getString("sesso");
			String email = risultatoQuery.getString("email");
			String password = risultatoQuery.getString("password");
			boolean active = risultatoQuery.getBoolean("active");
			Utente utente = new Utente(nome, cognome, eta, sesso, email, password, active);
			elencoMagazzino.add(utente);
		}
		return elencoMagazzino;
	}

	public String retrieveNomeUtente(String email) throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("select nome from biblioteca.utente where email = ?");
		statement.setString(1, email);
		ResultSet risultatoQuery = statement.executeQuery();
		String nome = "";
		while (risultatoQuery.next()) {
			nome = risultatoQuery.getString("nome");
		}
		return nome;
	}

	public long retrieveIdLibro() throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("select id from biblioteca.libro order by id desc limit 1");
		ResultSet risultatoQuery = statement.executeQuery();
		long id = 0;
		while (risultatoQuery.next()) {
			id = risultatoQuery.getLong("id");
		}
		return id;
	}

	public List<Carrello> getListaCarrello() throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.carrello");
		List<Carrello> elencoCarrello = new ArrayList<Carrello>();
		ResultSet risultatoQuery = statement.executeQuery();
		while (risultatoQuery.next()) {
			long id = risultatoQuery.getLong("id");
			String email = risultatoQuery.getString("email");
			long idLibro = risultatoQuery.getLong("idLibro");
			String titolo = risultatoQuery.getString("titolo");
			int quantita = risultatoQuery.getInt("quantita");
			String tipo = risultatoQuery.getString("tipo");
			double prezzo = risultatoQuery.getDouble("prezzo");
			double totale = risultatoQuery.getDouble("totale");
			Carrello carrello = new Carrello(id, email, idLibro, titolo, quantita, tipo, prezzo, totale);
			elencoCarrello.add(carrello);
		}
		return elencoCarrello;
	}
	public List<Libro> getSearchBoxLibro(String testo) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM biblioteca.libro where (titolo OR autore like ?)");
		statement.setString(1, testo + "%");
		ResultSet risultatoQuery = statement.executeQuery();
		List<Libro> elencoLibri = new ArrayList<Libro>();
		while (risultatoQuery.next()) {
			long id = risultatoQuery.getLong("id");
			String titolo = risultatoQuery.getString("titolo");
			String autore = risultatoQuery.getString("autore");
			int quantita = risultatoQuery.getInt("quantita");
			double prezzo = risultatoQuery.getInt("prezzo");
			Libro libro = new Libro(id, titolo, autore, quantita, prezzo);
			elencoLibri.add(libro);
		}
		return elencoLibri;
	}
	public List<Noleggio> getListaNoleggiInCorsoAdmin() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.noleggio where stato = 'Noleggiato'");
		ResultSet risultatoQuery = statement.executeQuery();
		List<Noleggio> elencoNoleggiInCorso = new ArrayList<Noleggio>();
		while (risultatoQuery.next()) {
			String email = risultatoQuery.getString("email");
			long idLibro = risultatoQuery.getLong("idLibro");
			String titolo = risultatoQuery.getString("titolo");
			String data = risultatoQuery.getString("data");
			String stato = risultatoQuery.getString("stato");
			Noleggio noleggio = new Noleggio(email, idLibro, titolo, data, stato);
			elencoNoleggiInCorso.add(noleggio);
		}
		return elencoNoleggiInCorso;
	}
	public List<Noleggio> getListaNoleggiInRestituitiAdmin() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("select * from biblioteca.noleggio where stato = 'Restituito'");
		ResultSet risultatoQuery = statement.executeQuery();
		List<Noleggio> elencoNoleggiInRestituiti = new ArrayList<Noleggio>();
		while (risultatoQuery.next()) {
			String email = risultatoQuery.getString("email");
			long idLibro = risultatoQuery.getLong("idLibro");
			String titolo = risultatoQuery.getString("titolo");
			String data = risultatoQuery.getString("data");
			String stato = risultatoQuery.getString("stato");
			Noleggio noleggio = new Noleggio(email, idLibro, titolo, data, stato);
			elencoNoleggiInRestituiti.add(noleggio);
		}
		return elencoNoleggiInRestituiti;
	}
/////////////Check
	public boolean checkPresenzaLibroNoleggiato(long idLibro, String email) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select idLibro, stato from biblioteca.noleggio where email = ?");
		prepareStatement.setString(1, email);
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (idLibro == risultato.getLong("idLibro") && "Noleggiato".equals(risultato.getString("stato"))) {
				return false;
			}
		}
		return true;
	}
	public boolean checkQuantitaLibriResidua(long idLibro, int quantita) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select quantita from biblioteca.libro where id = ?");
		prepareStatement.setLong(1, idLibro);
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (quantita > risultato.getInt("quantita")) {
				return false;
			}
		}
		return true;
	}
	public boolean checkEsistenzaTitoloLibro(String titolo) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select titolo from biblioteca.libro where titolo = ?");
		prepareStatement.setString(1, titolo);
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (titolo.equals(risultato.getString("titolo"))) {
				return false;
			}
		}
		return true;
	}

	public boolean checkEsistenzaAutoreLibro(String autore) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select autore from biblioteca.libro where autore = ?");
		prepareStatement.setString(1, autore);
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (autore.equals(risultato.getString("autore"))) {
				return false;
			}
		}
		return true;
	}

	public boolean checkEsistenzaUtente(String email) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select email from biblioteca.utente where email = ?");
		prepareStatement.setString(1, email);
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (email.equals(risultato.getString("email"))) {
				return false;
			}
		}
		return true;
	}

	public boolean checkPasswordValida(String email, String password) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select utente.password from biblioteca.utente where email = ?");
		prepareStatement.setString(1, email);
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (password.equals(risultato.getString("password"))) {
				return false;
			}
		}
		return true;
	}
	public boolean checkActive(String email) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select utente.active from biblioteca.utente where email = ?");
		prepareStatement.setString(1, email);
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (risultato.getBoolean("active")) {
				return false;
			}
		}
		return true;
	}

///////////////delete
	public void deleteUtente(String email) throws SQLException {
		String query = "delete from biblioteca.utente where email = ?";
		PreparedStatement preparedStatement = connessione.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.execute();
	}

	public void deleteLibro(long idLibro) throws SQLException {
		String query = "delete from biblioteca.id where username = ?";
		PreparedStatement preparedStatement = connessione.prepareStatement(query);
		preparedStatement.setLong(1, idLibro);
		preparedStatement.execute();
	}
	public void deleteCarrello() throws SQLException {
		String query = "delete from biblioteca.carrello where id = ?";
		PreparedStatement preparedStatement = connessione.prepareStatement(query);
		preparedStatement.setLong(1, 0);
		preparedStatement.execute();
	}
///////////////update
	public void updateLibro(long id, int quantita, double prezzo) throws SQLException {
		String queryUpdateVendite = "UPDATE `biblioteca`.`libro` SET `quantita` = ?, `prezzo` = ? WHERE (`id` = ?)";
		PreparedStatement statementVendite = connessione.prepareStatement(queryUpdateVendite);
		statementVendite.setInt(1, quantita);
		statementVendite.setDouble(2, prezzo);
		statementVendite.execute();
	}
	public void updateStatoNoleggio(String email, long idLibro) throws SQLException {
		String queryUpdateVendite = "UPDATE `biblioteca`.`noleggio` SET `stato` = ? WHERE (`email` = ?) AND idLibro = ?";
		PreparedStatement statementVendite = connessione.prepareStatement(queryUpdateVendite);
		statementVendite.setString(1, "Restituito");
		statementVendite.setString(2, email);
		statementVendite.setLong(3, idLibro);
		statementVendite.execute();
	}
	public void updateStatoActive (String email) throws SQLException {
		String queryUpdateActive = "UPDATE `biblioteca`.`utente` SET `active` = ? WHERE (`email` = ?) ";
		PreparedStatement statement = connessione.prepareStatement(queryUpdateActive);
		statement.setBoolean(1, true);
		statement.setString(2, email);
		statement.execute();
	}
	public void updateQuantitaVenduta(int quantita, long idLibro) throws SQLException {
		String queryUpdateActive = "UPDATE `biblioteca`.`vendite` SET `quantita` = quantita + ? WHERE (`id` = ?) ";
		PreparedStatement statement = connessione.prepareStatement(queryUpdateActive);
		statement.setInt(1, quantita);
		statement.setLong(2, idLibro);
		statement.execute();
	}
	public void updateQuantitaLibri(int quantita, long idLibro) throws SQLException {
		String queryUpdateActive = "UPDATE `biblioteca`.`libro` SET `quantita` = quantita - ? WHERE (`id` = ?) ";
		PreparedStatement statement = connessione.prepareStatement(queryUpdateActive);
		statement.setInt(1, quantita);
		statement.setLong(2, idLibro);
		statement.execute();
	}

}
