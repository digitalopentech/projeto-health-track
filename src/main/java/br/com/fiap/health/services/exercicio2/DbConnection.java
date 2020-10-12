package br.com.fiap.health.services.exercicio2;

import java.sql.*;

public class DbConnection {

    //private static final String DB_URL = "jdbc:mysql://localhost:3306/humanResources2";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/humanResources2?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    //private static final String PASSWORD = "Ramona1990sql";
    private static final String PASSWORD = "caelum123";

    private DbConnection() { }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);   //factory method design pattern
        return conn;
    }
}
