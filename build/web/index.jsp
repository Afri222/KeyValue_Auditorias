<%-- 
    Document   : index
    Created on : 09-oct-2026, 12:06:05
    Author     : afric
--%>

<%@page import="java.time.LocalDateTime"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="controller.EvaluaPasswordServlet" %>
<%@ page import="controller.ConsultaVaultServlet" %>
<%@ page import="controller.GuardaVaultServlet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contraseña</title>
    </head>
    <body>
        <h1>Formulario</h1>
        <form id="formulario" action="./evaluaPassword" method="post">
            <table>
                <tr>
                    <th>Nombre de usuario:</th>
                    <th>Contraseña</th>
                    <th></th>
                </tr>
                <tr>
                    <td><input type="text"></td>
                    <td><input type="password">
                        <%-- <form id="solContraseña" action="./vaultHistorico" method="post">
                            <input type="submit" value="Recomendar contraseña">
                        </form> --%>
                    </td>
                    <td>
                        <form id="solContraseña" action="./" method="post">
                            <input type="submit" value="Recomendar contraseña">
                        </form>
                    </td>
                </tr>
            </table>

            <br> <br>

            <input type="submit" value="Enviar">
            <input type="reset" value="Borrar">

            <hr>

            <%
                Cookie[] misCookies = request.getCookies();
                Cookie cookie;
                
                
                /* if (misCookies != null)
                    cookie = misCookies.getCookie("ultimaAuditoría"); */
            %>
            <p>Última contraseña analizada: <%= misCookies. %></p>
        </form>

        <br>

        <form id="consultaVault" action="./consultaVault" method="post">
            <input type="submit" value="Ver histórico">
        </form>
    </body>
</html>
