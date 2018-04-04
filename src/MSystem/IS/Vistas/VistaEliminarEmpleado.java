package MSystem.IS.Vistas;

import java.awt.EventQueue;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Datos.DAOAdministracion;
import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Servicios.ServicioAdministracion;
import javafx.scene.control.ComboBox;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VistaEliminarEmpleado extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
	//inicialización
	private JPanel contentPane;
	String noEmpleado;
	Empleado empleado1;
	private ArrayList<Empleado> emp;
	DAOAdministracion controlDBA = new DAOAdministracion();
	ServicioAdministracion servAdmin = new ServicioAdministracion(controlDBA); 
	ControlAdministracion controlAdmin = new ControlAdministracion(servAdmin);
	private JTextField txtNombre,txtAP,txtAM,txtCargo;
	private JComboBox<String> combId;
	
	
	public VistaEliminarEmpleado() {
		setTitle("Eliminar Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 360);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//carga la informacion de la base de datos
		emp = controlAdmin.cargarLista();
		empleado1 = new Empleado("", "", "", "", "", "","");
		
		txtNombre = new JTextField();
		txtNombre.setBounds(89, 88, 228, 20);
		txtNombre.setName("txtNombre");
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtAP = new JTextField();
		txtAP.setBounds(89, 137, 109, 20);
		txtAP.setName("txtAP");
		txtAP.setEditable(false);
		contentPane.add(txtAP);
		txtAP.setColumns(10);
		
		txtAM = new JTextField();
		txtAM.setName("txtAM");
		txtAM.setEditable(false);
		txtAM.setBounds(208, 137, 109, 20);
		contentPane.add(txtAM);
		txtAM.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(91, 198, 226, 20);
		txtCargo.setName("txtCargo");
		txtCargo.setEditable(false);
		contentPane.add(txtCargo);
		txtCargo.setColumns(10);
		
		
		combId = new JComboBox<String>();
		combId.addItemListener(this);
		combId.setModel(new DefaultComboBoxModel<String>(new String[] {}

		) {
			

			public int getSize() {
				// TODO Auto-generated method stub
				return emp.size();
			}
		});
		// comboBox.addItem("");
		//agragacion de datos en el combobox
		for (int i = 0; i < emp.size(); i++) {
			combId.addItem(emp.get(i).getid() + " - " + emp.get(i).getNombre() + " " + emp.get(i).getApellidoPaterno()
					+ " " + emp.get(i).getApellidoMaterno());
		}
		combId.setBounds(66, 60, 284, 20);
		contentPane.add(combId);
		
		JLabel lblNoDeEmpleado = new JLabel("No. de Empleado: ");
		lblNoDeEmpleado.setBounds(26, 38, 102, 20);
		contentPane.add(lblNoDeEmpleado);
		
		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setBounds(26, 88, 68, 20);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(26, 137, 55, 20);
		contentPane.add(lblApellidos);
		
		JLabel lblCargo = new JLabel("Cargo: ");
		lblCargo.setBounds(26, 198, 55, 20);
		contentPane.add(lblCargo);
		
		//ejecucion del boton cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 165, 0));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnCancelar.setBounds(89, 254, 89, 23);
		contentPane.add(btnCancelar);
		
		//ejecución del boton eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 165, 0));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = combId.getSelectedIndex();
				//evalua si hay algun elemento en el combobox para eliminar
				if (index>=0){
					//selecciona el empleado
					empleado1 = emp.get(index);
					int empleado = empleado1.getid();
					
					boolean estado = controlAdmin.eliminarEmpleado(empleado);
					
					if(estado == true){
						JOptionPane.showMessageDialog(null, "¡Empleado eliminado!");
						dispose();
							
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "¡No hay empleados!");
				}
				
			}
		});
		btnEliminar.setBounds(228, 254, 89, 23);
		contentPane.add(btnEliminar);
		
		

	}
	//muesta informacion segun el id seleccionado
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == combId) {
			int index=0;
			index = combId.getSelectedIndex();
			empleado1 = emp.get(index);
			
			txtNombre.setText(empleado1.getNombre());
			txtAP.setText(empleado1.getApellidoPaterno());
			txtAM.setText(empleado1.getApellidoMaterno());
			txtCargo.setText(empleado1.getCargo());
		}

	}
	
	
}