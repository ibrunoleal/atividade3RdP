package br.ufc.arida.bcl.rp20152.gui.telas;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

@SuppressWarnings("serial")
public class JPanelMatriz extends JPanel {
	
	private final String identificadorLinha = "X";
	
	/**
	 * Matriz a ser exibida no painel.
	 */
	private RealMatrix matriz;
	
	/**
	 * Tabela que representa a matriz visualmente.
	 */
	private JTable table;
	
	
	/**
	 * Forma o modelo e preenche os elementos da tabela a partir do atributo matriz da classe;
	 * @return o modelo da tabela preenchida com os valores da matriz.
	 */
	public DefaultTableModel getModelo() {
		DefaultTableModel modelo;
		
		/*
		 * adiciona uma coluna a mais para o identifcador das linhas
		 */
		Object[] tituloColuna = new Object[matriz.getRowDimension() + 1];
		tituloColuna[0] = identificadorLinha; 
		
		/*
		 * atribui o identificador de cada coluna de acordo com o seu numero.
		 * obs.: primeira coluna da tabela nao apresenta elementos da matriz, e sim o identificador
		 * das linhas da matriz.
		 */
		for (int j = 1; j < (matriz.getColumnDimension() + 1); j++) {
			tituloColuna[j] = getIdentificador(j-1);
		}
		
		modelo = new DefaultTableModel(tituloColuna, 0);
		
		for (int i = 0; i < matriz.getRowDimension(); i++) {
			RealVector vlinha = matriz.getRowVector(i);
			Object[] linha = new Object[matriz.getColumnDimension() + 1];
			linha[0] = getIdentificador(i);
			for (int j = 1; j < (vlinha.getDimension() + 1); j++) {
				linha[j] = vlinha.getEntry(j-1);
			}
			modelo.addRow(linha);
		}
				
		return modelo;
	}
	
	private String getIdentificador(int num) {
		return "[" + num + "]";
	}
	
	/**
	 * Define as propriidades do modelo de formatacao para as celulas que identificam 
	 * as linhas da matriz(coluna 0 da tabela). 
	 * @return modelo de formatacao para as celulas que identificam 
	 * as linhas da matriz(coluna 0 da tabela).
	 */
	private DefaultTableCellRenderer getTableCellRenderIdLinhas() {
		DefaultTableCellRenderer labelLinhas = new DefaultTableCellRenderer() {

			public void setValue(Object value) {
				setBackground(new Color(238, 238, 238));
				setForeground(Color.BLACK);
				setHorizontalAlignment(JLabel.CENTER);
				super.setValue(value);
			}
		};
		return labelLinhas;
	}

	/**
	 * Define as propriidades do modelo de formatacao para as celulas dos 
	 * elementos(valores) da matriz
	 * @return modelo de formatacao para as celulas que identificam 
	 * as linhas da matriz(coluna 0 da tabela).
	 */
	private DefaultTableCellRenderer getTableCellRenderFormatadorDeValores() {
		DefaultTableCellRenderer labelValores = new DefaultTableCellRenderer() {

			public void setValue(Object value) {
				setHorizontalAlignment(JLabel.CENTER);
				super.setValue(value);
			}
		};
		
		return labelValores;
	}
	
	private void aplicarFormatacaoDeColuna(String idColuna, DefaultTableCellRenderer defaultTableCellRenderer) {
		TableColumn tc = table.getColumn(idColuna);
		tc.setCellRenderer(defaultTableCellRenderer);
	}
	
	private void aplicarFormatacaoDosElementos() {
		for (int i = 0; i < matriz.getColumnDimension(); i++) {
			String identificador = getIdentificador(i);
			aplicarFormatacaoDeColuna(identificador, getTableCellRenderFormatadorDeValores());
		}
	}
	
	/**
	 * Create the panel.
	 */
	public JPanelMatriz(RealMatrix matriz) {
		this.matriz = matriz;
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(getModelo());

		aplicarFormatacaoDeColuna(identificadorLinha, getTableCellRenderIdLinhas());
		aplicarFormatacaoDosElementos();
		
		scrollPane.setViewportView(table);
	}

}