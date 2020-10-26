package br.com.fiap.health.model;

/**
 * Classe que representa o Login do Usu�rio
 * @author Grupo FIAP
 *
 */
public class Login extends Usuario {
	
	public String username;
    private String password;
    private static Login instance;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    protected Login()
    {
    }
    
    public void addLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login getInstance() {
        if(instance == null) {
            instance = new Login();
        }
        return instance;
    }


}
