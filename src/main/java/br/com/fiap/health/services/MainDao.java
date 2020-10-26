package br.com.fiap.health.services;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import br.com.fiap.health.model.Usuario;
import br.com.fiap.health.services.infra.AtividadeRepository;
import br.com.fiap.health.services.infra.PesoRepository;
import br.com.fiap.health.services.infra.PressaoArterialRepository;
import br.com.fiap.health.services.infra.UsuarioRepository;

public class MainDao {

	public static void main(String[] args) {
		insertUsuarios();
		System.out.println("************************");
		exibirUsuarios();
		System.out.println("************************");
		insertPeso();
		System.out.println("************************");
		insertPressaoArterial();
		System.out.println("************************");
		insertAtividade();
	}

	/**
	 * 
	 */
	public static void insertUsuarios() {

		try {
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			
			for(int i=0;i<=5;i++) {
				usuarioRepository.insert();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void insertPeso() {

		try {
			PesoRepository pesoRepository = new PesoRepository();
			
			for(int i=0;i<=5;i++) {
				pesoRepository.insert();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void insertPressaoArterial() {

		try {
			PressaoArterialRepository pressaoArterialRepository = new PressaoArterialRepository();
			
			for(int i=0;i<=5;i++) {
				pressaoArterialRepository.insert();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void insertAtividade() {

		try {
			AtividadeRepository atividadeRepository = new AtividadeRepository();
			
			for(int i=0;i<=5;i++) {
				atividadeRepository.insert();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public static void exibirUsuarios() {

		try {
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			
			usuarioRepository.insert();
			
			int idade;
			String genero;
			String nome;
			Date dataInclusao;
			
			List<Usuario> usuarios = usuarioRepository.getAll();
			
			for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext();) {
				Usuario usuario = (Usuario) iterator.next();

				idade = usuario.getIdade();
				genero = usuario.getGenero();
				nome = usuario.getNome();
				dataInclusao = (Date) usuario.getNascimento();
				System.out.println("Linhas = " + idade + ": " + genero + ": " + nome + ": " + dataInclusao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}