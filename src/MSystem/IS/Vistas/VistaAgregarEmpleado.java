package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Modelo.Empleado;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;



public class VistaAgregarEmpleado extends JFrame {

	ControlAdministracion controlAdmin;

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField amat;
	private JTextField apat;
	private JTextField direc;
	private JTextField tel;
	private JTextField cargo;
	private JTextField contrasena;

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
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaAgregarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setTitle("Agregar Personal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 387, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JLabel lblPersonal = new JLabel("DATOS PERSONAL");
		lblPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPersonal.setBounds(76, 11, 209, 20);
		layeredPane.add(lblPersonal);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 45, 125, 14);
		layeredPane.add(lblNombre);

		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(10, 70, 125, 14);
		layeredPane.add(lblApellidoPaterno);

		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(10, 95, 125, 14);
		layeredPane.add(lblApellidoMaterno);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 120, 125, 14);
		layeredPane.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 145, 125, 14);
		layeredPane.add(lblTelefono);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 166, 125, 20);
		layeredPane.add(lblCargo);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(10, 197, 125, 14);
		layeredPane.add(lblContrasena);

		nombre = new JTextField();
		nombre.setBounds(188, 42, 125, 20);
		layeredPane.add(nombre);
		nombre.setColumns(10);

		amat = new JTextField();
		amat.setBounds(188, 92, 125, 20);
		layeredPane.add(amat);
		amat.setColumns(10);

		apat = new JTextField();
		apat.setBounds(188, 67, 125, 20);
		layeredPane.add(apat);
		apat.setColumns(10);

		direc = new JTextField();
		direc.setBounds(188, 117, 125, 20);
		layeredPane.add(direc);
		direc.setColumns(10);

		tel = new JTextField();
		tel.setBounds(188, 142, 125, 20);
		layeredPane.add(tel);
		tel.setColumns(10);

		cargo = new JTextField();
		cargo.setBounds(188, 166, 125, 20);
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
				String Contrasena = "";

				Empleado emple;

				if (e.getSource() == btnAceptar) {

					Nombre = nombre.getText();
					ApellidoPaterno = apat.getText();
					ApellidoMaterno = amat.getText();
					Direccion = direc.getText();
					Telefono = tel.getText();
					Cargo = cargo.getText();
					Contrasena = contrasena.getText();

					// validacion de que los campos se encuentren totalmente
					// llenos RNF
					if (Nombre.equals("") || ApellidoPaterno.equals("") || ApellidoMaterno.equals("")
							|| Direccion.equals("") || Telefono.equals("") || Cargo.equals("")
							|| Contrasena.equals("")) {
						int option = JOptionPane.showConfirmDialog(null,
								"Algunos Campos Se Encuentran Vacios\n " + "¿Deseas Continuar Con El Llenado?");

						if (JOptionPane.CLOSED_OPTION == option) {
							dispose();
						}

						if (JOptionPane.NO_OPTION == option) {
							dispose();

						}
					}

					else {
						emple = new Empleado(Nombre, ApellidoPaterno, ApellidoMaterno, Direccion, Telefono, Cargo, Contrasena);

						if (controlAdmin.agregarEmpleado(emple) == true) {

							JOptionPane.showMessageDialog(null, "Empleado Agregado Exitosamente");
							setVisible(false);
						}

					}
				}
			}
		});

		contrasena = new JTextField();
		contrasena.setBounds(188, 192, 125, 20);
		layeredPane.add(contrasena);
		contrasena.setColumns(10);
		btnAceptar.setBounds(224, 237, 89, 23);
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
		btnCancelar.setBounds(60, 237, 89, 23);
		layeredPane.add(btnCancelar);

	}
}
