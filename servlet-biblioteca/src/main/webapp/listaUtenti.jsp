<%@page import="it.dstech.model.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<%
		List<Utente> elencoUtenti = (List<Utente>) request.getAttribute("listaUtenti");
	%>
	<table class="centro">
		<tr class="head">
			<th>Nome</th>
			<th>Cognome</th>
			<th>Eta</th>
			<th>Sesso</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
			<%
			for (Utente lista : elencoUtenti) {
		%>
		<tr>
			<td><%=lista.getNome()%></td>
			<td><%=lista.getCognome()%></td>
			<td><%=lista.getEta()%></td>
			<td><%=lista.getSesso()%></td>
			<td><%=lista.getEmail()%></td>
			<td><%=lista.getPassword()%></td>

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