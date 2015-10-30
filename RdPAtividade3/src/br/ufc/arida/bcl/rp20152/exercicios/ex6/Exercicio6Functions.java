package br.ufc.arida.bcl.rp20152.exercicios.ex6;

import java.util.List;


import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;

public class Exercicio6Functions {
	
	private FileHandler fileHandler;
	
	private List<Double> dataCV1;
	
	private List<Double> dataCV2;
	
	public Exercicio6Functions() {
		fileHandler = new FileHandler("dataC_input.csv", ",");
		dataCV1 = fileHandler.getVetor(0);
		dataCV2 = fileHandler.getVetor(1);
	}

	
}
