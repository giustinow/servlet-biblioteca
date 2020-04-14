<%@page import="it.dstech.model.Acquisto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Libri.</title>
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
</head>
<body>
	<%
		List<Acquisto> acquisti = (List<Acquisto>) request.getAttribute("restituito");
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
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/utente/torna-al-profilo">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/utente/stampa-libri-disponibili">Libri</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/utente/storico-acquisti>">Acquisti</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/utente/storico-noleggi">Noleggi</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/utente/lista-restituzione">Restituisci</a>
          </li>
                 <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/utente/logout">LogOut</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <br><br> <br>
<div class="container">
	<table  class="table table-bordered table-striped">
	 <thead>
		<tr class="head">
			<th>Email</th>
			<th>IdLibro</th>
			<th>Titolo</th>
			<th>Data</th>
			<th>Quantita</th>
			<th>Prezzo</th>
			<th>Totale</th>
		</tr>
		</thead>
		<%
			for (Acquisto lista : acquisti) {
		%>
		<tbody>
		<tr>
			<td><%=lista.getEmail()%></td>
			<td><%=lista.getIdLibro()%></td>
			<td><%=lista.getTitolo()%></td>
			<td><%=lista.getData()%></td>
			<td><%=lista.getQuantita()%></td>
			<td><%=lista.getPrezzo()%></td>
			<td><%=lista.getTotale()%></td>
		</tr>
		</tbody>
		<%
			}
		%>
	</table>
</div>
	<form action="utente/torna-al-profilo">
		<button>home</button>
	</form>
</body>
</html>