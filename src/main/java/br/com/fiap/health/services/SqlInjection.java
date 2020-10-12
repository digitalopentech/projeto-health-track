package br.com.fiap.health.services;

import java.sql.*;

public class SqlInjection {
    public static void main(String[] args) {

        PreparedStatementDemo.createUsersTable();
        badLogin("Ion", "123456");
        badLogin("Ion", "1234");
        badLogin("Ion", "' or password=(SELECT password from users where username='Ion') or password='");
        login("Ion","123456");
        login("Ion","12356");
        login("Ion","' or password=(SELECT password from users where username='Ion') or password='");

    }

    public static void badLogin(String username, String password) {
        String sql = "SELECT username FROM users WHERE username='" + username + "' AND password='" + password + "'";
        try (Connection conn = DbConnection.getConnection(); //getH2Connection()
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            if (resultSet.next()) {
                System.out.println("Login");
            } else {
                System.out.println("Wrong username or password!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void login(String username, String password) {
        String sql = "SELECT username FROM users WHERE username=? AND password=?";
        try (Connection conn = DbConnection.getConnection(); //getH2Connection()
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Login");
                } else {
                    System.out.println("Wrong username or password!");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
