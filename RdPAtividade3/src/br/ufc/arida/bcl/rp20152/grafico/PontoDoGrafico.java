package br.ufc.arida.bcl.rp20152.grafico;



public class PontoDoGrafico {

	private double x;
	
	private double y;
	
	public PontoDoGrafico(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
