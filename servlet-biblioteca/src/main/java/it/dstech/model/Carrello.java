package it.dstech.model;

public class Carrello {
	private long id;
	private String email;
	private long idLibro;
	private String titolo;
	private int quantita;
	private String tipo;
	private double prezzo;
	private double totale;

	public Carrello(long id, String email, long idLibro, String titolo, int quantita, String tipo, double prezzo, double totale) {
		super();
		this.id = id;
		this.email = email;
		this.idLibro = idLibro;
		this.titolo = titolo;
		this.quantita = quantita;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.totale = totale;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
}
