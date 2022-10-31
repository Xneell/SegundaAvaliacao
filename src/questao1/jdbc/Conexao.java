package questao1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
             // CONECTANDO
    private String url = "jdbc:mysql://localhost/produtosbd?useTimezone=true&serverTimezone=UTC";
    private String usuario = "root";
    private String senha = "root";

    public Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        return conexao;
    }
}
