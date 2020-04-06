package it.dstech.model;

public class Libro {
	private long id;
	private String titolo;
	private String autore;
	private int quantita;
	private double prezzo;

	public Libro(long id, String titolo, String autore, int quantita, double prezzo) {
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
