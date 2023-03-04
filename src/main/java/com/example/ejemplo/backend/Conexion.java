package com.example.ejemplo.backend;

import java.sql.Connection;
import java.sql.*;

public class Conexion{

    public Connection getConnection(){
        Connection connection =null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serie", "root", "");
            if(connection !=null){
                System.out.println("Conexion exitosa");
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}