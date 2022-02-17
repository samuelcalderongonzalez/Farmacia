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

public class PedidoView {

	private JFrame frame;
	private JTextField tfPedidos;
	private JButton btnAtras;
	private JButton btnConfirmar;
	private JLabel lblTitle;
	private ArrayList<Medicamento> medicamentos;
	private int index;

	/**
	 * En el constructor recibo un entero que voy a usar para saber a qué
	 * medicamento he de añadirle stock.
	 * 
	 * @param index
	 */
	public PedidoView(int index, ArrayList<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
		this.index = index;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblTitle = new JLabel("\u00BFCu\u00E1ntos pedidos quiere hacer?");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(38, 24, 348, 41);
		frame.getContentPane().add(lblTitle);

		tfPedidos = new JTextField();
		tfPedidos.setBounds(157, 103, 86, 20);
		frame.getContentPane().add(tfPedidos);
		tfPedidos.setColumns(10);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			/**
			 * Método que suma la cantidad introducida en el tf a la ya existente y la
			 * guarda en la bbdd. Posteriormente se cierra la ventana y se vuelve a la
			 * farmacia. Todo esto siempre y cuando el tf no esté vacío.
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				String pedido = tfPedidos.getText();
				if (pedido.isEmpty()) {
					JOptionPane.showMessageDialog(btnConfirmar, "El campo está vacío");
				} else {
					if (Integer.parseInt(tfPedidos.getText()) <= 0)
						JOptionPane.showMessageDialog(btnConfirmar, "El número introducido debe ser positivo");
					else {
						medicamentos.get(index).aumentarCantidadActual(Integer.parseInt(pedido));
						frame.dispose();
						new FarmaciaView(medicamentos);
					}
				}
			}
		});
		btnConfirmar.setBounds(86, 179, 102, 23);
		frame.getContentPane().add(btnConfirmar);

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new FarmaciaView(medicamentos);
			}
		});
		btnAtras.setBounds(238, 179, 89, 23);
		frame.getContentPane().add(btnAtras);
	}

}
