package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Datos.DAOVentas;
import MSystem.IS.Modelo.Pedido;
import MSystem.IS.Servicios.ServicioProductos;
import MSystem.IS.Servicios.ServicioVentas;
import java.awt.Color;



public class VistaFinalizarOrden extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable Finalizados;
	private JTable porHacer;
	private JButton btnBloquearPlatillo;
	private JButton btnNotificarFaltantes;
	private JButton btnFinalizarOrden;
	TableModel Tmodel;
	TableModel TmodelF;
	int row,col=0;
	Pedido pedido;
	DAOVentas controlDBV = new DAOVentas();
	ServicioVentas servVent = new ServicioVentas(controlDBV); 
	ControlVentas controlVent = new ControlVentas(servVent);
	DAOProductos controlDBProd = new DAOProductos();
	ServicioProductos servProd = new ServicioProductos(controlDBProd); 
	ControlProductos controlProd = new ControlProductos(servProd);
	private JButton btnSalir;
	

	/**
	 * Create the frame.
	 */
	public VistaFinalizarOrden() {
		
		setTitle("Finalizar Orden");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 64, 395, 238);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(450, 64, 303, 238);
		contentPane.add(scrollPane_1);
		
		btnBloquearPlatillo = new JButton("Bloquear Platillo");
		btnBloquearPlatillo.setBackground(new Color(255, 165, 0));
		btnBloquearPlatillo.setBounds(61, 376, 142, 23);
		contentPane.add(btnBloquearPlatillo);
		
		btnNotificarFaltantes = new JButton("NotificarFaltantes");
		btnNotificarFaltantes.setBackground(new Color(255, 165, 0));
		btnNotificarFaltantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlProd.iniciaMuestraNotiFalt();
			}
		});
		btnNotificarFaltantes.setBounds(307, 376, 142, 23);
		contentPane.add(btnNotificarFaltantes);
		
		
		Pedido[] pedidos = controlVent.PlatillosPorHacer();
		Pedido[] pedidosF= controlVent.PedidosFinalizados();
		
		
		porHacer = new JTable();
		
		porHacer.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Terminado", "Platillo", "Cantidad", "No. Mesa" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { Boolean.class, String.class, Integer.class, Integer.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { true, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}

			public int getRowCount() {
				// TODO Auto-generated method stub
				return pedidos.length;
			}
		});
		
		// Se agregan los elementos a la tabla
		for (int i = 0; i < pedidos.length; i++) {
			porHacer.setValueAt(pedidos[i].getPlatillo().getNombrePlatillo(), i, 1);
			porHacer.setValueAt(pedidos[i].getCantidadPlatillo(), i, 2);
			porHacer.setValueAt(pedidos[i].getNoMesa(), i, 3);
		}
		
		porHacer.setFocusable(false);
		porHacer.getTableHeader().setReorderingAllowed(false);
		porHacer.getColumnModel().getColumn(3).setPreferredWidth(107);
		porHacer.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if (e.getType() == TableModelEvent.UPDATE) {
					row = e.getFirstRow();
					col = e.getColumn();
					TmodelF = ((TableModel)(e.getSource()));

				}

			}
		});
				
		scrollPane.setViewportView(porHacer);

//		//Crea una tabla para almacenar los platillos finalizados
		Finalizados = new JTable();
		Finalizados.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Platillo", "Cantidad", "No. Mesa" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}

			public int getRowCount() {
				// TODO Auto-generated method stub
				return pedidosF.length;
			}
		});
		
		
		Finalizados.setFocusable(false);
		Finalizados.getTableHeader().setReorderingAllowed(false);
		Finalizados.getColumnModel().getColumn(2).setPreferredWidth(107);
		
		scrollPane_1.setViewportView(Finalizados);
		
		
		btnFinalizarOrden = new JButton("Finalizar Orden");
		btnFinalizarOrden.setBackground(new Color(255, 165, 0));
		btnFinalizarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pregunta si el platillo seleccionado es el que se realizo
				int resp = JOptionPane.showConfirmDialog(null, pedidos[row].getPlatillo().getNombrePlatillo(), "Alerta!", JOptionPane.YES_NO_OPTION);
				if(resp==JOptionPane.YES_OPTION){
					try {
						if (controlVent.FinalizarO(pedidos[row])) {
							//for (int i = 0; i < pedidos.length; i++) {
								//elimina de la lista el pedido
								TmodelF.setValueAt(false, row, 0);
								TmodelF.setValueAt("", row, 1);
								TmodelF.setValueAt(0, row, 2);
								TmodelF.setValueAt(0, row,3);

						
								System.out.println(row);

						
						}

						else
							JOptionPane.showMessageDialog(null, "Error al Finalizar");
					} catch (NullPointerException e2) {
						JOptionPane.showMessageDialog(null, "Error, no se puede finalizar2");
					}
				
					//imprime en la tabal finalizados, los platillos que se han realizado
					Finalizados.setValueAt(pedidos[row].getPlatillo().getNombrePlatillo(), row, 0);
					Finalizados.setValueAt(pedidos[row].getCantidadPlatillo(), row, 1);
					Finalizados.setValueAt(pedidos[row].getNoMesa(),row, 2);
					System.out.println(pedidos[row].getPlatillo().getNombrePlatillo());
				
				
				}
			}
		});
		btnFinalizarOrden.setBounds(594, 376, 123, 23);
		contentPane.add(btnFinalizarOrden);
		
		btnSalir = new JButton("Cerrar sesion");
		btnSalir.setBackground(new Color(255, 165, 0));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null, "Seguro que deseas Salir");

				if(JOptionPane.OK_OPTION == option)
					dispose();	
			}
		});
		btnSalir.setBounds(679, 437, 105, 23);
		contentPane.add(btnSalir);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	
}
