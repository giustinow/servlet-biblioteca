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
  padding: 100px 0 100px;
}

section {
  padding: 50px 0;
}

.row{
padding-top: 100px;
}
.submit {
  background-color: #008CBA; 
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
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/admin/profilo">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/aggiungiLibro.jsp?">Aggiunta</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/admin/stampa-libro">Libri</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/admin/stampa-vendite">Vendite</a>
          </li>
              <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/admin/stampa-noleggi>">Noleggi</a>
          </li>
                 <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/admin/stampa-utenti>">Utenti</a>
          </li>         
                 <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="http://localhost:8080/servlet-biblioteca/admin/logout">LogOut</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
   <header class="bg-primary text-white">
    <div class="container text-center">
      <h1>Admin.</h1>
      <p class="lead">Benvenuto Capo</p>
    </div>
  </header>
  
  <section id="services" class="bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Aggiungi un nuovo Libro alla tua raccolta!</h2>
              <form action="aggiungiLibro.jsp">
       <input type="submit" class="button" value="Aggiungi Libro">
       </form>
        </div>
      </div>
    </div>
  </section>
  
   <section id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Vedi </h2>
       <form action="stampa-libro">
       <input type="submit" class="button" value="Vedi Libri">
       </form>
        </div>
      </div>
    </div>
  </section>
   
  <section id="services" class="bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Vedi le vendite totali</h2>
              <form action="stampa-vendite">
       <input type="submit" class="button" value="Vendite">
       </form>
        </div>
      </div>
    </div>
  </section> 
  
    <section id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Vedi i noleggi</h2>
       <form action="stampa-noleggi">
       <input type="submit" class="button" value="Noleggi">
       </form>
        </div>
      </div>
    </div>
  </section>
  
    <section id="services" class="bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Vedi tutti gli utenti</h2>
              <form action="stampa-utenti">
       <input type="submit" class="button" value="Utenti">
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

</body>
</html>