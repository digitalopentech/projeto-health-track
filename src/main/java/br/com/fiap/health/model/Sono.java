package br.com.fiap.health.model;

import java.util.Date;

/**
 * Classe que simula o Sono
 * @author Grupo FIAP
 *
 */
public class Sono {
    public Date horaDormir;
    public Date horaAcordar;

    public Sono(Date sleepTime, Date wakeTime) {
        this.horaDormir = sleepTime;
        this.horaAcordar = wakeTime;
    }

    public long tempoDormindo() {
        return (horaAcordar.getTime() - horaDormir.getTime()) / 1000;
    }

	public Date getHoraDormir() {
		return horaDormir;
	}

	public Date getHoraAcordar() {
		return horaAcordar;
	}
}