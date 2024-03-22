/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.conexion;

import com.mycompany.proyecto.Alumno;
import com.mycompany.proyecto.Grupo;
import com.mycompany.proyecto.Materia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
public class ConexionGrupos extends AbstractConnector{

    public ConexionGrupos(Connection _dbCon) {
        super(_dbCon);
    }

    @Override
   public LinkedList queryToDataBase(String id) {
        String sql="SELECT idGrupo, idAlumno, nombre, apellidos FROM tbl_alumnos WHERE idGrupo = '"+id+"'";
        LinkedList<Grupo> grupos = new LinkedList<>();
        LinkedList<Alumno> alumnos=new LinkedList<>();
        Alumno a;
        
        ResultSet rs = super.ejecutarQuery(sql);
        try {
            while(rs.next()){
                int idAlumno = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                a=new Alumno(idAlumno, nombre, apellidos);
                alumnos.add(a);
               }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        Grupo g=new Grupo(id, alumnos);
        grupos.add(g);
        return grupos;    
    }
    public LinkedList<Grupo> queryAllToDataBase(){
        String sql="SELECT g.idGrupo, g.espacioTotal, a.idAlumno, a.nombre, a.apellidos" +
                           "FROM tbl_grupos g" +
                           "JOIN tbl_alumnos a ON g.idGrupo = a.idGrupo" +
                           "ORDER BY g.idGrupo";
        LinkedList<Grupo> grupos = new LinkedList<>();
        LinkedList<Alumno> alumnos=new LinkedList<>();
        Alumno a;
        Grupo g = null;
        ResultSet rs = super.ejecutarQuery(sql);
        String grupoActual=null;
        try {
            while(rs.next()){
                if(grupoActual==null){
                    grupoActual=rs.getString("idGrupo");
                }else if(grupoActual.compareTo(rs.getString("idGrupo"))!=0){
                    g=new Grupo(grupoActual, new LinkedList<>(alumnos));
                    alumnos.clear();
                    grupos.add(g);
                    grupoActual=rs.getString("idGrupo");
                }
                int idAlumno = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                a=new Alumno(idAlumno, nombre, apellidos);
                alumnos.add(a);
               }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        g=new Grupo(grupoActual, new LinkedList<>(alumnos));
        alumnos.clear();
        grupos.add(g);
        
        return grupos;
    }

    @Override
    public boolean insertToDataBase(Object objeto) {
        Materia m=(Materia)objeto;
        String sql="INSERT INTO `control_escolar`.`materias` (`nombreMateria`) VALUES ('"+m.getNombreMateria()+"');";
        
        return super.ejecutarUpdate(sql);
    }

    @Override
    public boolean updateToDataBase(Object objeto) {
        Materia m=(Materia)objeto;
        String sql="UPDATE `control_escolar`.`materias` SET `nombreMateria` = '"+m.getNombreMateria()+"' WHERE (`idMateria` = '"+m.getIdMateria()+"');";        
        return super.ejecutarUpdate(sql);
    }

    @Override
    public boolean deleteToDataBase(String id) {
        String sql="DELETE FROM `control_escolar`.`materias` WHERE (`idMateria` = '"+id+"');";
        
        return super.ejecutarUpdate(sql);
    }
    
}