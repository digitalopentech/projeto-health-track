package br.com.fiap.health.model;

import java.util.Date;

/**
 * Classe de Configura��o
 * @author digit
 *
 */
public class Configuracao {
    private UsuarioDevice companionDevice;
    private Login deviceUser;
    private static Configuracao instance = null;
    private boolean syncComplete;

    protected Configuracao() {
        companionDevice = new UsuarioDevice();
        deviceUser = deviceUser.getInstance();
        syncComplete = false;
    }

    public static Configuracao getInstance() {
        if(instance == null) {
            instance = new Configuracao();
        }
        return instance;
    }

    /**
     * Verifica se o dispositivo foi conectado com sucesso
     * @return
     */
    public boolean addCompanion() {
        if(companionDevice.connect())
            return true;
        return false;
    }

    /**
     * Simula��o de configura��o de informa��es do usu�rio
     * @param data
     */
    private void parseIncomingData(String data) {
        deviceUser.addLogin("admin", "password");
//        deviceUser.addBirthday(new Date());
//        deviceUser.addGender("male");
//        deviceUser.addHeightWeight(182, 79);
    }

    /**
     * Metodo que Espera 2 segundos e meio para simular a sincroniza��o dos dados do usu�rio
     * @param ourData
     */
    public void syncData(String ourData) {
        syncComplete = false;
        Runnable syncThread = new Runnable() {
            public void run() {
                try {
                    if(!companionDevice.send(ourData)) {
                        System.out.println("Falha na Sincroniza��o dos dados do usu�rio");
                    }

                    Thread.sleep(2500);

                    String recvData = companionDevice.receive();
                    
                    if(recvData == null) {
                        System.out.println("Falha ao receber os dados do usu�rio");
                    }
                    else {
                        syncComplete = true;
                    }

                    parseIncomingData(recvData);
                }
                catch (InterruptedException e) {
                    System.out.println("Erro");
                }
            }
        };

        Thread syncDevice = new Thread(syncThread);
        syncDevice.start();
    }

    /**
     * returns is the sync process completed
     * @return
     */
    public boolean successful() {
        return this.syncComplete;
    }
}
