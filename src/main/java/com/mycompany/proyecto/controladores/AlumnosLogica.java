package com.mycompany.proyecto.controladores;

import com.mycompany.proyecto.Alumno;
import com.mycompany.proyecto.conexion.ConexionAlumno;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author cardo
 */
public class AlumnosLogica{

    private ConexionAlumno bdAlumnos;

    public AlumnosLogica (Connection _dbCon) {
        bdAlumnos = new ConexionAlumno(_dbCon);
    }
    
    public LinkedList<Alumno> recuperarTodos(){
        
        return bdAlumnos.queryAllToDataBase();
    }
    public LinkedList<Alumno> buscar(int id){
        
        return bdAlumnos.queryToDataBase(id+"");
    }
    public boolean insertar(Alumno a){
        return bdAlumnos.insertToDataBase(a);
    }
    public boolean eliminarAlumno(String idAlumno){
        return bdAlumnos.deleteToDataBase(idAlumno);
    }
    public boolean actualizarAlumno(Alumno a){
        return bdAlumnos.updateToDataBase(a);
    }
}

