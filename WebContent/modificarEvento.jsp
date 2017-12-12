<%@page import="vo.PaisVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.btn{
width:100%;
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
    <title>OCM</title>
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
        
        <div class="container-fluid mimin-wrapper">
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
                    
					<li class="ripple">
                      <a href="<%=request.getContextPath()%>/listar-inscripciones.do?opcion=verEventos">
                      <span class="fa-tasks fa"></span> Dashboard 
                      </a>
                    </li>
                    
                                       
                  </ul>
                </div>
            </div>
            
            <div id="content">
            	<div class="panel box-shadow-none content-header">
                  <div class="panel-body">
                    <div class="col-md-12">
                        <h3 class="animated fadeInLeft">Modificar</h3>
                    </div>
                  </div>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-10">
                  <div class="col-md-12 panel">
                    <div class="col-md-12 panel-heading">
                      <h4>Información Evento</h4>
                    </div>
                    <div class="col-md-12 panel-body" style="padding-bottom:30px;">
						<!--DESDE AQUI -->
                      <div class="col-md-12">
                      
	
		
                        <form class="cmxform" id="signupForm" action="<%=request.getContextPath()%>/listar-evento.do">
                        <c:forEach items="${listaDatosEvento}" var="Evento">
                        <input type="hidden" id="idEvento" name="idEvento" value="${Evento.id_evento}">
                          <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                              <input type="text" id="nombreModificarEvento" name="nombreModificarEvento" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" value="${Evento.nombre }" required>
                              <span class="bar"></span>
                              <label>Nombre del Evento</label>
                            </div>

                            <div class="form-group form-animate-text">
	                          <input type="text" id="fechaInicioModificarEvento" title="Ingresa la Fecha de Inicio" name="fechaInicioModificarEvento" class="form-text dateAnimate" value="${Evento.fecha_inicio}" required>
	                          <span class="bar"></span>
	                          <label>Fecha Inicio</label>
	                        </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
		                        <input type="number" id="precioModificarEvento" name="precioModificarEvento" class="form-text" value="${Evento.precio }" required title="Ingresa el precio">
		                        <span class="bar"></span>
		                        <label>Precio</label>
		                      </div>
		                      
		                      
                          </div>

                          <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                              <input type="text" id="descripcionModificarEvento" name="descripcionModificarEvento"  class="form-text" title="Solo letras numeros y espacios" value="${Evento.descripcion }" required>
                              <span class="bar"></span>
                              <label>Descripción</label>
                            </div>

                            <div class="form-group form-animate-text">
	                          <input type="text" id="fechaFinModificarEvento" title="Ingresa la Fecha de Término" name="fechaFinModificarEvento" class="form-text dateAnimate" value="${Evento.fecha_fin }" required>
	                          <span class="bar"></span>
	                          <label>Fecha Fin</label>
	                        </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
		                        <input type="number" id="capacidadModificarEvento" name="capacidadModificarEvento" class="form-text" required title="Ingresa la capacidad" value="${Evento.capacidad }">
		                        <span class="bar"></span>
		                        <label>Capacidad</label>
		                      </div>
                          </div>
                          </div>
                          
                          <div class="col-md-4">
                          	<div class="col-sm-12 padding-0">
                          	<p>País:</p>	
                                  <select class="form-control" id="selectPais">
									<option value="0" selected>Selecciona el país...</option>
									<c:forEach items="${listaPaises }" var = "Pais">
										<c:if test="${idPais == Pais.ID_Pais }">
											<option selected value="${Pais.ID_Pais }">${Pais.nombre }</option>
										</c:if>
										<c:if test="${idPais != Pais.ID_Pais }">
											<option value="${Pais.ID_Pais }">${Pais.nombre }</option>
										</c:if>		
									</c:forEach>
								</select>
                                </div>
                          </div>  
                          
                          <div class="col-md-4">
                          	<div class="col-sm-12 padding-0">
                                  <p>Ciudad:</p>
                                  <select class="form-control" id="selectCiudad" name="selectCiudad">
                                  <option selected>Selecciona la ciudad...</option>	
									<c:forEach items="${listaCiudades }" var = "Ciudad">
										<c:if test="${idCiudad == Ciudad.id }">
											<option id="${Ciudad.id }" value="${Ciudad.id }" selected>${Ciudad.nombre }</option>
										</c:if>
										<%-- <c:if test="${idPrograma != Programa.id }">
											<option id="${Programa.id }" value="${Programa.id }" >${Programa.nombre }</option>
											
										</c:if> --%>
									</c:forEach>
								</select>	
                                </div>
                          </div>
                          
                          <div class="col-md-4">
                          	<div class="col-sm-12 padding-0">
                                  <p>Lugar:</p>		
									<select class="form-control" id="selectLugar" name="selectLugar">
									<option value="0">Selecciona el lugar...</option>
										<c:forEach items="${listaLugares }" var="Lugar">
										
											<c:if test="${Evento.id_lugar == Lugar.id}">
												<option selected id="${Lugar.id}" value="${Lugar.id }">${Lugar.nombre }</option>
											</c:if>
										
										</c:forEach>
										
										
									</select>
                                </div>
                          </div>
                          
                          <p style="color: white;">.</p>
                          <div class="col-md-4">
                          	<div class="col-sm-12 padding-0">
                          	<p>Instructor:</p>
                                  <select class="form-control" name="selectInstructor">
                                  	<option value="0" selected> Selecciona el instructor...</option>
									<c:forEach items="${listaInstructores }" var = "Instructor">
										<c:if test="${Evento.id_usuario == Instructor.id_instructor}">
											<option selected id="${Instructor.id_instructor }" value="${Instructor.id_instructor }">${Instructor.nombre } ${Instructor.apellido_paterno} ${Instructor.apellido_materno}</option>
										</c:if>
										<c:if test="${Evento.id_usuario != Instructor.id_instructor}">
											<option id="${Instructor.id_instructor }" value="${Instructor.id_instructor }">${Instructor.nombre } ${Instructor.apellido_paterno} ${Instructor.apellido_materno}</option>
				
										</c:if>
									</c:forEach>
                                  </select>
                                </div>
                          </div>
                          <div class="col-md-4">
                          	<div class="col-sm-12 padding-0">
                          	<p>Programa:</p>
                                  <select class="form-control" id="selectPrograma" name="selectPrograma">
                                  	<option selected> Selecciona el programa...</option>
                                  	<option value="0">Por asignar</option>
									<c:forEach items="${listaProgramas }" var = "Programa">
										<c:if test="${idPrograma == Programa.id }">
											<option id="${Programa.id }" value="${Programa.id }" selected>${Programa.nombre }</option>
										</c:if>
										<c:if test="${idPrograma != Programa.id }">
											<option id="${Programa.id }" value="${Programa.id }" >${Programa.nombre }</option>
											
										</c:if>
									</c:forEach>
                                  </select>
                                </div>
                          </div> 
                          <div class="col-md-4">
                          	<div class="col-sm-12 padding-0">
                          	<p>Curso:</p>
                                  <select class="form-control" id="selectCurso" name="selectCurso">
                                  	<option value="0" selected> Selecciona el curso...</option>
									<c:forEach items="${listaCursos }" var = "Curso">
										<c:if test="${Evento.id_curso == Curso.id}">
											<option selected id="${Curso.id}" value="${Curso.id }">${Curso.nombre }</option>
										</c:if>
										
									</c:forEach>
                                  </select>
                                </div>
                          </div>
                          
                          <div class="col-md-4">
                          	<div class="col-sm-12 padding-0">
                          	<p>Destinatarios:</p>
                                  <select class="form-control" name="selectDestinatario">
                                  
                                  	<option> Selecciona el destinatario...</option>
                                  	<option value="0">Por asignar</option>
									<c:forEach items="${listaDestinatarios }" var = "Destinatario">
									
										<c:if test="${Evento.id_destinatario == Destinatario.id_destinatario}">
										
											<option selected id="${Destinatario.id_destinatario }" value="${Destinatario.id_destinatario }">${Destinatario.nombre }</option>
										</c:if>
										 <c:if test="${Evento.id_destinatario != Destinatario.id_destinatario}">
											<option id="${Destinatario.id_destinatario }" value="${Destinatario.id_destinatario }">${Destinatario.nombre}</option>
				
										</c:if> 
									</c:forEach>
                                  </select>
                                </div>
                          </div> 
                          <p style="color:white;">.</p>  
                          <div class="col-md-1"></div>
                          
                          <div class="col-md-4 " style="padding:20px;padding-bottom:0px;">
                          <c:if test="${Evento.tipo == 'Publico' }">
	                        <div class="form-animate-radio">
	                          <label class="radio">
	                            <input id="radio1" type="radio" name="tipoModificarEvento" value="Publico" checked/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Público
	                            </label>
	                            <br>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="tipoModificarEvento" value="Privado"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Privado
	                            </label>
	                          </div>
	                      </c:if>
	                      <c:if test="${Evento.tipo == 'Privado' }">
	                        <div class="form-animate-radio">
	                          <label class="radio">
	                            <input id="radio1" type="radio" name="tipoModificarEvento" value="Publico"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Público
	                            </label>
	                            <br>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="tipoModificarEvento" value="Privado" checked/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Privado
	                            </label>
	                          </div>
	                      </c:if>     
	                      </div>  
	                      
	                      <div class="col-md-2"></div> 
	                      <div class="col-md-4 " style="padding:20px;padding-bottom:0px;">
                          <c:if test="${Evento.promocion == 'SEB' }">
	                        <div class="form-animate-radio">
	                          <label class="radio">
	                            <input id="radio1" type="radio" name="promocion" value="SEB" checked/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Super Early Bird
	                            </label>
	                            <br>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="EB"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Early Bird
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="10"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 10% para 2 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="15"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 15% para 3 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="na"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Sin promoción
	                            </label>
	                          </div>
	                      </c:if>
	                     <c:if test="${Evento.promocion == 'EB' }">
	                        <div class="form-animate-radio">
	                          <label class="radio">
	                            <input id="radio1" type="radio" name="promocion" value="SEB" />
	                            <span class="outer">
	                              <span class="inner"></span></span> Super Early Bird
	                            </label>
	                            <br>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="EB" checked/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Early Bird
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="10"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 10% para 2 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="15"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 15% para 3 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="na"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Sin promoción
	                            </label>
	                          </div>
	                      </c:if>
	                      <c:if test="${Evento.promocion == '10' }">
	                        <div class="form-animate-radio">
	                          <label class="radio">
	                            <input id="radio1" type="radio" name="promocion" value="SEB" />
	                            <span class="outer">
	                              <span class="inner"></span></span> Super Early Bird
	                            </label>
	                            <br>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="EB"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Early Bird
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="10" checked/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 10% para 2 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="15"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 15% para 3 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="na"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Sin promoción
	                            </label>
	                          </div>
	                      </c:if>
	                      
	                      <c:if test="${Evento.promocion == '15' }">
	                        <div class="form-animate-radio">
	                          <label class="radio">
	                            <input id="radio1" type="radio" name="promocion" value="SEB" />
	                            <span class="outer">
	                              <span class="inner"></span></span> Super Early Bird
	                            </label>
	                            <br>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="EB"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Early Bird
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="10"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 10% para 2 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="15" checked/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 15% para 3 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="na"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Sin promoción
	                            </label>
	                          </div>
	                      </c:if>
	                      <c:if test="${Evento.promocion == 'na' }">
	                       <div class="form-animate-radio">
	                          <label class="radio">
	                            <input id="radio1" type="radio" name="promocion" value="SEB" />
	                            <span class="outer">
	                              <span class="inner"></span></span> Super Early Bird
	                            </label>
	                            <br>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="EB"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Early Bird
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="10"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 10% para 2 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="15"/>
	                            <span class="outer">
	                              <span class="inner"></span></span> 15% para 3 personas
	                            </label>
	                            <label class="radio">
	                            <input id="radio2" type="radio" name="promocion" value="na" checked/>
	                            <span class="outer">
	                              <span class="inner"></span></span> Sin promoción
	                            </label>
	                          </div>
	                      </c:if>  
	                      </div> 
	                      <div class="col-md-4"></div>
                          <div class="col-md-4">
                              <button class="submit btn btn-danger" name="confirmarModificarEvento" value="modificar">Modificar</button>
                        </div>
                        </c:forEach>
                      </form>
                    </div>
                    <!-- HASTA AQUI -->
                  </div>
                </div>
              </div>
            </div>
        </div>
 <!-- start: Header -->
