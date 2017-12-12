<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript.js"></script>
<title>Preinscripcion</title>
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
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/nouislider.min.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/select2.min.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/ionrangeslider/ion.rangeSlider.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/ionrangeslider/ion.rangeSlider.skinFlat.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/bootstrap-material-datetimepicker.css"/>
	<link href="asset/css/style.css" rel="stylesheet">
	<!-- end: Css -->

	<link rel="shortcut icon" href="asset/img/logomi.png">
</head>

<body id="mimin" class="dashboard">
	<!-- start: Navbar -->
	<nav class="navbar navbar-default header navbar-fixed-top">
		<div class="col-md-12 nav-wrapper">
			<div class="navbar-header" style="width:100%;">
				<a class="navbar-brand">
					<b>OCM</b>
				</a>
				<ul class="nav navbar-nav navbar-right user-nav">
					<li class="user-name"><span>${correo}</span></li>
                  	<li class="dropdown avatar-dropdown">
						<img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
					</li>               
				</ul>
			</div>
		</div>
	</nav>
	<!-- end: Navbar -->
	
	<div class="container-fluid mimin-wrapper">
	
		<!-- start:Left Menu -->
		<div id="left-menu">
              <div class="sub-left-menu scroll">
                <ul class="nav nav-list">
                    <li><div class="left-bg"></div></li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/index.jsp"> 
                      <span class="fa-home fa"></span>Inicio
                      </a>
                    </li>
                    
					<li class="ripple">
                      <a href="<%=request.getContextPath()%>/crear-evento.do?opcion=inicioAltaEvento"> 
                      <span class="fa-calendar-plus-o fa"></span>Crear Evento
                      </a>
                    </li>
                    
					<li class="ripple">
                      <a href="<%=request.getContextPath()%>/listar-evento.do?opcion=verListadoEventos"> 
                      <span class="fa-calendar fa"></span> Ver Eventos 
                      </a>
                    </li>
                    
					<li class="active ripple">
                      <a href="<%=request.getContextPath()%>/listar-inscripciones.do?opcion=verEventos">
                      <span class="fa-tasks fa"></span> Ver Inscripciones 
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
						<h3 class="animated fadeInLeft">Preinscripción</h3>                    
					</div>
				</div>
			</div>
			
			<div class="col-md-12 top-20 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading bg-white">
							<h3>Datos</h3>
						</div>
						
						<div class="panel-body">
							<div class="col-md-12">
								<form action="<%=request.getContextPath()%>/crear-evento.do">
									
										<input type="hidden" name="idEvento" value="${param.idEvento }">
										<div class="col-md-6">
											<div class="form-group form-animate-text" style="margin-top:40px !important;">
												<input type="text" id="nombrePreinscripcion" name="nombrePreinscripcion" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
												<span class="bar"></span>
												<label>Nombre</label>
											</div>
											
											<div class="form-group form-animate-text" style="margin-top:40px !important;">
												<input type="text" id="apellidoMaternoPreinscripcion" name="apellidoMaternoPreinscripcion" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
												<span class="bar"></span>
												<label>Apellido Materno</label>
											</div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group form-animate-text" style="margin-top:40px !important;">
												<input type="text" id="apellidoPaternoPreinscripcion" name="apellidoPaternoPreinscripcion" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
												<span class="bar"></span>
												<label>Apellido Paterno</label>
											</div>
											
											<div class="form-group form-animate-text" style="margin-top:40px !important;">
												<input type="number" id="telefonoPreinscripcion" name="telefonoPreinscripcion" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
												<span class="bar"></span>
                    							<label>Teléfono</label>
											</div>
										</div>
										<div class="col-md-5"></div>
										<div class="col-md-2">
											<button class="submit btn btn-danger" name="crearInscripcion" value="preinscrito">Preinscripción</button>
										</div>
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
                                    
                       <%-- <table class="col-md-12 ">                       
                         <tr>
                           <td class="col-md-8 col-xs-8">
                             <div >
                               <div class="panel box-v4">
                                 <div class="panel-heading bg-white border-none">
                                   <h4><span class="icon-notebook icons"></span>Datos</h4>
                                 </div>
                                  <div class="panel-body padding-0">
                                    <div class="col-md-12 col-xs-12 col-md-12 padding-0 box-v4-alert">
                                     
<form action="<%=request.getContextPath()%>/lista-eventos-interesado.do">

<input type="hidden" name="idPreinscripcion" value="${idPreinscripcion }">
<select name="metodoPago">
	<c:forEach items="${listaPagos}" var="Pago">
		<option>${Pago.metodo}</option>
	</c:forEach>
</select><br>
<c:forEach items="${listaUsuarios }" var="Usuario">

<div class="form-group form-animate-text" style="margin-top:40px !important;">
<input type="text" id="nombrePreinscripcion" name="nombrePreinscripcion"  value="${Usuario.nombre }" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
		 <span class="bar"></span>
                    <label>Nombre</label>
		</div> 

<div class="form-group form-animate-text" style="margin-top:40px !important;">
<input type="text" id="apellidoPaternoPreinscripcion" name="apellidoPaternoPreinscripcion" value="${Usuario.apellido_paterno }" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
<span class="bar"></span>
                    <label>Apellido Paterno</label>
		</div> 

<div class="form-group form-animate-text" style="margin-top:40px !important;">
<input type="text" id="apellidoMaternoPreinscripcion" name="apellidoMaternoPreinscripcion"  value="${Usuario.apellido_materno }" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
<span class="bar"></span>
                    <label>Apellido MATERNO</label>
		</div> 

<div class="form-group form-animate-text" style="margin-top:40px !important;">
<input type="number" id="telefonoPreinscripcion" name="telefonoPreinscripcion" value="${Usuario.telefono }" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br>
<span class="bar"></span>
                    <label>Teléfono</label>
		</div> 

<button class="btn" name="confirmarPreinscripcion" value="preinscrito">Preinscribirme</button>
</c:forEach>
</form>
                                      	
                                    </div>
                                    <div class="calendar">
                                       <!-- texto adicional  -->
                                    </div>
                                  </div>
                                </div> 
                            </div>
                           </td>
                       </tr>                       
                      </table> --%>
            
	 <!-- Star Mobile -->		
		<%-- <div id="mimin-mobile" class="reverse ">
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
	      </button> --%>
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
</html>