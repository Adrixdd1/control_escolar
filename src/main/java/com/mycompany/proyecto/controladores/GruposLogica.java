/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.controladores;

import com.mycompany.proyecto.Alumno;
import com.mycompany.proyecto.Grupo;
import com.mycompany.proyecto.conexion.ConexionGrupos;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author victo
 */
public class GruposLogica {
    private LinkedList<Grupo> listaGrupos;
    private ConexionGrupos dbGrupos;

    public GruposLogica(Connection dbCon) {
        dbGrupos= new ConexionGrupos(dbCon);
        //listaGrupos= dbGrupos.queryAllToDataBase();
        //no funciona por la conexión
    }
    
    public LinkedList<Grupo> recuperarTodos(){
        
        listaGrupos= dbGrupos.queryAllToDataBase();
        return this.listaGrupos;
    }
    public LinkedList<Grupo> buscar(int id){
        
        return dbGrupos.queryToDataBase(id+"");
    }
    public boolean insertar(Grupo a){
        return dbGrupos.insertToDataBase(a);
    }
    public boolean eliminarAlumno(String idGrupo){
        return dbGrupos.deleteToDataBase(idGrupo);
    }
    public boolean actualizarAlumno(Grupo a){
        return dbGrupos.updateToDataBase(a);
    } 
    public String[] gruposDisponibles(){
        
        String[] grupos=new String[listaGrupos.size()];
        int i=0;
        for(Grupo g:listaGrupos){
            grupos[i]=g.getIdGrupo();
            i++;
        }
        //return grupos;
        //para probar la vista de Alumnos se desactiva dado que aún no funciona la conexion
        String[] gruposs={"A","B","C"};
        return gruposs;
    }
}