<!--         <nav class="navbar navbar-default header navbar-fixed-top"> -->
<!--           <div class="col-md-12 nav-wrapper"> -->
<!--             <div class="navbar-header" style="width:100%;"> -->
<!--               <div class="opener-left-menu is-open"> -->
<!--                 <span class="top"></span> -->
<!--                 <span class="middle"></span> -->
<!--                 <span class="bottom"></span> -->
<!--               </div> -->
<!--                 <a href="index.html" class="navbar-brand">  -->
<!--                  <b><img src="img/itu.png" width="45%"/></b> -->
<!--                 </a> -->
		
<!--               <ul class="nav navbar-nav navbar-right user-nav"> -->
<!--                 <li class="user-name"><span>Akihiko Avaron</span></li> -->
<!--                   <li class="dropdown avatar-dropdown"> -->
<!--                    <img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/> -->
<!--                    <ul class="dropdown-menu user-dropdown"> -->
<!--                      <li><a href="#"><span class="fa fa-user"></span> My Profile</a></li> -->
<!--                      <li><a href="#"><span class="fa fa-calendar"></span> My Calendar</a></li> -->
<!--                      <li role="separator" class="divider"></li> -->
<!--                      <li class="more"> -->
<!--                       <ul> -->
<!--                         <li><a href=""><span class="fa fa-cogs"></span></a></li> -->
<!--                         <li><a href=""><span class="fa fa-lock"></span></a></li> -->
<!--                         <li><a href=""><span class="fa fa-power-off "></span></a></li> -->
<!--                       </ul> -->
<!--                     </li> -->
<!--                   </ul> -->
<!--                 </li> -->
               
