package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.math.plot.Plot2DPanel;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.Transfer;

import javax.swing.JTextPane;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane1;
	private JPanel contentPane;
	private JTextField tamPoblacionTx;
	private JTextField numGeneracionesTx;
	private JTextField errorTx;
	private JTextField porcentCruceTx;
	private JTextField porcentMutacionTx;
	private JTextField porcentElitismoTx;
	private JTextField textField;

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
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);

		JLabel tamPoblacionLb = new JLabel("Tamaño población");

		tamPoblacionTx = new JTextField();
		tamPoblacionTx.setText("100");
		tamPoblacionTx.setColumns(10);

		JLabel numGeneracionesLb = new JLabel("Número de generaciones");

		numGeneracionesTx = new JTextField();
		numGeneracionesTx.setText("100");
		numGeneracionesTx.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Valor error");

		errorTx = new JTextField();
		errorTx.setText("0.001");
		errorTx.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Selección");

		JLabel lblNewLabel_4 = new JLabel("Tipo de selección");

		JComboBox tipoSelecc = new JComboBox();
		tipoSelecc.setModel(new DefaultComboBoxModel(new String[] {"Estoc\u00E1stico universal", "Restos", "Ruleta", "Torneo determin\u00EDstico", "Torneo probabil\u00EDstico", "Truncamiento", "Ranking"}));

		JLabel lblNewLabel_5 = new JLabel("Cruce");

		JLabel lblNewLabel_6 = new JLabel("Tipo de cruce");

		JComboBox tipoCruce = new JComboBox();
		tipoCruce.setModel(new DefaultComboBoxModel(new String[] {"Cruce CO", "Cruce CX", "Cruce ERX", "Cruce OX", "Cruce OXPP", "Cruce PMX", "Cruce por mezcla aleatoria"}));

		JLabel lblNewLabel_7 = new JLabel("% cruce");

		porcentCruceTx = new JTextField();
		porcentCruceTx.setText("0.6");
		porcentCruceTx.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Mutación");

		JLabel lblNewLabel_9 = new JLabel("Tipo de mutación");

		JComboBox tipoMutacion = new JComboBox();
		tipoMutacion.setModel(new DefaultComboBoxModel(new String[] {"Mutaci\u00F3n heur\u00EDstica", "Mutaci\u00F3n por inserci\u00F3n", "Mutaci\u00F3n complementaria", "Mutaci\u00F3n por intercambio", "Mutaci\u00F3n por inversi\u00F3n"}));

		JLabel lblNewLabel_10 = new JLabel("% mutación");

		porcentMutacionTx = new JTextField();
		porcentMutacionTx.setText("0.05");
		porcentMutacionTx.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Élite");

		JLabel lblNewLabel_12 = new JLabel("% elitismo");

		porcentElitismoTx = new JTextField();
		porcentElitismoTx.setText("0.02");
		porcentElitismoTx.setColumns(10);

		JButton btnNewButton = new JButton("Restaurar");

		JButton btnNewButton_1 = new JButton("Ejecutar");

		JSeparator separator_3_1 = new JSeparator();

		// Grafica
		JPanel panel = new JPanel();
		Plot2DPanel plot = new Plot2DPanel();
		FlowLayout flowLayout = (FlowLayout) plot.plotCanvas.getLayout();

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(plot);

		JSeparator separator_4_2 = new JSeparator();

		JSeparator separator_4_1 = new JSeparator();
		
		JTextPane textoPropuesto = new JTextPane();
		
		JTextPane textoSolucion = new JTextPane();
		
		JLabel textoPropuestoLb = new JLabel("Texto encriptado");
		
		JLabel textoSolucionLb = new JLabel("Texto soluci\u00F3n");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblol = new JLabel("a b c d e f g h i j k l m n o p q r s t u v w x y z");
		
		JLabel lblNewLabel = new JLabel("Soluci\u00F3n");

		GroupLayout gl_contentPane = new GroupLayout(contentPane1);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(errorTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(34)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																	.addComponent(tipoCruce, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
																	.addComponent(lblNewLabel_7)
																	.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																			.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE))
																			.addComponent(tipoMutacion, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
																			.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(lblNewLabel_9)
																				.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE))
																			.addComponent(porcentMutacionTx, 125, 125, 125))
																		.addComponent(porcentCruceTx, Alignment.LEADING, 126, 126, 126)))
																.addGap(456)
																.addComponent(separator_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGap(6))
															.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(separator_4_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
																	.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
																	.addComponent(tipoSelecc, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
																.addComponent(separator_4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
												.addGap(0))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
													.addComponent(tamPoblacionLb, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
													.addComponent(tamPoblacionTx, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
													.addComponent(numGeneracionesLb, Alignment.LEADING)
													.addComponent(numGeneracionesTx, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
												.addGap(530))))))
							.addGap(300))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_11)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(porcentElitismoTx, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblol, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(16)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textoPropuesto, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
										.addComponent(textoPropuestoLb))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textoSolucionLb)
										.addComponent(textoSolucion, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
							.addGap(29))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(tamPoblacionLb)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tamPoblacionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(numGeneracionesLb)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numGeneracionesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(errorTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(separator_4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)))
					.addGap(11)
					.addComponent(tipoSelecc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(18)
							.addComponent(separator_4_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tipoCruce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(porcentCruceTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(separator_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(lblNewLabel_8)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tipoMutacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(porcentMutacionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_11)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_12)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(porcentElitismoTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addComponent(lblol)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(165))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(105))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textoPropuestoLb)
								.addComponent(textoSolucionLb))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textoPropuesto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
								.addComponent(textoSolucion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
							.addContainerGap())))
		);

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
				tipoCruce.setSelectedItem("Cruce CO");
				tipoMutacion.setSelectedItem("Mutación heurística");
				tipoSelecc.setSelectedItem("Estocástico universal");
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
				String textoCifrado = textoPropuesto.getText();
				
				AlgoritmoGenetico alg = new AlgoritmoGenetico(tamPob, numGen, pCruce, pMut, pElit, selecc, cruc,
						mut, textoCifrado);
				Transfer t = alg.run();
				textoSolucion.setText(t.getMejorIndividuo().devolverTexto());

				// define the legend position
				plot.addLegend("SOUTH");

				// add a line plot to the PlotPanel
				plot.addLinePlot("media de la generación", t.getArrayNumGene(), t.getArrayMedias());
				plot.addLinePlot("mejor absoluto", t.getArrayNumGene(), t.getArrayMejoresAbs());
				plot.addLinePlot("mejor de la generación", t.getArrayNumGene(), t.getArrayMejorGene());

			}
		});
		contentPane1.setLayout(gl_contentPane);
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
