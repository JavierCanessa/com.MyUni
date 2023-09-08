<%@page import="com.MyUni.MyUni.Tabla.TablaHtml"%>
<%@page import="com.MyUni.MyUni.Dao.ClienteDAO"%>
<%@page import="com.MyUni.MyUni.Entidades.Cliente" %>
<%@page import="com.MyUni.MyUni.Entidades.Proceso" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.HttpURLConnection, java.net.URL, java.io.BufferedReader, java.io.InputStreamReader" %>


<!doctype html>
<html class="no-js" lang="es">

    <head>
        <!-- META DATA -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->



        <!--|-family-->
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i,900,900i" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900" rel="stylesheet">

        <!-- TITLE OF SITE -->
        <title>UNISTUDENT-MyUni</title>

        <!-- for title img -->
        <link rel="shortcut icon" type="image/icon" href="assets/images/logo/unistudent_logo.svg" />

        <!--font-awesome.min.css-->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

        <!--linear icon css-->
        <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">

        <!--animate.css-->
        <link rel="stylesheet" href="assets/css/animate.css">

        <!--hover.css-->
        <link rel="stylesheet" href="assets/css/hover-min.css">

        <!--vedio player css-->
        <link rel="stylesheet" href="assets/css/magnific-popup.css">

        <!--owl.carousel.css-->
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link href="assets/css/owl.theme.default.min.css" rel="stylesheet" />


        <!--bootstrap.min.css-->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <!-- bootsnav -->
        <link href="assets/css/bootsnav.css" rel="stylesheet" />

        <!--style.css-->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--responsive.css-->
        <link rel="stylesheet" href="assets/css/responsive.css">

    </head>

    <body>
        <%
            //HttpSession session = request.getSession();

            boolean xSession = false;
            try {
                xSession = (boolean) session.getAttribute("session");
            } catch (Exception e) {
            }
            if (!xSession) {
                response.sendRedirect("sinsesion.html");
            }

        %>
        <link rel="stylesheet" href="assets/whatsappbotonflotante/whats.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">


        <!--menu start-->
        <section id="menu">
            <div class="container">
                <div class="menubar">
                    <nav class="navbar navbar-default">

                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand active" href="indexInicio.jsp">
                                <img id="imgiconoweb" style="width: 450px;height: 90px;"
                                     src="assets/images/logo/unistudent_logo_blanco_102x23-01.svg" alt="logo">
                            </a>
                        </div>
                        <!--/.navbar-header -->

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="active"><a  target="_blank" href="https://www.unistudentasesoria.com/">HomeWebNormal</a></li>
                                <li class="active"><a href="logout.jsp">Cerrar Sesión</a></li>
                            </ul><!-- / ul -->
                        </div><!-- /.navbar-collapse -->
                    </nav>
                    <!--/nav -->
                </div>
                <!--/.menubar -->
            </div><!-- /.container -->

        </section>
        <!--/#menu-->
        <!--menu end-->


        <!--Tabla-->
        <section  style="padding: 40px 20px 100px 20px ;margin-bottom: 400px" id="Nosotros" class="about-us">

            <h1  style="margin-bottom:100px" id="topPagina" >Administrador MyUni</h1>


            <div class="container mt-5">
                <div class="row">
                    <div class="col-md-4">
                        <a href="tabla.jsp" >
                            <button type="button" class="btn btn-primary btn-lg" >Tabla Completa</button>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modal2">Agregar</button>
                    </div>
                    <div class="col-md-4">
                        <a href="ModalModificar.jsp" >
                            <button type="button" class="btn btn-primary btn-lg">Modificar/Eliminar</button>
                        </a>
                    </div>

                </div>
            </div>

            <!-- Modal 1 -->
            <div class="modal fade" id="modal1" tabindex="-1" role="dialog" aria-labelledby="modal1Label" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modal1Label">Tabla Completa</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Contenido del Modal 1
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal 2 -->
            <div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="modal2Label" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modal2Label">Agregar Usuario</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form id="formularioAgregar" >
                                <!--                                <div class="form-group">
                                                                    <label for="foto">Foto:</label>
                                                                    <input type="text" class="form-control" id="foto" name="foto" required>
                                                                </div>-->
                                <div class="form-group">
                                    <label for="nombres">Nombres:</label>
                                    <input type="text" class="form-control" id="nombres" name="nombres" required>
                                </div>
                                <div class="form-group">
                                    <label for="apellidos">Apellidos:</label>
                                    <input type="text" class="form-control" id="apellidos" name="apellidos" required>
                                </div>
                                <div class="form-group">
                                    <label for="ciudad">Ciudad:</label>
                                    <input type="text" class="form-control" id="ciudad" name="ciudad" required>
                                </div>
                                <div class="form-group">
                                    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
                                </div>
                                <div class="form-group">
                                    <label for="celular">Celular:</label>
                                    <input type="text" class="form-control" id="celular" name="celular" required pattern="[0-9]+">
                                    <small class="form-text text-muted">Ingrese solo números.</small>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" id="email" name="email" required>
                                    <small class="form-text text-muted">Ingrese un formato de correo válido.</small>
                                </div>
                                <div class="form-group">
                                    <label for="pasaporte">Pasaporte:</label>
                                    <input type="text" class="form-control" id="pasaporte" name="pasaporte" required pattern="[0-9]+">
                                    <small class="form-text text-muted">Ingrese solo números.</small>
                                </div>
                                <div class="form-group">
                                    <label for="portafolio">Portafolio:</label>
                                    <input type="text" class="form-control" style="font-size: 25px;" id="portafolio" name="portafolio" >
                                </div>

                                <!-- Lista de procesos -->
                                <div class="form-group">
                                    <label for="procesos">Procesos:</label>
                                    <% for (Proceso proceso : Proceso.values()) {%>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="proceso_<%= proceso.getId()%>" name="procesos" value="<%= proceso.name()%>">

                                        <label class="form-check-label" for="proceso_<%= proceso.getId()%>"><%= proceso%></label>

                                    </div>
                                    <% }%>
                                </div>
                                <!-- Fin Lista de procesos -->

                                <button type="submit" class="btn btn-primary">Guardar</button>
                                <button type="button" class="btn btn-secondary" onclick="limpiarFormulario()">Limpiar</button>
                                <div id="popup" style="display: none;">
                                    <p id="mensaje"></p>
                                    <button id="okButton">OK</button>
                                </div>

                                <!--tochjs.js-->
                                <script>
                                    // Agregar controlador de eventos para el evento "submit" del formulario
                                    document.getElementById('formularioAgregar').addEventListener('submit', handleFormSubmit);

                                    function handleFormSubmit(event) {
                                        event.preventDefault(); // Evitar la recarga de la página por defecto

                                        fetch('http://localhost:8084/myuni/clientes/agregar', {
                                            method: 'POST',
                                            body: new FormData(document.getElementById('formularioAgregar'))
                                        })
                                                .then(response => response.json())
                                                .then(data => {
                                                    console.log(data);
                                                    if (data.agregado) {
                                                        const mensaje = data.mensaje;

                                                        // Mostrar mensaje emergente de cliente agregado utilizando alert
                                                        //const mensajeAlert = `Cliente agregado` + data.mensaje;
                                                        alert(mensaje);

                                                        // Limpiar formulario y URL después de mostrar el mensaje
                                                        setTimeout(() => {
                                                            document.getElementById('formularioAgregar').reset();
                                                            window.history.replaceState({}, document.title, 'http://localhost:8084/myuni/ingresoadmin.jsp');
                                                        }, 100);
                                                    } else {
                                                        console.error('Error al agregar el cliente:', data.mensaje);
                                                    }
                                                })
                                                .catch(error => {
                                                    console.error('Error en la solicitud:', error);
                                                });
                                    }
                                </script>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <!-- footer-copyright start -->
        <footer class="footer-copyright">
            <div class="container">
                <div class="row">
                    <div class="col-sm-7">
                        <div class="foot-copyright pull-left">
                            <p>
                                &copy; All Rights Reserved. Designed and Developed by
                                <a href="">TOCHO</a>
                            </p>
                        </div>
                        <!--/.foot-copyright-->
                    </div>
                    <!--/.col-->
                    <div class="col-sm-5">
                        <div class="foot-menu pull-right
                             ">
                            <ul>
                                <li><a href="#">legal</a></li>
                                <li><a href="#">sitemap</a></li>
                                <li><a href="#">privacy policy</a></li>
                            </ul>
                        </div><!-- /.foot-menu-->
                    </div>
                    <!--/.col-->
                </div>
                <!--/.row-->
                <div id="scroll-Top">
                    <i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip"
                       data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
                </div>
                <!--/.scroll-Top-->
            </div><!-- /.container-->

        </footer><!-- /.footer-copyright-->
        <!-- footer-copyright end -->




        <!-- jaquery link -->

        <script src="assets/js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->

        <!--modernizr.min.js-->
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>


        <!--bootstrap.min.js-->
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>

        <!-- bootsnav js -->
        <script src="assets/js/bootsnav.js"></script>

        <!-- for manu -->
        <script src="assets/js/jquery.hc-sticky.min.js" type="text/javascript"></script>


        <!-- vedio player js -->
        <script src="assets/js/jquery.magnific-popup.min.js"></script>


        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>

        <!--owl.carousel.js-->
        <script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>

        <!-- counter js -->
        <script src="assets/js/jquery.counterup.min.js"></script>
        <script src="assets/js/waypoints.min.js"></script>

        <!--Custom JS-->
        <script type="text/javascript" src="assets/js/jak-menusearch.js"></script>
        <script type="text/javascript" src="assets/js/custom.js"></script>

        <!--tochjs.js-->
        <script type="text/javascript" src="assets/js/Toch.js"></script>


    </body>

</html>