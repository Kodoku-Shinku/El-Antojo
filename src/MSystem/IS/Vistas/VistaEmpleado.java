package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Controles.ControlProductos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;

public class VistaEmpleado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VistaEmpleado frame = new VistaEmpleado();
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
	public VistaEmpleado(ControlAdministracion controlAdmin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
		btnAgregarEmpleado.setBounds(133, 49, 170, 23);
		btnAgregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnAgregarEmpleado){
					controlAdmin.muestraVentanaAgregarEmpleado();
				}
				
			}
		});
		layeredPane.setLayout(null);
		layeredPane.add(btnAgregarEmpleado);
		
		JButton btnActualizarEmpleado = new JButton("Actualizar Empleado");
		btnActualizarEmpleado.setBounds(133, 103, 170, 23);
		layeredPane.add(btnActualizarEmpleado);
		
		JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");
		btnEliminarEmpleado.setBounds(133, 158, 170, 23);
		layeredPane.add(btnEliminarEmpleado);
	}

		}
	
