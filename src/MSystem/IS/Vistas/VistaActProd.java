package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Modelo.Producto;
import javax.swing.JButton;

public class VistaActProd extends JFrame {

	
	TableModel modelo;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VistaActProd frame = new VistaActProd();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VistaActProd(ControlProductos muestraProdAdmin) {
		
		ArrayList<Producto> devuelveProd = muestraProdAdmin.muestraProdAdmin();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 329);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 11, 339, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Producto", "Cantidad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			//Metodo que muestra la cantidad de filas dependiendo de cuantos productos existan
			public int getRowCount(){
				return devuelveProd.size(); 
			}
		});
		
		for(int i=0; i < devuelveProd.size(); i++ ){
			table.setValueAt(devuelveProd.get(i).getNombreProducto(), i, 0);
			table.setValueAt(devuelveProd.get(i).getCantidadProducto(), i, 1);
		}
		
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				modelo = ((TableModel)(e.getSource()));
				if(e.getType() == TableModelEvent.UPDATE){
					int row = e.getFirstRow();
					String nombre = ((String)modelo.getValueAt(row,0));
					
					double cantidad = ((double)modelo.getValueAt(row,1));
					muestraProdAdmin.actualizaProd(cantidad,devuelveProd.get(row));
				
				}
				
			}
		});
		
		scrollPane.setViewportView(table);
	}
}