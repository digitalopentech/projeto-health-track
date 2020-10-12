package br.com.fiap.health.services;

import java.util.ArrayList;

public class PassosHistorySingleton {
    private ArrayList<ExerciciosDiarios> stepCounts = new ArrayList<ExerciciosDiarios>();
    public Passos stepCounter = new Passos();
    private static PassosHistorySingleton instance = null;

    protected PassosHistorySingleton() {
    }

    public static PassosHistorySingleton getInstance() {
        if(instance == null) {
            instance = new PassosHistorySingleton();
        }
        return instance;
    }
    /**
     * Adds a DailySteps object to history list
     * @param dailyCount
     */
    public void addDailyCount(ExerciciosDiarios dailyCount) {
        stepCounts.add(dailyCount);
    }

    /**
     * Get daily step count from a saved index
     * @param index
     * @return
     */
    public ExerciciosDiarios getDailyCount(int index) {
        return stepCounts.get(index);
    }

    public int historySize() {
        return stepCounts.size();
    }
}
