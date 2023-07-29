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

        <!--bootstrap.min.css-->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <!-- bootsnav -->
        <link href="assets/css/bootsnav.css" rel="stylesheet" />

        <!--style.css-->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--responsive.css-->
        <link rel="stylesheet" href="assets/css/responsive.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">


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

        <style>
            /* Agregar estilos para la lista desplegable */
            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding: 12px 16px;
                z-index: 1;
            }

            /* Estilos para la opción seleccionada */
            .selected-option {
                color: #ffffff;
                background-color: #007bff;
            }
        </style>

        <div style="font-size: 22px; margin-bottom: 100px; margin-top: 50px" >
            <table id="tablaAdmin" class="table table-hover table-dark">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Foto</th>
                        <th scope="col">Nombres</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Ciudad</th>
                        <th scope="col">Fecha Nacimiento</th>
                        <th scope="col">Celular</th>
                        <th scope="col">Email</th>
                        <th scope="col">Pasaporte</th>
                        <th scope="col">Procesos</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td id="foto"></td>
                        <td id="nombres"></td>
                        <td id="apellidos"></td>
                        <td id="ciudad"></td>
                        <td id="fechaNacimiento"></td>
                        <td id="celular"></td>
                        <td id="email"></td>
                        <td id="pasaporte"></td>
                        <td>
                            <div class="dropdown">
                                <button class="selected-option" onclick="toggleDropdown()">Procesos</button>
                                <div id="procesosDropdown" class="dropdown-content">
                                    <!-- Aquí puedes agregar los distintos items del desplegable -->
                                    <!-- Por ejemplo, los valores pueden ser "proceso1", "proceso2", etc. -->
                                    <p><input type="checkbox" name="procesos" value="proceso1"> Proceso 1</p>
                                    <p><input type="checkbox" name="procesos" value="proceso2"> Proceso 2</p>
                                    <p><input type="checkbox" name="procesos" value="proceso3"> Proceso 3</p>
                                    <!-- ... -->
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <script>
            // Función para mostrar/ocultar la lista desplegable de procesos
            function toggleDropdown() {
                const dropdown = document.getElementById("procesosDropdown");
                dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
            }


            // Función para obtener los datos de todos los clientes desde el API
            function obtenerClientes() {
                fetch('http://localhost:8084/myuni/clientes/all')
                        .then(response => response.json())
                        .then(data => {
                            // Llenar la tabla con los datos de los clientes
                            const tablaBody = document.getElementById("tablaClientesBody");
                            tablaBody.innerHTML = ""; // Limpiar contenido actual de la tabla

                            data.forEach(cliente => {
                                const fila = document.createElement("tr");
                                fila.innerHTML = `
                        <th scope="row">${cliente.id}</th>
                        <td>${cliente.foto}</td>
                        <td>${cliente.nombres}</td>
                        <td>${cliente.apellidos}</td>
                        <td>${cliente.ciudad}</td>
                        <td>${cliente.fechaNacimiento}</td>
                        <td>${cliente.celular}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.pasaporte}</td>
                        <td>
                            <div class="dropdown">
                                <button class="selected-option" onclick="toggleDropdown(event)">Procesos</button>
                                <div class="dropdown-content">
            
                                </div>
                            </div>
                        </td>
                    `;
                                tablaBody.appendChild(fila);
                            });
                        })
                        .catch(error => {
                            console.error('Error al obtener los clientes:', error);
                        });
            }

            // Llamar a la función para obtener los clientes al cargar la página
            obtenerClientes();


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

    <!-- for manu -->
    <script src="assets/js/jquery.hc-sticky.min.js" type="text/javascript"></script>

    <!--Custom JS-->
    <script type="text/javascript" src="assets/js/jak-menusearch.js"></script>
    <script type="text/javascript" src="assets/js/custom.js"></script>

</html>
