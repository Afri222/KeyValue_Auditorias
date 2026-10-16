<%-- 
    Document   : resultadoAnalisis
    Created on : 09-oct-2026, 12:06:23
    Author     : afric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado análisis</title>
    </head>
    <body>
        <h1>Resultado del análisis de contraseña</h1>

        <%
            ServletContext sc = request.getServletContext();
            String diag = String.valueOf(request.getAttribute("diagnostico"));
            String nvlFort;
            
            nvlFort = String.valueOf(diag.subSequence((diag.indexOf(":") + 1), diag.indexOf("%")));
        %>

        <table>
            <tr>
                <th>Nivel de fortaleza</th>
                <td><%= nvlFort%>%</td>
            </tr>
            <tr>
                <th>Recomendaciones</th>
                <td>Compruebe en la tabla qué elemento falta en su contraseña para que sea más segura.</td>
            </tr>
        </table>
        <hr>
        <h3>Recuerde el tiempo de rotura...</h3>
        <%-- <img src="<%= request.getContextPath()%>/img/tiempoRoturaPassword.jpg" alt="Tabla tiempos rotura contraseña"/> --%>
        <img src="<%=request.getContextPath()%>/img/tiempoRoturaPassword.jpg" alt="Tabla tiempos rotura contraseña"/>
        <%-- <img src="../src/java/img/tiempoRoturaPassword.jpg" alt=""/> --%>
        
        <hr>
        
        <form action="guardaVault" method="post">
            <input type="submit" value="Guardar en Vault" name="GuardarEnVault">
        </form>
        <br>
        <form action="index.jsp" method="post">
            <input type="submit" value="Volver">
        </form>
    </body>
</html>
