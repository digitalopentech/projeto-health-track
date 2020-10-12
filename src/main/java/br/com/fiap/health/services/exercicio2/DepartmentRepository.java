package br.com.fiap.health.services.exercicio2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    List<Department> findAll() {
        String sql = "SELECT * FROM departments";
        List<Department> departmentList = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                Department d = new Department();
                //d.setDepartmentId(resultSet.getInt(1));
                d.setName(resultSet.getString("name"));
                departmentList.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return departmentList;
    }

    List<Department> findById(Integer departmentId) {
        String sql = "SELECT departmentID,name FROM departments WHERE departmentID=?";
        List<Department> departmentList = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, departmentId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Department d = new Department();
                d.setName(resultSet.getString("name"));
                departmentList.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return departmentList;
    }

    void deleteById(Integer departmentId) {
        String sql = "DELETE FROM employees WHERE departmendID=?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, departmentId);
            int deleteRows = stmt.executeUpdate();
            System.out.println("Au fost sterse " + deleteRows + " randuri din employees!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void save(Department department) {
        String sql = "INSERT INTO departments (name) VALUES ('" + department.getName() + "')";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void update(Department department) {
        String slq = "UPDATE departments SET name = '" + department.getName() +
                "' WHERE departmentId = '" + department.getDepartmentId() + "'";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(slq)) {
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    List<Department> findByName(String name) {
        String sql = "SELECT * FROM departments WHERE name=?";
        List<Department> departmentList = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Department d = new Department();
                d.setName(resultSet.getString("name"));
                departmentList.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return departmentList;
    }

}
