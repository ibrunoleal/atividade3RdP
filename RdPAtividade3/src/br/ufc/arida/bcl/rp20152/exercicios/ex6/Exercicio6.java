package br.ufc.arida.bcl.rp20152.exercicios.ex6;

import java.util.List;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;

public class Exercicio6 {

	public static void main(String[] args) {
		
		FileHandler fileHandler = new FileHandler("dataC_input.csv", ",");
		List<Double> dataCV1 = fileHandler.getVetor(0);
		List<Double> dataCV2 = fileHandler.getVetor(1);

		
	}

}
