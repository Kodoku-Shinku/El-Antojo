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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaActualizarEmpleado extends JFrame implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private JPanel contentPane;
	private JTextField telefono;
	private JTextField apPat;
	private JTextField apMat;
	private JTextField nombre;
	private JCheckBox chxNombre;
	private JCheckBox chxApellidoMaterno;
	private JCheckBox chxApellidoPaterno;
	private JCheckBox chxDomicilio;
	private JCheckBox chxTelefono;
	private JTextArea textArea;
	private JComboBox<String> comboBox;
	private Empleado empl;

	/**
	 * Create the frame.
	 */
	public VistaActualizarEmpleado(ControlAdministracion controlAdmin) {
		
		ArrayList<Empleado> emp = controlAdmin.cargarLista();
		empl = new Empleado("","","","","","");
		setTitle("Actualizar Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 505);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		telefono = new JTextField();
		telefono.setName("tel");
		telefono.setEditable(false);
		telefono.setBounds(249, 352, 195, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		apPat = new JTextField();
		apPat.setName("apat");
		apPat.setEditable(false);
		apPat.setBounds(249, 179, 195, 20);
		contentPane.add(apPat);
		apPat.setColumns(10);
		
		apMat = new JTextField();
		apMat.setName("amat");
		apMat.setEditable(false);
		apMat.setBounds(249, 222, 195, 20);
		contentPane.add(apMat);
		apMat.setColumns(10);
		
		nombre = new JTextField();
		nombre.setName("nombre");
		nombre.setEditable(false);
		nombre.setBounds(249, 137, 195, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setName("domicilio");
		textArea.setEditable(false);
		textArea.setBounds(249, 262, 195, 65);
		contentPane.add(textArea);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBox){
					int index = comboBox.getSelectedIndex();
					empl = emp.get(index);
					nombre.setText(empl.getNombre());
					apMat.setText(empl.getApellidoMaterno());
					
				}
			}
		});
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
		comboBox.addItem("");
		for(int i = 0; i < emp.size(); i++){
			comboBox.addItem(emp.get(i).getid() + " - " + emp.get(i).getNombre() + " " + emp.get(i).getApellidoPaterno() + " " + emp.get(i).getApellidoMaterno());
		}
		comboBox.setBounds(66, 60, 284, 20);
		contentPane.add(comboBox);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(32, 22, 46, 14);
		contentPane.add(lblEmpleado);
		
		JLabel lblNewLabel = new JLabel("Datos");
		lblNewLabel.setBounds(32, 115, 46, 14);
		contentPane.add(lblNewLabel);
		
		chxDomicilio = new JCheckBox("Domicilio");
		chxDomicilio.setBounds(66, 263, 97, 23);
		chxDomicilio.addItemListener(this);
		contentPane.add(chxDomicilio);
		
		chxTelefono = new JCheckBox("Telefono");
		chxTelefono.setBounds(66, 351, 97, 23);
		chxTelefono.addItemListener(this);
		contentPane.add(chxTelefono);
		
		chxNombre = new JCheckBox("Nombre");
		chxNombre.setBounds(66, 136, 97, 23);
		chxNombre.addItemListener(this);
		contentPane.add(chxNombre);
		
		chxApellidoMaterno = new JCheckBox("Apellido Materno");
		chxApellidoMaterno.setBounds(66, 221, 134, 23);
		chxApellidoMaterno.addItemListener(this);
		contentPane.add(chxApellidoMaterno);
		
		chxApellidoPaterno = new JCheckBox("Apellido Paterno");
		chxApellidoPaterno.setBounds(66, 178, 134, 23);
		chxApellidoPaterno.addItemListener(this);
		contentPane.add(chxApellidoPaterno);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(228, 417, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Empleado empl = null;
//				String campo = null;
//				String nValor = null;
//				boolean cierto = controlAdmin.actualiza(emp, campo, nValor);
				System.out.println("nombre: " + nombre.getName());
				System.out.println("Hola");
			}
		});
		btnAceptar.setBounds(355, 417, 89, 23);
		contentPane.add(btnAceptar);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(chxNombre.isSelected() == true)
			nombre.setEditable(true);
		else
			nombre.setEditable(false);
		
		if(chxApellidoMaterno.isSelected() == true)
			apMat.setEditable(true);
		else
			apMat.setEditable(false);
		
		if(chxApellidoPaterno.isSelected() == true)
			apPat.setEditable(true);
		else
			apPat.setEditable(false);
		
		if(chxDomicilio.isSelected() == true)
			textArea.setEditable(true);
		else
			textArea.setEditable(false);
		
		if(chxTelefono.isSelected() == true)
			telefono.setEditable(true);
		else
			telefono.setEditable(false);
		
	}
}
