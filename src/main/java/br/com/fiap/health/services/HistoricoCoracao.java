package br.com.fiap.health.services;

import java.util.ArrayList;

/**
 * Classe que representa o hist�ria de frequ�ncia cardiaca
 * @author Grupo FIAP
 *
 */
public class HistoricoCoracao {
    private ArrayList<FrequenciaCardiaca> frequenciasCardiacasList = new ArrayList<>();
    public Coracao heartMonitor = new Coracao();
    private static HistoricoCoracao instance = null;

    protected HistoricoCoracao() {

    }

    public static HistoricoCoracao getInstance() {
        if(instance == null) {
            instance = new HistoricoCoracao();
        }
        return instance;
    }

    /**
     * Adiciona uma frequ�ncia card�aca ao hist�rico
     * @param heartRate
     */
    public void addFrequenciaCradiaca(FrequenciaCardiaca frequenciaCardiaca) {
    	frequenciasCardiacasList.add(frequenciaCardiaca);
    }

    /**
     * Retorna uma frequencia cardiaca do hist�rico
     * @param index
     * @return
     */
    public FrequenciaCardiaca getFrequenciaCradiaca(int index) {
        return frequenciasCardiacasList.get(index);
    }

    /**
     * Retorna o total de frequencias cardiacas realizadas
     * @return
     */
    public int historicoTotal() {
        return frequenciasCardiacasList.size();
    }
}
