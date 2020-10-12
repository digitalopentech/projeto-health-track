package br.com.fiap.health.services.exercicio2;

import java.sql.*;

public class Exercise1 {
    public static void main(String[] args) {

        displayAllProjects();
        System.out.println("************************");
        displayAllEmployees();
        System.out.println("************************");
        displayAllEmployeesWithNameStartsWithJ();
        System.out.println("************************");
        displayAllEmployeesWithNoDepartment();
        System.out.println("************************");
        displayAllEmployeesWithThereDepartment();
    }

    public static void displayAllProjects() {
        String sql = "SELECT * FROM projects";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString("description"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void displayAllEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString("firstName") +
                        ": " + resultSet.getString("lastName") + ": " + resultSet.getDate("dateOfBirth"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void displayAllEmployeesWithNameStartsWithJ() {
        String sql = "SELECT * FROM employees WHERE firstName LIKE 'J%'";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString("firstName") +
                        ": " + resultSet.getString("lastName") + ": " + resultSet.getDate("dateOfBirth"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void displayAllEmployeesWithNoDepartment(){
        String sql = "SELECT * FROM employees WHERE departmentID IS NULL";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString("firstName") +
                        ": " + resultSet.getString("lastName") + ": " + resultSet.getDate("dateOfBirth"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void displayAllEmployeesWithThereDepartment(){
        String sql = "SELECT e.employeeId,e.firstName,e.lastName,e.dateOfBirth,d.name FROM employees e " +
                "INNER JOIN departments d ON e.departmentId=d.departmentId";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString("firstName") +
                        ": " + resultSet.getString("lastName") + ": " + resultSet.getDate("dateOfBirth") +
                        ": " + resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
