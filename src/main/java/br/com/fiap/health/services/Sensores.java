package br.com.fiap.health.services;

/**
 * Interface que implenta a simula��o de um Sensor de atividades
 * @author Grupo FIA
 *
 * @param <Type>
 */
public interface Sensores<Type> {

    boolean isReading = false;

    public void start();

    public void stop();

    public Type read();
}