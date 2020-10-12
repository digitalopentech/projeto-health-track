package br.com.fiap.health.services;

import java.util.Random;

/**
 * Classe que representa uma atividade de exerc�cio sendo monitorada por um Sensor
 * Toda atividade possui um sensor
 * @author grupo FIAP
 *
 */
public class Atividade implements Sensores<Integer> {
    //Variavel que informa se o sensor est� ativo
    public boolean isReading = false;
    //Simula a velocidade do exerc�cio
    private Random velocidade = null;

    public Atividade() {
        velocidade = new Random();
    }

    //Inicializa o Sensor
    @Override
    public void start() {
        isReading = true;
        System.out.println("Iniciando atividade");
    }

    //Para o Sensor
    @Override
    public void stop() {
        isReading = false;
    }

    //Retorna o valor da velocidade do Sensor
    @Override
    public Integer read() {
        int valor = velocidade.nextInt(2000);
        return valor;
    }
}