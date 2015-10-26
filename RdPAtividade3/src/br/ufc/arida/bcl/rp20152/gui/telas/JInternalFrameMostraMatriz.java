package br.ufc.arida.bcl.rp20152.gui.telas;

import javax.swing.JInternalFrame;

import org.apache.commons.math3.linear.RealMatrix;


@SuppressWarnings("serial")
public class JInternalFrameMostraMatriz extends JInternalFrame {
	
	/**
	 * Create the frame.
	 */
	public JInternalFrameMostraMatriz(RealMatrix matriz) {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 408, 257);
		
		JPanelMatriz jPanelMatriz = new JPanelMatriz(matriz);
		this.getContentPane().add(jPanelMatriz);
	}

}
