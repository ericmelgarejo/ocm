<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript.js"></script>
<title>Inicio</title>
<meta charset="utf-8">
  <meta name="description" content="OCM v.1">
  <meta name="author" content="Lipe">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>OCM</title>

  <!-- start: Css -->
  <link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">

  <!-- plugins -->
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
  <link href="asset/css/style.css" rel="stylesheet">
  <!-- end: Css -->

  <link rel="shortcut icon" href="asset/img/logomi.png">
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                <li class="user-name"><span>${correo }</span></li>
                  <li class="dropdown avatar-dropdown">
                   <img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
                   <ul class="dropdown-menu user-dropdown">
                     <li><a href="#"><span class="fa fa-user"></span> Mi Perfil</a></li>
                     <li><a href="#"><span class="fa fa-calendar"></span> Mi Calendario</a></li>
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
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/indexInteresado.jsp"><span class="fa-home fa"></span> Inicio 
                      </a>
                    </li>
                   
                    <li class="active ripple">
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
  		
        <!-- start: Content -->
            <div id="content">
                <div class="panel">
                  <div class="panel-body">
                      <div class="col-md-6 col-sm-12">
                        <h3 class="animated fadeInLeft">Bienvenido a tu Plataforma</h3>
                        <p class="animated fadeInDown"><span class="fa  fa-map-marker"></span> Tecnología,México</p>

                        
                    </div>
                    <div class="col-md-6 col-sm-12">
                        <div class="col-md-6 col-sm-6 text-right" style="padding-left:10px;">
                          <h3 style="color:#DDDDDE;"><span class="fa  fa-map-marker"></span> Queretáro</h3>
                          <h1 style="margin-top: -10px;color: #ddd;">21<sup>o</sup></h1>
                        </div>
                        <div class="col-md-6 col-sm-6">
                        <!--Inicia animacion de Clima-->
                         <div class="suny">
                                    <div class="sun animated pulse infinite">
                                    </div>                             
                                    <div class="mount"></div>
                                    <div class="mount mount1"></div>
                                    <div class="mount mount2"></div>
                                </div>
                        </div>                   
                    </div>
                  </div>                    
                </div>					  
                                    
                       <div class="col-md-12 top-20 padding-0">
                          <div class="col-md-12">
                             <div class="panel">
                                 <div class="panel-heading bg-white border-none">
                                   <h4><span class="icon-notebook icons"></span>Listado de Eventos</h4>
                                 </div>


                                  
                                     <form action="<%=request.getContextPath()%>/detalle-evento-interesado2.do">



		                  <div class="panel-body">
                      <div class="responsive-table">
                      <table id="datatables-example" class="table table-striped table-bordered" width="100%" cellspacing="0">

			               <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Descripción</th>
                          <th>Precio</th>
                          <th></th>
                          
                        </tr>
                      </thead>
			
			<c:if test="${not empty listaEventos}">
		
				<c:forEach items="${listaEventos}" var="miEvento">
        <tbody>
				<tr><td> 
						${miEvento.nombre}
				</td><td>
						${miEvento.descripcion}
				</td><td>
						${miEvento.precio}
				</td><td>		
				 		<button class="btn" name="detallesEvento" value="${miEvento.id_evento}">Ver Detalles</button>
				 </td>
				 		
				 	
				 </td></tr>
				</c:forEach>
			</c:if>		
	
					
	</form>
                                      	
                                   
                                   
                          </td>
                       </tr>
                       </tbody>                       
                      </table>
                          </div>
                  </div>
            
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
                 <form action="<%=request.getContextPath()%>/lista-eventos-interesado.do">
		<button class="btn" name = "opcion" value="verListadoEventos">Ver Eventos</button>
	</form>
	<form action="<%=request.getContextPath()%>/lista-inscripciones.do">
		<button class="btn"  name = "opcion" value="verListadoInscripciones">Ver Inscripciones</button>
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