package MSystem.IS.Vistas;

import java.awt.EventQueue;
import java.awt.Toolkit;
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
import java.awt.Color;

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
	
	public VistaConsultarFaltantes() {
		setTitle("Consultar Faltantes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 64, 340 , 238);
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
			ProductosFal.setValueAt(ProductosF.get(i).getNombreProducto(), i, 0);
			ProductosFal.setValueAt(ProductosF.get(i).getCantidadProducto(), i, 1);
		}
		ProductosFal.setFocusable(false);
		ProductosFal.getTableHeader().setReorderingAllowed(false);
		ProductosFal.getColumnModel().getColumn(1).setPreferredWidth(107);
		scrollPane.setViewportView(ProductosFal);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAceptar.setBackground(new Color(255, 165, 0));
		btnAceptar.setBounds(295, 366, 89, 23);
		contentPane.add(btnAceptar);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}