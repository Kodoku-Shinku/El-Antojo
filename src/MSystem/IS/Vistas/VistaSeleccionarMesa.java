package MSystem.IS.Vistas;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Modelo.Platillo;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class VistaSeleccionarMesa extends JFrame {
	/**
	 * Creación de la ventana seleccionar mesa, una tabla para pedidos realizados
	 * por el cliente y otra tabla para mostrar los pedidos terminados por el cocinero
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePedidosTerminados;
	private JTable tablePedidosPorMesa;
	
	public VistaSeleccionarMesa(ControlVentas controlVent) {
		setTitle("Seleccionar Mesa");
		
		// Se crea un arreglo con el contenido de la base de datos
		//Platillo[] menu = controlVent.mostrarMenu();
		
		getContentPane().setLayout(null);
		
		JButton btnMesa_1 = new JButton("Mesa 1");
		btnMesa_1.setBackground(Color.ORANGE);
		btnMesa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMesa_1.setBounds(44, 21, 80, 30);
		getContentPane().add(btnMesa_1);
		
		JButton btnMesa_2 = new JButton("Mesa 2");
		btnMesa_2.setBackground(Color.ORANGE);
		btnMesa_2.setBounds(136, 21, 80, 30);
		getContentPane().add(btnMesa_2);
		
		JButton btnMesa_3 = new JButton("Mesa 3");
		btnMesa_3.setBackground(Color.ORANGE);
		btnMesa_3.setBounds(228, 21, 80, 30);
		getContentPane().add(btnMesa_3);
		
		JButton btnMesa_4 = new JButton("Mesa 4");
		btnMesa_4.setBackground(Color.ORANGE);
		btnMesa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMesa_4.setBounds(319, 21, 80, 30);
		getContentPane().add(btnMesa_4);
		
		JButton btnMesa_5 = new JButton("Mesa 5");
		btnMesa_5.setBackground(Color.ORANGE);
		btnMesa_5.setBounds(44, 53, 80, 30);
		getContentPane().add(btnMesa_5);
		
		JButton btnMesa_6 = new JButton("Mesa 6");
		btnMesa_6.setBackground(Color.ORANGE);
		btnMesa_6.setBounds(136, 53, 80, 30);
		getContentPane().add(btnMesa_6);
		
		JButton btnMesa_7 = new JButton("Mesa 7");
		btnMesa_7.setBackground(Color.ORANGE);
		btnMesa_7.setBounds(228, 53, 80, 30);
		getContentPane().add(btnMesa_7);
		
		JButton btnMesa_8 = new JButton("Mesa 8");
		btnMesa_8.setBackground(Color.ORANGE);
		btnMesa_8.setBounds(319, 53, 80, 30);
		getContentPane().add(btnMesa_8);
		
		
		//tabla de pedidos realizados por los clientes
		JLabel lblPedidosRealizados = new JLabel("Pedidos Realizados");
		lblPedidosRealizados.setBounds(54, 96, 120, 16);
		getContentPane().add(lblPedidosRealizados);
		
		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setBounds(52, 125, 338, 90);
		getContentPane().add(scrollPaneRealizados);
		
		tablePedidosPorMesa = new JTable();
		tablePedidosPorMesa.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Platillo", "Cantidad", "Precio" }) {
			
			Class<?>[] columnTypes = new Class[] { String.class, Integer.class, Double.class};
			boolean[] columnEditables = new boolean[] { false, false, true, true };
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			/*public int getRowCount() {
				// TODO Auto-generated method stub
				return menu.length;
			}*/
			
		});
		
		scrollPaneRealizados.setViewportView(tablePedidosPorMesa);
		
		//tabla de pedidos terminados por el cocinero
		JLabel lblPedidosTerminados = new JLabel("Pedidos Terminados");
		lblPedidosTerminados.setBounds(54, 227, 134, 16);
		getContentPane().add(lblPedidosTerminados);
		
		JScrollPane scrollPaneTerminados = new JScrollPane();
		scrollPaneTerminados.setBounds(52, 255, 338, 90);
		getContentPane().add(scrollPaneTerminados);
		
		tablePedidosTerminados = new JTable();
		tablePedidosTerminados.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mesa","Platillo", "Cantidad", "Precio" }) {
			
			Class<?>[] columnTypes = new Class[] { String.class, Integer.class, Double.class};
			boolean[] columnEditables = new boolean[] { false, false, true, true };
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			/*public int getRowCount() {
				// TODO Auto-generated method stub
				return menu.length;
			}*/
			
		});
		
		scrollPaneTerminados.setViewportView(tablePedidosTerminados);
	
		JButton btnGenerarCuenta = new JButton("Generar cuenta");
		btnGenerarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVent.iniciaMostrarMenu(1);
			}
		});
		btnGenerarCuenta.setBackground(Color.ORANGE);
		btnGenerarCuenta.setBounds(319, 356, 120, 30);
		getContentPane().add(btnGenerarCuenta);
		
		JButton btnConsultarMenu = new JButton("Consultar Menu");
		btnConsultarMenu.setBackground(Color.ORANGE);
		btnConsultarMenu.setBounds(187, 356, 130, 30);
		getContentPane().add(btnConsultarMenu);		
	}
}
