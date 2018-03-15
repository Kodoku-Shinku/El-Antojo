package MSystem.IS.Vistas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Modelo.Producto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaNotificarFaltantes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private JPanel contentPane;
	private JTable table;

	int row = 0;
	int colum = 0;
	double cantidad = 0;
	TableModel modelo;
	ArrayList<Producto> listaProdFalt = new ArrayList<Producto>();

	/**
	 * Create the frame.
	 */
	public VistaNotificarFaltantes(ControlProductos controlProd) {
		// Se crea un arreglo con el contenido de la tabla ProductosCocina
		ArrayList<Producto> lista = controlProd.cargaLista();
		if (lista == null)
			JOptionPane.showMessageDialog(null, "No se puede cargar la base de datos");
		else {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(86, 29, 264, 146);
			contentPane.add(scrollPane);

			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Ingredientes", "", "Cantidad" }) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 3L;
				Class<?>[] columnTypes = new Class[] { String.class, Boolean.class, Double.class };

				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { false, true, true };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}

				public int getRowCount() {
					return lista.size();
				}
			});

			for (int i = 0; i < lista.size(); i++)
				table.setValueAt(lista.get(i).getNombreProducto(), i, 0);
			table.getModel().addTableModelListener(new TableModelListener() {

				@Override
				public void tableChanged(TableModelEvent e) {
					modelo = ((TableModel) (e.getSource()));
					if (e.getType() == TableModelEvent.UPDATE) {
						row = e.getLastRow();
						colum = e.getColumn();
						if (colum == 1)
							return;
						
						// Verifica, si no hay un platillo seleccionado marca error
						if (modelo.getValueAt(row, 1) == null)
							JOptionPane.showMessageDialog(null, "Seleccione el platillo escogido");
						
						// Por default, la casilla se pone roja si lo ingresado no es un doble
						cantidad = (double) modelo.getValueAt(row, 2);
						lista.get(row).setCantidadProdcuto(cantidad);
						listaProdFalt.add(lista.get(row));
					}

				}
			});

			scrollPane.setViewportView(table);

			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(null, "Seguro que deseas Cancelar");

					if (option == JOptionPane.OK_OPTION) {
						listaProdFalt.removeAll(listaProdFalt);
						dispose();
					}
				}
			});
			btnCancelar.setBounds(189, 227, 89, 23);
			contentPane.add(btnCancelar);

			JButton btnEnviar = new JButton("Aceptar");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (listaProdFalt.size() == 0)
						JOptionPane.showMessageDialog(null, "No hay productos seleccionados. \n\r Seleccione uno y escriba la cantidad existente");
					else {
						if (controlProd.guardaFaltantes(listaProdFalt)) {
							JOptionPane.showMessageDialog(null,
									"Se han enviado " + listaProdFalt.size() + " productos al administrador");
							System.exit(DISPOSE_ON_CLOSE);
						} else
							JOptionPane.showMessageDialog(null, "No se pueden cargar los productos");
					}

				}

			});
			btnEnviar.setBounds(317, 227, 89, 23);
			contentPane.add(btnEnviar);
		}
	}
}
