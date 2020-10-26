package br.com.fiap.health.model;

public class UsuarioDevice {
    private boolean connected;

    /**
     * Disconecta o Device do Usuario
     * @return
     */
    public boolean disconnect() {
        connected = false;
        return true;
    }

    /**
     * Envia os dados do usuario para o device
     * @param data
     * @return
     */
    public boolean send(String data) {
        if(!connected)
            return false;

        return true;
    }

    /**
     * Recebe dados do device
     * @return
     */
    public String receive() {
        if(!connected)
            return null;

        return "Dados Sincronizados";
    }

    /**
     * Conecta ao device do usuario
     * @return
     */
    public boolean connect() {
        connected = true;
        return true;
    }
}
