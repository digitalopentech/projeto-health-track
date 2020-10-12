package br.com.fiap.health.services;

import java.util.Random;

/**
 * Classe que representa o Monitor de Frequ�ncia Card�aca
 * @author Grupo FIAP
 *
 */
public class MonitorFrequenciaCardiaca implements Sensores<Double> {
    public boolean isReading = false;
    private Random rand;

    public MonitorFrequenciaCardiaca() {
        this.rand = new Random();
    }

    @Override
    public void start() {
        isReading = true;
        System.out.println("Iniciando Monitor de frequencia cardiaca");
    }

    @Override
    public void stop() {
        isReading = false;
    }

    @Override
    public Double read() {
        double value = rand.nextDouble() + 0.7; //Simula um valor aleat�rio entre 0.7 and 1.7
        return value;
    }
}
