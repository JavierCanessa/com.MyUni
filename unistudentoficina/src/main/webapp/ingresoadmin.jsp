<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Administrador</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <link rel="icon" href="./images/elmercader01.svg"/>
        <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>

    </head>

    <body class="is-preload">
        <%
            //HttpSession session=request.getSession();
            boolean xSession = false;
            try {
                xSession = (boolean) session.getAttribute("session");
            } catch (Exception e) {
            }
            if (!xSession)
                response.sendRedirect("sinsesion.html");
        %>

        <h1 id="topPagina" >Administrador</h1>
        <div class="logo">
            <button onclick=" location.href = 'logout.jsp'">
                Salir de Administrador
                <a style="text-decoration: none" href="index.jsp" class="icon fa-gem" ></a>
            </button>

        </div>


        <!-- Scripts -->    
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/browser.min.js"></script>
        <script src="assets/js/breakpoints.min.js"></script>
        <script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>

    </body>

</html>
