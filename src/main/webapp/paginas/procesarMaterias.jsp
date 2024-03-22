<%-- 
    Document   : procesarMaterias
    Created on : 22 mar 2024, 6:30:40
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                    <% 
                        HttpServletRequest requeest = (HttpServletRequest) pageContext.getRequest();
                        HttpSession sesion = request.getSession();
                        String estado= "materias";
                        sesion.setAttribute("estado",estado);
                        int cont=(int)sesion.getAttribute("cont");
                        cont++;
                        out.println(cont);
                        sesion.setAttribute("cont",cont);
                        String nombre = requeest.getParameter("nombre");
                        String materia = requeest.getParameter("materia");
                        out.println("Nombre: " + nombre + "<br>");
                        out.println("Materia: " + materia + "<br>");
                    %>
                    <jsp:forward page="../index.jsp"/>
    </body>
</html>
