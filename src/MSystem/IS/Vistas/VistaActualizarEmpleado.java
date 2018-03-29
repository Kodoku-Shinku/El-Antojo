package MSystem.IS.Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Modelo.Empleado;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JLabel enEmp;
	private JComboBox<String> comboBox;
	private Empleado empl;
	private String campo = "";
	private String name = "";
	private String nValor = "";

	/**
	 * Create the frame.
	 */
	public VistaActualizarEmpleado(ControlAdministracion controlAdmin) {
		
		empl = new Empleado("","","","","","");
		ArrayList<Empleado> emp = controlAdmin.cargarLista();
		setTitle("Actualizar Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 523);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombre = new JTextField();
		nombre.setName("nombre");
		nombre.setEditable(false);
		nombre.setBounds(249, 169, 195, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apPat = new JTextField();
		apPat.setName("apat");
		apPat.setEditable(false);
		apPat.setBounds(249, 212, 195, 20);
		contentPane.add(apPat);
		apPat.setColumns(10);
		
		apMat = new JTextField();
		apMat.setName("amat");
		apMat.setEditable(false);
		apMat.setBounds(249, 256, 195, 20);
		contentPane.add(apMat);
		apMat.setColumns(10);
		
		telefono = new JTextField();
		telefono.setName("tel");
		telefono.setEditable(false);
		telefono.setBounds(249, 387, 195, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setName("domicilio");
		textArea.setEditable(false);
		textArea.setBounds(249, 298, 195, 65);
		contentPane.add(textArea);
		
		JLabel lblNumeroDeEmpleado = new JLabel("Numero de Empleado");
		lblNumeroDeEmpleado.setBounds(66, 138, 134, 14);
		contentPane.add(lblNumeroDeEmpleado);
		
		enEmp = new JLabel("");
		enEmp.setBounds(249, 138, 46, 14);
		contentPane.add(enEmp);
		
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int index = comboBox.getSelectedIndex();
				empl = emp.get(index);
				nombre.setText(empl.getNombre());
				apPat.setText(empl.getApellidoPaterno());
				apMat.setText(empl.getApellidoMaterno());
				telefono.setText(empl.getTelefono());
				textArea.setText(empl.getDireccion());
				enEmp.setText(empl.getid()+"");
			}
		});
//		comboBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(e.getSource() == comboBox){
//					int index = comboBox.getSelectedIndex();
//					empl = emp.get(index);
//					nombre.setText(empl.getNombre());
//					apPat.setText(empl.getApellidoPaterno());
//					apMat.setText(empl.getApellidoMaterno());
//					telefono.setText(empl.getTelefono());
//					textArea.setText(empl.getDireccion());
//					enEmp.setText(empl.getid()+"");
//				}
//			}
//		});
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
		//comboBox.addItem("");
		for(int i = 0; i < emp.size(); i++){
			comboBox.addItem(emp.get(i).getid() + " - " + emp.get(i).getNombre() + " " + emp.get(i).getApellidoPaterno() + " " + emp.get(i).getApellidoMaterno());
		}
		comboBox.setBounds(66, 60, 284, 20);
		contentPane.add(comboBox);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(32, 22, 78, 14);
		contentPane.add(lblEmpleado);
		
		JLabel lblNewLabel = new JLabel("Datos");
		lblNewLabel.setBounds(32, 115, 46, 14);
		contentPane.add(lblNewLabel);
		
		chxDomicilio = new JCheckBox("Domicilio");
		chxDomicilio.setBounds(66, 299, 97, 23);
		chxDomicilio.addItemListener(this);
		contentPane.add(chxDomicilio);
		
		chxTelefono = new JCheckBox("Telefono");
		chxTelefono.setBounds(66, 386, 97, 23);
		chxTelefono.addItemListener(this);
		contentPane.add(chxTelefono);
		
		chxNombre = new JCheckBox("Nombre");
		chxNombre.setBounds(66, 168, 97, 23);
		chxNombre.addItemListener(this);
		contentPane.add(chxNombre);
		
		chxApellidoMaterno = new JCheckBox("Apellido Materno");
		chxApellidoMaterno.setBounds(66, 255, 134, 23);
		chxApellidoMaterno.addItemListener(this);
		contentPane.add(chxApellidoMaterno);
		
		chxApellidoPaterno = new JCheckBox("Apellido Paterno");
		chxApellidoPaterno.setBounds(66, 211, 134, 23);
		chxApellidoPaterno.addItemListener(this);
		contentPane.add(chxApellidoPaterno);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(228, 448, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				
				if(chxNombre.isSelected() == true)
					nValor = nombre.getText();
				if(chxApellidoMaterno.isSelected() == true)
					nValor = apMat.getText();
				if(chxApellidoPaterno.isSelected() == true)
					nValor = apPat.getText();
				if(chxDomicilio.isSelected() == true)
					nValor = textArea.getText();
				if(chxTelefono.isSelected() == true)
					nValor = telefono.getText();
				//if(campo.equals("") || name.equals("") || nValor.equals(""))
					//JOptionPane.showMessageDialog(null, "No ha seleccionado un campo");
				//else{
					if(controlAdmin.actualiza(empl, campo, nValor)){
						JOptionPane.showMessageDialog(null, "Dato " + name + " catualizado correctamente");
						repaint();
					}
					else{
						String error = "Campo "+ name +" excedido o no ha ingresado valores";
						if(campo.equals("tel"))
							error = "Numero de telefono invalido o muy largo";
						JOptionPane.showMessageDialog(null, "Error al actualizar el campo:\n " + error);
					}
				//}
			}
		});
		btnAceptar.setBounds(355, 448, 89, 23);
		contentPane.add(btnAceptar);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(chxNombre.isSelected() == true){
			nombre.setEditable(true);
			campo = nombre.getName();
			name = "Nombre";
		}
		else{
			nombre.setEditable(false);
			//campo = "";
			//nombre.setText("");
		}
		
		if(chxApellidoMaterno.isSelected() == true){
			apMat.setEditable(true);
			campo = apMat.getName();
			name = "Apellido Materno";
		}
		else{
			apMat.setEditable(false);
			//campo = "";
			//apMat.setText("");
		}
		
		if(chxApellidoPaterno.isSelected() == true){
			apPat.setEditable(true);
			campo = apPat.getName();
			name = "Apellido Paterno";
		}
		else{
			apPat.setEditable(false);
			//campo = "";
			//apPat.setText("");
		}
		
		if(chxDomicilio.isSelected() == true){
			textArea.setEditable(true);
			campo = textArea.getName();
			name = "Domicilio";
		}
		else{
			textArea.setEditable(false);
			//campo = "";
			//textArea.setText("");
		}
		
		if(chxTelefono.isSelected() == true){
			telefono.setEditable(true);
			campo = telefono.getName();
			name = "Telefono";
		}
		else{
			telefono.setEditable(false);
			//campo = "";
		//	telefono.setText("");
		}
		
	}
}
