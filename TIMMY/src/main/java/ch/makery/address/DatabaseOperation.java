package ch.makery.address;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Steff
 */
public class DatabaseOperation {
    static String dbAdress = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2018_teaching?autoReconnect=true&useSSL=false";
    static String dbUsername = "hst_2018_teaching";
    static String dbPassword = "aeneekohngeithikophe";
    
    public static Connection connect(){
        try{
            // Load JDBL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        }
        catch (ClassNotFoundException ex){
            System.out.println("Class not found");
            return null;
        }
        
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(dbAdress, dbUsername, dbPassword);
            return connection;
        }
        catch(SQLException sqlEx){
            System.out.println(sqlEx.getMessage());
            return null;
        }
    }
}
