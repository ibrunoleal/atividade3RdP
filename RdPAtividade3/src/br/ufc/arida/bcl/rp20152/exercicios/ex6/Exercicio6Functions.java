package br.ufc.arida.bcl.rp20152.exercicios.ex6;


import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.entidades.Matriz;

public class Exercicio6Functions {
	
	private Matriz matrizDataCInput;
	
	private double[] vetorOutput;
	
	public Exercicio6Functions() {
		FileHandler fileHandlerDataCInput = new FileHandler("dataC_input.csv", ",");
		matrizDataCInput = fileHandlerDataCInput.getMatriz();
		
		FileHandler fileHandlerDataCOutput = new FileHandler("dataC_output.csv", ";");
		vetorOutput = fileHandlerDataCOutput.getVetor(0);
	}
	
	public double phi(int x, int j) {
		if (j == 0) {
			return 1;
		} else {
			return matrizDataCInput.getEntry(x, j-1);
		}
	}
	
	
	public RealVector wML(Matriz PHI, RealVector t) {
		Matriz PHI_t = new Matriz(PHI.transpose());
		Matriz A = new Matriz(PHI_t.multiply(PHI));
		Matriz A_I = new Matriz(MatrixUtils.inverse(A));
		Matriz B = new Matriz(A_I.multiply(PHI_t));
		RealVector r = B.operate(t);
		System.out.println(PHI);
		return r;
	}
	

	public Matriz getMatrizDataCInput() {
		return matrizDataCInput;
	}

	public double[] getVetorOutput() {
		return vetorOutput;
	}

	

	
}
