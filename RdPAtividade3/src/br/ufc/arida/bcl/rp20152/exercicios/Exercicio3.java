package br.ufc.arida.bcl.rp20152.exercicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.special.Gamma;

import br.ufc.arida.bcl.rp20152.grafico.Grafico;
import br.ufc.arida.bcl.rp20152.grafico.PontoDoGrafico;

public class Exercicio3 {

	public static void main(String[] args) {
		
		/*
		 * Exercicio 3
		 */
		System.out.println("\nExercício 3)\n");
		
		
		
		/*
		 * ************ 3.1) ***************************************
		 */
		System.out.println("\n3.1)---------------------------------------");
		graficoStudent(0.01, "Exercicio 3.1 - v = 0.01");
		System.out.println("Realizado o plot na tela com GUI");
		
		/*
		 * ************ 3.2) ***************************************
		 */
		System.out.println("\n3.2)---------------------------------------");
		graficoStudent(0.1, "Exercicio 3.2 - v = 0.1");
		System.out.println("Realizado o plot na tela com GUI");
		
		/*
		 * ************ 3.3) ***************************************
		 */
		System.out.println("\n3.3)---------------------------------------");
		graficoStudent(1, "Exercicio 3.3 - v = 1");
		System.out.println("Realizado o plot na tela com GUI");
		
		/*
		 * ************ 3.4) ***************************************
		 */
		System.out.println("\n3.4)---------------------------------------");
		graficoStudent(10, "Exercicio 3.4 - v = 10");
		System.out.println("Realizado o plot na tela com GUI");
		
		/*
		 * ************ 3.5) ***************************************
		 */
		System.out.println("\n3.5)---------------------------------------");
		graficoStudent(100, "Exercicio 3.5 - v = 100");
		System.out.println("Realizado o plot na tela com GUI");
		
		/*
		 * ************ 3.6) ***************************************
		 */
		System.out.println("\n3.6)---------------------------------------");
		System.out.println("A curva vai se abrindo e se aproximando cada vez mais da curva normal.");
	}

	public static void graficoStudent(double v, String exercicio) {
		double u = 1.0;
		double y = 2.0;
		
		List<PontoDoGrafico> listaDePontos = new ArrayList<PontoDoGrafico>();
		double x = -10;
		for (int i = 0; i < 1000 ; i++) {
			PontoDoGrafico p = new PontoDoGrafico(x, funcaoStudent(x, u, y, v));
			listaDePontos.add(p);
			System.out.println(p);
			x += 0.02;
		}
		Grafico g = new Grafico("Lista 3", exercicio);
		g.adicionarSerie(listaDePontos, "v = " + v);
		g.exibirGrafico();
	}
	
	public static double funcaoStudent(double x, double u, double y, double v) {
		double a = (Gamma.gamma(v/2.0 + 0.5)) / Gamma.gamma(v/2.0);
		double c = Math.pow((y / (Math.PI * v)),(0.5));
		double d = 1.0 + ((y * Math.pow((x - u),2.0)) / v);
		double e = (-v/2.0) - (0.5);
		double f = Math.pow(d, e);
		
		return a * c * f;
	}
	
}
