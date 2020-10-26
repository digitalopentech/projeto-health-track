package br.com.fiap.health.model;

import java.util.Date;

/**
 * Classe que simula a medição do peso
 * 
 * @author digit
 *
 */
public class Peso {
	private double peso;
	private double altura;
	private Usuario usuario;
	private Date saveTime;

	public Peso() {
	}

	public Peso(double bpm, double minima, Usuario usuario) {
		this.peso = peso;
		this.altura = altura;
		this.usuario = usuario;
		this.saveTime = new Date();
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}

}
