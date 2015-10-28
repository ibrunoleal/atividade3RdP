package br.ufc.arida.bcl.rp20152.exercicios;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import br.ufc.arida.bcl.rp20152.entidades.Matriz;

public class Exercicio1 {

	public static void main(String[] args) {

		/*
		 * ************ Dados de entrada ***************************************
		 */
		double[] dadosU = { 3, 1, 2 };
		RealVector u = new ArrayRealVector(dadosU);
		
//		System.out.println("Vetor ua: " + ua);
//		System.out.println("Vetor ub: " + ub);
		
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

		Matriz EI = new Matriz(I.scalarMultiply(k));

		Matriz KT = new Matriz(K.transpose());

		Matriz EII = new Matriz(K.multiply(KT));

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
		
		Matriz AIII = new Matriz(MatrixUtils.inverse(EIII).getData());
		Matriz AIIIaa = getParticaoAA(AIII);
		Matriz AIIIab = getParticaoAB(AIII);
		Matriz AIIIba = getParticaoBA(AIII);
		Matriz AIIIbb = getParticaoBB(AIII);
		System.out.println("\nMatriz AIII:\n" + AIII);
		System.out.println("\nMatriz AIIIaa:\n" + AIIIaa);
		System.out.println("\nMatriz AIIIab:\n" + AIIIab);
		System.out.println("\nMatriz AIIIba:\n" + AIIIba);
		System.out.println("\nMatriz AIIIbb:\n" + AIIIbb);
		
		/*
		 * ************ 1.4) ***************************************
		 */
		System.out.println("1.4)---------------------------------------\n");
		Matriz EIa_b = funcaoSigmaDeADadoB(EI);
		System.out.println("\nMatriz EIa_b:\n" + EIa_b);
		
		Matriz EIIa_b = funcaoSigmaDeADadoB(EII);
		System.out.println("\nMatriz EIIa_b:\n" + EIIa_b);
		
		Matriz EIIIa_b = funcaoSigmaDeADadoB(EIII);
		System.out.println("\nMatriz EIIIa_b:\n" + EIIIa_b);
		
		/*
		 * ************ 1.5) ***************************************
		 */
		System.out.println("1.5)---------------------------------------\n");
		RealVector ua = u.getSubVector(0, 2);
		RealVector ub = u.getSubVector(2, 1);
		System.out.println("Vetor u: " + u);
		System.out.println("Vetor ua: " + ua);
		System.out.println("Vetor ub: " + ub);
		
		double[] xaData = {0,0.5};
		RealVector xa = new ArrayRealVector(xaData);
		double[] xbData = {1};
		RealVector xb = new ArrayRealVector(xbData);
		System.out.println("Vetor xa: " + xa);
		System.out.println("Vetor xb: " + xb);
		
		RealVector EIu_a_b = funcaoMiADadoB(EI, ua, ub, xb);
		System.out.println("\nVetor Ua_b para EI:\n" + EIu_a_b);
		
		RealVector EIIu_a_b = funcaoMiADadoB(EII, ua, ub, xb);
		System.out.println("\nVetor Ua_b para EII:\n" + EIIu_a_b);
		
		RealVector EIIIu_a_b = funcaoMiADadoB(EIII, ua, ub, xb);
		System.out.println("\nVetor Ua_b para EIII:\n" + EIIIu_a_b);

		/*
		 * ************ 1.6) ***************************************
		 */
		System.out.println("1.6)---------------------------------------\n");
		
	}

	
	
	
	public static Matriz getParticaoAA(Matriz matriz) {
		Matriz aa = new Matriz(matriz.getSubMatrix(0, 1, 0, 1));
		return aa;
	}

	public static Matriz getParticaoAB(Matriz matriz) {
		Matriz ab = new Matriz(matriz.getSubMatrix(0, 1, 2, 2));
		return ab;
	}

	public static Matriz getParticaoBA(Matriz matriz) {
		Matriz ba = new Matriz(matriz.getSubMatrix(2, 2, 0, 1));
		return ba;
	}

	public static Matriz getParticaoBB(Matriz matriz) {
		Matriz bb = new Matriz(matriz.getSubMatrix(2, 2, 2, 2));
		return bb;
	}
	
	public static Matriz funcaoSigmaDeADadoB(Matriz matriz) {
		Matriz xaa = getParticaoAA(matriz);
		Matriz xab = getParticaoAB(matriz);
		Matriz xbb = new Matriz(MatrixUtils.inverse(getParticaoBB(matriz)));
		Matriz xba = getParticaoBA(matriz);
		
		Matriz resultado = new Matriz(xab.multiply(xbb));
		resultado = new Matriz(resultado.multiply(xba));
		resultado = new Matriz(xaa.subtract(resultado));
		return resultado;
	}
	
	public static RealVector funcaoMiADadoB(Matriz matriz, RealVector ua, RealVector ub, RealVector xb) {
		Matriz mab = getParticaoAB(matriz);
		Matriz mbb = new Matriz(MatrixUtils.inverse(getParticaoBB(matriz)));
		Matriz maux = new Matriz(mab.multiply(mbb));
		RealVector vetoraux = new ArrayRealVector(xb.subtract(ub));
		
		RealVector resultado = maux.operate(vetoraux);
		resultado = ua.subtract(resultado);
		return resultado;
	}

}
