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
import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Modelo.Producto;

public class VistaLogin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumEmpleado;
	private JTextField textPassword;
	private String noEmpleado = "";
	private ControlVentas controlVent;
	Choice choice = new Choice();
	
	public VistaLogin(ControlAdministracion controlAdmin) {
		ArrayList<Empleado> listaEmpleados = controlAdmin.cargarLista();
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
		//Agregamos un caretListener para que se actualice el textfield sobre cada entrada.
		
		textNumEmpleado.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				//control.recibeUsuario(textUser.getText());
			}
		});
		textNumEmpleado.setBounds(143, 147, 214, 26);
		contentPane.add(textNumEmpleado);
		textNumEmpleado.setColumns(10);
		
		textPassword = new JPasswordField();
		//Agregamos un caretListener para que se actualice el textfield sobre cada entrada
		textPassword.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				//control.recibeContraseña(textPassword.getText());
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
				//Tomamos parámetros para validar.y dependiendo de esto mostramos errores o la ventana siguiente.
				if(choice.getSelectedItem().equals("Selecciona...")) {
					JOptionPane.showMessageDialog(null, "Selecciona tipo de ingreso, por favor");	
				}else if((choice.getSelectedItem().equals("Administrador")) && 
						(listaEmpleados.get(0).getid() == Integer.parseInt((textNumEmpleado.getText())) && 
						(listaEmpleados.get(0).getContrasena().equals(textPassword.getText())))){
						JOptionPane.showMessageDialog(null, "Ingresaste como: Administrador, bienvenido");
						controlAdmin.vistaAdministrador();
					
					}else if(choice.getSelectedItem().equals("Mesero")) {
						JOptionPane.showMessageDialog(null, "Ingresaste como: Mesero, bienvenido");
						}else if(choice.getSelectedItem().equals("Cocinero")) {
							JOptionPane.showMessageDialog(null, "Ingresaste como: Cocinero, bienvenido");
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
