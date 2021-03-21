package com.pevolutiva.practica1.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pevolutiva.practica1.algoritmoGenetico.AlgoritmoGenetico;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tamPoblacionTx;
	private JTextField numGeneracionesTx;
	private JTextField errorTx;
	private JTextField porcentCruceTx;
	private JTextField porcentMutacionTx;
	private JTextField porcentElitismoTx;
	private JTextField solucionTx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 862);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel tamPoblacionLb = new JLabel("Tamaño población");
		
		tamPoblacionTx = new JTextField();
		tamPoblacionTx.setText("100");
		tamPoblacionTx.setColumns(10);
		
		JLabel numGeneracionesLb = new JLabel("Número de generaciones");
		
		numGeneracionesTx = new JTextField();
		numGeneracionesTx.setText("100");
		numGeneracionesTx.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Volor error");
		
		errorTx = new JTextField();
		errorTx.setText("0.001");
		errorTx.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Selección");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de selección");
		
		JComboBox tipoSelecc = new JComboBox();
		tipoSelecc.setModel(new DefaultComboBoxModel(new String[] {"Estocástico universal", "Restos", "Ruleta", "Torneo", "Truncamiento"}));
		
		JLabel lblNewLabel_5 = new JLabel("Cruce");
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de cruce");
		
		JComboBox tipoCruce = new JComboBox();
		tipoCruce.setModel(new DefaultComboBoxModel(new String[] {"Cruce monopunto", "Cruce uniforme"}));
		
		JLabel lblNewLabel_7 = new JLabel("% cruce");
		
		porcentCruceTx = new JTextField();
		porcentCruceTx.setText("0.6");
		porcentCruceTx.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mutación");
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblNewLabel_9 = new JLabel("Tipo de mutación");
		
		JComboBox tipoMutacion = new JComboBox();
		tipoMutacion.setModel(new DefaultComboBoxModel(new String[] {"Mutación básica"}));
		
		JSeparator separator_3 = new JSeparator();
		
		JLabel lblNewLabel_10 = new JLabel("% mutación");
		
		porcentMutacionTx = new JTextField();
		porcentMutacionTx.setText("0.05");
		porcentMutacionTx.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Élite");
		
		JSeparator separator_4 = new JSeparator();
		
		JLabel lblNewLabel_12 = new JLabel("% elitismo");
		
		porcentElitismoTx = new JTextField();
		porcentElitismoTx.setText("0.02");
		porcentElitismoTx.setColumns(10);
		
		JButton btnNewButton = new JButton("Restaurar");
		
		JLabel lblNewLabel_13 = new JLabel("Solución");
		
		solucionTx = new JTextField();
		solucionTx.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ejecutar");
		
		JSeparator separator_3_1 = new JSeparator();
		
		JLabel lblNewLabel_14 = new JLabel("Problema");
		
		JComboBox tipoProblema = new JComboBox();
		tipoProblema.setModel(new DefaultComboBoxModel(new String[] {"Problema 1", "Problema 2", "Problema 3", "Problema 4"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tamPoblacionLb)
										.addComponent(numGeneracionesLb, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2)
										.addComponent(tamPoblacionTx, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel_3)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(errorTx, Alignment.LEADING)
											.addComponent(numGeneracionesTx, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_11)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel_12)
												.addComponent(porcentElitismoTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(127))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(separator_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(50)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tipoSelecc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(solucionTx, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(porcentMutacionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10)
								.addComponent(tipoMutacion, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(porcentCruceTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_6)
								.addComponent(tipoCruce, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(395)
							.addComponent(lblNewLabel_14)
							.addGap(18)
							.addComponent(tipoProblema, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addGap(0)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_14)
						.addComponent(tipoProblema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(tamPoblacionLb)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tamPoblacionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(numGeneracionesLb)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(numGeneracionesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(errorTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tipoSelecc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_5)
						.addComponent(separator_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tipoCruce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(porcentCruceTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_8)
						.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tipoMutacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(porcentMutacionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_11)
						.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_12)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(porcentElitismoTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(solucionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13)
						.addComponent(btnNewButton_1))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				errorTx.setText("0.001");
				porcentCruceTx.setText("0.6");
				porcentMutacionTx.setText("0.05");
				porcentElitismoTx.setText("0.02");
				tamPoblacionTx.setText("100");
				numGeneracionesTx.setText("100");
				tipoCruce.setSelectedItem("Cruce monopunto");
				tipoMutacion.setSelectedItem("Mutación básica");
				tipoSelecc.setSelectedItem("Estocástico universal");
				tipoProblema.setSelectedItem("Problema 1");				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer numGen = getNumGeneracionesTx();
				Double err = getErrorTx();
				Double pCruce = getPorcentCruceTx();
				Double pMut = getPorcentMutacionTx();
				Double pElit = getPorcentElitismoText();
				Integer tamPob = getTamPoblacionTx();
				String selecc = (String) tipoSelecc.getSelectedItem();
				String mut = (String) tipoMutacion.getSelectedItem();
				String cruc = (String) tipoCruce.getSelectedItem();
				String problema = (String) tipoProblema.getSelectedItem();

				AlgoritmoGenetico alg = new AlgoritmoGenetico(tamPob, numGen, pCruce, pMut, pElit, err, selecc, cruc,
						mut, problema);

				solucionTx.setText(alg.run());				
			}
		});
		contentPane.setLayout(gl_contentPane);
	}
	public Double getErrorTx() {
		String num = errorTx.getText();
		return Double.parseDouble(num);
	}

	public Double getPorcentCruceTx() {
		String num = porcentCruceTx.getText();
		return Double.parseDouble(num);
	}

	public Double getPorcentMutacionTx() {
		String num = porcentMutacionTx.getText();
		return Double.parseDouble(num);
	}

	public Double getPorcentElitismoText() {
		String num = porcentElitismoTx.getText();
		return Double.parseDouble(num);
	}

	public Integer getTamPoblacionTx() {
		String num = tamPoblacionTx.getText();
		return Integer.parseInt(num);
	}

	public Integer getNumGeneracionesTx() {
		String num = numGeneracionesTx.getText();
		return Integer.parseInt(num);
	}
}
