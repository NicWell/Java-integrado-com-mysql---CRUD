/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;


public class JDBCInsere {
    public static void main (String[] args) throws SQLException{
        /*
        //Conectado
        Connection con = new ConnectionFactory().getConnection();
        
        //Criando O preparedStatement
        String sql = "insert into contatos" + " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        //preeche os Valores
        stmt.setString(1, "Well");
        stmt.setString(2, "wellingtonngc12345@gmail.com");
        stmt.setString(3, "AV. Alemanha 04");
        stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        
        //Executa
        
        stmt.execute();
        stmt.close();
        
        System.out.println("Gravado");
        
        con.close();
        */
        /*
        Connection con = null;
        String sql = "insert into contatos" + " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
        try {
            con = new ConnectionFactory().getConnection();
            //Criando O preparedStatement
            PreparedStatement stmt = con.prepareStatement(sql);
        
            //preeche os Valores
            stmt.setString(1, "Well");
            stmt.setString(2, "wellingtonngc12345@gmail.com");
            stmt.setString(3, "AV. Alemanha 04");
            stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        
            //Executa
            stmt.execute();
            stmt.close();
            System.out.println("Gravado");
        }catch (RuntimeException | SQLException e){
            System.err.println(e);
        } finally {
            con.close();
        } */
        Connection con = null;
        String sql = "insert into contatos" + " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
        try {
            con = new ConnectionFactory().getConnection();
            //preeche os Valores
            //Criando O preparedStatement
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                //preeche os Valores
                stmt.setString(1, "teste");
                stmt.setString(2, "weldsasd@fff");
                stmt.setString(3, "vsahvdas dfdsf");
                stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                 
                //Executa
                stmt.execute();
            } catch(SQLException  | RuntimeException e){
                System.err.println(e);
            }
            System.out.println("Gravado");
        } finally {
            con.close();
        }
        
        
    }
}
