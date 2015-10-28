package br.ufc.arida.bcl.rp20152.grafico;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico extends ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private DefaultCategoryDataset dataset;
	
	private JFreeChart chart;
	
	private XYDataset dataset;
	
	private List<XYSeries> series;
	
	private String tituloDoGrafico;
	
	public Grafico(String tituloDaAplicacao, String tituloDoGrafico) {
		super(tituloDaAplicacao);
		this.tituloDoGrafico = tituloDoGrafico;
		series = new ArrayList<XYSeries>();
	}
	
	public void construirParaExibicao() {
		dataset = createDataset();
		chart = createChart(dataset, "x", "y");

		//chart = ChartFactory.createBarChart(tituloDoGrafico, legendaX, tipoDeValorX, dataset);
		//chart = ChartFactory.createLineChart(tituloDoGrafico, legendaX, tipoDeValorX, dataset);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public void construirComOverlay(HistogramDataset histogramDataset) {
		dataset = createDataset();
		chart = createChartComOverlaid(histogramDataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public JFreeChart createChartComOverlaid(HistogramDataset histogramDataset) {
		
		
		final XYItemRenderer renderer = new XYBarRenderer();
		
		final NumberAxis xAxis = new NumberAxis("x");
		xAxis.setAutoRangeIncludesZero(false);
		final ValueAxis yAxis = new NumberAxis("y");
		final XYPlot plot = new XYPlot((XYDataset) histogramDataset, xAxis, yAxis, renderer);
		
		final XYItemRenderer xyLineRenderer = new XYLineAndShapeRenderer();
		xyLineRenderer.setSeriesShape(0, new Line2D.Double(0.0, 0.0, 0.0, 0.0));
		xyLineRenderer.setSeriesStroke(0, new BasicStroke(4.5f));
		plot.setDataset(1, createDataset());
		plot.setRenderer(1, xyLineRenderer);
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		
		return new JFreeChart("Overlaid Plot Example", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
	}
	
	public void adicionarSerie(List<PontoDoGrafico> listaDePontos, String nomeDaSerie) {
		XYSeries serieXY = new XYSeries(nomeDaSerie);
		for (PontoDoGrafico pontoDoGrafico : listaDePontos) {
			serieXY.add(pontoDoGrafico.getX(), pontoDoGrafico.getY());
		}
		series.add(serieXY);
		createDataset();
	}

	private XYDataset createDataset() {
		final XYSeriesCollection dataset = new XYSeriesCollection();
		for (XYSeries xySerie : series) {
			dataset.addSeries(xySerie);
		}
		return dataset;
	}
	
	private JFreeChart createChart(XYDataset dataset, String labelX, String labelY) {
		
		JFreeChart chart = ChartFactory.createXYLineChart(tituloDoGrafico,// chart title
				labelX, // x axis label
				labelY, // y axis label
				dataset, // data
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

	/**
	 * Gera e exporta uma imagem JPG do grafico. Alem disso escreve o link na tela para a figura
	 * ser acessada remotamente
	 */
	public void exportarGraficoComoFigura() {
		construirParaExibicao();
		
		double numeroaletorio = Math.random() * 1000000;
		String nomeAux = "" + numeroaletorio;
		String nomeAleatorio = "grafico" + nomeAux.substring(0,5) + ".jpg";

		try {
			ChartUtilities.saveChartAsJPEG(new java.io.File(nomeAleatorio), chart, 1280, 720);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
	
	public void exibirGraficoComOverlay(HistogramDataset histogramDataset) {
		construirComOverlay(histogramDataset);
		
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}
}