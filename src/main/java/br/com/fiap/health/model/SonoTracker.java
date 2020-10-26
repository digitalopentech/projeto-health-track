package br.com.fiap.health.model;

import java.util.Date;

/**
 * Classe que simula o Acompanhamento do Sono
 * @author digit
 *
 */
public class SonoTracker {
    private static final int sleepSpeed = 1000;

    private boolean sleeping = false;
    private Thread sleepThread;
    private Atividade sensor;
    private Date horaDormir;
    private Date horaAcordar;

    public SonoTracker() {
        sensor = new Atividade();
        horaDormir = null;
        horaAcordar = null;
    }

    /**
     * Reading from sensor to check if sleeping
     * @return
     */
    private boolean checkIfSleeping() {
        if(sensor.isReading) {
            int speed = sensor.read();
            System.out.printf("reading: %d\n", speed);
            if(speed < sleepSpeed)
                return true;
        }
        return false;
    }

    /**
     * Starts the thread to check sleep pattern in the background
     * @return
     */
    public boolean startSleepTracker() {
        if(!sensor.isReading) {
            sensor.start();

            Runnable sleepRunnable = new Runnable() {
                public void run() {
                    try {
                        //small delay to allow UI thread to be ready
                        Thread.sleep(1000);

                        while(!checkIfSleeping() && sensor.isReading) {
                            //check if sleep every 30 seconds
                            Thread.sleep(1000);
                        }

                        if(sensor.isReading) {
                            horaDormir = new Date();
                            sleeping = true;
                        }

                        // Atraso de dez segundos para compensar por n�o haver uma maneira real de detectar o sono
                        // Apenas para fornecer alguns dados para prova de conceito
                        Thread.sleep(10000);

                        while(checkIfSleeping() && sensor.isReading) {
                            //check to see if we are still asleep
                            Thread.sleep(1000);
                        }

                        if(sensor.isReading) {
                            horaAcordar = new Date();
                            sleeping = false;
                        }
                    }
                    catch (InterruptedException e) {
                        sensor.stop();
                    }
                }
            };

            sleepThread = new Thread(sleepRunnable);
            sleepThread.start();
            return true;
        }
        return false;
    }

    /**
     * Force stop sleep tracker
     */
    public void stopSleepTracker() {
        sensor.stop();
    }

    /**
     * reset the sleep tracker to defaults
     */
    public void resetSleepTracker() {
        this.sleeping = false;
        this.horaDormir = null;
        this.horaAcordar = null;
    }

    /**
     * method for UI to check if user is asleep
     * @return
     */
    public boolean isSleeping() {
        return this.sleeping;
    }

    /**
     * returns the time the user fell asleep
     * @return
     */
    public Date getSleepTime() {
        return this.horaDormir;
    }

    /**
     * returns the time the user woke up
     * @return
     */
    public Date getWakeTime() {
        return this.horaAcordar;
    }

    /**
     * Save a nights sleep copy
     * @return
     */
    public Sono salvarNoiteDeSono() {
        return new Sono(horaDormir, horaAcordar);
    }
}
