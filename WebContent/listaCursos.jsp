<%@page import="vo.PaisVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="javascript.js"></script>
	<title>Cursos</title>
	<meta charset="utf-8">
	<meta name="description" content="Miminium Admin Template v.1">
	<meta name="author" content="Isna Nur Azis">
	<meta name="keyword" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IT University</title>
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
				<a href="index.html" class="navbar-brand"><b>OCM</b></a>
				<ul class="nav navbar-nav navbar-right user-nav">
					<li class="user-name" style="padding-top: 5px">
                		<span>${pageContext.request.userPrincipal.name}</span>
                		<a href="inicio.jsp" style="padding:0; text-align: right">Cerrar Sesion</a>
                	</li>
					
					<li class="dropdown avatar-dropdown">
						<img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
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
                    
                    <li class="active ripple">
                      <a href="<%=request.getContextPath()%>/cursos?opcion=verCursos"><span class="fa-book fa"></span> Cursos
                      </a>
                    </li>
                    
                    <li class="ripple">
                      <a href="<%=request.getContextPath()%>/programas?opcion=verProgramas"><span class="fa-graduation-cap fa"></span> Programas
                      </a>
                    </li>
                    
                    <li class="ripple">
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
	
		<div id="content">
		
			<div class="panel box-shadow-none content-header">
				<div class="panel-body">
					<div class="col-md-12">
						<h3 class="animated fadeInLeft">Lista Cursos</h3>
					</div>
				</div>
			</div>

			<div class="col-md-12 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<div style="position:absolute; right:30px">
								<form action = "<%=request.getContextPath()%>/curso">
									<input type="hidden" name="opcion" value="crear">
									<button class="btn btn-success">Crear Curso</button>
								</form>
							</div>
							<h4>Cursos</h4>
						</div>
						
						<div class="panel-body">
							<div class="responsive-table">
								<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="row">
										<div class="col-sm-12">
											<table id="datatables-example" class="table table-striped table-bordered dataTable no-footer" width="100%" cellspacing="0" role="grid" aria-describedby="datatables-example_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Nombre: activate to sort column descending" style="width: 93px; text-align:center;">
															Nombre
														</th>
														<th class="sorting" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-label="Descripcion: activate to sort column ascending" style="width: 154px; text-align:center;">
															Descripcion
														</th>
														<th class="sorting" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-label="Horas activate to sort column ascending" style="width: 154px; text-align:center;">
															Horas
														</th>
														<th class="sorting" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-label="Horas activate to sort column ascending" style="width: 154px; text-align:center;">
															Programa
														</th>
														<th class="sorting" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="2" aria-label="Opciones: activate to sort column ascending" style="width: 154px; text-align:center;">
															Opciones
														</th>
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty listaCursos}">
														<c:forEach items="${listaCursos}" var="curso">
															<tr role="row">
																<td class="sorting_1" style="text-align:center;">${curso.nombre }</td>
																
																<td style="text-align:center;">${curso.descripcion }</td>
																
																<td style="text-align:center;">${curso.horas }</td>
																
																<td style="text-align:center;">${curso.programa_nombre }</td>
																
																<td style="width:10%">
																	<form action = "<%=request.getContextPath()%>/curso">
																		<input type="hidden" name="opcion" value="modificar">
																		<button name="id_curso" class="btn btn-warning" value=${curso.id }>Modificar</button>
																	</form>	
																</td>
																<td style="width:10%">
																	<form>
																		<input type="hidden" name="opcion" value="eliminar">
																		<button onclick="if (confirm('Seguro que quieres eliminar el curso ${curso.nombre }?')) { form.action = '<%=request.getContextPath()%>/curso'; } else { return false; }" name="id_curso" class="btn btn-danger" value=${curso.id }>Eliminar</button>
																	</form>
																</td>
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
	window.addEventListener('load', init, true);
	
	function init(){
		var respuesta = '${respuesta}';
		if (respuesta != null && respuesta != ""){
			alert(respuesta);
		}
	}
	
</script>
<script type="text/javascript">
	
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




	    $('.dateAnimate').bootstrapMaterialDatePicker({format : 'DD/MM/YYYY', weekStart : 0, time: false,animation:true});
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
	
</script>
</html>