<!--               </ul> -->
<!--             </div> -->
<!--           </div> -->
<!--         </nav> -->
<!--       end: Header -->

<!--       <div class="container-fluid mimin-wrapper"> -->
  
<!--           start:Left Menu -->
<!--             <div id="left-menu"> -->
<!--               <div class="sub-left-menu scroll"> -->
<%--                	<form name="form" action="<%=request.getContextPath()%>/crear-evento.do"> --%>
<!-- 		<button class="btn btn-primary " name = "opcion" value="inicioAltaEvento">Crear Evento</button><br><br> -->
<!-- 		<button class="btn btn-primary " onclick="listarEventos()" name = "opcion" value="verListadoEventos">Ver Eventos</button><br><br> -->
<!-- 		<button class="btn btn-primary " onclick="verInscripciones()" name="opcion" value="verInscripciones">Ver Inscripciones</button><br><br> -->
<!-- 	</form> -->
	
<%-- 	<form action="<%=request.getContextPath()%>/preinscripcion-interesado.do"> --%>
<!-- 		<button class="btn btn-primary " name = "preinscripcion" value="inicioAltaInscripcion">Inscripciones</button> -->
<!-- 	</form> -->
               
<!--                 </div> -->
<!--             </div> -->
<!--           end: Left Menu -->

  		
<!--           start: content -->
<!--  <div id="content"> -->
<!--                 <div class="panel"> -->
<!--                   <div class="panel-body"> -->
<!--                       <div class="col-md-6 col-sm-12"> -->
<!--                         <h3 class="animated fadeInLeft">Crear un evento</h3> -->
                    
