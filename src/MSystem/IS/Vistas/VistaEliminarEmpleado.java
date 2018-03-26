package MSystem.IS.Vistas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Modelo.Producto;
import MSystem.IS.Servicios.ServicioProductos;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaEliminarEmpleado extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel Tmodel;
	int row,col=0;
	Producto productosf;
	DAOProductos controlDBP = new DAOProductos();
	ServicioProductos servProduct = new ServicioProductos(controlDBP); 
	ControlProductos controlProduct = new ControlProductos(servProduct);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEliminarEmpleado frame = new VistaEliminarEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaEliminarEmpleado() {
		setTitle("Eliminar Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 360);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(138, 38, 160, 20);
		contentPane.add(comboBox);
		
		JLabel lblNoDeEmpleado = new JLabel("No. de Empleado: ");
		lblNoDeEmpleado.setBounds(26, 38, 102, 20);
		contentPane.add(lblNoDeEmpleado);
		
		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setBounds(26, 88, 68, 20);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(89, 88, 228, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(26, 137, 55, 20);
		contentPane.add(lblApellidos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 137, 109, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(208, 137, 109, 20);
		contentPane.add(textField_2);
		
		JLabel lblCargo = new JLabel("Cargo: ");
		lblCargo.setBounds(26, 198, 55, 20);
		contentPane.add(lblCargo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(91, 198, 226, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(89, 254, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(228, 254, 89, 23);
		contentPane.add(btnEliminar);
		
		

	}
}
