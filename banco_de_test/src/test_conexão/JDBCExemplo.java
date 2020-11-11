/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCExemplo {
    public static void main(String[] args) throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/fj21";
        String USER = "root";
        String PASS = "well12";
        Connection conexao = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Conectado");
        conexao.close();
        /*
        Connection con = new ConnectionFactory().getConnection();
        if(con != null){
            System.err.println("Conectado");
        } else {
            System.err.println("Erro");
        }
        con.close(); 
        */
    }
}