<!--                     </div> -->
<!-- 							  </div> -->
<!-- 							  </div> -->
							  
                
                     
<!--                        <table class="col-md-12 "> -->
                       
<!--                        <tr> -->
<!--                        <td class="col-md-8 col-xs-8"> -->
<!--                           <div > -->
<!--                                 <div class="panel box-v4"> -->
<!--                                     <div class="panel-heading bg-white border-none"> -->
<!--                                       <h4><span class="icon-notebook icons"></span>Evento Nuevo</h4> -->
<!--                                     </div> -->
<!--                                     <div class="panel-body padding-0"> -->
<!--                                         <div height="100%" class="col-md-12 col-xs-12 col-md-12 padding-0 box-v4-alert"> -->
                                          
<%--                                          	<form action="<%=request.getContextPath()%>/listar-evento.do"> --%>
<!-- 	 <div class="panel periodic-login" style="height="100%"> -->
<!-- 	   <div class="panel-body text-center"> -->
	   

                  

<!-- 	<div class="form-group form-animate-text" style="margin-top:40px !important;"> -->
			
<!-- 		<input type="text" id="nombreCrearEvento" name="nombreCrearEvento" class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required> <br> -->
<!-- 		 <span class="bar"></span> -->
<!--                     <label>Nombre</label> -->
<!-- 		</div> -->
<!-- 		<div class="form-group form-animate-text" style="margin-top:40px !important;"> -->
<!-- 			<input type="text" id="descripcionCrearEvento" name="descripcionCrearEvento"  class="form-text" pattern="[A-Za-z0-9 ]+" title="Solo letras numeros y espacios" required><br> -->
		
<!-- 				 <span class="bar"></span> -->
<!--                     <label>Descripcion</label> -->
<!-- 		</div> -->
		
		
<!-- 		<input type="radio" name="tipoEvento" value="Publico" checked required> Público -->
<!-- 		<input type="radio" name="tipoEvento" value="Privado" required> Privado <br> -->
		
