<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en"><head>

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

.submit {
  background-color: #008CBA; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}
.button {
  background-color: white; 
  color: black; 
  border: 2px solid #008CBA;
}

.button:hover {
  background-color: #008CBA;
  color: white;
}

.avatar{
vertical-align: middle;
  width: 150px;
  height: 150px;
  border-radius: 50%;
}
</style>
</head>

<body id="page-top">
	<%
		String nome = (String) request.getAttribute("nome");
		String email = (String) request.getAttribute("email");
		String immagine = (String) request.getAttribute("immagine");
	%>

  <!-- Navigation -->
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

  <header class="bg-primary text-white">
    <div class="container text-center">
      <img alt="immagine" class="avatar" src="data:image/jpg;base64,<%=immagine %>"> <br>
      <h1>Benvenuto! <%=nome %></h1>
      <p class="lead">Approfitta di questo periodo di quarantena. Solo per questo mese spedizione gratuita!</p>
    </div>
  </header>

  <section id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Biblioteca</h2>
          <p class="lead"><%=nome %>! Per te tantissimi vantaggi. Visto che sei un nostro cliente hai la possibilita di:</p>
          <ul>
            <li>Acquistare o Noleggiare un libro a tuo piacimento</li>
            <li>Vedere i tuoi Acquisti effettuati</li>
            <li>Vedere i tuoi Noleggi</li>
            <li>Restituire i Libri che hai Noleggiato</li>
          </ul>
        </div>
      </div>
    </div>
  </section>

  <section id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Acquista o Noleggia</h2>
          <p class="lead">Ora che passiamo tutto il nostro il tempo a casa non hai piu scuse! Approfitta per Acquistare o Noleggiare un libro presso la nostra biblioteca.</p>
       <form action="stampa-libri-disponibili">
       <input type="hidden" name="nome" value=<%=nome %>>
       <input type="hidden" name="email" value=<%=email %>>
       <input type="submit" class="button" value="Noleggia o Acquista">
       </form>
        </div>
      </div>
    </div>
  </section>
  
  <section id="services" class="bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>I tuoi Noleggi</h2>
          <p class="lead">Vedi la lista dei libri che hai noleggiato! Non dimenticarti di Restituire i libri che prendi.</p>
              <form action="storico-noleggi">
       <input type="hidden" name="nome" value=<%=nome %>>
       <input type="hidden" name="email" value=<%=email %>>
       <input type="submit" class="button" value="I miei Noleggi">
       </form>
        </div>
      </div>
    </div>
  </section>

  <section id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>I miei Acquisti</h2>
          <p class="lead">In questa sezione potrai vedere tutti i tuoi Acquisti!</p>
                   <form action="storico-acquisti">
       <input type="hidden" name="nome" value=<%=nome %>>
       <input type="hidden" name="email" value=<%=email %>>
       <input type="submit" class="button" value="I miei Acquisti">
       </form>
        </div>
      </div>
    </div>
  </section>

  <section id="services" class="bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Restituisci un libro noleggiato</h2>
          <p class="lead">Molti dei nostri clienti si dimenticano di restituire i libri noleggiati. Se stai leggendo significa che tu non uno di quelli!</p>
           <form action="lista-restituzione">
       <input type="hidden" name="nome" value=<%=nome %>>
       <input type="hidden" name="email" value=<%=email %>>
       <input type="submit" class="button" value="Restituisci">
       </form>
        </div>
      </div>
    </div>
  </section>
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright © Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="js/scrolling-nav.js"></script>




</body></html>
