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
                      <a href="<%=request.getContextPath()%>/indexInteresado.jsp"><span class="fa-home fa"></span> Inicio 
                      </a>
                    </li>
                    
					<li class="ripple">
                      <a href="<%=request.getContextPath()%>/lista-eventos-interesado.do?opcion=verListadoEventos"> 
                      <span class="fa-calendar fa"></span> Ver Eventos 
                      </a>
                    </li>
                    
                    <li class="active ripple">
                      <a href="<%=request.getContextPath()%>/lista-inscripciones.do?opcion=verListadoInscripciones">
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
										<form action="<%=request.getContextPath()%>/pagar-evento.do">
											<table id="datatables-example" class="table table-striped table-bordered dataTable no-footer" width="100%" cellspacing="0" role="grid" aria-describedby="datatables-example_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Evento
														</th>
														<!-- <th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Instructor
														</th> -->
														<!-- <th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Curso
														</th> --> 
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Metodo de Pago
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Nombre
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 80px; text-align: center; ">
															Apellido Paterno
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Apellido Materno
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Teléfono
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
														</th>
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty listaInscripcionesUsuario}">
														<c:forEach items="${listaInscripcionesUsuario}" var="Inscripcion">
															<tr>
																<td style="text-align: center;">${Inscripcion.nombre_evento}</td>
 																<%-- <td style="text-align: center;">${Inscripcion.nombre_curso}</td> --%>
 																<td style="text-align: center;">${Inscripcion.pago}</td>
																<td style="text-align: center;">${Inscripcion.nombre}</td>
																<td style="text-align: center;">${Inscripcion.apellido_paterno}</td>
																<td style="text-align: center;">${Inscripcion.apellido_materno}</td>
																<td style="text-align: center;">${Inscripcion.telefono} </td>
																
																<td style="text-align: center;">
																<c:if test="${Inscripcion.estado == '0' }">
																<div class="col-md-3"></div>
																<div class="col-md-2">
																	<button class="submit btn btn-danger" name="pagarEvento" value="${Inscripcion.id_inscripcion}">&nbsp;Pagar&nbsp;&nbsp;</button>
																</div>	
																</c:if>
																<c:if test="${Inscripcion.estado == '1' }">
																<div class="col-md-3"></div>
																<div class="col-md-2">
																	<button class="submit btn btn-success" onclick="alert('Gracias por su pago :)')" disabled>Pagado</button>
																</div>	
																</c:if>
																</td>
															</tr>
														</c:forEach>
													</c:if>		
												</tbody>
											</table>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			

      

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