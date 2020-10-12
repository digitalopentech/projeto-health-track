package br.com.fiap.health.services;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class DbConnection {

    //private static final String DB_URL="jdbc:mysql://localhost:3306/school";
	private static final String DB_URL="jdbc:mysql://localhost:3306/school?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC";
    private static final String USERNAME ="root";
    //private static final String PASSWORD ="Ramona1990sql";
    private static final String PASSWORD ="Caelum123";
    private DbConnection(){}

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);   //factory method design pattern
        return conn;
    }
    public static Connection getH2Connection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./test","sa",""); //default sa no password
        return conn;
    }
    public static Connection getConnectionWithDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(DB_URL);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        Connection conn = dataSource.getConnection();
        return conn;
    }
}
