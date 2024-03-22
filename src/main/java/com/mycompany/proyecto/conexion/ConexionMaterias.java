/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.conexion;

import com.mycompany.proyecto.Alumno;
import com.mycompany.proyecto.Materia;
import java.sql.CallableStatement;
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
public class ConexionMaterias extends AbstractConnector{

    public ConexionMaterias(Connection _dbCon) {
        super(_dbCon);
    }
    @Override
   public LinkedList<Materia> queryToDataBase(String id) {
        String sql="SELECT * FROM control_escolar.materias WHERE idMateria = "+id+";";
        LinkedList<Materia> materias = new LinkedList<>();
        Materia materia;
        ResultSet rs = super.ejecutarQuery(sql);
        try {
            while(rs.next()){
                int idMateria=(rs.getInt("idMateria"));
                String nombre=(rs.getString("nombreMateria"));
                materia=new Materia(idMateria, nombre);
                materias.add(materia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;    
    }
   public LinkedList<Materia> queryAllToDataBase() {
        String sql="SELECT * FROM control_escolar.materias;";
        LinkedList<Materia> materias = new LinkedList<>();
        Materia materia;
        ResultSet rs = super.ejecutarQuery(sql);
        try {
            while(rs.next()){
                int idMateria=(rs.getInt("idMateria"));
                String nombre=(rs.getString("nombreMateria"));
                materia=new Materia(idMateria, nombre);
                materias.add(materia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;    
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

