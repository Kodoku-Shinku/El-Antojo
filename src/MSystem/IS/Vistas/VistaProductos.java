package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MSystem.IS.Controles.ControlProductos;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaProductos extends JFrame {

	private JPanel contentPane;
	private ControlProductos controlProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaProductos frame = new VistaProductos();
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
	public VistaProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JButton btnConsultarFaltantes = new JButton("Consultar Faltantes");
		btnConsultarFaltantes.setBounds(125, 25, 148, 23);
		layeredPane.add(btnConsultarFaltantes);
		btnConsultarFaltantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlProd.iniciaConsultarF();
				dispose();
				
			}
		});
		
		JButton btnNewButton = new JButton("Generar Lista");
		btnNewButton.setBounds(125, 98, 148, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnActualizarProductos = new JButton("Actualizar Productos");
		btnActualizarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizarProductos.setBounds(125, 165, 148, 23);
		layeredPane.add(btnActualizarProductos);
	}

}
