package MSystem.IS.Vistas;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Modelo.Pedido;
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
	ControlVentas controlVent;
	ArrayList<Pedido> pedido = new ArrayList<Pedido>();

	int tam = 0;
	int noMesa = 0;
	
	public VistaSeleccionarMesa(ControlVentas controlVent) {
		setTitle("Seleccionar Mesa");
		this.controlVent = controlVent;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 528, 465);
		setLocationRelativeTo(null);
		setResizable(false);

		getContentPane().setLayout(null);
		
		JButton btnMesa_1 = new JButton("Mesa 1");
		btnMesa_1.setBackground(new Color(255, 165, 0));
		btnMesa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 1;
				seleccionaMesa(noMesa);
			}
		});
		btnMesa_1.setBounds(44, 21, 80, 30);
		getContentPane().add(btnMesa_1);
		
		JButton btnMesa_2 = new JButton("Mesa 2");
		btnMesa_2.setBackground(new Color(255, 165, 0));
		btnMesa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 2;
				seleccionaMesa(noMesa);
			}
		});
		btnMesa_2.setBounds(136, 21, 80, 30);
		getContentPane().add(btnMesa_2);
		
		JButton btnMesa_3 = new JButton("Mesa 3");
		btnMesa_3.setBackground(new Color(255, 165, 0));
		btnMesa_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 3;
				seleccionaMesa(noMesa);
			}
		});
		btnMesa_3.setBounds(228, 21, 80, 30);
		getContentPane().add(btnMesa_3);
		
		JButton btnMesa_4 = new JButton("Mesa 4");
		btnMesa_4.setBackground(new Color(255, 165, 0));
		btnMesa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 4;
				seleccionaMesa(noMesa);
			}
		});
		btnMesa_4.setBounds(319, 21, 80, 30);
		getContentPane().add(btnMesa_4);
		
		JButton btnMesa_5 = new JButton("Mesa 5");
		btnMesa_5.setBackground(new Color(255, 165, 0));
		btnMesa_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 5;
				seleccionaMesa(noMesa);
			}
		});
		btnMesa_5.setBounds(44, 53, 80, 30);
		getContentPane().add(btnMesa_5);
		
		JButton btnMesa_6 = new JButton("Mesa 6");
		btnMesa_6.setBackground(new Color(255, 165, 0));
		btnMesa_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 6;
				seleccionaMesa(noMesa);
			}
		});
		btnMesa_6.setBounds(136, 53, 80, 30);
		getContentPane().add(btnMesa_6);
		
		JButton btnMesa_7 = new JButton("Mesa 7");
		btnMesa_7.setBackground(new Color(255, 165, 0));
		btnMesa_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 7;
				seleccionaMesa(noMesa);
			}
		});
		btnMesa_7.setBounds(228, 53, 80, 30);
		getContentPane().add(btnMesa_7);
		
		JButton btnMesa_8 = new JButton("Mesa 8");
		btnMesa_8.setBackground(new Color(255, 165, 0));
		btnMesa_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noMesa = 8;
				seleccionaMesa(noMesa);
			}
		});
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
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { String.class, Integer.class, Double.class};
			
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] columnEditables = new boolean[] { false, false, false };
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			public int getRowCount() {
				// TODO Auto-generated method stub
				
				return 20;

			}		
			
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
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			Class<?>[] columnTypes = new Class[] { Integer.class, String.class, Integer.class, Double.class};
			
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] columnEditables = new boolean[] { false, false, false, false };
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			public int getRowCount() {
				// TODO Auto-generated method stub
				return 20;
			}
		});
		
		scrollPaneTerminados.setViewportView(tablePedidosTerminados);
		
		
	
		JButton btnGenerarCuenta = new JButton("Generar cuenta");
		btnGenerarCuenta.setBackground(new Color(255, 165, 0));
		btnGenerarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVent.muestraGCuenta(noMesa);
			}
		});
		btnGenerarCuenta.setBounds(319, 356, 134, 30);
		getContentPane().add(btnGenerarCuenta);
		
		JButton btnConsultarMenu = new JButton("Consultar Menu");
		btnConsultarMenu.setBackground(new Color(255, 165, 0));
		btnConsultarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVent.iniciaMostrarMenu(noMesa);
			}
		});
		btnConsultarMenu.setBounds(187, 356, 130, 30);
		getContentPane().add(btnConsultarMenu);		
	}
	/**
	 * Metodo que nos permite seleccionar una mesa y mostrar los pedidos de dicha mesa
	 * @param noMesa
	 */
	
	private void seleccionaMesa(int noMesa){
		System.out.println(noMesa);
		pedido = controlVent.ped(noMesa); 
		
		try{
			for (int i = 0; i < pedido.size(); i++) {
				System.out.println("TAMAÑO PEDIDO: "+controlVent.traepedido().size());
				tablePedidosPorMesa.setValueAt(pedido.get(i).getPlatillo().getNombrePlatillo(), i, 0);
				tablePedidosPorMesa.setValueAt(pedido.get(i).getCantidadPlatillo(), i, 1);
				tablePedidosPorMesa.setValueAt(pedido.get(i).getPlatillo().getPrecio(), i, 2);
				
			}
		}catch (Exception e){
			System.out.println("entra al catch");
			int tam = controlVent.traepedido().size();
			System.out.println("tabla "+tablePedidosPorMesa.getRowCount());
			for (int i = 0; i < tam; i++) {
				tablePedidosPorMesa.setValueAt("", i, 0);
				tablePedidosPorMesa.setValueAt(0, i, 1);
				tablePedidosPorMesa.setValueAt(0.0, i, 2);
				
			}
			
		}
//		try{
//			tam = controlVent.PedidosFinalizados().length;
//			// Se agregan los elementos a la tabla
//			for (int i = 0; i < tam; i++) {
//
//				tablePedidosTerminados.setValueAt(controlVent.PedidosFinalizados()[i].getNoMesa(), i , 0);
//				tablePedidosTerminados.setValueAt(controlVent.PedidosFinalizados()[i].getPlatillo().getNombrePlatillo(), i, 1);
//				tablePedidosTerminados.setValueAt(controlVent.PedidosFinalizados()[i].getCantidadPlatillo(), i, 2);
//				tablePedidosTerminados.setValueAt(controlVent.PedidosFinalizados()[i].getPlatillo().getPrecio(), i, 3);
//			}
//			}catch (Exception e){
//
//				tam = 0;
//		}
	}
}
