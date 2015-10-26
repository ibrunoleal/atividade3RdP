package br.ufc.arida.bcl.rp20152.gui.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AplicacaoGui {

	private JFrame frame;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoGui window = new AplicacaoGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacaoGui() {
		initialize();
	}

	public void sair() {
		System.exit(0);
	}
	
	public void exibirMatrizK() {
		double[][] valoresK = {{0.5,0.2,0.1},{0.6,0.18,0.4},{0.1,0.6,0.2}};
		RealMatrix matriz = new Array2DRowRealMatrix(valoresK);
		JInternalFrameMostraMatriz jInternalFrameMostraMatriz = new JInternalFrameMostraMatriz(matriz);
		getDesktopPane().add(jInternalFrameMostraMatriz);
		jInternalFrameMostraMatriz.setVisible(true);
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1175, 809);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnAtivdade = new JMenu("Ativdade3");
		menuBar.add(mnAtivdade);
		
		JMenuItem mntmExibirMatriz = new JMenuItem("Exibir Matriz");
		mntmExibirMatriz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirMatrizK();
			}
		});
		mnAtivdade.add(mntmExibirMatriz);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
	}
	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}
}
