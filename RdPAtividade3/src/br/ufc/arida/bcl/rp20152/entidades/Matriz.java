package br.ufc.arida.bcl.rp20152.entidades;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

@SuppressWarnings("serial")
public class Matriz extends Array2DRowRealMatrix {

	public Matriz(double[][] dados) {
		super(dados);
	}
	
	public Matriz(RealMatrix matrix) {
		super(matrix.getData());
	}
	
	public Matriz(int dimensaoDeLinhas, int dimensaoDeColunas) {
		super(dimensaoDeLinhas, dimensaoDeColunas);
	}
	
	public RealVector getDiagonalVector() {
		if (isSquare()) {
			RealVector vetorDiagonal = new ArrayRealVector(getRowDimension());
			for (int i = 0; i < getRowDimension(); i++) {
				vetorDiagonal.setEntry(i, getEntry(i, i));
			}
			return vetorDiagonal;
		}
		return null;
	}
	
	public String toString() {
		String texto = "";
		int maiortamanho = getMaiorQuantidadeDeDigitos();
		
		for (int i = 0; i < getRowDimension(); i++) {
			String linha = "[";
			for (int j = 0; j < (getColumnDimension()); j++) {
				int tamanhoDoElemento = ((Double)getEntry(i, j)).toString().length();
				int diferenca = maiortamanho - tamanhoDoElemento;
				String elemento = ((Double)getEntry(i, j)).toString();
				
				if (j == getColumnDimension() - 1) {
					linha += adicionarEspacos(elemento, diferenca) + "]\n";
				} else {
					linha += adicionarEspacos(elemento, diferenca) + "; ";
				}
			}
			texto += linha;
		}
		
		return texto;

	}
	
	private String adicionarEspacos(String texto, int quantidadeDeEspacos) {
		String novoTexto = texto;
		for (int i = 0; i < quantidadeDeEspacos; i++) {
			novoTexto += " ";
		}
		return novoTexto;
	}
	
	/**
	 * Metodo auxiliar para formatacao de saída da matriz.
	 * Recupera a quantidade de digitos do elemento da matriz com a
	 * maior quantidade de dígitos.
	 * @return a quantidade de dígitos do elemento com mais dígitos
	 * nam matriz.
	 */
	private int getMaiorQuantidadeDeDigitos() {
		int maior = 0;
		for (int i = 0; i < getRowDimension(); i++) {
			for (int j = 0; j < getColumnDimension(); j++) {
				int tamanhoTemp = ((Double)getEntry(i, j)).toString().length();
				if (tamanhoTemp > maior) {
					maior = tamanhoTemp;
				}
			}
		}
		return maior;
	}
	
}
