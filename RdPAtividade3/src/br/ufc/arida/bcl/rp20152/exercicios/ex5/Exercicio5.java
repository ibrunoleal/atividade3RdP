package br.ufc.arida.bcl.rp20152.exercicios.ex5;

import java.util.List;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.grafico.Grafico;
import br.ufc.arida.bcl.rp20152.grafico.PontoDoGrafico;

public class Exercicio5 {

	public static void main(String[] args) {
		
		/*
		 * Exercicio 5
		 */
		System.out.println("\nExercício 5)\n");
		
		
		FileHandler fileHandler = new FileHandler("dataB.csv", ";");
		List<Double> dataB = fileHandler.getVetor();
		
		double min = -20.0;
		double max = 60.0;
		
		Exercicio5Functions funcoes = new Exercicio5Functions();
		
		/*
		 * ************ 5.1) ***************************************
		 */
		System.out.println("\n5.1) h=0.1---------------------------------------");
		
		double h51 = 0.1;
		
		List<PontoDoGrafico> listaDePontos51a = funcoes.getListaDePontosDoGraficoParzelPx(h51, dataB, min, max, 1000);
		Grafico g51a = new Grafico("Exercicio 5.1", "Exercício 5.1.: Parzel Window kernel # h = 0.1");
		g51a.adicionarSerie(listaDePontos51a, "p(x) com h=0.1");
		g51a.exibirGrafico();
		
		List<PontoDoGrafico> listaDePontos51b = funcoes.getListaDePontosDoGraficoGaussianPx(h51, dataB, min, max, 1000);
		Grafico g51b = new Grafico("Exercicio 5.1", "Exercício 5.1.: Gaussian kernel # h = 0.1");
		g51b.adicionarSerie(listaDePontos51b, "p(x) com h=0.1");
		g51b.exibirGrafico();
		
		/*
		 * ************ 5.2) ***************************************
		 */
		System.out.println("\n5.2) h=0.5---------------------------------------");
		
		double h52 = 0.5;
		
		List<PontoDoGrafico> listaDePontos52a = funcoes.getListaDePontosDoGraficoParzelPx(h52, dataB, min, max, 1000);
		Grafico g52a = new Grafico("Exercicio 5.2", "Exercício 5.2.: Parzel Window kernel # h = 0.5");
		g52a.adicionarSerie(listaDePontos52a, "p(x) com h=0.5");
		g52a.exibirGrafico();
		
		List<PontoDoGrafico> listaDePontos52b = funcoes.getListaDePontosDoGraficoGaussianPx(h52, dataB, min, max, 1000);
		Grafico g52b = new Grafico("Exercicio 5.2", "Exercício 5.2.: Gaussian kernel # h = 0.5");
		g52b.adicionarSerie(listaDePontos52b, "p(x) com h=0.5");
		g52b.exibirGrafico();
		
		/*
		 * ************ 5.3) ***************************************
		 */
		System.out.println("\n5.3) h=1.0---------------------------------------");
		
		double h53 = 1.0;
		
		List<PontoDoGrafico> listaDePontos53a = funcoes.getListaDePontosDoGraficoParzelPx(h53, dataB, min, max, 1000);
		Grafico g53a = new Grafico("Exercicio 5.3", "Exercício 5.3.: Parzel Window kernel # h = 1.0");
		g53a.adicionarSerie(listaDePontos53a, "p(x) com h=1.0");
		g53a.exibirGrafico();
		
		List<PontoDoGrafico> listaDePontos53b = funcoes.getListaDePontosDoGraficoGaussianPx(h53, dataB, min, max, 1000);
		Grafico g53b = new Grafico("Exercicio 5.3", "Exercício 5.3.: Gaussian kernel # h = 1.0");
		g53b.adicionarSerie(listaDePontos53b, "p(x) com h=1.0");
		g53b.exibirGrafico();
		
		/*
		 * ************ 5.4) ***************************************
		 */
		System.out.println("\n5.4) h=2.0---------------------------------------");
		
		double h54 = 2.0;
		
		List<PontoDoGrafico> listaDePontos54a = funcoes.getListaDePontosDoGraficoParzelPx(h54, dataB, min, max, 1000);
		Grafico g54a = new Grafico("Exercicio 5.4", "Exercício 5.4.: Parzel Window kernel # h = 2.0");
		g54a.adicionarSerie(listaDePontos54a, "p(x) com h=2.0");
		g54a.exibirGrafico();
		
		List<PontoDoGrafico> listaDePontos54b = funcoes.getListaDePontosDoGraficoGaussianPx(h54, dataB, min, max, 1000);
		Grafico g54b = new Grafico("Exercicio 5.4", "Exercício 5.4.: Gaussian kernel # h = 2.0");
		g54b.adicionarSerie(listaDePontos54b, "p(x) com h=2.0");
		g54b.exibirGrafico();
		
	}
	
}
