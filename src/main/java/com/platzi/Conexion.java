package com.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if(connection != null){
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException throwables) {
            System.out.println("Error de conexion");
            throwables.printStackTrace();
        }
        finally {
            return connection;
        }
    }
}
