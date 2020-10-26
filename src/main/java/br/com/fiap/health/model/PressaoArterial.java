package br.com.fiap.health.model;

import java.util.Date;

/**
 * Classe que simula a aferição da Pressão arterial
 * 
 * @author digit
 *
 */
public class PressaoArterial {
	private double maxima;
	private double minima;
	private Usuario usuario;
	private Date saveTime;

	public PressaoArterial(double bpm, double minima, Usuario usuario) {
		this.maxima = bpm;
		this.minima = minima;
		this.usuario = usuario;
		this.saveTime = new Date();
	}

	public double getMaxima() {
		return maxima;
	}

	public void setMaxima(double maxima) {
		this.maxima = maxima;
	}

	public double getMinima() {
		return minima;
	}

	public void setMinima(double minima) {
		this.minima = minima;
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
