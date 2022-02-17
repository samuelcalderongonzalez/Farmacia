package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import models.Medicamento;

public class FarmaciaView {

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfPrincipioActivo;
	private JTextField tfFechaIncorporacion;
	private JTextField tfTipo;
	private JTextField tfPrecio;
	private JTextField tfStock;
	private JLabel lblTitle;
	private JLabel lblStock;
	private JLabel lblName;
	private JLabel lblActivo;
	private JLabel lblFechaIncorporacion;
	private JLabel lblTipo;
	private JLabel lblPrecio;
	private JButton btnPedido;
	private JButton btnVenta;
	private JButton btnActualizar;
	// Necesito un arraylist de medicamentos
	private ArrayList<Medicamento> medicamentos;
	// Índice para navegar entre medicamentos
	private int index;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnGuardar;
	private JButton btnDeshacer;
	private JButton btnCerrar;

	public FarmaciaView(ArrayList<Medicamento> medicamentos) {
		initialize();
		this.medicamentos = medicamentos;
		this.index = 0;
		// Si hay medicamentos, imprime medicamento
		if (this.medicamentos.size() >= 1)
			printMedicamento();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 627, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblTitle = new JLabel("Medicamentos");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(141, 25, 324, 44);
		frame.getContentPane().add(lblTitle);

		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setBounds(207, 113, 266, 20);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);

		tfPrincipioActivo = new JTextField();
		tfPrincipioActivo.setEditable(false);
		tfPrincipioActivo.setColumns(10);
		tfPrincipioActivo.setBounds(207, 142, 266, 20);
		frame.getContentPane().add(tfPrincipioActivo);

		tfFechaIncorporacion = new JTextField();
		tfFechaIncorporacion.setEditable(false);
		tfFechaIncorporacion.setColumns(10);
		tfFechaIncorporacion.setBounds(207, 173, 266, 20);
		frame.getContentPane().add(tfFechaIncorporacion);

		tfTipo = new JTextField();
		tfTipo.setEditable(false);
		tfTipo.setColumns(10);
		tfTipo.setBounds(207, 204, 266, 20);
		frame.getContentPane().add(tfTipo);

		tfPrecio = new JTextField();
		tfPrecio.setEditable(false);
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(207, 235, 266, 20);
		frame.getContentPane().add(tfPrecio);

		tfStock = new JTextField();
		tfStock.setEditable(false);
		tfStock.setHorizontalAlignment(SwingConstants.CENTER);
		tfStock.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tfStock.setBounds(488, 173, 94, 82);
		frame.getContentPane().add(tfStock);
		tfStock.setColumns(10);

		lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStock.setBounds(488, 142, 94, 17);
		frame.getContentPane().add(lblStock);

		lblName = new JLabel("Medicamento");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(10, 114, 95, 17);
		frame.getContentPane().add(lblName);

		lblActivo = new JLabel("Principio Activo");
		lblActivo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblActivo.setBounds(10, 145, 95, 17);
		frame.getContentPane().add(lblActivo);

		lblFechaIncorporacion = new JLabel("Fecha Incorporaci\u00F3n");
		lblFechaIncorporacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaIncorporacion.setBounds(10, 176, 154, 17);
		frame.getContentPane().add(lblFechaIncorporacion);

		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setBounds(10, 205, 95, 17);
		frame.getContentPane().add(lblTipo);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(10, 238, 95, 17);
		frame.getContentPane().add(lblPrecio);

