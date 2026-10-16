<%-- 
    Document   : vaultHistorico
    Created on : 09-oct-2026, 12:06:42
    Author     : afric
--%>

<%@page import="modelo.RegistroPassword"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vault histórico</title>
    </head>
    <body>
        <h1>Vault histórico de contraseñas</h1>
        
        <%
        ArrayList<RegistroPassword> lista = (ArrayList<RegistroPassword>) request.getAttribute("registrosLeidos");
        if (lista != null) {
            for (int i=0; i<lista.size(); i++) { %>
            <ul>
                <li> <%= lista.get(i).toString() %> </li>
            </ul>
        <% } } else { %>
            <p>No hay registros disponibles.</p>
        <% } %>
        
        <hr>
        
        <form action="index.jsp" method="post">
            <input type="submit" value="Volver">
        </form>
    </body>
</html>
