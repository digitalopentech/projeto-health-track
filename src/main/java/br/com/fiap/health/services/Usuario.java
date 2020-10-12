package br.com.fiap.health.services;

import java.util.Date;

/**
 * Classe que representa um usuario
 * @author
 *
 */
public class Usuario {
	
    protected Date aniversario;
    private int peso;
    private int altura;
    private String genero;
    private static Usuario instance;
    
    private double valor;
    
    public Usuario()
    {
    }
    
    public Usuario(Date aniversario, int peso, int altura) {
    	this.aniversario = aniversario;
    	this.peso = peso;
    	this.altura = altura;
    }
    
    public static Usuario getInstance() {
        if(instance == null) {
            instance = new Usuario();
        }
        return instance;
    }

    public void addBirthday(Date birthday) {
        this.aniversario = birthday;
    }

    public void addHeightWeight(int height, int weight) {
        this.peso = height;
        this.altura = weight;
    }

    public void addGender(String gender) {
        this.genero = gender;
    }

    public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static void setInstance(Usuario instance) {
		Usuario.instance = instance;
	}

	public boolean beingSetup() {
        return false;
    }
}
