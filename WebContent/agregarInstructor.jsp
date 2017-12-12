
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript.js"></script>
<title>Instructores</title>
<meta charset="utf-8">
	<meta name="description" content="Miminium Admin Template v.1">
	<meta name="author" content="Isna Nur Azis">
	<meta name="keyword" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
 
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
				<a href="index.html" class="navbar-brand"> 
					<b>OCM</b>
                </a>
                
                <ul class="nav navbar-nav navbar-right user-nav">
                	<li class="user-name"><span>${correo }</span></li>
                	<li class="dropdown avatar-dropdown">
                		<img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
                	</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- end: Header -->
	
	<!-- star: container -->
	<div class="container-fluid mimin-wrapper">
	
		<!-- start:Left Menu -->
		<div id="left-menu">
			<div class="sub-left-menu scroll">
				<ul class="nav nav-list">
					<li><div class="left-bg"></div></li>
                    
                     <li class="ripple">
                      <a href="<%=request.getContextPath()%>/indexSuperAdmin.jsp"><span class="fa-home fa"></span> Inicio 
                      </a>
                    </li>
                    
                    <li class="ripple">
                      	<a href="<%=request.getContextPath()%>/listar-paises.do?opcionPaises=listarPaises"><span class="fa-map fa"></span> Paises
                      	</a>
                    </li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/listar-ciudades.do?opcionCiudades=listarCiudades"><span class="fa-map-pin fa"></span> Ciudades
                      </a>
                    </li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/listar-lugares.do?opcionLugares=listarLugares"><span class="fa-map-signs fa"></span> Lugares
                      </a>
                    </li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/cursos?opcion=verCursos"><span class="fa-book fa"></span> Cursos
                      </a>
                    </li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/programas?opcion=verProgramas"><span class="fa-graduation-cap fa"></span> Programas
                      </a>
                    </li>
                    
                    <li class="active ripple">
                      <a href="<%=request.getContextPath()%>/listar-instructores.do?opcionInstructores=listarInstructores"><span class="fa-user fa"></span> Instructores
                      </a>
                    </li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/listar-destinatarios.do?opcionDestinatarios=listarDestinatarios"><span class="fa-group fa"></span> Destinatarios
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
					<div class="col-sm-12">
						<h3 class="animated fadeInLeft">Agregar Instructor</h3>                    
					</div>
				</div>
			</div>
			
			
			
			
			<div class="col-md-12 top-20 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<h3>Nuevo Instructor</h3>
						</div>
						
						<div class="panel-body">
							
									
										<div class="col-md-12">
										<form action="<%=request.getContextPath()%>/listar-instructores.do">
										
											<div class="col-md-6">
                            				<div class="form-group form-animate-text" style="margin-top:40px !important;">
                              					<input type="text" id="nombreAgregarInstructor" name="nombreAgregarInstructor" class="form-text" title="Solo letras numeros y espacios" required>
                              					<span class="bar"></span>
                              					<label>Nombre del Instructor</label>
                            				</div>
                            				<div class="form-group form-animate-text" style="margin-top:40px !important;">
                              					<input type="text" id="apellidopAgregarInstructor" name="apellidopAgregarInstructor" class="form-text" title="Solo letras numeros y espacios" required>
                              					<span class="bar"></span>
                              					<label>Apellido Paterno</label>
                            				</div>
                            				<div class="form-group form-animate-text" style="margin-top:40px !important;">
                              					<input type="text" id="apellidomAgregarInstructor" name="apellidomAgregarInstructor" class="form-text" title="Solo letras numeros y espacios" required>
                              					<span class="bar"></span>
                              					<label>Apellido Materno</label>
                            				</div>
                            				</div>
                            				
                            				<div class="col-md-6">
                            				<div class="form-group form-animate-text" style="margin-top:40px !important;">
                              					<input type="email" id="correoAgregarInstructor" name="correoAgregarInstructor" class="form-text" title="Solo letras numeros y espacios" required>
                              					<span class="bar"></span>
                              					<label>Correo</label>
                            				</div>
                            				<div class="form-group form-animate-text" style="margin-top:40px !important;">
                              					<input type="text" id="telefonoAgregarInstructor" name="telefonoAgregarInstructor" class="form-text" title="Solo letras numeros y espacios" required>
                              					<span class="bar"></span>
                              					<label>Tel�fono</label>
                            				</div>
                            				<div class="form-group form-animate-text" style="margin-top:40px !important;">
                              					<input type="text" id="fechanAgregarInstructor" name="fechanAgregarInstructor" class="form-text" title="Solo letras numeros y espacios" required>
                              					<span class="bar"></span>
                              					<label>Fecha de nacimiento</label>
                            				</div>
                            				</div>
                            				
                            				
                            				
                            				<div class="col-md-5"></div>
                            				
                          					<div class="col-md-4">
                              				<button class="submit btn btn-danger" name="opcionInstructores" value="agregarInstructor">Agregar Instructor</button>
                        					</div>
										</form>
										</div>
									
								
							
						</div>
					</div>
				</div>
			</div> 
			
            
	 <!-- Star Mobile -->		
		
       <!-- end: Mobile -->

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
<script>

function eliminarEvento(){
	alert("Se va a eliminar un evento");
	document.forms["formaLista"].action = "<%=request.getContextPath()%>/listar-evento.do?opcion=verListadoEventos";
	document.forms["formaLista"].submit();
}

//function cambiarColorBorde(elcolor) {
//	  var contenedor = document.getElementById("nombreDIV");  
//	  contenedor.style.background-color = elcolor;
//	}
</script>
</html>