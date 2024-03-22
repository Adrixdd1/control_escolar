/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author victo
 * @param <T>
 */
public abstract class AbstractConnector<T> {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    private Connection dbCon;
    
    public AbstractConnector (Connection _dbCon){
        this.dbCon = _dbCon;
    }

    public Connection getDbCon() {
        return dbCon;
    }

    public void setDbCon(Connection dbCon) {
        this.dbCon = dbCon;
    }
    
    public abstract LinkedList<T> queryToDataBase(String id);
    
    public abstract boolean insertToDataBase(Object objeto);

    public abstract boolean updateToDataBase(Object objeto);

    public abstract boolean deleteToDataBase(String id);

    

    public boolean ejecutarUpdate(String querySQL) {
        try {
            Statement r = this.getDbCon().createStatement();
            if (r.executeUpdate(querySQL) != 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public ResultSet ejecutarQuery(String querySQL) {
        try {
            Statement r = getDbCon().createStatement();
            return r.executeQuery(querySQL);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            StackTraceElement lista[] =ex.getStackTrace();
            for (StackTraceElement item : lista) {
                 System.out.println(item.toString());
            }
        }
        return null;
    }
}