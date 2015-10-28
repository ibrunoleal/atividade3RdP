package br.ufc.arida.bcl.rp20152.arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	
	/**
	 * nome do arquivo que contem o dataset
	 */
	private String arquivo;
	
	/**
	 * Separador de elementos da linha
	 * obs: o separador entre linhas é a quebra de linha por padrao
	 */
	private String delimitador;
	
	public FileHandler(String arquivo, String delimitador) {
		this.arquivo = arquivo;
		this.delimitador = delimitador;
	}
	
	/**
	 * Contabiliza o numero de linhas contidas no arquivo. Consequentemente o numero de linhas da matriz.
	 * @return o numero de linhas no arquivo.
	 */
	public int getNumeroDeLinhas() {
		FileReader fileReader;
		int numeroDeLinhas = 0;
		
		try {
			fileReader = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fileReader);
			
			String linha = br.readLine();
			while (linha != null) {
				numeroDeLinhas++;
				linha = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return numeroDeLinhas;
	}
	
	/**
	 * Contabiliza o numero de colunas contidas no arquivo a partir do delimitador especificado. 
	 * Consequentemente o numero de colunas da matriz.
	 * @return o numero de colunas do arquivo.
	 */
	public int getNumeroDeColunas() {
		FileReader fileReader;
		int numeroDeColunas = 0;
		
		try {
			fileReader = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fileReader);
			
			String linha = br.readLine();
			if (linha != null) {
				String[] elementos = linha.split(delimitador);
				numeroDeColunas = elementos.length;
			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numeroDeColunas;
	}
	

	public List<Double> getVetor() {
		FileReader fileReader;
		int numeroDeLinhas = getNumeroDeLinhas();
		List<Double> vetor = new ArrayList<Double>();
		
		if (numeroDeLinhas > 0) {
			try {
				fileReader = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fileReader);

				String linha = br.readLine();
				while (linha != null) {
					double valor = Double.parseDouble(linha);
					vetor.add(valor);
					linha = br.readLine();
				}
				br.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return vetor;
	}
	
	
}