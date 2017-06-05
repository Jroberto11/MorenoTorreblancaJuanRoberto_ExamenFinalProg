package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Container.container;

import Models.Coche;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaPrincipal {

	private JFrame frame;
	private JTextField textFieldMatricula;
	private JTextField textFieldFechaEntrada;
	private JTextField textFieldFechaSalida;
	private JTextField textFieldimporte;
	private JButton btnPagoYSalida;
	private JButton btnEntradaVehculo;
	private JButton btnCajadeldia;
	private JButton btnRegistrar;
	private JLabel lblTotalAPagar;
	private JLabel lblPagar;
	private JLabel lblImporteEntregado;
	private JLabel lblCambio;
	private JLabel lblCambioNumerico;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		initialize();
		setComponetProperties();
		setComponetAdapters();
		Modoinicio();
		
	}
	/**
	 * Acciones.
	 */
	private void setComponetAdapters(){
		
		btnEntradaVehculo.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				ModoEntrar();
			}
		});
		btnPagoYSalida.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				ModoPago();
				imprimirCoche(container.listaVehiculos.get(container.cocheActivo));								
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 		
				Date Salida=new Date();
				String cadenaFecha = formato.format(Salida); 
				textFieldFechaSalida.setText(cadenaFecha);
				String aux="";
				float pago;
				pago=Calcularpago(container.listaVehiculos.get(container.cocheActivo).getEntrada(), Salida);
				aux="total: "+pago+" €";
				lblPagar.setText(aux);
				
						}
			   	
						
			
			});
	
		btnCajadeldia.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnRegistrar.isEnabled()) {
					Models.Coche aux = leercoche();
					try {
						container.listaVehiculos.aniadir(aux);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
}
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
	/**
	 * propiedades.
	 */
	private void setComponetProperties(){
		frame.setBounds(100, 100, 645, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnEntradaVehculo.setBounds(59, 30, 129, 99);
		frame.getContentPane().add(btnEntradaVehculo);
		
		btnPagoYSalida.setBounds(215, 30, 169, 99);
		frame.getContentPane().add(btnPagoYSalida);
		
		btnCajadeldia.setBounds(418, 30, 129, 99);
		frame.getContentPane().add(btnCajadeldia);
		
		textFieldMatricula.setBounds(59, 176, 152, 50);
		frame.getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		btnRegistrar.setBounds(59, 270, 152, 58);
		frame.getContentPane().add(btnRegistrar);
		
		textFieldFechaEntrada.setBounds(255, 176, 129, 50);
		frame.getContentPane().add(textFieldFechaEntrada);
		textFieldFechaEntrada.setColumns(10);
		
		textFieldFechaSalida.setBounds(418, 176, 144, 50);
		frame.getContentPane().add(textFieldFechaSalida);
		textFieldFechaSalida.setColumns(10);
		
		lblTotalAPagar.setBounds(306, 270, 83, 16);
		frame.getContentPane().add(lblTotalAPagar);
		
		lblPagar.setBounds(431, 270, 116, 16);
		frame.getContentPane().add(lblPagar);
		
		textFieldimporte.setBounds(431, 319, 116, 22);
		frame.getContentPane().add(textFieldimporte);
		textFieldimporte.setColumns(10);
		
		lblImporteEntregado.setBounds(306, 322, 113, 16);
		frame.getContentPane().add(lblImporteEntregado);
		
		lblCambio.setBounds(306, 378, 56, 16);
		frame.getContentPane().add(lblCambio);
		
		lblCambioNumerico.setBounds(431, 378, 56, 16);
		frame.getContentPane().add(lblCambioNumerico);
		
		btnSalir.setBounds(59, 352, 195, 68);
		frame.getContentPane().add(btnSalir);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		btnSalir = new JButton("Pagar y salir del parking");
		
		
		 btnEntradaVehculo = new JButton("Entrada Veh\u00EDculo");
		
		
		btnPagoYSalida = new JButton("Pago y \r\nSalida \r\nVeh\u00EDculo");
		
		
		btnCajadeldia = new JButton("Caja del d\u00EDa");
		
		
		textFieldMatricula = new JTextField();
		
		btnRegistrar = new JButton("Registrar");
		
		
		textFieldFechaEntrada = new JTextField();
		
		textFieldFechaSalida = new JTextField();
		
		lblTotalAPagar = new JLabel("Total a pagar");
		
		 lblPagar = new JLabel("0,0");
		
		textFieldimporte = new JTextField();
		
		 lblImporteEntregado = new JLabel("Importe Entregado");
		
		lblCambio = new JLabel("Cambio");
		
		lblCambioNumerico = new JLabel("0,0");
		
		
	}
	
	/**
	 * Metodo para iniciar la aplicacion y que la pantalla este limpia.
	 */
	private void Modoinicio(){
		textFieldMatricula.setVisible(false);
		textFieldFechaEntrada.setVisible(false);
	    textFieldFechaSalida.setVisible(false);
		textFieldimporte.setVisible(false);
		btnRegistrar.setVisible(false);
	    lblTotalAPagar.setVisible(false);
		lblPagar.setVisible(false);
		lblImporteEntregado.setVisible(false);
		lblCambio.setVisible(false);
		lblCambioNumerico.setVisible(false);
		btnSalir.setVisible(false);
		
	}
	/**
	 * Deja matricula y boton registrar.
	 */
	private void ModoEntrar(){
		textFieldMatricula.setVisible(true);
		textFieldFechaEntrada.setVisible(false);
	    textFieldFechaSalida.setVisible(false);
		textFieldimporte.setVisible(false);
		btnRegistrar.setVisible(true);
	    lblTotalAPagar.setVisible(false);
		lblPagar.setVisible(false);
		lblImporteEntregado.setVisible(false);
		lblCambio.setVisible(false);
		lblCambioNumerico.setVisible(false);
		btnSalir.setVisible(false);

	}
	private void imprimirCoche(Models.Coche v){		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 		
		String cadenaFecha = formato.format(v.getEntrada()); 
		textFieldFechaEntrada.setText(cadenaFecha);;
		} 
		 
	
	private void ModoPago(){
		textFieldMatricula.setVisible(true);
		textFieldFechaEntrada.setVisible(true);		
	    textFieldFechaSalida.setVisible(true);
		textFieldimporte.setVisible(true);
		btnRegistrar.setVisible(false);
	    lblTotalAPagar.setVisible(true);
		lblPagar.setVisible(true);
		lblImporteEntregado.setVisible(true);
		lblCambio.setVisible(true);
		lblCambioNumerico.setVisible(true);
		btnSalir.setVisible(true);
	
	}
	private Models.Coche leercoche(){
		String Matricula=textFieldMatricula.getText();
		Date fechaentrada=new Date();
		
		return new Models.Coche(Matricula,fechaentrada);
		}
	
	private float Calcularpago(Date uno,Date dos){
		float aux=0.0f;
		int auxmi=0;
		int auxmin=0;
		int tiempototal=0;
		auxmi=uno.getMinutes();
		auxmin=dos.getMinutes();
		
		tiempototal=auxmin-auxmi;
		
		if(tiempototal<30){
			aux=(float) (tiempototal*0.06);
		}else if(tiempototal<60){
			aux=(float) (tiempototal*0.01);
		}else if(tiempototal<720){
			aux=(float) (tiempototal*0.03);
		}else{
			aux=(float) (tiempototal*0.15);
		}		
		return aux;
	}
	
	}


