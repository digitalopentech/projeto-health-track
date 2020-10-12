package br.com.fiap.health.services;

import java.sql.*;
import java.util.*;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DbConnection.getConnection()) {
            System.out.println(conn);
        }

        Connection conn2=null;
        //old way, use try with resorusec
        try{
            conn2 = DbConnection.getConnectionWithDataSource();
            System.out.println(conn2);
        }finally {
            if(conn2!=null)
                conn2.close();
        }
        StatementDemo.deleteAllNota();
        StatementDemo.deleteAllStudents();
        StatementDemo.deleteAllTeacher();
        StatementDemo.deleteAllMaterii();

        StatementDemo.addStudent("Ion");
        StatementDemo.addStudent("Mihai");

        StatementDemo.addProfesor("Profesor One");
        StatementDemo.addProfesor("Profesor Two");

        StatementDemo.updateStudentName("Ion","Ionut");

        StatementDemo.displayAllStudents();

        StatementDemo.SearchTeacherByName("Profesor One");

        Set<String> courses = new HashSet<>();
        courses.add("Romana");
        courses.add("Matematica");
        courses.add("Istorie");
        StatementDemo.addCourses(courses);

        PreparedStatementDemo.addNota("Mihai","Romana",10);

        PreparedStatementDemo.addTeacher("Profesor Three");

        TransactionDemo.addStudents(Arrays.asList("Dan","Gigel"));
        TransactionDemo.addBatchStudents(Arrays.asList("Ionel","Gigel","Igor"));
    }
}
