package MSystem.IS.Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Modelo.Pedido;
import MSystem.IS.Modelo.Platillo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class VistaConsultarMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnAceptar;
	private JButton btnCancelar;
	int cantidad = 0;
	int row = 0;
	int c = 0;
	TableModel modelo;
	Pedido pedido;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public VistaConsultarMenu(ControlVentas controlVent) {
		setTitle("Consultar Menu");

		// Se crea un arreglo con el contenido de la base de datos
		Platillo[] menu = controlVent.mostrarMenu();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 334);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 100, 367, 150);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Precio", "", "Cantidad" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { String.class, Double.class, Boolean.class, Integer.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}

			public int getRowCount() {
				// TODO Auto-generated method stub
				return menu.length;
			}
		});

		// Se agregan los elementos a la tabla
		for (int i = 0; i < menu.length; i++) {
			table.setValueAt(menu[i].getNombrePlatillo(), i, 0);
			table.setValueAt(menu[i].getPrecio(), i, 1);
		}

		table.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				modelo = ((TableModel) (e.getSource()));
				if (e.getType() == TableModelEvent.UPDATE) {
					row = e.getLastRow();
					c = e.getColumn();
					if (c == 2)
						return;
					try {
						cantidad = (Integer) modelo.getValueAt(row, 3);
						pedido = new Pedido(cantidad, menu[row], controlVent.muestraNoMesa());
					} catch (Exception e0) {
						JOptionPane.showMessageDialog(null, "Formato no valido");
					}

				}

			}
		});

		scrollPane.setViewportView(table);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (modelo.getValueAt(row, 2) == null || modelo.getValueAt(row, 3) == null)
						JOptionPane.showMessageDialog(null,
								"Error, existe un campo vacio o no se ha seleccionado un platillo");
					else {
						if (controlVent.agregarPedido(menu[row], cantidad)) {
							JOptionPane.showMessageDialog(null, "Guardado");
						}

						else
							JOptionPane.showMessageDialog(null, "Error al guardar");
					}
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Error, no se puede leer la cantidad");
				}
			}
		});
		btnAceptar.setBounds(314, 261, 89, 23);
		contentPane.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Seguro que deseas Cancelar");

				if(JOptionPane.OK_OPTION == option){
					dispose();	
				}

			}
		});
		btnCancelar.setBounds(180, 261, 89, 23);
		contentPane.add(btnCancelar);

		JLabel lblConsultarMenu = new JLabel("Consultar Menu");
		lblConsultarMenu.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		lblConsultarMenu.setBounds(143, 55, 156, 14);
		contentPane.add(lblConsultarMenu);
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(10, 27, 46, 14);
		contentPane.add(lblMesa);
		
		textField = new JTextField();
		textField.setText(controlVent.muestraNoMesa() + "");
		textField.setEditable(false);
		textField.setBounds(55, 24, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
