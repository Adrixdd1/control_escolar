/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.conexion;

import com.mycompany.proyecto.Alumno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
public class ConexionAlumno extends AbstractConnector{

    public ConexionAlumno(Connection _dbCon) {
        super(_dbCon);
    }
    

    @Override
    public LinkedList queryToDataBase(String id) {
        String sql="SELECT * FROM control_escolar.tbl_alumnos WHERE idAlumno = "+id+";";
        LinkedList<Alumno> alumnos = new LinkedList<>();
        Alumno alumno;
        ResultSet rs = super.ejecutarQuery(sql);
        try {
            while(rs.next()){
                int idAlumno=(rs.getInt("idAlumno"));
                String nombre=(rs.getString("nombre"));
                String apellidos=(rs.getString("apellidos"));
                String idGrupo=rs.getString("idGrupo");
                String correo=(rs.getString("correo"));
                int telefonoPadres=(rs.getInt("telefono"));
                int edad=rs.getInt("edad");
                String sexo=rs.getString("sexo");
                alumno=new Alumno(idAlumno, nombre, apellidos,idGrupo,correo,telefonoPadres, edad, sexo);
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;    
    }
    
    public LinkedList queryAllToDataBase() {
        String sql="SELECT * FROM control_escolar.tbl_alumnos;";
        LinkedList<Alumno> alumnos = new LinkedList<>();
        Alumno alumno;
        ResultSet rs = super.ejecutarQuery(sql);
        try {
            while(rs.next()){
                int idAlumno=(rs.getInt("idAlumno"));
                String nombre=(rs.getString("nombre"));
                String apellidos=(rs.getString("apellidos"));
                String idGrupo=rs.getString("idGrupo");
                String correo=(rs.getString("correo"));
                int telefonoPadres=(rs.getInt("telefono"));
                int edad=rs.getInt("edad");
                String sexo=rs.getString("sexo");
                alumno=new Alumno(idAlumno, nombre, apellidos,idGrupo,correo,telefonoPadres, edad, sexo);
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;    
    }

    @Override
    public boolean insertToDataBase(Object objeto) {
        Alumno a=(Alumno)objeto;
        String sql="INSERT INTO `control_escolar`.`tbl_alumnos` (`nombre`, `apellidos`, `idGrupo`, `correo`, `telefono`, `edad`, `sexo`) VALUES ('"+a.getNombre()+"', '"+a.getApellidos()+"', '"+a.getGrupo()+"', '"+a.getCorreo()+"', '"+a.getTelefono()+"', '"+a.getEdad()+"', '"+a.getSexo()+"');";
        
        return super.ejecutarUpdate(sql);
    }

    @Override
    public boolean updateToDataBase(Object objeto) {
        Alumno a=(Alumno)objeto;
        String sql="UPDATE `control_escolar`.`tbl_alumnos` SET `nombre` = '"+a.getNombre()+"', `apellidos` = '"+a.getApellidos()+"', `idGrupo` = '"+a.getGrupo()+"', `correo` = '"+a.getCorreo()+"', `telefono` = '"+a.getTelefono()+"', `edad` = '"+a.getEdad()+"' WHERE (`idAlumno` = '"+a.getIdAlumno()+"');";
        
        return super.ejecutarUpdate(sql);
    }

    @Override
    public boolean deleteToDataBase(String id) {
        String sql="DELETE FROM `control_escolar`.`tbl_alumnos` WHERE (`idAlumno` = '"+id+"');";
        
        return super.ejecutarUpdate(sql);
    }


}