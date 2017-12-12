<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript.js"></script>
<title>Inscripciones</title>
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
					<li class="user-name" style="padding-top: 5px">
                	<span>${pageContext.request.userPrincipal.name}</span>
                	<a href="inicio.jsp" style="padding:0">Cerrar Sesion</a>
                </li>
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
                      <span class="fa-tasks fa"></span> Dashboard 
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
						<h3 class="animated fadeInLeft">Ver Inscripciones</h3>                    
					</div>
				</div>
			</div>
			
			<div class="col-md-12 top-20 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<h3>Inscripciones</h3>
						</div>
						
						<div class="panel-body">
							<div class="responsive-table">
								<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="row">
										<div class="col-sm-12">
											<table id="datatables-example" class="table table-striped table-bordered dataTable no-footer" width="100%" cellspacing="0" role="grid" aria-describedby="datatables-example_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Evento
														</th>
														<!-- <th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Instructor
														</th> -->
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Metodo de Pago
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Nombre
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Apellido Paterno
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Apellido Materno
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Teléfono
														</th>
														<!-- <th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px;">
														</th> -->
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty listaInscripciones}">
														<c:forEach items="${listaInscripciones}" var="Inscripcion">
															<tr>
																<td style="text-align: center;">${Inscripcion.nombre_evento}</td>
																<%-- <td style="text-align: center;">${Inscripcion.nombre_instructor}</td> --%>
						 										<td style="text-align: center;">${Inscripcion.pago}</td>
																<td style="text-align: center;">${Inscripcion.nombre}</td>
																<td style="text-align: center;">${Inscripcion.apellido_paterno}</td>
																<td style="text-align: center;">${Inscripcion.apellido_materno}</td>
																<td style="text-align: center;">${Inscripcion.telefono} </td>
																
																<%-- <td>
																<c:if test="${Inscripcion.estado == '0' }">
																	<button class="btn" name="pagarEvento" value="${Inscripcion.id_inscripcion}">Pagar</button>
																</c:if>
																</td> --%>
															</tr>
														</c:forEach>
													</c:if>		
												</tbody>
											</table>
										</div>
									</div>
								</div>
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
                                   <h4><span class="icon-notebook icons"></span>Inscripciones Actuales</h4>
                                 </div>
                                  <div class="panel-body padding-0">
                                    <div class="col-md-12 col-xs-12 col-md-12 padding-0 box-v4-alert">
                                       
<form name="formaListaInscripciones" action="<%=request.getContextPath()%>/modificar-evento.do">
			
		<table>
			<tr><th>Evento</th><th>Instructor</th><th>Método de Pago</th><th>Nombre del Inscrito</th><th>Apellido Paterno</th><th>Apellido Materno </th><th>Teléfono </th></tr>
			
			<c:if test="${not empty listaInscripciones}">
				
				 <c:forEach items="${listaInscripciones}" var="Inscripcion">
				<tr><td> 
						${Inscripcion.id_inscripcion}
				</td><td>
						${Inscripcion.id_usuario}
				</td><td>
						${Inscripcion.pago}
				</td><td>
						${Inscripcion.nombre}
				</td><td>
						${Inscripcion.apellido_paterno}
				</td><td>
				 		${Inscripcion.apellido_materno}
				 </td><td>
				 		${Inscripcion.telefono}
				 </td><td>
				 		<button onclick="eliminarEvento()" name="eliminarEvento" value="${miEvento.id_evento}">Eliminar</button>
				 		
				 	
				 </td></tr>
				</c:forEach> 
			</c:if>		
		</table>
							
	</form>
	
                                    </div>
                                    <div class="calendar">
                                       <!-- texto adicional  -->
                                    </div>
                                  </div>
                                </div> 
                            </div>
                           </td>
                           <td class="col-md-4 col-xs-4">
                            <div >
                             <div >
                              <div class="panel box-v2 ">
                                  <div class="panel-heading padding-0">
                                    <img src="asset/img/bg2.jpg" class="box-v2-cover img-responsive"/>
                                    <div class="box-v2-detail">
                                      <img src="asset/img/avatar.jpg" class="img-responsive"/>
                                      <h4>Aquí el usuario</h4>
                                    </div>
                                  </div>
                                  <div class="panel-body azul2">
                                    <div class="col-md-12 padding-0 text-center ">
                                      <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                                          <h3>2.000</h3>
                                          <p>Post</p>
                                      </div>
                                      <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                                          <h3>2.232</h3>
                                          <p>share</p>
                                      </div>
                                      <div class="col-md-4 col-sm-4 col-xs-12 padding-0">
                                          <h3>4.320</h3>
                                          <p>photos</p>
                                      </div>
                                    </div>
                                  </div>
                              </div>
                             </div>
                            </div>
                          </td>
                       </tr>                       
                      </table>
            
	 <!-- Star Mobile -->		
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
             	<form name="form" action="<%=request.getContextPath()%>/crear-evento.do">
					<button class="btn btn-primary " name = "opcion" value="inicioAltaEvento">Crear Evento</button><br><br>
					<button class="btn btn-primary " onclick="listarEventos()" name = "opcion" value="verListadoEventos">Ver Eventos</button><br><br>
					<button class="btn btn-primary " onclick="verInscripciones()" name="opcion" value="verInscripciones">Ver Inscripciones</button><br><br>
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
	