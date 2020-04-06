package it.dstech.model;

public class Vendite {
	private String titolo; 
	private String autore; 
	private int quantita;
	public Vendite(String titolo, String autore, int quantita) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.quantita = quantita;
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
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
}

