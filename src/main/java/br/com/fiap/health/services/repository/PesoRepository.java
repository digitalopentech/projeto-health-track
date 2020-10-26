package br.com.fiap.health.services.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.health.model.Peso;
import br.com.fiap.health.services.infra.DbConnection;

public class PesoRepository {

	public List<Peso> getAll() {
		String sql = "SELECT * FROM peso";
		List<Peso> PesoList = new ArrayList<>();
		try (Connection conn = DbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery()) {
			while (resultSet.next()) {
				Peso Peso = new Peso();
				Peso.setPeso(resultSet.getDouble("peso"));
				Peso.setAltura(resultSet.getDouble("altura"));
				Peso.setSaveTime(resultSet.getDate("data_hora"));
				PesoList.add(Peso);
			}
			conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return PesoList;
	}

	public void insert() {
		String sql = "INSERT INTO peso(id_peso, usuario_id, peso, altura, data_hora) VALUES\r\n" + 
				"(peso_seq.NEXTVAL, 29, 90.0, 1.90, current_timestamp)";
		try (Connection conn = DbConnection.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
