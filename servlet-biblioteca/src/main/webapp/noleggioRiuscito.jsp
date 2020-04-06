<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<%
		String nome = (String) request.getAttribute("nome");
		String email = (String) request.getAttribute("email");
	%>
	<h1>
		<%=nome%>, hai effettuato il noleggio
	</h1>

	<form action="profiloUtente.jsp">
		<input type="hidden" name="email" value=<%=email%>> <input
			type="hidden" name="nome" value=<%=nome%>> <input
			type="submit" name="submit" value="torna alla home">
	</form>
</body>
</html>