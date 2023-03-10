/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FIRAS
 */
public class MyDB {
    final String URL="jdbc:mysql://127.0.0.1:3306/culter_wave";
    final String USERNAME="root";
    final String PWD ="";
    private  Connection cnx;
    private static   MyDB instance;
    private MyDB(){
        try {
            cnx = DriverManager.getConnection(URL , USERNAME , PWD);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static MyDB getInsatnce(){
        if(instance == null)
            instance = new MyDB();
        return instance;
        
    }
    public Connection getCnx(){
        return cnx;
        
    }
}
