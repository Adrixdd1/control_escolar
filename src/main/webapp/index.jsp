<%-- 
    Document   : index
    Created on : 21 mar 2024, 22:41:30
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.proyecto.conexion.DbUtil" %>
<%@page import="com.mycompany.proyecto.conexion.ConexionAlumno" %>
<%@page import="com.mycompany.proyecto.controladores.AlumnosLogica" %>
<%@page import="com.mycompany.proyecto.Alumno" %>
<%@page import="vistas.TablaAlumnos" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="js/script.js"></script>
        <link rel="stylesheet" href="estilo.css">
        
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                  <a class="navbar-brand" href="#">Control escolar</a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#" onclick="cargarContenido('grupos', event)">Grupos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="cargarContenido('materias', event)">Materias</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Alumnos
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item selected active" href="#" >Gestionar</a></li>
                                <li><a class="dropdown-item" href="#" >Registrar Asistencia</a></li>
                                <li><a class="dropdown-item" href="#" >Registrar Calificaciones</a></li>
                            </ul>
                        </li>
                    </ul>
                  </div>
                </div>
              </nav>
            <div id="navegacionPrincipal" class="row">
            <%
                Connection dbCon=DbUtil.getInstance().getConnection();
                LinkedList<Alumno> lista= new LinkedList<>();
            HttpSession sesion = request.getSession(); 
            boolean editar=false;
            if(sesion.getAttribute("listaAlumnos")==null){
                //lista.cargarDesdeBD();
                sesion.setAttribute("listaProductos",lista);   
                //lista.agregar(new Producto(1,"hola","mundo",2,3));
            }else if(sesion.getAttribute("listaEditar")==null){
                lista=(LinkedList<Alumno>) sesion.getAttribute("listaAlumnos");
                //lista.cargarDesdeBD();
            }else{
                lista=(LinkedList<Alumno>) sesion.getAttribute("listaEditar");
                editar=true;
            }
             
            TablaAlumnos tabla= new TablaAlumnos(dbCon);
            if(!editar){
                //lista.cargarDesdeBD();
                out.println(tabla.generarTabla(lista));
                
            }else{
                out.println(tabla.generarTabla(0,lista));
                editar=false;
            }
        
            %>
        </div>
            
            
            
        </div>   
    </body>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>




