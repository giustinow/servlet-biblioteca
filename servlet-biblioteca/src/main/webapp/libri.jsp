<%@page import="it.dstech.model.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<%
		List<Libro> listaLibri = (List<Libro>)request.getAttribute("listaLibri");
	%>
	<table class="centro">
		<tr class="head">
			<th>Titolo</th>
			<th>Autore</th>
			<th>Prezzo</th>
		</tr>
		<%
			for (Libro lista : listaLibri) {
		%>
		<tr>
			<td><%=lista.getTitolo() %></td>
			<td><%=lista.getAutore() %></td>
			<td><a
				href="http://localhost:8080/servlet-ortofrutta/elimina-libro?titolo=<%= %>">Rimuovi</a></td>
			<td><a
				href="http://localhost:8080/servlet-ortofrutta/modificaLibro.jsp?nome=<%= %>">Modifica</a></td>
		</tr>
		<%
			}
		%>
	</table>

	<form action="index">
		<button>Torna in Home</button>

	</form>
</body>
</html>