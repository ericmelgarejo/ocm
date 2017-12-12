
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <style>
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

}
.logo-menu{
width:100%;
background-color: #2196F3;
border-radius: 20%;
}
section#eventos .evento{
			width: 300px;
			min-height: 400px;
			display: inline-block;
			box-shadow: 0px 0px 10px rgba(4,4,4,.8);
			margin: 10px;
			border-radius: 45px;
		}
		section#eventos .evento:hover{
			box-shadow: 0px 0px 25px rgba(4,4,4,.8);
			text-shadow: 0px 0px 2px rgba(4,4,4,.8);
		}
		section#eventos .evento:hover h2{
			color: white;
		}
		section#news{
			box-shadow: 0px 0px 10px rgba(4,4,4,.8);
			width: 240px;
			margin: 0 auto;
			height: 150px;
		}
		section#recivo{
			box-shadow: 0px 0px 10px rgba(4,4,4,.8);
			width: 350px;
			min-height: 350px;
			margin: 0 auto;
			padding: 15px;
			text-align: center;
			display: none;
		}
</style> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript.js"></script>
<title>Inicio</title>
<meta charset="utf-8">
	<meta name="description" content="Miminium Admin Template v.1">
	<meta name="author" content="Isna Nur Azis">
	<meta name="keyword" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>OCM</title>
 
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
 
 	<nav class="navbar navbar-default header navbar-fixed-top">
          <div class="col-md-12 nav-wrapper">
            <div class="navbar-header" style="width:100%;">
              
                <a href="index.html" class="navbar-brand"> 
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
      <!-- end: Header -->

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
			
			<div class="col-md-11">
			<div class="col-md-1">
			
			<button class="btn btn-success" style="font-size:20px!important;" onclick="window.location.href='preinscripcion.jsp?idEvento=${param.preinscripcionEvento}'">+</button>
			
				
			</div>
			</div>
			<div class="col-md-12 top-20 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<h3>Inscripcion</h3>
						</div>
						
						<div class="panel-body">
							<div class="responsive-table">
								<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="row">
										<div class="col-sm-12">
										<form action="<%=request.getContextPath()%>/listar-evento.do">
											<table id="datatables-example" class="table table-striped table-bordered dataTable no-footer" width="100%" cellspacing="0" role="grid" aria-describedby="datatables-example_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Nombre del Evento
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
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Método de Pago
														</th>
														
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															
														</th>
														
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty listaPreinscripciones}">
														<c:forEach items="${listaPreinscripciones}" var="Preinscripcion">
															<tr>
																<td style="text-align: center;">${Preinscripcion.nombre_evento}<input type="hidden" name="idPagarEvento" value="${Preinscripcion.id_evento }"></td>
																<td style="text-align: center;">${Preinscripcion.nombre}</td>
																<td style="text-align: center;">${Preinscripcion.apellido_paterno}</td>
																<td style="text-align: center;">${Preinscripcion.apellido_materno}</td>
																<td style="text-align: center;">${Preinscripcion.telefono}</td>
																<td style="text-align: center;">${Preinscripcion.pago}</td>
																<c:if test="${Preinscripcion.estado == 0 }">
																 	<td style="text-align: center;"><button class="btn btn-danger" name="pagarEvento" value="${Preinscripcion.id_usuario }">Pagar</button></td>
																
																</c:if>
																<c:if test="${Preinscripcion.estado == 1 }">
																 	<td style="text-align: center;"><button class="btn btn-success" name="modificarEvento" value="${Evento.id_evento }" disabled>Pagado</button></td>
																
																</c:if>
																
																
																
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