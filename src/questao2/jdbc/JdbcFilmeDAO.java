package questao2.jdbc;

import questao2.Filme;
import questao2.FilmeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcFilmeDAO implements FilmeDAO {

    public void adicionarFilmes(List<Filme> filmes) {
       
        String sql = "INSERT INTO filme(nome, descricao, ano) VALUES (?, ?, ?)";

        ConectandoBD conexao = new ConectandoBD();

        try (Connection ignored = conexao.getConnection();
             PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql)) {

            for (Filme filme : filmes) {
                preparedStatement.setString(1, filme.getNome());
                preparedStatement.setString(2, filme.getDescricao());
                preparedStatement.setInt(3, filme.getAno());
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public List<Filme> listarFilmes(int quantidade, int pagina) {
    
        String sql = "SELECT * FROM filme LIMIT " + quantidade + " OFFSET " + pagina;

        List<Filme> filmes = new ArrayList<>();

        ConectandoBD conexao = new ConectandoBD();

        try (Connection ignored = conexao.getConnection();
             PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Filme filme = new Filme(
                        resultSet.getString("nome"),
                        resultSet.getString("descricao"),
                        resultSet.getInt("ano"));

                filmes.add(filme);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return filmes;
    }
    public void excluirFilmes() {
        String sql = "TRUNCATE TABLE filme";
        ConectandoBD conexao = new ConectandoBD();
        try (Connection ignored = conexao.getConnection();
             PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql)) {

            preparedStatement.execute();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
