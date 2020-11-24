package com.example.carsales;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class ConnectionClass {
    String ip="35.232.98.189";
    String port="3306";
    String database="Carsales";
    String username="newuser";
    String password="mypass";
    String url="jdbc:mysql://"+ip+":"+port+"/"+database;
    Connection connection=null;
    public Connection CONN(){
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String ConnURL=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,username,password);
            connection=DriverManager.getConnection(ConnURL);
        } catch (ClassNotFoundException | SQLException e) {
            Log.e("ERRO",e.getMessage());
        }
        return connection;
    }
}
