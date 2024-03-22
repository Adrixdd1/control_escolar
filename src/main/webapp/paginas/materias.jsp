<%-- 
    Document   : materias
    Created on : 22 mar 2024, 6:16:13
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <%  int cont=0;
        HttpSession sesion = request.getSession();
        sesion.setAttribute("cont",cont);%>
    <div class="row flexbox">
        <div class="col-6 center">
            <form id="formularioMaterias" action="proyecto/paginas/procesarMaterias.jsp" method="get" >
                <input type="text" placeholder="materia" name="materia" id="materia">
                <input type="text" placeholder="nombre" name="nombre" id="nombre">
                <button type="submit">enviar</button>  
            </form>
            <div id="resultado" ></div>
        </div>
    </div>
</html>