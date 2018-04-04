package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Datos.DAOAdministracion;
import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Servicios.ServicioAdministracion;
import MSystem.IS.Servicios.ServicioProductos;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class VistaAdministrador extends JFrame {
	
	DAOAdministracion controlDBAdmin = new DAOAdministracion();
	ServicioAdministracion servAdmin = new ServicioAdministracion(controlDBAdmin);
	ControlAdministracion controlAdmin = new ControlAdministracion(servAdmin);
	DAOProductos controlDBProd = new DAOProductos();
	ServicioProductos servProd = new ServicioProductos(controlDBProd); 
	ControlProductos controlProd = new ControlProductos(servProd);


	private JPanel contentPane;
	
	VistaProductos VP;
	VistaEmpleado VE;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VistaAdministrador frame = new VistaAdministrador();
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
	public VistaAdministrador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaAdministrador.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setResizable(false);
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 181);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.setBackground(new Color(255, 165, 0));
		btnPersonal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				VE = new VistaEmpleado(controlAdmin);
				VE.setVisible(true);
				
			}
		});
		btnPersonal.setBounds(61, 27, 120, 23);
		layeredPane.add(btnPersonal);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setBackground(new Color(255, 165, 0));
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VP = new VistaProductos(controlProd);
				VP.setVisible(true);
			}
		});
		btnProductos.setBounds(61, 79, 120, 23);
		layeredPane.add(btnProductos);
	}
}
