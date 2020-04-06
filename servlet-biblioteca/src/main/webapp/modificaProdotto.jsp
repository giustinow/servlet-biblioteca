<%@page import="it.dstech.model.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<%long id = (long) Long.parseLong(request.getParameter("id")); %>
	<form action="modifica-libro">
		Quantita: <input type="number" name="quantita">
		Prezzo: <input type="text" name="prezzo">
		<input type="hidden" name="id" value=<%=id %>>
		<input type="submit" value="Modifica">
	</form>
	
	<form action="admin.jsp">
		<button>home</button>
	</form>
</body>
</html>