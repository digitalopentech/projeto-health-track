package br.com.fiap.health.services;

import java.util.ArrayList;

/**
 * Classe que simula o Hist�rico do Sono do Usu�rio
 * @author Grupo FIAP
 *
 */
public class SonoHistorico {
    public ArrayList<Sono> sleepTimes = new ArrayList<>();
    public SonoTracker sleepTracker = new SonoTracker();
    private static SonoHistorico instance = null;

    protected SonoHistorico() {

    }

    public static SonoHistorico getInstance() {
        if(instance == null) {
            instance = new SonoHistorico();
        }
        return instance;
    }
    
    public void addSleepTimes(Sono sleep) {
        sleepTimes.add(sleep);
    }

    public Sono getSleepTimes(int index) {
        return sleepTimes.get(index);
    }

    public int historySize() {
        return sleepTimes.size();
    }
}
