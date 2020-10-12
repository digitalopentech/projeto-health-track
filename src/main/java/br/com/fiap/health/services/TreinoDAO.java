package br.com.fiap.health.services;

import java.util.ArrayList;
import java.util.List;

public class TreinoDAO implements Dao<Treino> {
    
    private List<Treino> treinos = new ArrayList<Treino>();
    private int tamanhoLista = 10;
    
	@Override
	public List<Treino> getAll() {
	
		for(int i = 1; i <= tamanhoLista; i++) {
	        Treino treino = new Treino();
	        
	        treino.start();
	        treinos.add(treino);
		}
        
		return treinos;
	}
}
