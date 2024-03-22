
package com.mycompany.proyecto.conexion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
	private static DbUtil instance = new DbUtil();
	private Connection conexion = null;
	
	private DbUtil(){}
	public static DbUtil getInstance() {
            return instance;
	}
        
	private boolean createConexion(){
            try {
            
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/";
            String database = "control_escolar?useUnicode=true&characterEncoding-utf8&useSSL=false";
            String user = "root";
            String password = "root";
            
            Class.forName(driver);
            
            conexion = DriverManager.getConnection(url + database, user, password);
            if (conexion != null) 
            {                
            	System.out.println("Conexion a base de datos lista....Esperando :)");
                
            }
        } catch (ClassNotFoundException e) {	// La clase a la que se llama no funciona
            e.printStackTrace();
        } catch (SQLException e) { 				// Error al establecer conexion
            e.printStackTrace();
        }
            return true;
	}
	
    public Connection getConnection() {
        if (conexion == null)
            this.createConexion();          
        return conexion;
    }

    private Statement createStatement(int TYPE_FORWARD_ONLY, int CONCUR_READ_ONLY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}