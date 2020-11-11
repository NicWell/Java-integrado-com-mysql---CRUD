/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Wellington Nicácio
 */
public class TestaLista {
    public static void main (String[] args) throws SQLException {
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("Data de Nascimento: " +
            contato.getDataNascimento().getTime() + "\n");
        }
        Contato con = new Contato();
        con.setNome("Teste Final");
        con.setEmail("contato@caelum.com.br");
        con.setEndereco("R. Vergueiro 3185 cj57");
        con.setDataNascimento(Calendar.getInstance());
        con.setId(Long.valueOf("1"));
        dao.altera(con);
        Contato con2 = new Contato();
        con2.setId(Long.valueOf("3"));
        dao.remove(con2);
    }
}
