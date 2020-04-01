package it.dstech.model;

public class Acquisto {

	private String libro;
	private String utente;
	private String data;

	public Acquisto(String libro, String utente, String data) {
		this.libro = libro;
		this.utente = utente;
		this.data = data;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}