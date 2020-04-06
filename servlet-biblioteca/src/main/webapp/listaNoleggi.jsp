<%@page import="it.dstech.model.Noleggio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
	body{
	text-align: center;
	}
			table {
			width: 100%;
				border-spacing: 0px;}
			.riepilogo{
			text-align:right;
			padding-right: 200px;
			}

  </style>
<body>
	<%
		List<Noleggio> noleggiInCorso = (List<Noleggio>) request.getAttribute("noleggiato");
		List<Noleggio> noleggiResitutiti = (List<Noleggio>) request.getAttribute("restituito");
		String nome = (String) request.getAttribute("nome");
		String email = (String) request.getAttribute("email");
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
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/torna-al-profilo?email=<%=email%>">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/stampa-libri-disponibili?email=<%=email%>&nome=<%=nome%>">Libri</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/storico-acquisti?email=<%=email%>&nome=<%=nome%>">Acquisti</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/storico-noleggi?email=<%=email%>&nome=<%=nome%>">Noleggi</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/lista-restituzione?email=<%=email%>&nome=<%=nome%>">Restituisci</a>
          </li>
                 <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/">LogOut</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    <br><br> <br>
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

		</tr>
		</tbody>
		<%-- <td><a
				href="http://localhost:8080/servlet-ortofrutta/elimina-prodotto?nome=<%=lista.getNome()%>">Rimuovi</a></td>
			<td><a
				href="http://localhost:8080/servlet-ortofrutta/modificaProdotto.jsp?nome=<%=lista.getNome()%>">Modifica</a></td> --%>
		<%
			}
		%>
	</table>
	</div>
	
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
		<%-- <td><a
				href="http://localhost:8080/servlet-ortofrutta/elimina-prodotto?nome=<%=lista.getNome()%>">Rimuovi</a></td>
			<td><a
				href="http://localhost:8080/servlet-ortofrutta/modificaProdotto.jsp?nome=<%=lista.getNome()%>">Modifica</a></td> --%>
		<%
			}
		%>
	</table>
		</div>
	<form action="torna-al-profilo">
	<input type="hidden" name="email" value=<%=email %>>
	<input type="hidden" name="nome" value=<%=nome %>>
		<button>home</button>
	</form>
</body>
</html>