package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Datos.DatabaseException;
import MSystem.IS.Modelo.Empleado;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Toolkit;

public class VistaAgregarEmpleado extends JFrame {
	
	
	ControlAdministracion controlAdmin;

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField amat;
	private JTextField apat;
	private JTextField direc;
	private JTextField tel;
	private JTextField cargo;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// vistaAgregarEmpleado frame = new vistaAgregarEmpleado();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public VistaAgregarEmpleado(ControlAdministracion controlAdmin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaAgregarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setTitle("Agregar Personal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 43, 125, 14);
		layeredPane.add(lblNombre);

		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(10, 68, 125, 14);
		layeredPane.add(lblApellidoPaterno);

		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(10, 95, 125, 14);
		layeredPane.add(lblApellidoMaterno);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 124, 125, 14);
		layeredPane.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 149, 125, 14);
		layeredPane.add(lblTelefono);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 177, 125, 14);
		layeredPane.add(lblCargo);

		nombre = new JTextField();
		nombre.setBounds(188, 40, 125, 20);
		layeredPane.add(nombre);
		nombre.setColumns(10);

		amat = new JTextField();
		amat.setBounds(188, 92, 125, 20);
		layeredPane.add(amat);
		amat.setColumns(10);

		apat = new JTextField();
		apat.setBounds(188, 65, 125, 20);
		layeredPane.add(apat);
		apat.setColumns(10);

		direc = new JTextField();
		direc.setBounds(188, 121, 125, 20);
		layeredPane.add(direc);
		direc.setColumns(10);

		tel = new JTextField();
		tel.setBounds(188, 146, 125, 20);
		layeredPane.add(tel);
		tel.setColumns(10);

		cargo = new JTextField();
		cargo.setBounds(188, 174, 125, 20);
		layeredPane.add(cargo);
		cargo.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// almacena los datos recibidos en la textbox de la ventana

				String Nombre = "";
				String ApellidoPaterno = "";
				String ApellidoMaterno = "";
				String Direccion = "";
				String Telefono = "";
				String Cargo = "";

				Empleado emple;

				if (e.getSource() == btnAceptar) {

					Nombre = nombre.getText();
					ApellidoPaterno = apat.getText();
					ApellidoMaterno = amat.getText();
					Direccion = direc.getText();
					Telefono = tel.getText();
					Cargo = cargo.getText();

					// validacion de que los campos se encuentren totalmente
					// llenos RNF
					if (Nombre.equals("") || ApellidoPaterno.equals("") || ApellidoMaterno.equals("")
							|| Direccion.equals("") || Telefono.equals("") || Cargo.equals("")) {
						int option = JOptionPane.showConfirmDialog(null,"Algunos Campos Se Encuentran Vacios\n "
																			+ "¿Deseas Continuar Con El Llenado?");

						if (JOptionPane.CLOSED_OPTION == option) {
							dispose();					
						}
						
						if (JOptionPane.NO_OPTION == option) {
							dispose();
							
						}
					}

					else {
						emple = new Empleado(Nombre, ApellidoPaterno, ApellidoMaterno, Direccion, Telefono, Cargo);
						
							if (controlAdmin.agregarEmpleado(emple)== true) {
							
								JOptionPane.showMessageDialog(null, "Empleado Agregado Exitosamente");
								setVisible(false);
							}

							}
				}
			}
		});
		btnAceptar.setBounds(242, 218, 89, 23);
		layeredPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCancelar) {
					int option = JOptionPane.showConfirmDialog(null, "seguro que deseas cancelar");

					if (JOptionPane.OK_OPTION == option) {
						dispose();
					}
				}
			}
		});
		btnCancelar.setBounds(68, 218, 89, 23);
		layeredPane.add(btnCancelar);
		

	}
}


	
	