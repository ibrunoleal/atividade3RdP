package br.ufc.arida.bcl.rp20152.exercicios;

import java.util.List;

import br.ufc.arida.bcl.rp20152.arquivos.FileHandler;
import br.ufc.arida.bcl.rp20152.grafico.GraficoDeHistograma;

public class Exercicio4 {

	public static void main(String[] args) {
		
		/*
		 * Carregamento dos dados de entrada para a lista
		 */
		FileHandler fileHandler = new FileHandler("dataB.csv", ";");
		List<Double> listaDeValores = fileHandler.getVetor();
		
		GraficoDeHistograma gh = new GraficoDeHistograma("Exercicio 4", "Histograma do Exercicio 4", 80);
		gh.adicionarSerie(listaDeValores);
		gh.exibirGrafico();

	}

}
