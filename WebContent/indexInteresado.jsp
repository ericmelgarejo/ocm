
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.fondo-blanco{
background: #fff;
width:100%;
height:100%;
}
.azul2{

background: #1C84C6;
}
.btn{
width:100%;
background: #1C84C6;
}
.logo-menu{
width:100%;
background-color: #2196F3;
border-radius: 20%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript.js"></script>
<title>Inicio</title>
<meta charset="utf-8">
	<meta name="description" content="Miminium Admin Template v.1">
	<meta name="author" content="Isna Nur Azis">
	<meta name="keyword" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IT University</title>
 
    <!-- start: Css -->
    <link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">

      <!-- plugins -->
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/fullcalendar.min.css"/>
	  <link href="asset/css/style.css" rel="stylesheet">
	<!-- end: Css -->

	<link rel="shortcut icon" href="asset/img/logomi.png">
</head>

 <body id="mimin" class="dashboard">
      <!-- start: Header -->
        <nav class="navbar navbar-default header navbar-fixed-top">
          <div class="col-md-12 nav-wrapper">
            <div class="navbar-header" style="width:100%;">
              <!-- <div class="opener-left-menu is-open">
                <span class="top"></span>
                <span class="middle"></span>
                <span class="bottom"></span>
              </div> -->
                 <a href="index.html" class="navbar-brand"> 
                 <b>OCM</b>
                 </a>
		
              <ul class="nav navbar-nav navbar-right user-nav">
                <li class="user-name"><span>${correo}</span></li>
                  <li class="dropdown avatar-dropdown">
                   <img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
                   <ul class="dropdown-menu user-dropdown">
                     <li><a href="#"><span class="fa fa-user"></span> My Profile</a></li>
                     <li><a href="#"><span class="fa fa-calendar"></span> My Calendar</a></li>
                     <li role="separator" class="divider"></li>
                     <li class="more">
                       <ul>
                        <li><a href=""><span class="fa fa-cogs"></span></a></li>
                        <li><a href=""><span class="fa fa-lock"></span></a></li>
                        <li><a href=""><span class="fa fa-power-off "></span></a></li>
                      </ul>
                    </li>
                  </ul>
                </li>               
              </ul>
            </div>
          </div>
        </nav>
      <!-- end: Header -->

      <div class="container-fluid mimin-wrapper">
  
          <!-- start:Left Menu -->
  <div id="left-menu">
   <div class="sub-left-menu scroll">
                <ul class="nav nav-list">
                    <li><div class="left-bg"></div></li>
                    
                    <li class="active ripple">
                      <a href="<%=request.getContextPath()%>/indexInteresado.jsp"><span class="fa-home fa"></span> Inicio 
                      </a>
                    </li>
                   
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/lista-eventos-interesado.do?opcion=verListadoEventos"><span class="fa-calendar fa"></span> Ver Eventos
                      </a>
                    </li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/lista-inscripciones.do?opcion=verListadoInscripciones"><span class="fa-tasks fa"></span> Ver Inscripciones
                      </a>
                    </li>
                    
                    
                    
                    
                  </ul>
                </div>
   </div>
          <!-- end: Left Menu -->

  		
          <!-- start: content -->
            <div id="content">
                <div class="panel box-shadow-none content-header">
                  <div class="panel-body">
                    <div class="col-md-12">
                        <h3 class="animated fadeInLeft">Inicio</h3>
                    </div>
                  </div>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-10">
                  <div class="col-md-12 panel">
                      
                    <div class="col-md-12 panel-heading">
                   
                      <h4>Bienvenido</h4>
                      
                    </div>
                    <div class="col-md-12 panel-body" style="padding-bottom:30px;">
				    <!-- DESDE AQUI -->
                    
                    <img  src="img/welcome.png" width="100%">
                    <!-- HASTA AQUI -->
                  </div>
                </div>
              </div>
            
	<%--  <!-- Star Mobile -->		
		<div id="mimin-mobile" class="reverse ">
         <div class="mimin-mobile-menu-list fondo-blanco" >
           <div class="logo-menu">
            <center>
			<img src="img/itu.png" width="60%">			
			</center>
           </div>
           <br><br><br>
            <div class="col-md-12 sub-mimin-mobile-menu-list animated fadeInLeft">
               <div id="left-menu">
                 <div class="sub-left-menu scroll">
               	  <form name="form" action="<%=request.getContextPath()%>/crear-evento.do">
						<button class="btn btn-primary " name = "opcion" value="inicioAltaEvento">Crear Evento</button><br><br>
						<button class="btn btn-primary " onclick="listarEventos()" name = "opcion" value="verListadoEventos">Ver Eventos</button><br><br>
						<button class="btn btn-primary " onclick="verInscripciones()" name="opcion" value="verInscripciones">Ver Inscripciones</button><br><br>
				 </form>
	

               
                 </div>                
               </div>
             <form action="<%=request.getContextPath()%>/lista-eventos-interesado.do">
		<button class="btn" name = "opcion" value="verListadoEventos">Ver Eventos</button>
	</form>
	<form action="<%=request.getContextPath()%>/lista-inscripciones.do">
		<button class="btn"  name = "opcion" value="verListadoInscripciones">Ver Inscripciones</button>
	</form>
             </div>            
           </div>             
         </div>
	      <button id="mimin-mobile-menu-opener" class="animated rubberBand btn btn-circle btn-danger">
	        <span class="fa fa-bars"></span>
	      </button>
       <!-- end: Mobile --> --%>

    <!-- start: Javascript -->
    <script src="asset/js/jquery.min.js"></script>
    <script src="asset/js/jquery.ui.min.js"></script>
    <script src="asset/js/bootstrap.min.js"></script>
     
    <!-- plugins -->
    <script src="asset/js/plugins/moment.min.js"></script>
    <script src="asset/js/plugins/fullcalendar.min.js"></script>
    <script src="asset/js/plugins/jquery.nicescroll.js"></script>
    <script src="asset/js/plugins/jquery.vmap.min.js"></script>
    <script src="asset/js/plugins/maps/jquery.vmap.world.js"></script>
    <script src="asset/js/plugins/jquery.vmap.sampledata.js"></script>
    <script src="asset/js/plugins/chart.min.js"></script>

    <!-- custom -->
     <script src="asset/js/main.js"></script>
  
  <!-- end: Javascript -->
  				</div>
  </body>

<script type="text/javascript">

	function listarEventos(){
		document.forms["form"].action = "<%=request.getContextPath()%>/listar-evento.do";
		document.forms["form"].submit();
 	}
	
	function verInscripciones(){
		document.forms["form"].action = "<%=request.getContextPath()%>/listar-inscripciones.do";
		document.forms["form"].submit();
	}
</script>
</html>