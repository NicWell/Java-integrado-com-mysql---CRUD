/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Wellington Nicácio
 */
public class TestaInsere {
    public static void main (String[] args) throws SQLException {
        Contato contato = new Contato();
        contato.setNome("Caelum");
        contato.setEmail("contato@caelum.com.br");
        contato.setEndereco("R. Vergueiro 3185 cj57");
        contato.setDataNascimento(Calendar.getInstance());
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        System.out.println("Gravado!");
        // pega a conexão e o Statement
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = con.prepareStatement("select * from contatos");
        // executa um select
        ResultSet rs = stmt.executeQuery();
        
        List<Contato> contatos = new ArrayList<Contato>();
        // itera no ResultSet
        while (rs.next()) {
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            System.out.println(nome + " :: " + email);
            // criando o objeto Contato
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));
            // montando a data através do Calendar
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            contato.setDataNascimento(data);
            // adicionando o objeto à lista
            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        con.close();
    }
}