		btnPedido = new JButton("Pedido");
		btnPedido.addActionListener(new ActionListener() {
			/**
			 * Abre la ventana para hacer pedidos y cierra esta
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PedidoView(index, medicamentos);
			}
		});
		btnPedido.setBounds(63, 293, 89, 23);
		frame.getContentPane().add(btnPedido);

		btnVenta = new JButton("Venta");
		btnVenta.addActionListener(new ActionListener() {
			/**
			 * Abre la ventana de ventas siempre y cuando haya stock. En caso contrario,
			 * lanza un aviso de que no queda stock
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				if (medicamentos.get(index).getCantidadActual() > 0) {
					frame.dispose();
					new VentaView(index, medicamentos);
				} else {
					JOptionPane.showMessageDialog(btnVenta, "No queda stock");
				}
			}
		});
		btnVenta.setBounds(181, 293, 89, 23);
		frame.getContentPane().add(btnVenta);

		btnActualizar = new JButton("Editar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleEditar();
			}
		});
		btnActualizar.setBounds(306, 293, 107, 23);
		frame.getContentPane().add(btnActualizar);

		

		btnAtras = new JButton("<");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAtras();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(16, 11, 62, 60);
		frame.getContentPane().add(btnAtras);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printDelante();
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSiguiente.setBounds(539, 11, 62, 58);
		frame.getContentPane().add(btnSiguiente);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setVisible(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				toggleEditar();
			}
		});
		btnGuardar.setBounds(124, 325, 89, 23);
		frame.getContentPane().add(btnGuardar);

		btnDeshacer = new JButton("Atras");
		btnDeshacer.setVisible(false);
		btnDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleEditar();
			}
		});
		btnDeshacer.setBounds(376, 327, 89, 23);
		frame.getContentPane().add(btnDeshacer);

		btnCerrar = new JButton("Cerrar Sesi\u00F3n");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginView();
			}
		});
		btnCerrar.setBounds(441, 293, 132, 23);
		frame.getContentPane().add(btnCerrar);
	}

	/**
	 * Imprime los medicamentos en los textFields sobre la información que contiene
	 * el arrayList de medicamentos
	 */
	private void printMedicamento() {
		if (medicamentos.size() > 0) {
			Medicamento m = medicamentos.get(index);
			tfName.setText(m.getNombre());
			tfPrincipioActivo.setText(m.getPpioActivo());
			tfFechaIncorporacion.setText(m.getFecha());
			tfTipo.setText(m.getTipo());
			tfPrecio.setText(String.valueOf(m.getPrecio()));
			tfStock.setText(String.valueOf(m.getCantidadActual()));
		}
	}

	/**
	 * Imprime el medicamento anterior en el arrayList. Si es el primero, va al
	 * último
	 */
	private void printAtras() {
		index--;
		if (index < 0) {
			index = medicamentos.size() - 1;
		}
		printMedicamento();
	}

	/**
	 * Imprime el medicamento siguiente en el arrayList. Si es el último, va al
	 * primero
	 */
	private void printDelante() {
		index++;
		if (index == medicamentos.size()) {
			index = 0;
		}
		printMedicamento();
	}

	/**
	 * Interruptor para cambiar la visibilidad y editabilidad de botones y
	 * textfields de interés
	 */
	private void toggleEditar() {
		tfName.setEditable(!tfName.isEditable());
		tfPrincipioActivo.setEditable(!tfPrincipioActivo.isEditable());
		tfFechaIncorporacion.setEditable(!tfFechaIncorporacion.isEditable());
		tfTipo.setEditable(!tfTipo.isEditable());
		tfPrecio.setEditable(!tfPrecio.isEditable());
		btnAtras.setVisible(!btnAtras.isVisible());
		btnSiguiente.setVisible(!btnSiguiente.isVisible());
		btnDeshacer.setVisible(!btnDeshacer.isVisible());
		btnGuardar.setVisible(!btnGuardar.isVisible());
		btnActualizar.setVisible(!btnActualizar.isVisible());
		btnPedido.setVisible(!btnPedido.isVisible());
		btnVenta.setVisible(!btnVenta.isVisible());
		
		medicamentos.get(index).setNombre(tfName.getText());
		medicamentos.get(index).setPpioActivo(tfPrincipioActivo.getText());
		medicamentos.get(index).setFecha(tfFechaIncorporacion.getText());
		medicamentos.get(index).setTipo(tfTipo.getText());
		medicamentos.get(index).setPrecio(Double.parseDouble(tfPrecio.getText()));
		medicamentos.get(index).setCantidadActual(Integer.parseInt(tfStock.getText()));







		printMedicamento();
	}

	

}
