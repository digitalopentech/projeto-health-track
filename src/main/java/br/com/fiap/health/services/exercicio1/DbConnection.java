package br.com.fiap.health.services.exercicio1;

import java.sql.*;

public class DbConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/humanResources2";
    private static final String USERNAME = "root";
    //private static final String PASSWORD = "Ramona1990sql";
    private static final String PASSWORD = "caelum123";

    private DbConnection() { }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);   //factory method design pattern
        return conn;
    }
    
    public static Connection getOracleConnection() throws SQLException {
    	Connection conexao = null;
    	try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "c##admin", "admin")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
                conexao = conn;
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return conexao;		
    }
}
