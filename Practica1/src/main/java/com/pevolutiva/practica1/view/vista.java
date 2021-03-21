package com.pevolutiva.practica1.view;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.pevolutiva.practica1.algoritmoGenetico.AlgoritmoGenetico;

public class vista {

	protected Shell shlPrcticaP;
	private Text numGeneracionesTx;
	private Text errorTx;
	private Label label;
	private Label lblSeleccin;
	private Label lblCruce;
	private Label label_1;
	private Label lblTipoDeCruce;
	private CCombo tipoCruce;
	private Label lblCruce_1;
	private Text porcentCruceTx;
	private Label lblMutacin;
	private Label label_2;
	private Label lblTipoDeMutacin;
	private CCombo tipoMutacion;
	private Label lblMutacin_1;
	private Text porcentMutacionTx;
	private Label lbllite;
	private Label label_3;
	private Label lblElitismo;
	private Text porcentElitismoText;
	private Text solucionTx;
	private Text tamPoblacionTx;
	private CCombo tipoSelecc;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			vista window = new vista();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlPrcticaP.open();
		shlPrcticaP.layout();
		while (!shlPrcticaP.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPrcticaP = new Shell();
		shlPrcticaP.setSize(1100, 795);
		shlPrcticaP.setText("Práctica 1 P. evolutiva");
		shlPrcticaP.setLayout(null);

		
		Label lblProblema = new Label(shlPrcticaP, SWT.NONE);
		lblProblema.setBounds(489, 23, 55, 15);
		lblProblema.setText("Problema");

		CCombo tipoProblema = new CCombo(shlPrcticaP, SWT.BORDER);
		tipoProblema.setText("Problema 1");
		tipoProblema.setItems(new String[] {"Problema 1", "Problema 2", "Problema 3", "Problema 4"});
		tipoProblema.setBounds(550, 22, 91, 21);

		// Tamaño poblacion
		Label lblTamaoPoblacin = new Label(shlPrcticaP, SWT.NONE);
		lblTamaoPoblacin.setBounds(10, 65, 140, 15);
		lblTamaoPoblacin.setText("Tamaño población");

		tamPoblacionTx = new Text(shlPrcticaP, SWT.BORDER);
		tamPoblacionTx.setText("100");
		tamPoblacionTx.setBounds(10, 90, 140, 21);

		// Numero de generaciones
		Label lblNmeroDeGeneraciones = new Label(shlPrcticaP, SWT.NONE);
		lblNmeroDeGeneraciones.setBounds(10, 117, 140, 15);
		lblNmeroDeGeneraciones.setText("Número de generaciones");

		numGeneracionesTx = new Text(shlPrcticaP, SWT.BORDER);
		numGeneracionesTx.setText("100");
		numGeneracionesTx.setBounds(10, 138, 140, 21);

		// Valor error
		Label lblValorDeError = new Label(shlPrcticaP, SWT.NONE);
		lblValorDeError.setBounds(10, 165, 140, 15);
		lblValorDeError.setText("Valor de error");

		errorTx = new Text(shlPrcticaP, SWT.BORDER);
		errorTx.setText("0.001");
		errorTx.setBounds(10, 186, 140, 21);

		label = new Label(shlPrcticaP, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(67, 227, 83, 8);

		// Seleccion
		lblSeleccin = new Label(shlPrcticaP, SWT.NONE);
		lblSeleccin.setBounds(10, 220, 56, 15);
		lblSeleccin.setText("Selección");

		Label lblTipoDeSelccin = new Label(shlPrcticaP, SWT.NONE);
		lblTipoDeSelccin.setBounds(20, 241, 130, 15);
		lblTipoDeSelccin.setText("Tipo de selección");

		tipoSelecc = new CCombo(shlPrcticaP, SWT.BORDER);
		tipoSelecc.setText("Ruleta");
		tipoSelecc.setItems(new String[] { "Estocástico universal", "Restos", "Ruleta", "Torneo", "Truncamiento" });
		tipoSelecc.setBounds(10, 262, 130, 21);


		label_1 = new Label(shlPrcticaP, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(47, 313, 103, 8);

		// Cruce
		lblCruce = new Label(shlPrcticaP, SWT.NONE);
		lblCruce.setBounds(10, 306, 39, 15);
		lblCruce.setText("Cruce");

		lblTipoDeCruce = new Label(shlPrcticaP, SWT.NONE);
		lblTipoDeCruce.setBounds(20, 327, 130, 15);
		lblTipoDeCruce.setText("Tipo de cruce");

		tipoCruce = new CCombo(shlPrcticaP, SWT.BORDER);
		tipoCruce.setText("Cruce monopunto");
		tipoCruce.setItems(new String[] { "Cruce monopunto", "Cruce uniforme" });
		tipoCruce.setBounds(20, 348, 130, 21);

		lblCruce_1 = new Label(shlPrcticaP, SWT.NONE);
		lblCruce_1.setBounds(20, 382, 130, 15);
		lblCruce_1.setText("% cruce");

		porcentCruceTx = new Text(shlPrcticaP, SWT.BORDER);
		porcentCruceTx.setText("0.6");
		porcentCruceTx.setBounds(20, 403, 130, 21);

		label_2 = new Label(shlPrcticaP, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(67, 454, 83, 8);

		// Mutacion
		lblMutacin = new Label(shlPrcticaP, SWT.NONE);
		lblMutacin.setText("Mutación");
		lblMutacin.setBounds(10, 447, 55, 15);

		lblTipoDeMutacin = new Label(shlPrcticaP, SWT.NONE);
		lblTipoDeMutacin.setText("Tipo de mutación");
		lblTipoDeMutacin.setBounds(20, 472, 130, 15);

		tipoMutacion = new CCombo(shlPrcticaP, SWT.BORDER);
		tipoMutacion.setText("Mutación básica");
		tipoMutacion.setItems(new String[] { "Mutación básica" });
		tipoMutacion.setBounds(20, 493, 130, 21);

		lblMutacin_1 = new Label(shlPrcticaP, SWT.NONE);
		lblMutacin_1.setBounds(20, 520, 71, 15);
		lblMutacin_1.setText("% mutación");

		porcentMutacionTx = new Text(shlPrcticaP, SWT.BORDER);
		porcentMutacionTx.setText("0.05");
		porcentMutacionTx.setBounds(20, 541, 130, 21);

		label_3 = new Label(shlPrcticaP, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(41, 589, 109, 8);

		// Elitismo
		lbllite = new Label(shlPrcticaP, SWT.NONE);
		lbllite.setBounds(10, 582, 55, 15);
		lbllite.setText("Élite");

		lblElitismo = new Label(shlPrcticaP, SWT.NONE);
		lblElitismo.setBounds(20, 603, 55, 15);
		lblElitismo.setText("% elitismo");

		porcentElitismoText = new Text(shlPrcticaP, SWT.BORDER);
		porcentElitismoText.setText("0.02");
		porcentElitismoText.setBounds(15, 624, 135, 21);

		Label label_4 = new Label(shlPrcticaP, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(41, 667, 71, 8);

		// Restaurar
		Button btnRestaurar = new Button(shlPrcticaP, SWT.NONE);
		btnRestaurar.setBounds(10, 703, 134, 25);
		btnRestaurar.setText("Restaurar");

		// Solucion
		Label lblSolucin = new Label(shlPrcticaP, SWT.NONE);
		lblSolucin.setBounds(210, 708, 55, 15);
		lblSolucin.setText("Solución");

		solucionTx = new Text(shlPrcticaP, SWT.BORDER);
		solucionTx.setBounds(271, 705, 596, 21);

		// Ejecutar
		Button btnEjecutar = new Button(shlPrcticaP, SWT.NONE);
		btnEjecutar.setBounds(920, 703, 120, 25);
		btnEjecutar.setText("Ejecutar");

		btnEjecutar.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				Integer numGen = getNumGeneracionesTx();
				Double err = getErrorTx();
				Double pCruce= getPorcentCruceTx();
				Double pMut= getPorcentMutacionTx();
				Double pElit= getPorcentElitismoText();
				Integer tamPob = getTamPoblacionTx();
				String selecc = tipoSelecc.getText(); 
				String mut = tipoMutacion.getText(); 
				String cruc = tipoCruce.getText(); 
				String problema = tipoProblema.getText();

				AlgoritmoGenetico alg = new AlgoritmoGenetico(tamPob, numGen, pCruce, pMut, pElit, err, selecc, cruc, mut, problema);
				
				solucionTx.setText(alg.run());
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		btnRestaurar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				errorTx.setText("0.001");		
				porcentCruceTx.setText("0.6");
				porcentMutacionTx.setText("0.05");
				porcentElitismoText.setText("0.02");
				tamPoblacionTx.setText("100");
				numGeneracionesTx.setText("100");
				tipoCruce.setText("Cruce monopunto");
				tipoMutacion.setText("Mutación básica");
				tipoSelecc.setText("Ruleta");
				tipoProblema.setText("Problema 1");
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	
	

	public Double getErrorTx() {
		String num = errorTx.getText();
		return Double.parseDouble(num);	}

	public Double getPorcentCruceTx() {
		String num = porcentCruceTx.getText();
		return Double.parseDouble(num);
	}

	public Double getPorcentMutacionTx() {
		String num = porcentMutacionTx.getText();
		return Double.parseDouble(num);
	}

	public Double getPorcentElitismoText() {
		String num = porcentElitismoText.getText();
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
