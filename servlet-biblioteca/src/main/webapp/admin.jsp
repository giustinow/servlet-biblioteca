<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Profilo Utente</title>

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <!-- Custom styles for this template -->
  <link href="css/scrolling-nav.css" rel="stylesheet">
<style type="text/css">
/*!
 * Start Bootstrap - Scrolling Nav (https://startbootstrap.com/template-overviews/scrolling-nav)
 * Copyright 2013-2019 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-scrolling-nav/blob/master/LICENSE)
 */
header {
  padding: 156px 0 100px;
}

section {
  padding: 150px 0;
}

.row{
padding-top: 200px;
}

</style>
</head>
<body>
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
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/stampa-libro?">Acquisti</a>
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
	<h1>Ciao Admin</h1>
	<div class="row">
  <div class="col-md-2"><form action="aggiungiLibro.jsp">
		<button>Aggiungi</button>
	</form>
</div>
  <div class="col-md-2"><form action="aggiungiLibro.jsp">
		<button>Aggiungi</button>
	</form></div>
  <div class="col-md-2"><form action="stampa-libro">
		<button>Vedi Libri</button>
	</form></div>
  <div class="col-md-2"><form action="stampa-vendite">
		<button>Vendite</button>
	</form></div>
  <div class="col-md-2"><form action="stampa-noleggi">
		<button>Noleggi In Corso</button>
	</form></div>
  <div class="col-md-2"><form action="stampa-utenti">
		<button>Vedi Utenti</button>
	</form></div>
</div>
	
	
</body>
</html>