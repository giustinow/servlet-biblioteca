<%@page import="it.dstech.model.Noleggio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<style>
body{
text-align: center;
}
</style>

<body>
	<%
		List<Noleggio> noleggiInCorso = (List<Noleggio>) request.getAttribute("noleggi");
		List<Noleggio> noleggiResitutiti = (List<Noleggio>) request.getAttribute("noleggiRestituiti");
	%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">Biblioteca</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/admin.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/aggiungiLibro.jsp?">Aggiunta</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/stampa-libro?">Libri</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/stampa-vendite?">Vendite</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/stampa-noleggi?>">Noleggi</a>
          </li>
                 <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/stampa-utenti?>">Utenti</a>
          </li>         
                 <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/">LogOut</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <br>  <br>  <br>
	<h1>Lista noleggi attuali</h1>
	<div class="container">
	<table  class="table table-bordered table-striped">
	 <thead>
		<tr class="head">
			<th>Email</th>
			<th>IdLibro</th>
			<th>Titolo</th>
			<th>Data</th>
			<th>Stato</th>
			<th>Sollecita</th>
		</tr>
		</thead>
		<%
			for (Noleggio lista : noleggiInCorso) {
		%>
		<tbody>
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
		</tbody>
		<%
			}
		%>
	</table>
		</div>
		<br><br>
	<h1>Lista noleggi passati</h1>
	<div class="container">
	<table  class="table table-bordered table-striped">
	 <thead>
		<tr class="head">
			<th>Email</th>
			<th>IdLibro</th>
			<th>Titolo</th>
			<th>Data</th>
			<th>Stato</th>
		</tr>
		</thead>
		<%
			for (Noleggio lista : noleggiResitutiti) {
		%>
		<tbody>
		<tr>
			<td><%=lista.getEmail()%></td>
			<td><%=lista.getIdLibro()%></td>
			<td><%=lista.getTitolo()%></td>
			<td><%=lista.getData()%></td>
			<td><%=lista.getStato()%></td>

		</tr>
		</tbody>
		<%
			}
		%>
	</table>
	</div>
	<form action="admin.jsp">
		<button>home</button>
	</form>
</body>
</html>