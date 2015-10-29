package br.ufc.arida.bcl.rp20152.grafico;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

@SuppressWarnings("serial")
public class GraficoDeHistograma extends ApplicationFrame {
	
	private JFreeChart chart;
	
	private HistogramDataset dataSet;
	
	private List<Double> series;
	
	private String tituloDoGrafico;
	
	private int bin;
	
	public GraficoDeHistograma(String tituloDaAplicacao, String tituloDoGrafico, int bin) {
		super(tituloDaAplicacao);
		this.tituloDoGrafico = tituloDoGrafico;
		series = new ArrayList<Double>();
		this.bin = bin;
	}

	public void construirParaExibicao() {
		
		chart = createChart("x", "y");
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public void adicionarSerie(List<Double> valores) {
		series.addAll(valores);
		createDataset();
	}
	
	private void createDataset() {
		dataSet = new HistogramDataset();
		double[] vetorDeDados = new double[series.size()];
		for (int i = 0; i < vetorDeDados.length; i++) {
			double d = series.get(i);
			vetorDeDados[i] = d;
		}
		dataSet.addSeries("Histograma", vetorDeDados, bin);
	}
	
	private JFreeChart createChart(String labelX, String labelY) {
		
		JFreeChart chart = ChartFactory.createHistogram(tituloDoGrafico,// chart title
				labelX, // x axis label
				labelY, // y axis label
				dataSet, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
		);
		
		XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.gray);
        plot.setRangeGridlinePaint(Color.gray);
		
		/*
		 * Inserir customizacao do grafico aqui
		 */
		
		return chart;
	}
	
	

	public HistogramDataset getDataSet() {
		return dataSet;
	}

	/**
	 * Exibe o grafico na tela em uma janela de aplicacao
	 */
	public void exibirGrafico() {
		construirParaExibicao();
		
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}
}
