package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import models.Medicamento;
import models.User;

public class LoginView {

	private JFrame frame;
	private JPasswordField pfPassword;
	private JLabel lblTitle;
	private JButton btnAccess;
	private ArrayList<Medicamento> medicamentos;

	public LoginView() {
		medicamentos = new ArrayList<Medicamento>();
		medicamentos.add(new Medicamento(0, "Paracetamol", "Analgésico", "2020-02-03", "Pastilla", 8, 6.5));
		medicamentos.add(new Medicamento(0, "Ibuprofeno", "Analgésico", "2017-09-07", "Píldora", 3, 10));
		medicamentos.add(new Medicamento(0, "Aspirina", "Aspirina", "2015-04-07", "Pastilla", 5, 2));

		initialize();
		frame.revalidate();
		frame.repaint();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		pfPassword = new JPasswordField();
		pfPassword.setBounds(121, 121, 165, 20);
		frame.getContentPane().add(pfPassword);

		lblTitle = new JLabel("Introduzca un PIN");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(69, 11, 272, 51);
		frame.getContentPane().add(lblTitle);

		btnAccess = new JButton("Acceder");
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarLogin();
			}
		});
		btnAccess.setBounds(158, 201, 89, 23);
		frame.getContentPane().add(btnAccess);
		// Con esta línea se activa el btnAccess cada vez que pulsas "ENTER". Es más
		// rápido que hacer el key listener
		frame.getRootPane().setDefaultButton(btnAccess);
	}
	
	private void comprobarLogin() {
		User usuario = new User();
		if (usuario.getPin().equals("6969")) {
			JOptionPane.showMessageDialog(btnAccess, "Acceso concedido");
			new FarmaciaView(medicamentos);
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(btnAccess, "PIN incorrecto");
		}
	}
}
