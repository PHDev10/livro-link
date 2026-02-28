package br.edu.ifpb.livrolink.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/livro_link";
    private static final String USER = "postgres";
    private static final String PASSWORD = "54321";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        return conn;
    }
}
