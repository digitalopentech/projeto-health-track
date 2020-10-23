package br.com.fiap.health.services;

import java.util.Date;

/**
 * Classe que representa um usuario
 * 
 * @author
 *
 */
public class Usuario {

	private String nome;
	protected Date nascimento;
	private String genero;
	private int idade;
	private static Usuario instance;

	private double valor;

	public Usuario() {
	}

	public static Usuario getInstance() {
		if (instance == null) {
			instance = new Usuario();
		}
		return instance;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public static void setInstance(Usuario instance) {
		Usuario.instance = instance;
	}

}
