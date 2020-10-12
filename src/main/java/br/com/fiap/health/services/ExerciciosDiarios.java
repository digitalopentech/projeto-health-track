package br.com.fiap.health.services;

import java.util.Date;

public class ExerciciosDiarios {
    public int stepCount;
    public Date saveTime;

    /**
     * Construtor para salvar os atributos da Etapa em um objeto salvo
     * @param stepCount
     */
    public ExerciciosDiarios(int stepCount) {
        this.stepCount = stepCount;
        this.saveTime = new Date();
    }

    /**
     * Retorna a contagem de etapas deste objeto de Etapa salvo
     * @return
     */
    public int stepCount() {
        return stepCount;
    }

    /**
     * Retorna a data que o objeto foi salvo
     * @return
     */
    public Date stepDate() {
        return saveTime;
    }
}
