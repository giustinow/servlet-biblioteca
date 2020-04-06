<%@page import="it.dstech.model.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<form action="aggiunta-libro">
		<h4>Titolo del libro:</h4>
		<input type="text" name="titolo" class="titolo" />
		<h4>Autore del libro</h4>
		<input type="text" name="autore" class="autore" />
		<h4>Quantita:</h4>
		<input type="number" name="quantita" class="quantita" />
		<h4>Prezzo:</h4>
		<input type="number" name="prezzo" class="prezzo" /> <input
			type="submit" name="submit" class="submit" />
	</form>
</body>
</html>