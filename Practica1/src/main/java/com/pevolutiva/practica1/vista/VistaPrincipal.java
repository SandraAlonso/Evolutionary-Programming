package com.pevolutiva.practica1.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.math.plot.Plot2DPanel;

import com.pevolutiva.practica1.algoritmoGenetico.AlgoritmoGenetico;
import com.pevolutiva.practica1.algoritmoGenetico.Transfer;

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
import javax.swing.BoxLayout;

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
	public void open() {
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
		setBounds(450, 5, 1000, 1000);
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

		JLabel lblNewLabel_4 = new JLabel("Tipo de selección");

		JComboBox tipoSelecc = new JComboBox();
		tipoSelecc.setModel(new DefaultComboBoxModel(
				new String[] { "Estocástico universal", "Restos", "Ruleta", "Torneo", "Truncamiento" }));

		JLabel lblNewLabel_5 = new JLabel("Cruce");

		JLabel lblNewLabel_6 = new JLabel("Tipo de cruce");

		JComboBox tipoCruce = new JComboBox();
		tipoCruce.setModel(new DefaultComboBoxModel(new String[] { "Cruce monopunto", "Cruce uniforme" }));

		JLabel lblNewLabel_7 = new JLabel("% cruce");

		porcentCruceTx = new JTextField();
		porcentCruceTx.setText("0.6");
		porcentCruceTx.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Mutación");

		JLabel lblNewLabel_9 = new JLabel("Tipo de mutación");

		JComboBox tipoMutacion = new JComboBox();
		tipoMutacion.setModel(new DefaultComboBoxModel(new String[] { "Mutación básica" }));

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

		JButton btnNewButton_1 = new JButton("Ejecutar");

		JSeparator separator_3_1 = new JSeparator();

		JLabel lblNewLabel_14 = new JLabel("Problema");

		JComboBox tipoProblema = new JComboBox();
		tipoProblema.setModel(new DefaultComboBoxModel(
				new String[] { "Problema 1", "Problema 2", "Problema 3", "Problema 4", "Problema 4 reales" }));

		// Grafica
		JPanel panel = new JPanel();
		Plot2DPanel plot = new Plot2DPanel();
		FlowLayout flowLayout = (FlowLayout) plot.plotCanvas.getLayout();

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(plot);

		JSeparator separator_4_2 = new JSeparator();

		JSeparator separator_4_1 = new JSeparator();

		JSeparator separator_4_3 = new JSeparator();

		solucionTx = new JTextField();
		solucionTx.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tipoSelecc, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
							.addGap(591))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(68))
								.addComponent(tipoMutacion, 0, 125, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(44))
								.addComponent(porcentMutacionTx, 125, 125, 125))
							.addGap(593))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(86))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(62))
								.addComponent(tipoCruce, 0, 126, Short.MAX_VALUE)
								.addComponent(porcentCruceTx, 126, 126, 126))
							.addGap(591))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(395)
							.addComponent(lblNewLabel_14)
							.addGap(18)
							.addComponent(tipoProblema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(0)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tamPoblacionLb, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
									.addGap(136))
								.addComponent(numGeneracionesLb, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
									.addGap(171))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
											.addGap(7)
											.addComponent(separator_4_1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
										.addComponent(errorTx, 161, 161, 161)
										.addComponent(numGeneracionesTx, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
									.addGap(70))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tamPoblacionTx, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
									.addGap(70))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_11)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(porcentElitismoTx, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_12, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
											.addGap(75)))
									.addGap(80))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
											.addGap(5)
											.addComponent(separator_4_3, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(separator_4_2, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
											.addGap(2)))
									.addGap(63)
									.addComponent(separator_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(2)))
							.addGap(4)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
							.addGap(56))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(separator_4, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(solucionTx, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
							.addGap(230))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_14)
						.addComponent(tipoProblema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
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
								.addComponent(lblNewLabel_3)
								.addComponent(separator_4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tipoSelecc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_5)
								.addComponent(separator_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_4_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(separator_4_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(porcentElitismoTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel_13)
						.addComponent(solucionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(85, Short.MAX_VALUE))
		);

		tipoProblema.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoCruce.removeItem("Cruce aritmético");
				tipoCruce.removeItem("Cruce BLXa");
				tipoMutacion.removeItem("Mutación uniforme");
				tipoMutacion.removeItem("Mutación básica");

				if (tipoProblema.getSelectedItem().equals("Problema 4 reales")) {
					tipoCruce.addItem("Cruce aritmético");
					tipoCruce.addItem("Cruce BLXa");
					tipoMutacion.addItem("Mutación uniforme");

				}
				else {
					
					tipoMutacion.addItem("Mutación básica");

				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				plot.removeAllPlots();
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
				plot.removeAllPlots();
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
				Transfer t = alg.run();
				solucionTx.setText(t.getMejorIndividuo().toString());

				// define the legend position
				plot.addLegend("SOUTH");

				// add a line plot to the PlotPanel
				plot.addLinePlot("media de la generación", t.getArrayNumGene(), t.getArrayMedias());
				plot.addLinePlot("mejor absoluto", t.getArrayNumGene(), t.getArrayMejoresAbs());
				plot.addLinePlot("mejor de la generación", t.getArrayNumGene(), t.getArrayMejorGene());

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
