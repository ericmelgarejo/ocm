<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/icheck/skins/flat/aero.css"/>
  <link href="asset/css/style.css" rel="stylesheet">
  <!-- end: Css -->

  <link rel="shortcut icon" href="asset/img/logomi.png">
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
    </head>

    <body id="mimin" class="dashboard form-signin-wrapper">

      <div class="login">
        

        <form class=form-signin action="j_security_check" name="formLogin" method="post">

          <div class="panel periodic-login">
              <div class="panel-body text-center">
                  <h4 class="atomic-symbol" style="font-size: 80px !important;">OCM</h4>
                  <p class="atomic-mass">IT-University</p>
                  

                  
                 
                  <div class="form-group form-animate-text" style="margin-top:40px !important;">
                    
                    <input input type="text" id="user" name="j_username" class="form-text" required>
                    <span class="bar"></span>
                    <label>Correo</label>
                  </div>


                  <div class="form-group form-animate-text" style="margin-top:40px !important;">
                   <input  type="password" id="password" name="j_password"class="form-text" required>
                    <span class="bar"></span>
                    <label>Password</label>
                  </div>
                  
                  
                  <label class="pull-left">
                  <input type="checkbox" class="icheck pull-left" name="checkbox1"/> Remember me
                  </label>

                  <input class="btn col-md-12" type="button" onclick="login()" value="Login">
              </div>
                <div class="text-center" style="padding:5px;">
                    <a href="">Recuperar Password </a>
                    <a href="">| Registrarse</a>
                </div>
          </div>
        </form>

      </div>
    

      <!-- end: Content -->
      <!-- start: Javascript -->
      <script src="asset/js/jquery.min.js"></script>
      <script src="asset/js/jquery.ui.min.js"></script>
      <script src="asset/js/bootstrap.min.js"></script>

      <script src="asset/js/plugins/moment.min.js"></script>
      <script src="asset/js/plugins/icheck.min.js"></script>

      <!-- custom -->
      <script type="text/javascript">
    function login(){
      var user = document.getElementById("user");
      var pass = document.getElementById("password");
      if(user == null || user.value == ""){
        alert("El campo usuario no debe estar vacío");
        user.focus();
        return;
      }
      if(pass == null || pass.value==""){
        alert("El campo password no debe estar vacio");
        pass.focus();
        return;
      }
      
      document.forms["formLogin"].action = "j_security_check";
      document.forms["formLogin"].submit();
    }
  </script>
     <!-- end: Javascript -->
   </body>
   </html>