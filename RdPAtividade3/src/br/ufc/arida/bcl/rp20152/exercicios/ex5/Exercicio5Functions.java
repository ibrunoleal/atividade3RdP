package br.ufc.arida.bcl.rp20152.exercicios.ex5;

import java.util.ArrayList;
import java.util.List;

import br.ufc.arida.bcl.rp20152.grafico.PontoDoGrafico;

public class Exercicio5Functions {

	public double funcaoKx(double x) {
		if (Math.abs(x) <= 0.5) {
			return 1.0;
		} else {
			return 0.0;
		}
	}
	
	public double funcaoParzelKernelPx(double x, int N, double h, List<Double> data) {	
		double sum = 0;
		for (int i = 0; i < N; i++) {
			double atemp = (x - data.get(i))/h;
			double a = funcaoKx(atemp);
			double b = (1.0 / h) * a;
			sum += b;
		}
		
		double px = (1.0/N) * sum;
		return px;
	}
	
	public List<PontoDoGrafico> getListaDePontosDoGraficoParzelPx(double h, List<Double> data, double minIntervalo, double maxIntervalo, int quantidadeDePontos) {
		double intervaloTotal = maxIntervalo - minIntervalo;
		double tamanhoDeCadaIntervalo = intervaloTotal / quantidadeDePontos;
		
		double xTemp = minIntervalo;
		List<PontoDoGrafico> listaDePontos = new ArrayList<PontoDoGrafico>();
		for (int i = 0; i < quantidadeDePontos; i++) {
			double x = xTemp;
			double resultado = funcaoParzelKernelPx(x, data.size(), h, data);
			PontoDoGrafico ponto = new PontoDoGrafico(x, resultado);
			listaDePontos.add(ponto);
			xTemp += tamanhoDeCadaIntervalo;
		}
		
		return listaDePontos;
	}
	
	
	public double funcaoGaussianKernelPx(double x, int N, double h, List<Double> data) {
		double sum = 0;
		for (int i = 0; i < N; i++) {
			double a = -( Math.pow((x - data.get(i)) , 2.0) / (2.0 * Math.pow(h, 2.0) ) );
			double b = Math.exp(a);
			double c = 1.0 / (h * Math.sqrt(2 * Math.PI) );
			sum += (c * b);
		}
		return sum;
	}
	
	public List<PontoDoGrafico> getListaDePontosDoGraficoGaussianPx(double h, List<Double> data, double minIntervalo, double maxIntervalo, int quantidadeDePontos) {
		double intervaloTotal = maxIntervalo - minIntervalo;
		double tamanhoDeCadaIntervalo = intervaloTotal / quantidadeDePontos;
		
		double xTemp = minIntervalo;
		List<PontoDoGrafico> listaDePontos = new ArrayList<PontoDoGrafico>();
		for (int i = 0; i < quantidadeDePontos; i++) {
			double x = xTemp;
			double resultado = funcaoGaussianKernelPx(x, data.size(), h, data);
			PontoDoGrafico ponto = new PontoDoGrafico(x, resultado);
			listaDePontos.add(ponto);
			xTemp += tamanhoDeCadaIntervalo;
		}
		
		return listaDePontos;
	}

}
