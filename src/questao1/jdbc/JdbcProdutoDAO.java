package questao1.jdbc;

import questao1.Produto;
import questao1.ProdutoDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcProdutoDAO implements ProdutoDAO {

    public void adicionarProdutos(Produto produto) {
        String sql = "INSERT INTO produto(nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";
        Conexao conexao = new Conexao();
        try(Connection ignored = conexao.getConnection();
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setBigDecimal(4, produto.getPreco());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    public Boolean buscarProduto(int id) {
        String sql = "SELECT id FROM produto WHERE id = " + id;

        Conexao conexao = new Conexao();

        try(Connection ignored = conexao.getConnection();
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            return resultSet.next();

        } catch (Exception e) {
            e.getStackTrace();
            return true;
        }
    }

    public void atualizandoProduto() {

        String sql = "UPDATE produto SET nome = ?, descricao = ?, quantidade = ?, preco = ? WHERE id = ?";

        Conexao conexao = new Conexao();
        try(Connection ignored = conexao.getConnection();
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, "Headset");
            preparedStatement.setString(2, "Mesa de escritorio");
            preparedStatement.setInt(3, 4);
            preparedStatement.setBigDecimal(4, new BigDecimal("236.63"));
            preparedStatement.setInt(5, 1);
            preparedStatement.execute();

            System.out.println("Produtos atualizados");

        }catch (Exception e) {
            e.getStackTrace();
        }
    }
    public void excluindoProduto() {
        String sql = "DELETE FROM produto WHERE id = ?";
        Conexao conexao = new Conexao();
        try(Connection ignored = conexao.getConnection();
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, 2);
            preparedStatement.execute();

            System.out.println("Produto foi Excluido");
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

	public void addproduto(Produto produto) {
		
	}
}