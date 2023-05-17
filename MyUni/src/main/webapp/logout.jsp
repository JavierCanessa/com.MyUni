<%-- 
    Document   : logout
    Created on : 13 jul. 2021, 03:35:53
    Author     : javiercanessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>LogOut</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/main.css" />
        <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
        <link rel="icon" href="./images/elmercader01.svg"/>
    </head>
    <body>
        <div class="alert alert-danger" role="alert">
            Usted terminó la sesión <a href="indexInicio.jsp" class="alert-link">OK</a>
        </div>
        <%
            session.invalidate();
        %>
    </body>
</html>
