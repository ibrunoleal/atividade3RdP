package br.ufc.arida.bcl.rp20152.exercicios.ex6;

import br.ufc.arida.bcl.rp20152.entidades.Matriz;

public class Exercicio6 {

	public static void main(String[] args) {
		
		Exercicio6Functions f = new Exercicio6Functions();

		Matriz PHI = new Matriz(f.getMatrizDataCInput().getRowDimension(), f.getMatrizDataCInput().getColumnDimension() + 1);
		for (int x = 0; x < f.getMatrizDataCInput().getRowDimension(); x++) {
			for (int j = 0; j < f.getMatrizDataCInput().getColumnDimension() + 1; j++) {
				double elemento = f.phi(x, j);
				PHI.setEntry(x, j, elemento);
			}
		}
		//System.out.println(PHI);
		
	}

}
