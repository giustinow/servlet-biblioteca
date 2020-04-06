<%@page import="it.dstech.model.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<%
		List<Libro> elencoLibri = (List<Libro>) request.getAttribute("listaLibri");
	%>
	<table class="centro">
		<tr class="head">
			<th>Titolo</th>
			<th>Autore</th>
			<th>Quantita</th>
			<th>Prezzo</th>
		</tr>
		<%
			for (Libro lista : elencoLibri) {
		%>
		<tr>
			<td><%=lista.getTitolo()%></td>
			<td><%=lista.getAutore()%></td>
			<td><%=lista.getQuantita()%></td>
			<td><%=lista.getPrezzo()%></td>
			
			<%-- <td><a
				href="http://localhost:8080/servlet-ortofrutta/elimina-prodotto?nome=<%=lista.getNome()%>">Rimuovi</a></td>
			<td><a
				href="http://localhost:8080/servlet-ortofrutta/modificaProdotto.jsp?nome=<%=lista.getNome()%>">Modifica</a></td> --%>
		</tr>
		<%
			}
		%>
	</table>
	<form action="admin.jsp">
		<button>home</button>

	</form>
</body>
</html>