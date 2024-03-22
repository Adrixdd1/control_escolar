/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.util.LinkedList;

/**
 *
 * @author victo
 */
public class Grupo { 
    private String idGrupo;
    private LinkedList<Alumno> listaAlumnos;

    public Grupo(String idGrupo, LinkedList<Alumno> listaAlumnos) {
        this.idGrupo = idGrupo;
        this.listaAlumnos = listaAlumnos;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    public void agregarAlumno(Alumno a){
        listaAlumnos.add(a);
    }
    public boolean editarAlumno(Alumno a){
        int indice=this.buscarAlumno(a.getIdAlumno());
        if(indice!=-1){
            this.listaAlumnos.set(indice, a);
            return true;
        }else{
            return false;
        }
    }
    public Alumno eliminarAlumno(int idAlumno){
        int indice=this.buscarAlumno(idAlumno);
        if(indice!=-1){
            return listaAlumnos.remove();
        }
        return null;
    }

    private int buscarAlumno(int idAlumno) {
        int indice=-1;
        for(int i=0;i<this.totalAlumnos();i++){
            if(listaAlumnos.get(i).getIdAlumno()==idAlumno){
                indice=i;
            }
        }
        return indice;
    }

    private int totalAlumnos() {
        return this.listaAlumnos.size();
    }
    /**/
}
