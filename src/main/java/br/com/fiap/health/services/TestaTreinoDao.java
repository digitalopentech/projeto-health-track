package br.com.fiap.health.services;

import java.util.List;

public class TestaTreinoDao {

	public static void main(String[] args) {
		
		TreinoDAO listaTreinos = new TreinoDAO();
		
		List<Treino> treinos = listaTreinos.getAll();
		
		int x = 0;
		System.out.println("***************** In�cio Treinos ***************** ");
		
		for (Treino treino : treinos) {
			x++;
			
			System.out.println("Treino " + x + " -> Iniciado");
			treino.start();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			treino.stop();
			
			System.out.println("Treino " + x + " -> Finalizado");
		}
		
		System.out.println("***************** Fim Treinos ***************** ");

	}

}
