<%-- 
    Document   : myuniclientes
    Created on : 18 jul. 2023, 10:13:30
    Author     : tocho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.MyUni.MyUni.Tabla.TablaHtml"%>
<%@page import="com.MyUni.MyUni.Dao.ClienteDAO"%>
<%@page import="com.MyUni.MyUni.Entidades.Cliente" %>
<%@page import="com.MyUni.MyUni.Entidades.Proceso" %>
<%@ page import="java.net.HttpURLConnection, java.net.URL, java.io.BufferedReader, java.io.InputStreamReader" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Uni</title>
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

        <!--menu start-->
        <section id="menu">
            <div class="container">
                <div class="menubar">
                    <nav class="navbar navbar-default">

                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <a class="navbar-brand active" href="https://www.unistudentasesoria.com">
                                <img id="imgiconoweb" style="width: 700px;height: 90px;"
                                     src="assets/images/logo/unistudent_logo_blanco_102x23-01.svg" alt="logo">
                            </a>
                        </div>
                    </nav>
                    <!--/nav -->
                </div>
                <!--/.menubar -->
            </div><!-- /.container -->

        </section>
        <!--/#menu-->
        <!--menu end-->


        <div class="container" style="font-size: 25px;margin-top: 50px">
            <div class="row">
                <div class="col-4">
                </div>
                <div class="col-4">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" class="form-control" style="font-size: 25px;" id="codigoClienteBuscar" placeholder="Ingresa tu usuario">
                        </div>
                    </div>
                    <div class="col-auto">
                        <button class="btn btn-primary" id="btnBuscarCliente">Buscar</button>
                    </div>
                    <div class="modal-body">
                        <form id="formularioModificar">
                            <div class="form-group">
                                <label for="codigoCliente">ID:</label>
                                <input type="text" class="form-control" style="font-size: 25px;" id="codigoClienteModificar" name="codigoCliente" readonly>
                            </div>
                            <!--                <div class="form-group">
                                                <label for="foto">Foto:</label>
                                                <input type="text" class="form-control" id="foto" name="foto" >
                                            </div>-->
                            <div class="form-group">
                                <label for="nombres">Nombres:</label>
                                <input type="text" class="form-control" style="font-size: 25px;" id="nombres" name="nombres" readonly>
                            </div>
                            <div class="form-group">
                                <label for="apellidos">Apellidos:</label>
                                <input type="text" class="form-control" style="font-size: 25px;" id="apellidos" name="apellidos" readonly>
                            </div>
                            <div class="form-group">
                                <label for="ciudad">Ciudad:</label>
                                <input type="text" class="form-control" style="font-size: 25px;" id="ciudad" name="ciudad" readonly>
                            </div>
                            <div class="form-group">
                                <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                                <input type="text" class="form-control" style="font-size: 25px;" id="fechaNacimiento" name="fechaNacimiento" readonly>
                            </div>
                            <div class="form-group">
                                <label for="celular">Celular:</label>
                                <input type="text" class="form-control" style="font-size: 25px;" id="celular" name="celular" required pattern="[0-9]+" readonly>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" style="font-size: 25px;" id="email" name="email" readonly>
                            </div>
                            <div class="form-group">
                                <label for="pasaporte">Pasaporte:</label>
                                <input type="text" class="form-control" style="font-size: 25px;" id="pasaporte" name="pasaporte" required pattern="[0-9]+" readonly>
                            </div>
                            <div class="form-group">
                                <label for="portafolio">Portafolio:</label><br>
                                <a id="portafolioLink"  style="font-size: 25px;" href="#" target="_blank"></a>
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
                        </form>
                    </div>

                    <script>
                        document.getElementById('btnBuscarCliente').addEventListener('click', function () {
                            const clienteId = document.getElementById('codigoClienteBuscar').value;
                            console.log("Primer paso" + clienteId);
                            fetch(`http://myuni.w1-us.cloudjiffy.net/clientes/buscar/` + clienteId)
                                    .then(response => response.json())
                                    .then(data => {
                                        const formularioModificar = document.getElementById('formularioModificar');
                                        console.log("Data segundo paso : ");
                                        console.log(data);
                                        if (data) {
                                            // Mostrar los datos del cliente en el formulario
                                            document.getElementById('codigoClienteModificar').value = data.id;
                                            //document.getElementById('foto').value = data.foto;
                                            document.getElementById('nombres').value = data.nombres;
                                            document.getElementById('apellidos').value = data.apellidos;
                                            document.getElementById('ciudad').value = data.ciudad;
                                            document.getElementById('fechaNacimiento').value = data.fechaNacimiento;
                                            document.getElementById('celular').value = data.celular;
                                            document.getElementById('email').value = data.email;
                                            document.getElementById('pasaporte').value = data.pasaporte;
                                            // Dentro de tu función de manejo de datos (donde llenas el formulario)
                                            document.getElementById('portafolioLink').href = data.portafolio;
                                            document.getElementById('portafolioLink').textContent = 'Ir a mi portafolio'; // Texto del enlace

                                            // Marcar los checkboxes de los procesos del cliente
                                            const procesosCliente = data.procesos;
                                            const checkboxes = document.querySelectorAll('input[name="procesos"]');
                                            checkboxes.forEach(checkbox => {
                                                const proceso = checkbox.value;
                                                if (procesosCliente.includes(proceso)) {
                                                    checkbox.checked = true;
                                                }
                                            });
                                        } else {
                                            console.error('No se encontró el cliente.');
                                        }
                                    })
                                    .catch(error => {
                                        console.error('Tocho Error en la solicitud:', error);
                                    });
                        });
                    </script>
                </div>
                <div class="col-4">
                </div>
            </div>
        </div>






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
    </body>

    <!-- jaquery link -->

    <script src="assets/js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->


    <!--bootstrap.min.js-->
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>

    <!--1111 bootsnav js -->
    <script src="assets/js/bootsnav.js"></script>

    <!-- for manu -->
    <script src="assets/js/jquery.hc-sticky.min.js" type="text/javascript"></script>


    <!-- vedio player js -->
    <script src="assets/js/jquery.magnific-popup.min.js"></script>


    <!--owl.carousel.js-->
    <script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>

    <!-- counter js -->
    <script src="assets/js/jquery.counterup.min.js"></script>
    <script src="assets/js/waypoints.min.js"></script>

    <!--Custom JS-->
    <script type="text/javascript" src="assets/js/jak-menusearch.js"></script>
    <script type="text/javascript" src="assets/js/custom.js"></script>

    <!--tochjs.js-->
    <script type="text/javascript" src="assets/js/toch.js"></script>
</html>
