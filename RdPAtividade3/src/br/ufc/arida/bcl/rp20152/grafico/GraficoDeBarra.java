package br.ufc.arida.bcl.rp20152.grafico;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

@SuppressWarnings("serial")
public class GraficoDeBarra extends ApplicationFrame {

	private List<PontoDoGrafico> pontosDoGrafico;
	
	private String eixoX;
	
	private String eixoY;

	public GraficoDeBarra(String title, List<PontoDoGrafico> pontos, String eixoX, String eixoY) {
		super(title);
		this.pontosDoGrafico = pontos;

		IntervalXYDataset dataset = createDataset();
		System.out.println("tamanho do dataset no construtor: "+ pontosDoGrafico.size());
		JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
	}
	
	public IntervalXYDataset createDataset() {
		final XYSeries series = new XYSeries("Series name");

		for (PontoDoGrafico p : pontosDoGrafico) {
			series.add(p.getX(), p.getY());
		}

		final XYSeriesCollection dataset = new XYSeriesCollection(series);
		return dataset;
	}

	private JFreeChart createChart(IntervalXYDataset dataset) {
		final JFreeChart chart = ChartFactory.createXYBarChart(
				"titulo",
				this.eixoX,
				false,
				this.eixoY,
				dataset,
				PlotOrientation.VERTICAL,
				true, true, false);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.gray);
        plot.setRangeGridlinePaint(Color.gray);
		return chart;
	}
	
	public void exibirGrafico() {
		final GraficoDeBarra grafico = new GraficoDeBarra(getTitle(), pontosDoGrafico, eixoX, eixoY);
		
		grafico.pack();
		RefineryUtilities.centerFrameOnScreen(grafico);
		grafico.setVisible(true);
	}
}
