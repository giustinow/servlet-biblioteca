package it.dstech.model;

public class Noleggio {
	private String email;
	private long idLibro;
	private String titolo;
	private String data;
	private String stato;

	public Noleggio(String email, long idLibro, String libro, String data, String stato) {
		this.idLibro = idLibro;
		this.email = email;
		this.titolo = libro;
		this.data = data;
		this.stato = stato;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String libro) {
		this.titolo = libro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

}
