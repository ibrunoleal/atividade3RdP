package br.ufc.arida.bcl.rp20152.exercicios.ex6;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import br.ufc.arida.bcl.rp20152.entidades.Matriz;
import br.ufc.arida.bcl.rp20152.grafico.Grafico;
import br.ufc.arida.bcl.rp20152.grafico.PontoDoGrafico;

public class Exercicio6 {

	public static void main(String[] args) {
		
		Exercicio6Functions f = new Exercicio6Functions();

		Matriz PHI = new Matriz(f.getMatrizDataCLearningInput().getRowDimension(), f.getMatrizDataCLearningInput().getColumnDimension() + 1);
		for (int x = 0; x < f.getMatrizDataCLearningInput().getRowDimension(); x++) {
			for (int j = 0; j < f.getMatrizDataCLearningInput().getColumnDimension() + 1; j++) {
				double elemento = f.phi(x, j);
				PHI.setEntry(x, j, elemento);
			}
		}
		//System.out.println(PHI);
		
		RealVector t = new ArrayRealVector(f.getVetorDataCLearningOutput());
		
		RealVector w = f.wML(PHI, t);
		System.out.println("wML: " + w);
		
		
		Matriz PHI_validation = new Matriz(f.getMatrizDataCValidationInput().getRowDimension(), f.getMatrizDataCValidationInput().getColumnDimension() + 1);
		for (int x = 0; x < f.getMatrizDataCValidationInput().getRowDimension(); x++) {
			for (int j = 0; j < f.getMatrizDataCValidationInput().getColumnDimension() + 1; j++) {
				double elemento = f.phi(x, j);
				PHI_validation.setEntry(x, j, elemento);
			}
		}
		
		RealVector y = new ArrayRealVector(PHI_validation.getRowDimension());
		for (int i = 0; i < PHI_validation.getRowDimension(); i++) {
			RealVector xi = PHI_validation.getRowVector(i);
			double yi = f.yPred(xi, w);
			y.setEntry(i, yi);
		}

		double mse = f.MSE(new ArrayRealVector(f.getVetorDataCValidationOutput()), y);
		System.out.println("MSE: " + mse);
		
		List<PontoDoGrafico> listaDePontos = new ArrayList<PontoDoGrafico>();
		for (int i = 0; i < y.getDimension(); i++) {
			PontoDoGrafico p = new PontoDoGrafico(new ArrayRealVector(f.getVetorDataCValidationOutput()).getEntry(i), y.getEntry(i));
			listaDePontos.add(p);
		}
		Grafico g = new Grafico("Lista 3", "");
		g.adicionarSerie(listaDePontos, "");
		g.exibirGrafico();
	}


}
