package br.com.fiap.health.services.infra;

import java.sql.*;

public class DbConnection {

	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "c##admin";
    private static final String PASSWORD = "admin";

    private DbConnection() { }

    public static Connection getConnection() throws SQLException {
    	Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        if (conn != null) {
            System.out.println("Conectado com sucesso!");
        } else {
            System.out.println("Falha na conexão!");
        }
		return conn;
    }

}
