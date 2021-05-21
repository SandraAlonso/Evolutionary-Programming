package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
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
	private JTextField porcentCruceTx;
	private JTextField porcentMutacionTx;
	private JTextField porcentElitismoTx;
	private JPanel[][] paneles = new JPanel[32][32];
	JPanel cuadricula = new JPanel();
	private JTextField profMax;

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

		JLabel lblNewLabel_3 = new JLabel("Selección");

		JLabel lblNewLabel_4 = new JLabel("Tipo de selección");

		JComboBox tipoSelecc = new JComboBox();
		tipoSelecc.setModel(
				new DefaultComboBoxModel(new String[] { "Torneo determin\u00EDstico", "Estoc\u00E1stico universal",
						"Restos", "Ruleta", "Torneo probabil\u00EDstico", "Truncamiento", "Ranking" }));

		JLabel lblNewLabel_5 = new JLabel("Cruce");

		JLabel lblNewLabel_6 = new JLabel("Tipo de cruce");

		JComboBox tipoCruce = new JComboBox();
		tipoCruce.setModel(new DefaultComboBoxModel(new String[] {"Cruce por intercambio"}));

		JLabel lblNewLabel_7 = new JLabel("% cruce");

		porcentCruceTx = new JTextField();
		porcentCruceTx.setText("0.6");
		porcentCruceTx.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Mutación");

		JLabel lblNewLabel_9 = new JLabel("Tipo de mutación");

		JComboBox tipoMutacion = new JComboBox();
		tipoMutacion.setModel(new DefaultComboBoxModel(new String[] {"Mutaci\u00F3n \u00E1rbol", "Mutaci\u00F3n por contracci\u00F3n", "Mutaci\u00F3n por expansi\u00F3n", "Mutaci\u00F3n funcional simple", "Mutaci\u00F3n hoist", "Mutaci\u00F3n por permutaci\u00F3n", "Mutaci\u00F3n terminal simple"}));

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

		JLabel solucionLetras = new JLabel("");
		
		JLabel inilbl = new JLabel("M\u00E9todo de inicializaci\u00F3n");
		
		JComboBox ini = new JComboBox();
		ini.setModel(new DefaultComboBoxModel(new String[] {"Completa", "Creciente", "Ramped and Half"}));
		
		JLabel lblNewLabel = new JLabel("Profundidad m\u00E1xima");
		
		profMax = new JTextField();
		profMax.setText("4");
		profMax.setToolTipText("");
		profMax.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane1);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_11)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(porcentElitismoTx, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(748, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(tamPoblacionLb, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(tamPoblacionTx, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(numGeneracionesLb)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(34)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tipoCruce, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_7)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
												.addComponent(tipoMutacion, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_9)
												.addComponent(porcentMutacionTx, 125, 125, 125))
											.addComponent(porcentCruceTx, Alignment.LEADING, 126, 126, 126))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(separator_4_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
											.addComponent(tipoSelecc, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
								.addComponent(inilbl)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(ini, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(profMax, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addComponent(numGeneracionesTx, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cuadricula, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(separator_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(6))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
									.addComponent(separator_4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(solucionLetras)
							.addGap(12))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(tamPoblacionLb)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tamPoblacionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(numGeneracionesLb)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numGeneracionesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(profMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
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
							.addComponent(porcentMutacionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(cuadricula, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_11)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_12)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(porcentElitismoTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
									.addComponent(solucionLetras)
									.addGap(79))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(inilbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ini, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(43)))
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(175))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
							.addContainerGap())))
		);

		// Rellenar la cuadricula con los casos de SantaFe
		cuadricula.setLayout(new GridLayout(32, 32, 0, 0));
		boolean mapa[][]=new boolean[32][32];
		leerMapa(mapa);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				plot.removeAllPlots();
				porcentCruceTx.setText("0.6");
				profMax.setText("4");
				porcentMutacionTx.setText("0.05");
				porcentElitismoTx.setText("0.02");
				tamPoblacionTx.setText("100");
				numGeneracionesTx.setText("100");
				tipoCruce.setSelectedItem("Cruce por intercambio");
				tipoMutacion.setSelectedItem("Mutación árbol");
				tipoSelecc.setSelectedItem("Torneo determin\\u00EDstico");
				ini.setSelectedItem("Completa");
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				plot.removeAllPlots();
				Integer numGen = getNumGeneracionesTx();
				Integer profMax = getProfMax();
				Double pCruce = getPorcentCruceTx();
				Double pMut = getPorcentMutacionTx();
				Double pElit = getPorcentElitismoText();
				Integer tamPob = getTamPoblacionTx();
				String selecc = (String) tipoSelecc.getSelectedItem();
				String mut = (String) tipoMutacion.getSelectedItem();
				String cruc = (String) tipoCruce.getSelectedItem();
				String inic = (String) ini.getSelectedItem();
				 AlgoritmoGenetico alg = new AlgoritmoGenetico(tamPob, numGen, pCruce, pMut,
				 pElit, selecc, cruc, mut, inic); 
				 Transfer t = alg.run();
				 cuadricula.removeAll();
				 leerMapa(t.getMejorIndividuo().solucion());
				
				// define the legend position
				plot.addLegend("SOUTH");

				// add a line plot to the PlotPanel
				
				 plot.addLinePlot("media de la generación", t.getArrayNumGene(),
				 t.getArrayMedias());
				 plot.addLinePlot("mejor absoluto", t.getArrayNumGene(),
				 t.getArrayMejoresAbs()); 
				 plot.addLinePlot("mejor de la generación",
				 t.getArrayNumGene(), t.getArrayMejorGene());
				

			}
		});
		contentPane1.setLayout(gl_contentPane);
	}

	public void leerMapa(boolean[][] mapa) {
		try {
			
			int j = 0;
			File myObj = new File("mapa/SantaFe.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String key[] = data.split(" ");
				for (int i = 0; i < key.length; i++) {
					JPanel p = new JPanel();
					Border border;
					border = BorderFactory.createLineBorder(Color.black);
					p.setBorder(border);
					if (key[i].equals("#") || key[i].equals("@")) {// bocado
						p.setBackground(Color.black);
					} else if (key[i].equals("0")) {
						p.setBackground(Color.white);
					}
					if(mapa[i][j]) {
						p.setBackground(Color.green);

					}
					paneles[j][i] = p;
					cuadricula.add(p);
				}
				j++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
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
	public Integer getProfMax() {
		String num = profMax.getText();
		return Integer.parseInt(num);
	}
	public Integer getNumGeneracionesTx() {
		String num = numGeneracionesTx.getText();
		return Integer.parseInt(num);
	}
}
