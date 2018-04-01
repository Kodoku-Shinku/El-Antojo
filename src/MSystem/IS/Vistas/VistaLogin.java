package MSystem.IS.Vistas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Datos.DAOAdministracion;
import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Datos.DAOVentas;
import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Modelo.Producto;
import MSystem.IS.Servicios.ServicioAdministracion;
import MSystem.IS.Servicios.ServicioProductos;
import MSystem.IS.Servicios.ServicioVentas;

public class VistaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumEmpleado;
	private JTextField textPassword;
	private String noEmpleado = "";
	Choice choice = new Choice();

	private DAOVentas controlDBV = new DAOVentas();
	private ServicioVentas servVent = new ServicioVentas(controlDBV);
	private ControlVentas controlVent = new ControlVentas(servVent);
	private DAOProductos controlDBProd = new DAOProductos();
	private ServicioProductos servProd = new ServicioProductos(controlDBProd);
	private ControlProductos controlProd = new ControlProductos(servProd);
	private DAOAdministracion controlDBAdmin = new DAOAdministracion();
	private ServicioAdministracion servAdmin = new ServicioAdministracion(controlDBAdmin);
	private ControlAdministracion controlAdmin = new ControlAdministracion(servAdmin);

	public VistaLogin() {
		// ArrayList<Empleado> listaEmpleados = controlAdmin.cargarLista();
		setTitle("Ventana Principal");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 472, 346);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblElAntojo = new JLabel("El Antojo");
		lblElAntojo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblElAntojo.setBounds(193, 10, 108, 19);
		contentPane.add(lblElAntojo);

		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(18, 27, 100, 100);
		contentPane.add(lblIcon);
		ImageIcon imgIcon = new ImageIcon(VistaLogin.class.getResource("/MSystem/IS/Vistas/el_antojo.png"));
		Image user = imgIcon.getImage();
		Image userScaled = user.getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
		imgIcon = new ImageIcon(userScaled);
		lblIcon.setIcon(imgIcon);

		textNumEmpleado = new JTextField();
		// Agregamos un caretListener para que se actualice el textfield sobre
		// cada entrada.

		textNumEmpleado.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				// control.recibeUsuario(textUser.getText());
			}
		});
		textNumEmpleado.setBounds(143, 147, 214, 26);
		contentPane.add(textNumEmpleado);
		textNumEmpleado.setColumns(10);

		textPassword = new JPasswordField();
		// Agregamos un caretListener para que se actualice el textfield sobre
		// cada entrada
		textPassword.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				// control.recibeContraseña(textPassword.getText());
			}
		});
		textPassword.setBounds(143, 197, 214, 26);
		contentPane.add(textPassword);
		textPassword.setColumns(10);

		JLabel lblNumEmpleado = new JLabel("Num. Empleado");
		lblNumEmpleado.setBounds(28, 152, 103, 16);
		contentPane.add(lblNumEmpleado);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(28, 202, 71, 16);
		contentPane.add(lblPassword);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tomamos parámetros para validar.y dependiendo de esto
				// mostramos errores o la ventana siguiente.

				if (choice.getSelectedItem().equals("Selecciona...")) {
					JOptionPane.showMessageDialog(null, "Selecciona tipo de ingreso, por favor");
				} else {
					try {
						String contrasena = textPassword.getText();
						String auxno = textNumEmpleado.getText();
						int noEmpleado = Integer.parseInt(auxno);
						Empleado empleado = controlAdmin.ingresarAlSistema(contrasena, noEmpleado);
						if (empleado == null) {
							JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos");
						} else {
							if ((choice.getSelectedItem().equals("Administrador"))
									&& (empleado.getCargo().equals("Administrador"))) {

								JOptionPane.showMessageDialog(null, "Ingresaste como: Administrador, bienvenido");
								controlProd.VistaAdministrador1();

							} else if (choice.getSelectedItem().equals("Mesero")
									&& (empleado.getCargo().equals("Mesero"))) {
								JOptionPane.showMessageDialog(null, "Ingresaste como: Mesero, bienvenido");
								controlVent.iniciaSeleccionarMesa();
							} else if (choice.getSelectedItem().equals("Cocinero")
									&& (empleado.getCargo().equals("Cocinero"))) {
								JOptionPane.showMessageDialog(null, "Ingresaste como: Cocinero, bienvenido");
								controlVent.inicia();
							} else
								JOptionPane.showMessageDialog(null, "El empleado no coincide con el cargo asignado");
						}
					} catch (NumberFormatException error2) {
						JOptionPane.showMessageDialog(null, "Formato de numero de empleado incorrecto");
					}

				}
			}
		});
		btnIngresar.setBounds(326, 245, 117, 29);
		contentPane.add(btnIngresar);

		choice.setForeground(Color.BLACK);
		choice.setBounds(200, 74, 130, 20);
		contentPane.add(choice);
		choice.addItem("Selecciona...");
		choice.addItem("Administrador");
		choice.addItem("Mesero");
		choice.addItem("Cocinero");

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(159, 74, 61, 16);
		contentPane.add(lblCargo);
	}

}
