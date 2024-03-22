/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.controladores;

import com.mycompany.proyecto.Materia;
import com.mycompany.proyecto.conexion.ConexionMaterias;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author victo
 */
public class MateriasLogica {
    private ConexionMaterias dbMaterias;
    public MateriasLogica(Connection dbCon) {
        dbMaterias=new ConexionMaterias(dbCon);
    }
    public LinkedList<Materia> recuperarTodos(){
        
        return dbMaterias.queryAllToDataBase();
    }
    public LinkedList<Materia> buscar(int id){
        
        return dbMaterias.queryToDataBase(id+"");
    }
    public boolean insertar(Materia a){
        return dbMaterias.insertToDataBase(a);
    }
    public boolean eliminarAlumno(String idMateria){
        return dbMaterias.deleteToDataBase(idMateria);
    }
    public boolean actualizarAlumno(Materia a){
        return dbMaterias.updateToDataBase(a);
    }
}
