package it.dstech.model;

public class Acquisto {
	private long id;
	private long idLibro;
	private String email;
	private String titolo;
	private String data;
	private int quantita;
	private double prezzo;
	private double totale;

	public Acquisto(long id,  String email,  long idLibro, String titolo,  String data, int quantita, double prezzo, double totale) {
		this.id = id;
		this.email = email;
		this.idLibro = idLibro;
		this.titolo = titolo;
		this.data = data;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.totale = totale;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
	

}