<!-- 		<div class="form-group form-animate-text" style="margin-top:40px !important;"> -->
<!-- 		<input type="number" id="precioCrearEvento" name="precioCrearEvento" class="form-text" pattern="[0-9]" title="Solo numeros" required><br> -->
<!-- 				 <span class="bar"></span> -->
<!--                     <label>Precio $</label> -->
<!-- 		</div> -->
<!-- 		<div class="form-group form-animate-text" style="margin-top:40px !important;"> -->
		
<!-- 			<input type="number" id="capacidadCrearEvento" name="capacidadCrearEvento" class="form-text" pattern="[0-9]" title="Solo numeros" required><br> -->
		
<!-- 				 <span class="bar"></span> -->
<!--                     <label>Capacidad</label> -->
<!-- 		</div> -->
<!-- 		<div class="form-group form-animate-text" style="margin-top:40px !important;"> -->
<!-- 		<input type="text" id="fechaInicioCrearEvento" name="fechaInicioCrearEvento"  class="form-text" pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" title="Día/Mes/Año ejemplo (30/12/1999)" required><br> -->
		
<!-- 				 <span class="bar"></span> -->
<!--                     <label>Fecha Inicio dd/mm/aaaa</label> -->
<!-- 		</div> -->
<!-- 		<div class="form-group form-animate-text" style="margin-top:40px !important;"> -->
		 
<!-- 		<input type="text" id="fechaFinCrearEvento" name="fechaFinCrearEvento"  class="form-text" pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" title="Día/Mes/Año ejemplo (30/12/1999)" required><br> -->
		
<!-- 				 <span class="bar"></span> -->
<!--                     <label>Fecha Fin dd/mm/aaaa</label> -->
<!-- 		</div> -->
		
<!-- 		<p>Selecciona el país:</p>	 -->
			
<!-- 		<select  class="form-control"> -->
<%-- 			<c:forEach items="${listaPaises }" var = "Pais"> --%>
<%-- 				<option id=${Pais.ID_Pais } value="${Pais.ID_Pais }" >${Pais.nombre } </option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select> -->
		
<!-- 		<p>Selecciona el instructor:</p>		 -->
<!-- 		<select  class="form-control"> -->
<%-- 			<c:forEach items="${listaInstructores }" var = "Instructor"> --%>
<%-- 				<option id="${Instructor.id_usuario }" value="${Instructor.id_usuario }">${Instructor.nombre } ${Instructor.apellido_paterno} ${Instructor.apellido_materno}</option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select> -->
		
<!-- 		<p>Selecciona el curso:</p>		 -->
<!-- 		<select  class="form-control"> -->
<%-- 			<c:forEach items="${listaCursos }" var = "Curso"> --%>
<%-- 				<option id="${Curso.id }" value="${Curso.id }">${Curso.nombre }</option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select> -->
		
<!-- 		<p>Selecciona la promoción:</p>	 -->
		
<!-- 		<input type="radio" name="promocion" value="SEB" checked required>SEB (Super Early Bird)<br> -->
<!-- 		<input type="radio" name="promocion" value="EB" required>EB (Early Bird)<br> -->
<!-- 		<input type="radio" name="promocion" value="10" required> 2 personas 10%<br> -->
<!-- 		<input type="radio" name="promocion" value="15" required> 3 personas 15%<br> -->
<!-- 		<input type="radio" name="promocion" value="na" required> Sin promoción	 -->
<!-- 		<br> -->
<!-- 		<br> -->
<!-- 		<button class="btn btn-primary" name ="opcion" value="crearNuevoEvento">Crear Evento</button> -->
<!-- 		</div> -->
<!-- 		</div> -->

