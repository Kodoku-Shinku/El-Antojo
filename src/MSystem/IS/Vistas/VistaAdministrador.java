package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Controles.ControlProductos;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAdministrador extends JFrame {

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
	public VistaAdministrador(ControlProductos control) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 181);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			ControlAdministracion controlAdmin = new ControlAdministracion(null);
				VE = new VistaEmpleado(controlAdmin);
				VE.setVisible(true);
				
			}
		});
		btnPersonal.setBounds(61, 27, 120, 23);
		layeredPane.add(btnPersonal);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VP = new VistaProductos(control);
				VP.setVisible(true);
			}
		});
		btnProductos.setBounds(61, 79, 120, 23);
		layeredPane.add(btnProductos);
	}
}
