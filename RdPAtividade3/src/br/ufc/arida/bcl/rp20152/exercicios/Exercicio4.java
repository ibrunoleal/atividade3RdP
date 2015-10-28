package br.ufc.arida.bcl.rp20152.exercicios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.math3.distribution.NormalDistribution;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.grafico.Grafico;
import br.ufc.arida.bcl.rp20152.grafico.GraficoDeHistograma;
import br.ufc.arida.bcl.rp20152.grafico.PontoDoGrafico;

public class Exercicio4 {

	public static void main(String[] args) {
		
		/*
		 * Carregamento dos dados de entrada para a lista
		 */
		FileHandler fileHandler = new FileHandler("dataB.csv", ";");
		List<Double> listaDeValores = fileHandler.getVetor();
		
		GraficoDeHistograma gh = new GraficoDeHistograma("Exercicio 4", "Histograma do Exercicio 4", 80);
		gh.adicionarSerie(listaDeValores);
		//gh.exibirGrafico();
		
		List<PontoDoGrafico> listaDePontos = new ArrayList<PontoDoGrafico>();
		double[] medias = {-8.0,16.5,50.0};
		double[] pis = {0.4,0.33,0.27};
		double desvioPadrao = 3.84;
		double qtdDePontos = 1000;
		double minIntervalo = -20.0;
		double maxIntervalo = 60.0;
		double intervaloTotal = maxIntervalo - minIntervalo;
		double tamanhoDeCadaIntervalo = intervaloTotal / qtdDePontos;
		double xTemp = minIntervalo;
		
		for (int i = 0; i < qtdDePontos; i++) {
			double x = xTemp;
			double resultado = (pX(x, pis, medias, desvioPadrao));
			PontoDoGrafico ponto = new PontoDoGrafico(x, resultado);
			listaDePontos.add(ponto);
			xTemp += tamanhoDeCadaIntervalo;
		}
		
		Grafico g = new Grafico("Exercicio 4", "Exercicio 4");
		g.adicionarSerie(listaDePontos, "p(x)");
		g.exibirGraficoComOverlay(gh.getDataSet());
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
