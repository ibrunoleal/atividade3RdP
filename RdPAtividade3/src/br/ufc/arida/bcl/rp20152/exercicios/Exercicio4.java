package br.ufc.arida.bcl.rp20152.exercicios;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.math3.distribution.NormalDistribution;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.grafico.GraficoDeBarraComOverlay;
import br.ufc.arida.bcl.rp20152.grafico.GraficoDeHistograma;
import br.ufc.arida.bcl.rp20152.grafico.PontoDoGrafico;

public class Exercicio4 {

	public static void main(String[] args) {
		
		/*
		 * Exercicio 4
		 */
		System.out.println("\nExercício 4)\n");
		
		
		/*
		 * Carregamento dos dados de entrada para a lista
		 */
		FileHandler fileHandler = new FileHandler("dataB.csv", ";");
		List<Double> listaDeValores = fileHandler.getVetor();
		int bin = 80;
		
		GraficoDeHistograma gh = new GraficoDeHistograma("Exercicio 4", "Histograma do Exercicio 4", bin);
		gh.adicionarSerie(listaDeValores);
		//gh.exibirGrafico();
		
		double fatorDeNormalizacao = 0;
		for (int i = 0; i < bin; i++) {
			double value = gh.getDataSet().getYValue(0, i);
			fatorDeNormalizacao += value;
		}
		
		List<PontoDoGrafico> pontosNormalizados = new ArrayList<PontoDoGrafico>();
		for (int i = 0; i < bin; i++) {
			double x = gh.getDataSet().getXValue(0, i);
			double valorNormalizado = gh.getDataSet().getYValue(0, i) / fatorDeNormalizacao;
			PontoDoGrafico p = new PontoDoGrafico(x, valorNormalizado);
			pontosNormalizados.add(p);
		}
		
//		GraficoDeBarra gb = new GraficoDeBarra("Histograma Normalizado", pontosNormalizados, "x", "y");
//		gb.exibirGrafico();
		

		/*
		 * valores para o que a questao pede com desvio padrao = 1.
		 * Porem o grafico não fica bem ajustado.
		 */
//		double[] medias = {-15.5,17.0,55.0};
//		double[] pis = {0.225,0.13,0.16};
//		double desvioPadrao = 1.0;
		/*
		 * valores que ficam melhor para ajustar o grafico (no olhometro).
		 */
		double[] medias = {-15.5,14.5,54.5};
		double[] pis = {0.8,0.5,0.57};
		double desvioPadrao = 3.6;
		
		double qtdDePontos = 500;
		double minIntervalo = -20.0;
		double maxIntervalo = 60.0;
		double intervaloTotal = maxIntervalo - minIntervalo;
		double tamanhoDeCadaIntervalo = intervaloTotal / qtdDePontos;
		double xTemp = minIntervalo;
		
		List<PontoDoGrafico> listaDePontos = new ArrayList<PontoDoGrafico>();
		for (int i = 0; i < qtdDePontos; i++) {
			double x = xTemp;
			double resultado = (pX(x, pis, medias, desvioPadrao));
			PontoDoGrafico ponto = new PontoDoGrafico(x, resultado);
			listaDePontos.add(ponto);
			xTemp += tamanhoDeCadaIntervalo;
		}
		
//		Grafico g = new Grafico("Exercicio 4", "Exercicio 4");
//		g.adicionarSerie(listaDePontos, "p(x)");
//		g.exibirGrafico();
		
		GraficoDeBarraComOverlay grafico = new GraficoDeBarraComOverlay("Exercicio 4", pontosNormalizados, listaDePontos, "X", "Y");
		grafico.exibirGrafico();
	}
	
	public static double pX(double x, double[] pis, double[] medias, double desvioPadra) {
		double px = 0;
		for (int i = 0; i < medias.length; i++) {
			px += funcaoDistribuicaoNormalParaX(x, pis[i], medias[i], desvioPadra);
		}
		return px;
	}
	
	public static double funcaoDistribuicaoNormalParaX(double x, double pi, double mean, double desvioPadrao) {
		NormalDistribution nd = new NormalDistribution(mean, desvioPadrao);
		return pi * nd.density(x);
	}

}
