/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import br.com.caelum.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wellington Nicácio
 */
public class funcionarioDao {
    private Connection connection;
    
    public funcionarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona (funcionario func){
        String sql = "insert into funcionario " +"(nome,usuario,senha,endereco)" + " values (?,?,?,?)";
        
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1,func.getNome());
            stmt.setString(2, func.getUsuario());
            stmt.setString(3, func.getSenha());
            stmt.setString(4, func.getEndereco());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public  List<funcionario> getLista() throws SQLException{
        List<funcionario> funcionarios = new ArrayList<funcionario>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from funcionario");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Contato
                funcionario funcionario1 = new funcionario();
                funcionario1.setId(rs.getLong("id"));
                funcionario1.setNome(rs.getString("nome"));
                funcionario1.setUsuario(rs.getString("usuario"));
                funcionario1.setSenha(rs.getString("senha"));
                funcionario1.setEndereco(rs.getString("endereco"));
                funcionarios.add(funcionario1);
            } 
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void altera(funcionario func) throws SQLException {
        String sql = "update funcionario set nome=?, usuario=?, senha=?," + "endereco=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getUsuario());
            stmt.setString(3, func.getSenha());
            stmt.setString(4, func.getEndereco());
            stmt.setLong(5, func.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void remove (funcionario func) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from funcionario where id=?");
            stmt.setLong(1, func.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
