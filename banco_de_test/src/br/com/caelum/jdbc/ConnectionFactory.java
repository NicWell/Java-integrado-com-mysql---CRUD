/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
    static final String URL = "jdbc:mysql://localhost:3306/fj21";
    static final String USER = "root";
    static final String PASSW = "well12";
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSW);
        } catch(SQLException e) {
            throw new RuntimeException(e);
            //System.err.println("Erro de conexão:"+e);
        }
    }
    //Connection con = new ConnectionFactory().getConnection();
}
