package br.com.fiap.health.model;

/**
 * 
 * @author Grupo Fiap
 *
 */
public class Coracao {
    private Thread heartThread = null;
    private MonitorFrequenciaCardiaca heart = null;
    private int secondsPassed;
    private double heartTotal;
    private Double bpm;

    public Double getBpm() {
        return this.bpm;
    }


    @SuppressWarnings("deprecation")
	public Coracao() {
        bpm = new Double(0.0);
        heart = new MonitorFrequenciaCardiaca();
        secondsPassed = 0;
        heartTotal = 0.0;
    }

    /**
     * Thread to read our current heart rate
     * Every second it reads a value from the Heart Monitor
     * This value will be used to calculate out bpm
     * @return
     */
    public boolean startHeart() {
        if(!heart.isReading) {
            heart.start();

            Runnable heartRunnabe = new Runnable() {
                public void run() {
                    try {
                        while(heart.isReading) {
                            //Simula uma freq��ncia card�aca entre 0,7 e 1,7, portanto, ap�s 60 segundos, teremos um bpm entre 42 e 102 (a freq��ncia card�aca m�dia em humanos est� entre 40 e 100
                            double rate = heart.read();
                            heartTotal = heartTotal + rate;
                            secondsPassed++;

                            //Atualiza valor do BPM
                            bpm = (heartTotal / secondsPassed) * 60;

                            Thread.sleep(1000);
                        }
                    }
                    catch (InterruptedException e) {
                        heart.stop();
                    }
                }
            };

            heartThread = new Thread(heartRunnabe);
            heartThread.start();
            return true;
        }
        return false;
    }

    /**
     * Stops the heart monitor
     */
    public void stopHeart() {
        heart.stop();
    }

    /**
     * Resets the values of the heart object
     */
    public void resetHeart() {
        bpm = 0.0;
        heartTotal = 0.0;
        secondsPassed = 0;
    }

    /**
     * Creates a copy of our heart rate and returns it
     * @return
     */
    public FrequenciaCardiaca saveHeartRate() {
        return new FrequenciaCardiaca(bpm);
    }
}
