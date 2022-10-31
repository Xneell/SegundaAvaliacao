package questao2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectandoBD {

    public Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/filmes?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";
        return DriverManager.getConnection(url, usuario, senha);
    }
}