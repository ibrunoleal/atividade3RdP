package br.ufc.arida.bcl.rp20152.grafico;

import java.awt.Color;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

@SuppressWarnings("serial")
public class GraficoDeBarra extends ApplicationFrame {

	private List<PontoDoGrafico> pontosDoGrafico;
	
	private String eixoX;
	
	private String eixoY;

	public GraficoDeBarra(String title, List<PontoDoGrafico> pontos, String eixoX, String eixoY) {
		super(title);
		this.pontosDoGrafico = pontos;
		this.eixoX = eixoX;
		this.eixoY = eixoY;

		IntervalXYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
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
				this.getTitle(),
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
