<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<%
		String email = (String) request.getAttribute("email");
		String nome = (String) request.getAttribute("nome");
	%>
	<%=email%>
	<h1>Restituzione Riuscita</h1>
	<form action="torna-al-profilo">
		<input type="hidden" name="nome" value=<%=nome%>> <input
			type="hidden" name="email" value=<%=email%>> <input
			type="submit" value="Profilo">
	</form>
</body>
</html>