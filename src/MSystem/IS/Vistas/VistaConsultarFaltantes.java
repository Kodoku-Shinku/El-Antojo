package MSystem.IS.Vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Modelo.Pedido;
import MSystem.IS.Modelo.Producto;
import MSystem.IS.Servicios.ServicioProductos;

public class VistaConsultarFaltantes extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable ProductosFal;
	TableModel Tmodel;
	int row,col=0;
	Producto productosf;
	DAOProductos controlDBP = new DAOProductos();
	ServicioProductos servProduct = new ServicioProductos(controlDBP); 
	ControlProductos controlProduct = new ControlProductos(servProduct);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaConsultarFaltantes frame = new VistaConsultarFaltantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaConsultarFaltantes() {
		setTitle("Consultar Faltantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 64, 395, 238);
		contentPane.add(scrollPane);
		
		ArrayList<Producto> ProductosF = controlProduct.ProductosFaltantes();
		
		
		ProductosFal = new JTable();
		
		ProductosFal.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Productos", "Cantidad en Almacen" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] {  String.class, Integer.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}

			public int getRowCount() {
				// TODO Auto-generated method stub
				return ProductosF.size();
			}
		});
		for (int i = 0; i < ProductosF.size(); i++) {
			ProductosFal.setValueAt(ProductosF, i, 1);
			ProductosFal.setValueAt(ProductosF, i, 2);
		}
		ProductosFal.setFocusable(false);
		ProductosFal.getTableHeader().setReorderingAllowed(false);
		ProductosFal.getColumnModel().getColumn(3).setPreferredWidth(107);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
