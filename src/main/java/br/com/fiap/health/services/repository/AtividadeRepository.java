package br.com.fiap.health.services.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.health.model.Usuario;
import br.com.fiap.health.services.infra.DbConnection;

public class AtividadeRepository {

	public List<Usuario> getAll() {
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarioList = new ArrayList<>();
		try (Connection conn = DbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery()) {
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(resultSet.getString("nome"));
				usuario.setGenero(resultSet.getString("genero"));
				usuario.setNascimento(resultSet.getDate("data_hora"));
				usuarioList.add(usuario);
			}
			conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return usuarioList;
	}

	public void insert() {
		String sql = "INSERT INTO atividade(id_atividade, usuario_id, id_tipo_atividade, data_hora) VALUES\r\n" + 
				"(peso_seq.NEXTVAL, 29, 1, current_timestamp)";
		try (Connection conn = DbConnection.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
