package br.com.fiap.health.services;

import java.util.Date;

/**
 * Classe que simula a ingestão de alimentos
 * 
 * @author digit
 *
 */
public class AlimentoIngerido {
	private String alimento;
	private double porcaoIngerida;
	private Usuario usuario;
	private Date saveTime;

	public AlimentoIngerido(String alimento, double porcaoIngerida, Usuario usuario) {
		this.alimento = alimento;
		this.porcaoIngerida = porcaoIngerida;
		this.usuario = usuario;
		this.saveTime = new Date();
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public double getPorcaoIngerida() {
		return porcaoIngerida;
	}

	public void setPorcaoIngerida(double porcaoIngerida) {
		this.porcaoIngerida = porcaoIngerida;
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
