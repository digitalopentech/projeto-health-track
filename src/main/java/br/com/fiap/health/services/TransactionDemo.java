package br.com.fiap.health.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionDemo {
    private TransactionDemo(){}

    public static void addStudents(List<String> studentList){
        String sql = "INSERT INTO student(nume) VALUES(?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            for(String student:studentList){
                stmt.setString(1,student);
                stmt.executeUpdate();
            }
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addBatchStudents(List<String> studentList){
        String sql = "INSERT INTO student(nume) VALUES(?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            for(String student:studentList){
                stmt.setString(1,student);
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
