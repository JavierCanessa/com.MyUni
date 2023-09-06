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

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    </head>
    <body>
        <%
            //HttpSession session = request.getSession();

//            boolean xSession = false;
//            try {
//                xSession = (boolean) session.getAttribute("session");
//            } catch (Exception e) {
//            }
//            if (!xSession) {
//                response.sendRedirect("sinsesion.html");
//            }

        %>

        <!--menu start-->
        <section id="menu">
            <div class="container">
                <div class="menubar">
                    <nav class="navbar navbar-default">

                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <a class="navbar-brand active" href="ingresoadmin.jsp">
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


        <div id="divTabla" style="font-size: 22px; margin-bottom: 100px; margin-top: 50px" >
            <table id="json-table" class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Foto</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Ciudad</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Celular</th>
                        <th>Email</th>
                        <th>Pasaporte</th>
                        <th>Procesos</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

        </div>


        <script>
            $(document).ready(function () {
                // Realizar una solicitud AJAX para obtener el JSON
                $.getJSON("http://localhost:8084/myuni/clientes/all", function (data) {
                    var tableBody = $("#divTabla tbody");

                    // Iterar sobre los objetos JSON y crear filas de tabla
                    data.forEach(function (item) {
                        var row = $("<tr>");
                        var idLink = $("<a>")
                                .attr("href", "ModalModificar.jsp?codigoClienteBuscar=" + item.id) // Configura la URL adecuada con el ID como parámetro
                                .text(item.id);

                        row.append($("<td>").append(idLink)); // Envuelve el "id" en un elemento <a>
                        row.append($("<td>").text(item.foto));
                        row.append($("<td>").text(item.nombres));
                        row.append($("<td>").text(item.apellidos));
                        row.append($("<td>").text(item.ciudad));
                        row.append($("<td>").text(item.fechaNacimiento));
                        row.append($("<td>").text(item.celular));
                        row.append($("<td>").text(item.email));
                        row.append($("<td>").text(item.pasaporte));

                        // Crear una lista desplegable para procesos
                        var processesSelect = $("<select>");
                        var processes = item.procesos;
                        for (var i = 0; i < processes.length; i++) {
                            processesSelect.append($("<option>").text(processes[i]));
                        }
                        row.append($("<td>").append(processesSelect));

                        tableBody.append(row);
                    });
                });
            });
        </script>






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


</html>
