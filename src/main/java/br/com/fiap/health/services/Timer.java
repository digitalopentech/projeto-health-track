package br.com.fiap.health.services;

/**
 * Classe que simula o Timer
 * @author digit
 *
 */
public class Timer {
    private boolean timerCounting;
    private int remainingTime;
    private Thread timerThread;
    private static Timer instance = null;

    public int getRemainingTime() {
        return remainingTime;
    }

    public int remainingTimeProperty() {
        return remainingTime;
    }

    public static Timer getInstance() {
        if(instance == null) {
            instance = new Timer();
        }
        return instance;
    }

    /**
     * TimerSingleton constructor
     * Initializes all class variables to zero
     */
    protected Timer() {
        timerCounting = false;
        remainingTime = new Integer(0);
        timerThread = null;
    }

    /**
     * Starts the timer in a thread to run while the UI can continue functioning
     * Increments the seconds down by 1 every 1000 milliseconds
     * @param seconds
     */
    public void startTimer(int seconds) {
        remainingTime = seconds;

        Runnable timerRunnable = new Runnable() {
            public void run() {
                try {
                    while (remainingTime > 0 && timerCounting) {
                        Thread.sleep(1000);
                        remainingTime = remainingTime - 1;
                    }
                }
                catch(InterruptedException e) {
                    remainingTime = 0;
                    timerCounting = false;
                }
                System.out.println("Timer Completo");

            }
        };

        timerCounting = true;
        timerThread = new Thread(timerRunnable);
        timerThread.start();

    }

    /**
     * Can be used to stop the timer before it is finished
     */
    public void stopTimer() {
        timerCounting = false;
        remainingTime = 0;
    }
}
