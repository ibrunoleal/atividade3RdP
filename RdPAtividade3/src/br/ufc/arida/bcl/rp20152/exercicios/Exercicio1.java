package br.ufc.arida.bcl.rp20152.exercicios;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;

import br.ufc.arida.bcl.rp20152.entidades.Matriz;

public class Exercicio1 {

	public static void main(String[] args) {

		/*
		 * ************ Dados de entrada ***************************************
		 */
		double[] dadosU = { 3, 1, 2 };
		ArrayRealVector u = new ArrayRealVector(dadosU);

		double[][] dadosK = { { 0.5, 0.2, 0.1 }, { 0.6, 0.18, 0.4 }, { 0.1, 0.6, 0.2 } };
		Matriz K = new Matriz(dadosK);

		int k = 4;

		// System.out.println("Vetor u: " + u);
		// System.out.println("\nMatriz K:\n" + K);
		// System.out.println("Escalar k: " + k);

		System.out.println("Exercícios 1)\n");

		/*
		 * ************ 1.1) ***************************************
		 */
		System.out.println("1.1)---------------------------------------\n");
		Matriz I = new Matriz(MatrixUtils.createRealIdentityMatrix(K.getRowDimension()).getData());

		Matriz EI = new Matriz(I.scalarMultiply(k).getData());

		Matriz KT = new Matriz(K.transpose().getData());

		Matriz EII = new Matriz(K.multiply(KT).getData());

		Matriz EIII = new Matriz(MatrixUtils.createRealDiagonalMatrix(EII.getDiagonalVector().toArray()).getData());

		// System.out.println("\nMatriz Identidade de K:\n" + I);
		System.out.println("\nMatriz EI:\n" + EI);
		// System.out.println("\nMatriz KT:\n" + KT);
		System.out.println("\nMatriz EII:\n" + EII);
		System.out.println("\nMatriz EIII:\n" + EIII);

		/*
		 * ************ 1.2) ***************************************
		 */
		System.out.println("1.2)---------------------------------------\n");
		Matriz EIaa = getParticaoAA(EI);
		Matriz EIab = getParticaoAB(EI);
		Matriz EIba = getParticaoBA(EI);
		Matriz EIbb = getParticaoBB(EI);
		System.out.println("\nMatriz EIaa:\n" + EIaa);
		System.out.println("\nMatriz EIab:\n" + EIab);
		System.out.println("\nMatriz EIba:\n" + EIba);
		System.out.println("\nMatriz EIbb:\n" + EIbb);

		Matriz EIIaa = getParticaoAA(EII);
		Matriz EIIab = getParticaoAB(EII);
		Matriz EIIba = getParticaoBA(EII);
		Matriz EIIbb = getParticaoBB(EII);
		System.out.println("\nMatriz EIIaa:\n" + EIIaa);
		System.out.println("\nMatriz EIIab:\n" + EIIab);
		System.out.println("\nMatriz EIIba:\n" + EIIba);
		System.out.println("\nMatriz EIIbb:\n" + EIIbb);

		Matriz EIIIaa = getParticaoAA(EIII);
		Matriz EIIIab = getParticaoAB(EIII);
		Matriz EIIIba = getParticaoBA(EIII);
		Matriz EIIIbb = getParticaoBB(EIII);
		System.out.println("\nMatriz EIIIaa:\n" + EIIIaa);
		System.out.println("\nMatriz EIIIab:\n" + EIIIab);
		System.out.println("\nMatriz EIIIba:\n" + EIIIba);
		System.out.println("\nMatriz EIIIbb:\n" + EIIIbb);
		
		/*
		 * ************ 1.3) ***************************************
		 */
		System.out.println("1.3)---------------------------------------\n");
		
		Matriz AI = new Matriz(MatrixUtils.inverse(EI).getData());
		Matriz AIaa = getParticaoAA(AI);
		Matriz AIab = getParticaoAB(AI);
		Matriz AIba = getParticaoBA(AI);
		Matriz AIbb = getParticaoBB(AI);
		System.out.println("\nMatriz AI:\n" + AI);
		System.out.println("\nMatriz AIaa:\n" + AIaa);
		System.out.println("\nMatriz AIab:\n" + AIab);
		System.out.println("\nMatriz AIba:\n" + AIba);
		System.out.println("\nMatriz AIbb:\n" + AIbb);
		
		Matriz AII = new Matriz(MatrixUtils.inverse(EII).getData());
		Matriz AIIaa = getParticaoAA(AII);
		Matriz AIIab = getParticaoAB(AII);
		Matriz AIIba = getParticaoBA(AII);
		Matriz AIIbb = getParticaoBB(AII);
		System.out.println("\nMatriz AII:\n" + AII);
		System.out.println("\nMatriz AIIaa:\n" + AIIaa);
		System.out.println("\nMatriz AIIab:\n" + AIIab);
		System.out.println("\nMatriz AIIba:\n" + AIIba);
		System.out.println("\nMatriz AIIbb:\n" + AIIbb);
		
		/*
		 * ************ 1.4) ***************************************
		 */
		System.out.println("1.4)---------------------------------------\n");
		
		
		
	}

	
	
	
	public static Matriz getParticaoAA(Matriz matriz) {
		Matriz aa = new Matriz(matriz.getSubMatrix(0, 1, 0, 1).getData());
		return aa;
	}

	public static Matriz getParticaoAB(Matriz matriz) {
		Matriz ab = new Matriz(matriz.getSubMatrix(0, 1, 2, 2).getData());
		return ab;
	}

	public static Matriz getParticaoBA(Matriz matriz) {
		Matriz ba = new Matriz(matriz.getSubMatrix(2, 2, 0, 1).getData());
		return ba;
	}

	public static Matriz getParticaoBB(Matriz matriz) {
		Matriz bb = new Matriz(matriz.getSubMatrix(2, 2, 2, 2).getData());
		return bb;
	}

}
