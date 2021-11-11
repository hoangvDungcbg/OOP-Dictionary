/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionaryuet;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class DBSQL {
        public static void main(String[] args){
            String url = "jdbc:mysql://localhost:3306/dictdb";
            String username = "coxedap";
            String password = "Dung1b345?";
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
               System.out.println("Error!!!");
               ex.printStackTrace();
            }
        }
}
