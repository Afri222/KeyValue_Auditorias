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
                    <th>Contraseña</th>
                    <th></th>
                </tr>
                <tr>
                    <td><input type="password" name="password">
                        <%-- <form id="solContraseña" action="./vaultHistorico" method="post">
                            <input type="submit" value="Recomendar contraseña">
                        </form> --%>
                    </td>
                    <td>
                        <form id="solContraseña" action="./evaluaPassword" method="post">
                            <input type="submit" name="btnPedirPw" value="Recomendar contraseña">
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
                String ultPwAn;
                if (misCookies != null) {
                    cookie = null;
                    for (Cookie c : misCookies) {
                        if ("ultimaAuditoria".equalsIgnoreCase(c.getName())) {
                            cookie = c;
                            break;
                        }
                    }
                    if (cookie != null) {
                        ultPwAn = cookie.getValue();
                    } else {
                        ultPwAn = "-";
                    }
                } else
                    ultPwAn = "-";
            %>
            <%
                HttpSession sesion = request.getSession(false);
                String name;
                
                if (sesion == null || (name = (String) sesion.getAttribute("nombre")) == null) {
                    name = "usuario/a";
                }
            %>
            <p>¡Hola <%= name%>!</p>
            <p>La última auditoría fue : <%= ultPwAn%></p>
        </form>

        <hr>

        <form id="consultaVault" action="./consultaVault" method="post">
            <input type="submit" value="Ver histórico">
        </form>
    </body>
</html>
