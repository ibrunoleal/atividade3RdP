package br.ufc.arida.bcl.rp20152.exercicios.ex6;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.entidades.Matriz;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

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
	
	public double phi2(RealVector x, RealVector u) {
		RealVector vtemp = x.subtract(u);
		double norma2 = Math.pow(vtemp.getNorm(), 2);
		double a = -1 * norma2 / 4.0;
		double e = Math.exp(a);
		return e;
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
	
	public List<RealVector> kMeans(int numeroDeClusters) {
		SimpleKMeans kMeans = new SimpleKMeans();
		List<RealVector> listaDeMeans = new ArrayList<RealVector>();
		try {
			kMeans.setNumClusters(numeroDeClusters);
			Instances instancias = DataSource.read("dataC_input.csv");
			kMeans.buildClusterer(instancias);
			Instances centroids = kMeans.getClusterCentroids();
			for (int i = 0; i < centroids.numInstances(); i++) {
				RealVector means = new ArrayRealVector(centroids.instance(i).numAttributes());
				for (int j = 0; j < centroids.instance(i).numAttributes(); j++) {
					double valor = centroids.instance(i).value(j);
					means.setEntry(j, valor);
				}
				listaDeMeans.add(means);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDeMeans;
	}

	public Matriz getMatrizPHI2(Matriz X, int numBasis) {
		Matriz PHI2 = new Matriz(X.getRowDimension(), numBasis);
		List<RealVector> means = kMeans(numBasis);
		for (int i = 0; i < X.getRowDimension(); i++) {
			RealVector xi = X.getRowVector(i);
			RealVector vetorLinhaPHI2 = new ArrayRealVector(numBasis);
			for (int b = 0; b < numBasis; b++) {
				double valor = phi2(xi, means.get(b));
				vetorLinhaPHI2.setEntry(b, valor);
			}
			PHI2.setRowVector(i, vetorLinhaPHI2);
		}
		
		return PHI2;
	}
	
}
