/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.controladores;

import com.mycompany.proyecto.conexion.DbUtil;
import java.sql.Connection;

/**
 *
 * @author victo
 */
public class main {
    public static void main(String[] args) {
        Connection _dbCon= DbUtil.getInstance().getConnection();
        AlumnosLogica a = new AlumnosLogica(_dbCon);
        System.out.println(a.recuperarTodos().getFirst().getNombre());
        
    }
}
