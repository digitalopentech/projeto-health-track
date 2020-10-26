package br.com.fiap.health.model;

import java.util.Date;

/**
 * Classe que simula a frequ�ncia cardiaca
 * @author digit
 *
 */
public class FrequenciaCardiaca {
    private double bpm;
    private Date saveTime;

    public FrequenciaCardiaca(double bpm) {
        this.bpm = bpm;
        this.saveTime = new Date();
    }

    /**
     * Retorna os batimentos por segundo do cora��o
     * @return
     */
    public double getBpm() {
        return bpm;
    }

    /**
     * Retorna a data que foi registrado
     * @return
     */
    public Date getSaveTime() {
        return saveTime;
    }
}
