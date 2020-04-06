<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="it.dstech.model.Libro"%>
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
h4{
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
		List<Libro> elencoLibri = (List<Libro>) request.getAttribute("listaLibri");
		String nome = (String) request.getAttribute("nome");
		String email = (String) request.getAttribute("email");
		List<Libro> search = (List<Libro>) request.getAttribute("search");
		String messaggio = (String) request.getAttribute("messaggio");
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
  <br>
  <br>
  <br>
  <div class="active-cyan-3 active-cyan-4 mb-4">
	<form action="search">
	 
		<input type="text" name="testo" class="form-control mb-4" placeholder="Search" id="tableSearch"> <input type="hidden"
			value=<%=nome%> name="nome"> <input type="hidden"
			value=<%=email%> name="email"> <input type="submit"
			value="Cerca">
	</form>
	<form action="stampa-libri-disponibili">
	<input type="hidden" name="email" value=<%=email %>>
	<input type="hidden" name="nome" value=<%=nome%>>
	<input type="submit" value="Vedi Tutti">
	</form>
	</div>
	<%if(messaggio != null){ %>
	<h4><%=messaggio %></h4>
	
	<%
	}
		if (search != null) {
	%>

<div class="container">
	<table  class="table table-bordered table-striped">
	 <thead>
		<tr>
			<th>Titolo</th>
			<th>Autore</th>
			<th>Quantita</th>
			<th>Prezzo</th>
			<th></th>
			<th></th>
		</tr>
		</thead>
		<%
			for (Libro lista : search) {
		%>
		    <tbody>
		<tr>
			<td><%=lista.getTitolo()%></td>
			<td><%=lista.getAutore()%></td>
			<td><%=lista.getQuantita()%></td>
			<td><%=lista.getPrezzo()%></td>
			<td><form action="noleggia-libro">
					<input type="hidden" name="nome" value=<%=nome%>> <input
						type="hidden" name="idLibro" value=<%=lista.getId()%>> <input
						type="hidden" name="titolo" value=<%=lista.getTitolo()%>>
					<input type="hidden" name="email" value=<%=email%>> <input
						type="submit" name="noleggia" value="noleggia">
				</form></td>

			<td><form action="acquista-libro">
					<input type="hidden" name="nome" value=<%=nome%>> <input
						type="hidden" name="idLibro" value=<%=lista.getId()%>> <input
						type="hidden" name="titolo" value=<%=lista.getTitolo()%>>
					<input type="hidden" name="email" value=<%=email%>> <input
						type="hidden" name="prezzo" value=<%=lista.getPrezzo()%>>
					<input type="number" min="1" max="5" name="quantita" required="required"> <input
						type="submit" name="compra" value="Aggiungi al Carrello">
				</form></td>
		</tr>
</tbody>
		<%
			}
		%>
	</table>
	</div>
	<%
		} else {
	%>
	<div class="container">
	<table  class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>Titolo</th>
			<th>Autore</th>
			<th>Quantita</th>
			<th>Prezzo</th>
		</tr>
		</thead>
		<%
			for (Libro lista : elencoLibri) {
		%>
		    <tbody>
		<tr>
			<td><%=lista.getTitolo()%></td>
			<td><%=lista.getAutore()%></td>
			<td><%=lista.getQuantita()%></td>
			<td><%=lista.getPrezzo()%></td>
			<td><form action="noleggia-libro">
					<input type="hidden" name="nome" value=<%=nome%>> <input
						type="hidden" name="idLibro" value=<%=lista.getId()%>> <input
						type="hidden" name="titolo" value=<%=lista.getTitolo()%>>
					<input type="hidden" name="email" value=<%=email%>> <input
						type="submit" name="noleggia" value="noleggia">
				</form></td>
			<td><form action="acquista-libro">
					<input type="hidden" name="nome" value=<%=nome%>> <input
						type="hidden" name="idLibro" value=<%=lista.getId()%>> <input
						type="hidden" name="titolo" value=<%=lista.getTitolo()%>>
					<input type="hidden" name="email" value=<%=email%>> <input
						type="hidden" name="prezzo" value=<%=lista.getPrezzo()%>>
					<input type="number" min="1" max="5" name="quantita" required="required"> <input
						type="submit" name="compra" value="Aggiungi al Carrello">
				</form></td>
		</tr>
		</tbody>
		<%
			}
		%>
	</table>
	</div>
	<%
		}
	%>

	<form action="riepilogo-acquisto-noleggio" class="riepilogo">
		<input type="hidden" name="nome" value=<%=nome%>> <input
			type="hidden" name="email" value=<%=email%>> <input
			type="submit" value="Pagamento">
	</form>

	
</body>
</html>
<%-- <td><a
				href="http://localhost:8080/servlet-biblioteca/noleggia-libro?titolo=<%=lista.getTitolo()%>&email">Noleggia</a></td>
			<td><a
				href="http://localhost:8080/servlet-biblioteca/compra-libro?titolo=<%=lista.getTitolo()%>">Compra</a></td> --%>