<!-- 	</form> -->
<!--                                         </div> -->
<!--                                         <div class="calendar"> -->
                                          
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div>  -->
<!--                             </div> -->
<!--                        </td> -->
<!--                        <td class="col-md-4 col-xs-4"> -->
<!--                          <div > -->
<!--                             <div > -->
<!--                               <div class="panel box-v2"> -->
<!--                                   <div class="panel-heading padding-0"> -->
<!--                                     <img src="asset/img/bg2.jpg" class="box-v2-cover img-responsive"/> -->
<!--                                     <div class="box-v2-detail"> -->
<!--                                       <img src="asset/img/avatar.jpg" class="img-responsive"/> -->
<!--                                       <h4>Akihiko Avaron</h4> -->
<!--                                     </div> -->
<!--                                   </div> -->
<!--                                   <div class="panel-body"> -->
<!--                                     <div class="col-md-12 padding-0 text-center"> -->
<!--                                       <div class="col-md-4 col-sm-4 col-xs-6 padding-0"> -->
<!--                                           <h3>2.000</h3> -->
<!--                                           <p>Post</p> -->
<!--                                       </div> -->
<!--                                       <div class="col-md-4 col-sm-4 col-xs-6 padding-0"> -->
<!--                                           <h3>2.232</h3> -->
<!--                                           <p>share</p> -->
<!--                                       </div> -->
<!--                                       <div class="col-md-4 col-sm-4 col-xs-12 padding-0"> -->
<!--                                           <h3>4.320</h3> -->
<!--                                           <p>photos</p> -->
<!--                                       </div> -->
<!--                                     </div> -->
<!--                                   </div> -->
<!--                               </div> -->
<!--                             </div> -->
<!--                             </div> -->
<!--                        </td> -->
<!--                        </tr>                        -->
<!--                        </table> -->
            
					
<!-- 					 <div id="mimin-mobile" class="reverse"> -->
<!--         <div class="mimin-mobile-menu-list"> -->
<!--             <div class="col-md-12 sub-mimin-mobile-menu-list animated fadeInLeft"> -->
<!--                  <div id="left-menu"> -->
<!--               <div class="sub-left-menu scroll"> -->
<%--                	<form name="form" action="<%=request.getContextPath()%>/crear-evento.do"> --%>
<!-- 		<button class="btn btn-primary " name = "opcion" value="inicioAltaEvento">Crear Evento</button><br><br> -->
<!-- 		<button class="btn btn-primary " onclick="listarEventos()" name = "opcion" value="verListadoEventos">Ver Eventos</button><br><br> -->
<!-- 		<button class="btn btn-primary " onclick="verInscripciones()" name="opcion" value="verInscripciones">Ver Inscripciones</button><br><br> -->
<!-- 	</form> -->
	
<%-- 	<form action="<%=request.getContextPath()%>/preinscripcion-interesado.do"> --%>
<!-- 		<button class="btn btn-primary " name = "preinscripcion" value="inicioAltaInscripcion">Inscripciones</button> -->
<!-- 	</form> -->
               
<!--                 </div>                 -->
<!--             </div> -->
                  	
<!--             </div>             -->
<!--         </div>              -->
<!--       </div> -->
<!--       <button id="mimin-mobile-menu-opener" class="animated rubberBand btn btn-circle btn-danger"> -->
<!--         <span class="fa fa-bars"></span> -->
<!--       </button> -->
       <!-- end: Mobile -->
					
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


<script src="asset/js/jquery.min.js"></script>
<script src="asset/js/jquery.ui.min.js"></script>
<script src="asset/js/bootstrap.min.js"></script>


<!-- plugins -->
<script src="asset/js/plugins/moment.min.js"></script>
<script src="asset/js/plugins/jquery.knob.js"></script>
<script src="asset/js/plugins/ion.rangeSlider.min.js"></script>
<script src="asset/js/plugins/bootstrap-material-datetimepicker.js"></script>
<script src="asset/js/plugins/jquery.nicescroll.js"></script>
<script src="asset/js/plugins/jquery.mask.min.js"></script>
<script src="asset/js/plugins/select2.full.min.js"></script>
<script src="asset/js/plugins/nouislider.min.js"></script>
<script src="asset/js/plugins/jquery.validate.min.js"></script>


<!-- custom -->
<script src="asset/js/main.js"></script>
<script type="text/javascript">

// 	function listarEventos(){
<%-- 		document.forms["form"].action = "<%=request.getContextPath()%>/listar-evento.do"; --%>
// 		document.forms["form"].submit();
//  	}
	
