<%-- 
    Document   : pruebas
    Created on : 19 may. 2023, 11:39:27
    Author     : tocho
--%>

<%@page import="com.MyUni.MyUni.Dao.ClienteDAO"%>
<%@page import="com.MyUni.MyUni.Entidades.Cliente"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! @Autowired
    private ClienteDAO cdao;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            if (cdao != null) {
                out.print(cdao.findAll().getClass());
            } else {
                out.print("cdao is null");
            }
            //out.print( cdao.findAll().getClass() );
        %>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <% for (Cliente cliente : clientes) {%>
                <tr>
                    <td><%= cliente.getId()%></td>
                    <td><%= cliente.getNombres()%></td>
                    <td><%= cliente.getEmail()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
