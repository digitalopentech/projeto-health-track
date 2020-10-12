package br.com.fiap.health.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class StatementDemo {
    private StatementDemo() {
    }

    public static void addStudent(String nume) {
        String sql = "INSERT INTO student (nume) VALUES ('" + nume + "')";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
        ) {
            int count = stmt.executeUpdate(sql);
            if (count == 1) {
                System.out.println("Am adaugat un student!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addProfesor(String nume) {
        String sql = "INSERT INTO profesor (nume) VALUES ('" + nume + "')";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
        ) {
            int count = stmt.executeUpdate(sql);
            if (count == 1) {
                System.out.println("Am adaugat un profesor!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllStudents() {
        String sql = "DELETE FROM student";
        try (Connection conn = DbConnection.getConnectionWithDataSource();
             Statement stmt = conn.createStatement()) {
            int deleteRows = stmt.executeUpdate(sql);
            System.out.println("Au fost stersi " + deleteRows + " studenti din tabelul student!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllTeacher() {
        String sql = "DELETE FROM profesor";
        try (Connection conn = DbConnection.getConnectionWithDataSource();
             Statement stmt = conn.createStatement()) {
            int deleteRows = stmt.executeUpdate(sql);
            System.out.println("Au fost stersi " + deleteRows + " profesori din tabelul profesor!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteAllMaterii() {
        String sql = "DELETE FROM materie";
        try (Connection conn = DbConnection.getConnectionWithDataSource();
             Statement stmt = conn.createStatement()) {
            int deleteRows = stmt.executeUpdate(sql);
            System.out.println("Au fost sterse " + deleteRows + " materii din tabelul materie!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteAllNota() {
        String sql = "DELETE FROM nota";
        try (Connection conn = DbConnection.getConnectionWithDataSource();
             Statement stmt = conn.createStatement()) {
            int deleteRows = stmt.executeUpdate(sql);
            System.out.println("Au fost sterse " + deleteRows + " note din tabelul nota!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudentName(String numeVechi, String numeNou) {
        String sql = "UPDATE student SET nume='" + numeNou + "' WHERE nume='" + numeVechi + "'";
//        StringBuilder sb = new StringBuilder("UPDATE student SET nume='")
//                .append(numeNou)
//                .append("' WHERE nume='")
//                .append(numeVechi)
//                .append("'");
//        System.out.println(sb.toString());
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            int updateStudents = stmt.executeUpdate(sql); //sb.toString()
            System.out.println("Am modificat " + updateStudents + " studenti!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllStudents() {
        String sql = "SELECT * FROM student";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ":" + resultSet.getString("nume"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void SearchTeacherByName(String name) {
        String sql = "SELECT nume FROM profesor WHERE nume='" + name + "'";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            boolean isSELECT = stmt.execute(sql);
            if (isSELECT) {
                System.out.println("Lista profesori cu numele " + name);
                try (ResultSet resultSet = stmt.getResultSet()) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(1));
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addCourses(Set<String> courseList) {
        String sql = "INSERT INTO materie(nume) VALUES";
        for (String course : courseList) {
            sql += "('" + course + "'),";
        }
        sql = sql.substring(0, sql.length() - 1);
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            boolean isSELECT = stmt.execute(sql);
            if (!isSELECT) {
                int updateCount = stmt.getUpdateCount();
                System.out.println("Am introdus " + updateCount + " cursuri!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


