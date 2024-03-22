/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import com.mycompany.proyecto.Alumno;
import com.mycompany.proyecto.controladores.GruposLogica;
import java.sql.Connection;
import java.util.LinkedList;


/**
 *
 * @author victo
 */
public class TablaAlumnos {
    private final String encabezado="<tr><th>id</th><th>Nombre</th><th>Apellidos</th><th>Grupo</th><th>Correo</th><th>Telefono</th><th>Edad</th><th>Sexo</th><th></th><th></th><tr>";
    private final String filaInsertar="<tr><td>(id autogenerada)</td><td><input type='text' name='txtInsertarNombre' id='txtInsertarNombre' ></td><td><input type='text' name='txtInsertarApellidos' id='txtInsertarApellidos' ></td><td>"+this.getCboGrupos()+"</td><td><input type='text' name='txtInsertarcorreo' id='txtInsertarcorreo' ></td><td><input type='text' name='txtInsertarTelefono'  id='txtInsertarTelefono'></td><td><input type='text' name='txtInsertarEdad'  id='txtInsertarEdad'></td><td><input type='text' name='txtInsertarSexo'  id='txtInsertarSexo'></td><td><input name='btnInsertar' type='submit' value='+'></td><td><button name='btnEditar' class='sinBorde desaparecido'><img src='imgs/editar.png'></button></td></tr>";
    private GruposLogica grupos;
    
    public TablaAlumnos(Connection dbCon){
        this.grupos = new GruposLogica(dbCon);
    }
    
    public String generarTabla(LinkedList<Alumno> lista){
        String tabla="<table>"+encabezado+filaInsertar;
        
        if(lista.size()!=-1){
            for(int i=0;i<lista.size();i++){
            tabla+="<tr>"+fila(lista.get(i),true)+"</tr>";
            }
        }
        
        return tabla+"</table>";
    }
    public String generarTabla(int indice, LinkedList<Alumno> lista){
        String tabla="<table>"+this.encabezado+this.generarFilaInsertar(lista, indice);
        
        if(lista.size()!=-1){
            for(int i=0;i<lista.size();i++){
            tabla+="<tr>"+fila(lista.get(i),false)+"</tr>";
            }
        }
        
        return tabla+"</table>";
    }
    public String fila(Alumno p,boolean interactuable){
        if(interactuable){
            return "<td>"+p.getIdAlumno()+"</td><td>"+p.getNombre()+"</td><td>"+p.getApellidos()+"</td><td>$"+p.getGrupo()+"</td><td>"+p.getCorreo()+"</td><td>"+p.getTelefono()+"</td><td>"+p.getEdad()+"</td><td>"+p.getSexo()+"</td><td><button class='sinBorde' name='btnEliminar' value="+p.getIdAlumno()+" ><img src='imgs/eliminar.png'></button></td><td><button name='btnEditar' value="+p.getIdAlumno()+" class='sinBorde'><img src='imgs/editar.png'></button></td>";
        
        }else{
            return "<td>"+p.getIdAlumno()+"</td><td>"+p.getNombre()+"</td><td>"+p.getApellidos()+"</td><td>$"+p.getGrupo()+"</td><td>"+p.getCorreo()+"</td><td>"+p.getTelefono()+"</td><td>"+p.getEdad()+"</td><td>"+p.getSexo()+"</td><td><button class='sinBorde' name='btnEliminar' value="+p.getIdAlumno()+" disabled><img src='imgs/eliminar.png'></button></td><td><button name='btnEditar' disabled value="+p.getIdAlumno()+" class='sinBorde'><img src='imgs/editar.png'></button></td>";
        }
    }

    private String generarFilaInsertar(LinkedList<Alumno> lista, int indice) {
        return "<tr><td>(id autogenerada)</td><td><input type='text' name='txtInsertarNombre' id='txtInsertarNombre' value='"+lista.get(indice).getIdAlumno()+"'></td><td><input type='text' name='txtInsertarApellidos' id='txtInsertarApellidos' value='"+lista.get(indice).getApellidos()+"'></td><td>"+this.getCboGrupos()+"</td><td><input type='text' name='txtInsertarcorreo'  id='txtInsertarcorreo' value='"+lista.get(indice).getCorreo()+"'></td><td><input type='text' name='txtInsertarTelefono'  id='txtInsertarTelefono' value='"+lista.get(indice).getTelefono()+"'></td><td><input type='text' name='txtInsertarEdad'  id='txtInsertarEdad' value='"+lista.get(indice).getEdad()+"'></td><td><input type='text' name='txtInsertarSexo'  id='txtInsertarSexo' value='"+lista.get(indice).getSexo()+"'></td><td><button name='btnAceptar' class='sinBorde'><img src='imgs/editar.png'></button></td><td><input name='btnCancelar' type='submit' value='X'></td></tr>";
    }
    
    private String getCboGrupos(){
        String opc="<select>";
        //String[] gruposs= this.grupos.gruposDisponibles();
        String[] gruposs={"A","B","C"};
        for (int i = 0; i < gruposs.length; i++) {
            opc+="<option>"+gruposs[i]+"</option>";
        }
        return opc+"</select>";
    }
}
