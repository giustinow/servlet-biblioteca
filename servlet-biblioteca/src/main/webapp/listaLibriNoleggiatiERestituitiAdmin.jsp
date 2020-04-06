<%@page import="it.dstech.model.Noleggio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<%
		List<Noleggio> noleggiInCorso = (List<Noleggio>) request.getAttribute("noleggi");
		List<Noleggio> noleggiResitutiti = (List<Noleggio>) request.getAttribute("noleggiRestituiti");
	%>
	<h1>Lista noleggi attuali</h1>
	<table class="centro">
		<tr class="head">
			<th>Email</th>
			<th>IdLibro</th>
			<th>Titolo</th>
			<th>Data</th>
			<th>Stato</th>
			<th>Sollecita</th>
		</tr>
		<%
			for (Noleggio lista : noleggiInCorso) {
		%>
		<tr>
			<td><%=lista.getEmail()%></td>
			<td><%=lista.getIdLibro()%></td>
			<td><%=lista.getTitolo()%></td>
			<td><%=lista.getData()%></td>
			<td><%=lista.getStato()%></td>
			<td><form action="sollecita">
				<input type="hidden" name="email" value=<%=lista.getEmail() %>>
				<input type="hidden" name="titolo" value=<%=lista.getTitolo() %>>
				<input type="hidden" name="data" value=<%=lista.getData() %>>
				<input type="submit" value="sollecita">
			</form></td>
		</tr>
		<%-- <td><a
				href="http://localhost:8080/servlet-ortofrutta/elimina-prodotto?nome=<%=lista.getNome()%>">Rimuovi</a></td>
			<td><a
				href="http://localhost:8080/servlet-ortofrutta/modificaProdotto.jsp?nome=<%=lista.getNome()%>">Modifica</a></td> --%>
		<%
			}
		%>
	</table>
	<h1>Lista noleggi passati</h1>
	<table class="centro">
		<tr class="head">
			<th>Email</th>
			<th>IdLibro</th>
			<th>Titolo</th>
			<th>Data</th>
			<th>Stato</th>
		</tr>
		<%
			for (Noleggio lista : noleggiResitutiti) {
		%>
		<tr>
			<td><%=lista.getEmail()%></td>
			<td><%=lista.getIdLibro()%></td>
			<td><%=lista.getTitolo()%></td>
			<td><%=lista.getData()%></td>
			<td><%=lista.getStato()%></td>

		</tr>
		<%-- <td><a
				href="http://localhost:8080/servlet-ortofrutta/elimina-prodotto?nome=<%=lista.getNome()%>">Rimuovi</a></td>
			<td><a
				href="http://localhost:8080/servlet-ortofrutta/modificaProdotto.jsp?nome=<%=lista.getNome()%>">Modifica</a></td> --%>
		<%
			}
		%>
	</table>
	<form action="admin.jsp">
		<button>home</button>
	</form>
</body>
</html>