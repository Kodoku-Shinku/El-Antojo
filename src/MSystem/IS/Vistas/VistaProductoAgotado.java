package MSystem.IS.Vistas;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Modelo.Producto;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaProductoAgotado extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private JTable tableProductoAgotado;
	private JPanel contentPane;
	
	
	public VistaProductoAgotado(ControlProductos controlProd) {
		
		ArrayList<Producto> listaExistencias = controlProd.muestraListaAgotados();
		
		setTitle("Producto Agotado");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaProductoAgotado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 400, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblProductoAgotado = new JLabel("Productos Agotados");
		lblProductoAgotado.setBounds(123, 14, 127, 16);
		layeredPane.add(lblProductoAgotado);
		
		JScrollPane scrollPaneProductoAgotado = new JScrollPane();
		scrollPaneProductoAgotado.setBounds(26, 42, 338, 201);
		layeredPane.add(scrollPaneProductoAgotado);
		
		tableProductoAgotado = new JTable();
		tableProductoAgotado.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Producto", "Existencias"}) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { String.class, String.class};
			
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] columnEditables = new boolean[] { false, false };
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			public int getRowCount() {
				// TODO Auto-generated method stub
				
				return listaExistencias.size();

			}		
			
		});
		
		try{
			for (int i = 0; i < listaExistencias.size(); i++) {
//				System.out.println(listaExistencias.get(i).getNombreProducto());
//				System.out.println("Tamaño: "+listaExistencias.size());
//				System.out.println("Cantidad: "+listaExistencias.get(i).getCantidadProducto());
				tableProductoAgotado.setValueAt(listaExistencias.get(i).getNombreProducto(), i, 0);
				tableProductoAgotado.setValueAt("Agotado", i, 1);
				
			}
		}catch (Exception e){
			if(listaExistencias.isEmpty()){
				JOptionPane.showMessageDialog(null, "No hay productos agotados");
				dispose();
			}
			
		}
		
		scrollPaneProductoAgotado.setViewportView(tableProductoAgotado);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Seguro que deseas Cancelar");

				if(JOptionPane.OK_OPTION == option){
					dispose();	
				}
			}
		});
		btnCancelar.setBounds(179, 270, 98, 29);
		layeredPane.add(btnCancelar);
				
	}

}