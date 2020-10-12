package br.com.fiap.health.services;

import java.sql.*;

public class PreparedStatementDemo {
    private PreparedStatementDemo() {
    }

    public static void addNota(String nume, String materie, int nota) {
        String sql = "INSERT INTO nota(student_id,materie_id,nota) SELECT s.id,m.id," + nota +
                " FROM (SELECT id FROM student WHERE nume='" + nume + "') s " +
                "CROSS JOIN (SELECT id FROM materie WHERE nume='" + materie + "') m";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            int count = stmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTeacher(String nume) {
        String sql = "INSERT INTO profesor(nume) VALUES(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nume);
            int addedTeachers = stmt.executeUpdate();
            System.out.println("Am introdus " + addedTeachers + (addedTeachers == 1 ? " profesor in coloana profesor" : " profesori in coloana profesor"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ( id int primary key auto_increment, username varchar(20), password varchar(20))";
        try (Connection conn = DbConnection.getConnection(); //getH2Connection()
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
