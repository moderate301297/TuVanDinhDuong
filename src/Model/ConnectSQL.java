/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectSQL {
    public static Connection connectsql(){
        try {
//          To load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
//          Create Connection variable in order to connect to database
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hcstt", "root", "12121996nghia");
            System.out.println("Database in connected!");
            return conn;
        }
        catch(Exception e) {
            System.out.print("Do not connect to DB - Error: " +e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        ConnectSQL con = new ConnectSQL();
        con.connectsql();
    }
}