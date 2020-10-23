package br.com.fiap.health.services;

import java.util.Date;

/**
 * Classe que simula a medição do peso
 * 
 * @author digit
 *
 */
public class Peso {
	private int peso;
	private int altura;
	private Usuario usuario;
	private Date saveTime;

	public Peso(double bpm, double minima, Usuario usuario) {
		this.peso = peso;
		this.altura = altura;
		this.usuario = usuario;
		this.saveTime = new Date();
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
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
