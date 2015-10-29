package br.ufc.arida.bcl.rp20152.exercicios.ex5;

import java.util.List;

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
		List<PontoDoGrafico> listaDePontos51 = funcoes.getListaDePontosGraficoPx(h51, dataB, min, max, 1000);
		
		Grafico g51 = new Grafico("Exercicio 5.1", "Exercício 5.1.: h = 0.1");
		g51.adicionarSerie(listaDePontos51, "p(x) com h=0.1");
		g51.exibirGrafico();
		
		/*
		 * ************ 5.2) ***************************************
		 */
		System.out.println("\n5.2) h=0.5---------------------------------------");
		
		double h52 = 0.5;
		List<PontoDoGrafico> listaDePontos52 = funcoes.getListaDePontosGraficoPx(h52, dataB, min, max, 1000);
		
		Grafico g52 = new Grafico("Exercicio 5.2", "Exercício 5.2.: h = 0.5");
		g52.adicionarSerie(listaDePontos52, "p(x) com h=0.5");
		g52.exibirGrafico();
		
		/*
		 * ************ 5.3) ***************************************
		 */
		System.out.println("\n5.3) h=1.0---------------------------------------");
		
		double h53 = 1.0;
		List<PontoDoGrafico> listaDePontos53 = funcoes.getListaDePontosGraficoPx(h53, dataB, min, max, 1000);
		
		Grafico g53 = new Grafico("Exercicio 5.3", "Exercício 5.3.: h = 1.0");
		g53.adicionarSerie(listaDePontos53, "p(x) com h=1.0");
		g53.exibirGrafico();
		
		/*
		 * ************ 5.4) ***************************************
		 */
		System.out.println("\n5.4) h=2.0---------------------------------------");
		
		double h54 = 2.0;
		List<PontoDoGrafico> listaDePontos54 = funcoes.getListaDePontosGraficoPx(h54, dataB, min, max, 1000);
		
		Grafico g54 = new Grafico("Exercicio 5.4", "Exercício 5.4.: h = 2.0");
		g54.adicionarSerie(listaDePontos54, "p(x) com h=2.0");
		g54.exibirGrafico();
		
	}
	
}
