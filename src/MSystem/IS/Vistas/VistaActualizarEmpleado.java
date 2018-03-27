package MSystem.IS.Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Modelo.Empleado;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class VistaActualizarEmpleado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private JPanel contentPane;
	private JTextField telefono;
	private JTextField salario;
	private JTextField apPat;
	private JTextField apMat;
	private JTextField nombre;

	/**
	 * Create the frame.
	 */
	public VistaActualizarEmpleado(ControlAdministracion controlAdmin) {
		
		ArrayList<Empleado> emp = controlAdmin.cargarLista();
		setTitle("Actualizar Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 535);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {}
		
		){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public int getSize() {
				// TODO Auto-generated method stub
				return emp.size();
			}
		});
		
		comboBox.setEditable(true);
		comboBox.addItem("1 - Rosa Guadalupe Toral Maldonado");
		comboBox.setBounds(66, 60, 284, 20);
		contentPane.add(comboBox);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(32, 22, 46, 14);
		contentPane.add(lblEmpleado);
		
		JLabel lblNewLabel = new JLabel("Datos");
		lblNewLabel.setBounds(32, 115, 46, 14);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxDomicilio = new JCheckBox("Domicilio");
		chckbxDomicilio.setBounds(66, 263, 97, 23);
		contentPane.add(chckbxDomicilio);
		
		JCheckBox chckbxTelefono = new JCheckBox("Telefono");
		chckbxTelefono.setBounds(66, 351, 97, 23);
		contentPane.add(chckbxTelefono);
		
		JCheckBox chckbxSalario = new JCheckBox("Salario");
		chckbxSalario.setBounds(66, 397, 97, 23);
		contentPane.add(chckbxSalario);
		
		telefono = new JTextField();
		telefono.setBounds(249, 352, 195, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		salario = new JTextField();
		salario.setColumns(10);
		salario.setBounds(250, 398, 119, 20);
		contentPane.add(salario);
		
		apPat = new JTextField();
		apPat.setBounds(249, 222, 195, 20);
		contentPane.add(apPat);
		apPat.setColumns(10);
		
		apMat = new JTextField();
		apMat.setBounds(249, 179, 195, 20);
		contentPane.add(apMat);
		apMat.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(249, 137, 195, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JCheckBox chckbxNombre = new JCheckBox("Nombre");
		chckbxNombre.setBounds(66, 136, 97, 23);
		contentPane.add(chckbxNombre);
		
		JCheckBox chckbxApellidoMaterno = new JCheckBox("Apellido Materno");
		chckbxApellidoMaterno.setBounds(66, 178, 134, 23);
		contentPane.add(chckbxApellidoMaterno);
		
		JCheckBox chckbxApellidoPaterno = new JCheckBox("Apellido Paterno");
		chckbxApellidoPaterno.setBounds(66, 221, 134, 23);
		contentPane.add(chckbxApellidoPaterno);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(249, 262, 195, 65);
		contentPane.add(textArea);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(227, 454, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(355, 454, 89, 23);
		contentPane.add(btnAceptar);
	}
}
