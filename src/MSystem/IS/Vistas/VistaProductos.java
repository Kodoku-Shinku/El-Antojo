package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Modelo.Producto;
import MSystem.IS.Vistas.VistaActProd;
import MSystem.IS.Principal.Principal;
import java.awt.Color;

public class VistaProductos extends JFrame {

	
	private JPanel contentPane;
	VistaActProd VAP;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VistaProductos frame = new VistaProductos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VistaProductos(ControlProductos control) {
		setTitle("Productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 220);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNotificarFaltantes = new JButton("Consultar Faltantes");
		btnNotificarFaltantes.setBackground(new Color(255, 165, 0));
		btnNotificarFaltantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.iniciaConcultFalt();
			}
		});
		btnNotificarFaltantes.setBounds(72, 25, 166, 23);
		layeredPane.add(btnNotificarFaltantes);
		
		JButton btnGeneraLista = new JButton("Generar Lista");
		btnGeneraLista.setBackground(new Color(255, 165, 0));
		btnGeneraLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnGeneraLista){
					control.vistaProductoAgotado();
				}
			}
		});
		btnGeneraLista.setBounds(72, 59, 166, 23);
		layeredPane.add(btnGeneraLista);
		
		JButton btnActualizarProductos = new JButton("Actualizar Productos");
		btnActualizarProductos.setBackground(new Color(255, 165, 0));
		btnActualizarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(evento.getSource() == btnActualizarProductos){		
					control.iniciaActualizarProductos();
				}	
			}
		});
		btnActualizarProductos.setBounds(72, 96, 166, 23);
		layeredPane.add(btnActualizarProductos);
	}

}