// 	function verInscripciones(){
<%-- 		document.forms["form"].action = "<%=request.getContextPath()%>/listar-inscripciones.do"; --%>
// 		document.forms["form"].submit();
// 	}
	
	  $(document).ready(function(){

	    $("#signupForm").validate({
	      errorElement: "em",
	      errorPlacement: function(error, element) {
	        $(element.parent("div").addClass("form-animate-error"));
	        error.appendTo(element.parent("div"));
	      },
	      success: function(label) {
	        $(label.parent("div").removeClass("form-animate-error"));
	      },
	      rules: {
	        validate_firstname: "required",
	        validate_lastname: "required",
	        validate_username: {
	          required: true,
	          minlength: 2
	        },
	        validate_password: {
	          required: true,
	          minlength: 5
	        },
	        validate_confirm_password: {
	          required: true,
	          minlength: 5,
	          equalTo: "#validate_password"
	        },
	        validate_email: {
	          required: true,
	          email: true
	        },
	        validate_agree: "required"
	      },
	      messages: {
	        validate_firstname: "Please enter your firstname",
	        validate_lastname: "Please enter your lastname",
	        validate_username: {
	          required: "Please enter a username",
	          minlength: "Your username must consist of at least 2 characters"
	        },
	        validate_password: {
	          required: "Please provide a password",
	          minlength: "Your password must be at least 5 characters long"
	        },
	        validate_confirm_password: {
	          required: "Please provide a password",
	          minlength: "Your password must be at least 5 characters long",
	          equalTo: "Please enter the same password as above"
	        },
	        validate_email: "Please enter a valid email address",
	        validate_agree: "Please accept our policy"
	      }
	    });

	    // propose username by combining first- and lastname
	    $("#username").focus(function() {
	      var firstname = $("#firstname").val();
	      var lastname = $("#lastname").val();
	      if (firstname && lastname && !this.value) {
	        this.value = firstname + "." + lastname;
	      }
	    });


	    $('.mask-date').mask('00/00/0000');
	    $('.mask-time').mask('00:00:00');
	    $('.mask-date_time').mask('00/00/0000 00:00:00');
	    $('.mask-cep').mask('00000-000');
	    $('.mask-phone').mask('0000-0000');
	    $('.mask-phone_with_ddd').mask('(00) 0000-0000');
	    $('.mask-phone_us').mask('(000) 000-0000');
	    $('.mask-mixed').mask('AAA 000-S0S');
	    $('.mask-cpf').mask('000.000.000-00', {reverse: true});
	    $('.mask-money').mask('000.000.000.000.000,00', {reverse: true});
	    $('.mask-money2').mask("#.##0,00", {reverse: true});
	    $('.mask-ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
	      translation: {
	        'Z': {
	          pattern: /[0-9]/, optional: true
	        }
	      }
	    });
	    $('.mask-ip_address').mask('099.099.099.099');
	    $('.mask-percent').mask('##0,00%', {reverse: true});
	    $('.mask-clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
	    $('.mask-placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
	    $('.mask-fallback').mask("00r00r0000", {
	      translation: {
	        'r': {
	          pattern: /[\/]/, 
	          fallback: '/'
	        }, 
	        placeholder: "__/__/____"
	      }
	    });
	    $('.mask-selectonfocus').mask("00/00/0000", {selectOnFocus: true});

	    var options =  {onKeyPress: function(cep, e, field, options){
	      var masks = ['00000-000', '0-00-00-00'];
	      mask = (cep.length>7) ? masks[1] : masks[0];
	      $('.mask-crazy_cep').mask(mask, options);
	    }};

	    $('.mask-crazy_cep').mask('00000-000', options);


	    var options2 =  { 
	      onComplete: function(cep) {
	        alert('CEP Completed!:' + cep);
	      },
	      onKeyPress: function(cep, event, currentField, options){
	        console.log('An key was pressed!:', cep, ' event: ', event, 
	          'currentField: ', currentField, ' options: ', options);
	      },
	      onChange: function(cep){
	        console.log('cep changed! ', cep);
	      },
	      onInvalid: function(val, e, f, invalid, options){
	        var error = invalid[0];
	        console.log ("Digit: ", error.v, " is invalid for the position: ", error.p, ". We expect something like: ", error.e);
	      }
	    };

	    $('.mask-cep_with_callback').mask('00000-000', options2);

	    var SPMaskBehavior = function (val) {
	      return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
	    },
	    spOptions = {
	      onKeyPress: function(val, e, field, options) {
	        field.mask(SPMaskBehavior.apply({}, arguments), options);
	      }
	    };

	    $('.mask-sp_celphones').mask(SPMaskBehavior, spOptions);



// 	    var slider = document.getElementById('noui-slider');
// 	    noUiSlider.create(slider, {
// 	      start: [20, 80],
// 	      connect: true,
// 	      range: {
// 	        'min': 0,
// 	        'max': 100
// 	      }
// 	    });

// 	    var slider = document.getElementById('noui-range');
// 	    noUiSlider.create(slider, {
// 	                        start: [ 20, 80 ], // Handle start position
// 	                        step: 10, // Slider moves in increments of '10'
// 	                        margin: 20, // Handles must be more than '20' apart
// 	                        connect: true, // Display a colored bar between the handles
// 	                        direction: 'rtl', // Put '0' at the bottom of the slider
// 	                        orientation: 'vertical', // Orient the slider vertically
// 	                        behaviour: 'tap-drag', // Move handle on tap, bar is draggable
// 	                        range: { // Slider can select '0' to '100'
// 	                        'min': 0,
// 	                        'max': 100
// 	                      },
// 	                        pips: { // Show a scale with the slider
// 	                          mode: 'steps',
// 	                          density: 2
// 	                        }
// 	                      });



// 	    $(".select2-A").select2({
// 	      placeholder: "Select a state",
// 	      allowClear: true
// 	    });

// 	    $(".select2-B").select2({
// 	      tags: true
// 	    });

// 	    $("#range1").ionRangeSlider({
// 	      type: "double",
// 	      grid: true,
// 	      min: -1000,
// 	      max: 1000,
// 	      from: -500,
// 	      to: 500
// 	    });

	    $('.dateAnimate').bootstrapMaterialDatePicker({format : 'DD/MM/YYYY', weekStart : 0, monthPicker: true, time: false,animation:true});
	    $('.date').bootstrapMaterialDatePicker({format : 'DD/MM/YYYY', weekStart : 0, time: false});
	    $('.time').bootstrapMaterialDatePicker({ date: false,format:'HH:mm',animation:true});
	    $('.datetime').bootstrapMaterialDatePicker({ format : 'dddd DD MMMM YYYY - HH:mm',animation:true});
	    $('.date-fr').bootstrapMaterialDatePicker({ format : 'DD/MM/YYYY HH:mm', lang : 'fr', weekStart : 1, cancelText : 'ANNULER'});
	    $('.min-date').bootstrapMaterialDatePicker({ format : 'DD/MM/YYYY HH:mm', minDate : new Date() });


	    $(".dial").knob({
	      height:80
	    });

	    $('.dial1').trigger(
	     'configure',
	     {
	       "min":10,
	       "width":80,
	       "max":80,
	       "fgColor":"#FF6656",
	       "skin":"tron"
	     }
	     );

	    $('.dial2').trigger(
	     'configure',
	     {

	       "width":80,
	       "fgColor":"#FF6656",
	       "skin":"tron",
	       "cursor":true
	     }
	     );

	    $('.dial3').trigger(
	     'configure',
	     {

	       "width":80,
	       "fgColor":"#27C24C",
	     }
	     );
	  });
	  
	  window.addEventListener('load', init, true);

		function init(){
			document.getElementById('selectPais').addEventListener('change', actualizarCiudades);
			document.getElementById('selectCiudad').addEventListener('change', actualizarLugares);
			document.getElementById('selectPrograma').addEventListener('change', actualizarCursos);

		}
		
		function actualizarCiudades(){
			
			document.getElementById('selectLugar').innerHTML = "<select><option>Selecciona el lugar...</option></select>";
			
			id = document.getElementById('selectPais').value;
			ajaxCiudades = new XMLHttpRequest();
			ajaxCiudades.open('GET', 'ciudades.do?id_pais='+id);
			ajaxCiudades.send();
			ajaxCiudades.onreadystatechange = function(){
				if (ajaxCiudades.readyState == 4 && ajaxCiudades.status == 200){
					res = ajaxCiudades.responseText;
					
					document.getElementById('selectCiudad').innerHTML = res;

									
				}
			}
		}
		
		function actualizarLugares(){
			id = document.getElementById('selectCiudad').value;
			ajaxCiudades = new XMLHttpRequest();
			ajaxCiudades.open('GET', 'lugares.do?id_ciudad='+id);
			ajaxCiudades.send();
			ajaxCiudades.onreadystatechange = function(){
				if (ajaxCiudades.readyState == 4 && ajaxCiudades.status == 200){
					res = ajaxCiudades.responseText;
					
					document.getElementById('selectLugar').innerHTML = res;

									
				}
			}
		}
		
		function actualizarCursos(){
			id = document.getElementById('selectPrograma').value;
			ajaxCursos = new XMLHttpRequest();
			ajaxCursos.open('GET', 'cursos.do?id_programa='+id);
			ajaxCursos.send();
			ajaxCursos.onreadystatechange = function(){
				if (ajaxCursos.readyState == 4 && ajaxCursos.status == 200){
					res = ajaxCursos.responseText;
					
					document.getElementById('selectCurso').innerHTML = res;

									
				}
			}
			
		}
	
</script>
</html>

