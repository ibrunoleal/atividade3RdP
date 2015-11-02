package br.ufc.arida.bcl.rp20152.exercicios.ex6;


import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.entidades.Matriz;

public class Exercicio6Functions {
	
	private FileHandler fileHandler;
	
	private Matriz matrizDataCInput;
	
	public Exercicio6Functions() {
		fileHandler = new FileHandler("dataC_input.csv", ",");
		matrizDataCInput = fileHandler.getMatriz();
	}
	
	public double phi(int x, int j) {
		if (j == 0) {
			return 1;
		} else {
			return matrizDataCInput.getEntry(x, j-1);
		}
	}

	public Matriz getMatrizDataCInput() {
		return matrizDataCInput;
	}

	
}
