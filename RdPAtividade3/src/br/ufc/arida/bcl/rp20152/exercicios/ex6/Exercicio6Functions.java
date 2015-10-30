package br.ufc.arida.bcl.rp20152.exercicios.ex6;

public class Exercicio6Functions {

	public double phi(double[] x, int j) {
		if (x.length == 0) {
			return 1.0;
		} else {
			return x[j-1];
		}
	}
	

}
