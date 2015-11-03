package br.ufc.arida.bcl.rp20152.exercicios.ex6;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.entidades.Matriz;

public class Exercicio6Functions {
	
	private Matriz matrizDataCLearningInput;
	
	private double[] vetorDataCLearningOutput;
	
	private Matriz matrizDataCValidationInput;
	
	private double[] vetorDataCValidationOutput;
	
	public Exercicio6Functions() {
		FileHandler fileHandlerDataCInput = new FileHandler("dataC_input.csv", ",");
		matrizDataCLearningInput = fileHandlerDataCInput.getMatriz();
		
		FileHandler fileHandlerDataCOutput = new FileHandler("dataC_output.csv", ";");
		vetorDataCLearningOutput = fileHandlerDataCOutput.getVetor(0);
		
		FileHandler fileHandlerDataCValidationInput = new FileHandler("dataC_validation_input.csv", ";");
		matrizDataCValidationInput = fileHandlerDataCValidationInput.getMatriz();
		
		FileHandler fileHandlerDataCValidationOutput = new FileHandler("dataC_validation_output.csv", ";");
		vetorDataCValidationOutput = fileHandlerDataCValidationOutput.getVetor(0);
	}
	
	public double phi(int x, int j) {
		if (j == 0) {
			return 1;
		} else {
			return matrizDataCLearningInput.getEntry(x, j-1);
		}
	}
	
	
	public RealVector wML(Matriz PHI, RealVector t) {
		Matriz PHI_t = new Matriz(PHI.transpose());
		Matriz A = new Matriz(PHI_t.multiply(PHI));
		Matriz A_I = new Matriz(MatrixUtils.inverse(A));
		Matriz B = new Matriz(A_I.multiply(PHI_t));
		RealVector r = B.operate(t);
		return r;
	}
	
	public double yPred(RealVector x, RealVector w) {
		RealMatrix wm = new Array2DRowRealMatrix(w.toArray());
		RealMatrix wt = wm.transpose();
		return wt.operate(x).getEntry(0);
	}
	
	public double MSE(RealVector x, RealVector y) {
		double sum = 0;
		for (int i = 0; i < x.getDimension(); i++) {
			double xi = x.getEntry(i);
			double yi = y.getEntry(i);
			double r = Math.pow((xi-yi), 2);
			sum += r;
		}
		double n = x.getDimension();
		return sum/n;
	}

	public Matriz getMatrizDataCLearningInput() {
		return matrizDataCLearningInput;
	}

	public double[] getVetorDataCLearningOutput() {
		return vetorDataCLearningOutput;
	}

	public Matriz getMatrizDataCValidationInput() {
		return matrizDataCValidationInput;
	}

	public double[] getVetorDataCValidationOutput() {
		return vetorDataCValidationOutput;
	}
	
	
}
