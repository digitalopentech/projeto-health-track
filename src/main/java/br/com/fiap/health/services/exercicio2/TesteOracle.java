package br.com.fiap.health.services.exercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class TesteOracle {

	public static void main(String[] args) {

		String sql;

		/*
		 * O driver JDBC do Oracle está disponível no seguinte endereço:
		 * http://www.oracle.com/technetwork/database/features/jdbc/index-091264.html
		 */
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##admin", "admin");

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			
            boolean tabelaCriada = false;
            
			// Cria-se Statement com base na conexão con
			Statement stmt = conn.createStatement();

//			// Exemplo: excluindo a tabela filmes do Banco de Dados de Teste
//			try {
//				sql = "DROP TABLE FILMESS";
//				stmt.executeUpdate(sql);	
//			} catch (SQLSyntaxErrorException e) {
//				// TODO: handle exception
//				tabelaCriada = true;
//				createTable(stmt);
//			}
//			// Exemplo: cria-se uma tabela no Banco de Dados de Teste
//			if(!tabelaCriada){
//				createTable(stmt);				
//			}
//
//			// Exemplo: inserindo dados na tabela de filmes
//			sql = "INSERT INTO FILMESS (titulo, ano, diretor)"
//					+ "VALUES ('The Matrix', 1999, 'Andy Wachowski & Larry Wachowski')";
//			stmt.executeUpdate(sql);
//
//			sql = "INSERT INTO FILMESS (titulo, ano, diretor)"
//					+ "VALUES ('The Matrix Reloaded', 2003, 'Andy Wachowski & Larry Wachowski')";
//			stmt.executeUpdate(sql);
//
//			sql = "INSERT INTO FILMESS (titulo, ano, diretor)"
//					+ "VALUES ('The Matrix Revolutions', 2003, 'Andy Wachowski & Larry Wachowski')";
			
//			stmt.executeUpdate(sql);

			// Exemplo: navegando e exibindo os dados dos filmes
			//sql = "SELECT titulo, ano FROM FILMESS";
			sql = "SELECT * FROM USUARIO";
			// Executa-se a consulta dos campos titulo,ano da tabela de filmes
			ResultSet res = stmt.executeQuery(sql);

			int id;
			int idade;
			String genero;

			while (res.next()) {
				id = res.getInt("id");
				idade = res.getInt("idade");
				genero = res.getString("genero");
				System.out.println("ROW = " + id + ": " + genero + ": " + idade);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void createTable(Statement stmt) throws SQLException {
		String sql;
		sql = "CREATE TABLE FILMESS\r\n" + 
				"   (\r\n" + 
				"   COD_EMPRESA NUMBER(*,0), \r\n" + 
				"    TITULO VARCHAR2(30 BYTE), \r\n" + 
				"	ANO NUMBER(*,0), \r\n" + 
				"	DIRETOR VARCHAR2(32 BYTE), \r\n" + 
				"	SITUACAO CHAR(1 BYTE)\r\n" + 
				"   )";
		stmt.executeUpdate(sql);
	}

}
