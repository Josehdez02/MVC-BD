package org.example;

import java.sql.Connection;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String bd_name = "topicoss";
    private String url = "jdbc:mysql://localhost:3306/" + bd_name;
    private String user = "root";
    private String pswd = "Mamita-2002";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conn;

    public Conexion(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            JOptionPane.showMessageDialog(null,
                    "Connexion Establecida Correctamente");
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,
                    "Error de conexion");
        }
    }
    public Connection getConn(){
        return conn;
    }
    public void closeConn() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null,"Conexion Cerrada");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cerrar conexion "+e.getMessage());
        }
    }
}