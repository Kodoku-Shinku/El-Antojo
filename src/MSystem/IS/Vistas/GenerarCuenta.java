package MSystem.IS.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Modelo.Pedido;
import MSystem.IS.Servicios.ServicioVentas;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GenerarCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField mesas;
	private JTextField total;

	/**
	 * Create the frame.
	 */
	public GenerarCuenta(ControlVentas controlVenta) {
		setTitle("Cuenta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaActualizarEmpleado.class.getResource("/MSystem/IS/Vistas/el_antojo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ArrayList<Pedido> traerped = controlVenta.traepedido();
		JLayeredPane PanelPlatillos = new JLayeredPane();
		contentPane.add(PanelPlatillos, BorderLayout.CENTER);
		//ArrayList<Pedido> traePed = controlVenta.traepedido();
		PanelPlatillos.setLayout(null);

		JLabel lblPlatillo = new JLabel("Platillo");
		lblPlatillo.setBounds(139, 12, 46, 14);
		PanelPlatillos.add(lblPlatillo);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(285, 12, 46, 14);
		PanelPlatillos.add(lblPrecio);

		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(10, 47, 46, 14);
		PanelPlatillos.add(lblMesa);

		mesas = new JTextField();
		mesas.setText(controlVenta.muestraNoMesa() + "");
		mesas.setEditable(false);
		mesas.setBounds(47, 44, 43, 20);
		//*-*-*-*-*%%%%%%  Descomentar una vez que se una con el de Rosa
		//mesas.setText(controlVentas.muestraNoMesas);
		PanelPlatillos.add(mesas);
		mesas.setColumns(10);


		//Boton de cancelar cuenta
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 165, 0));
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCancelar){
					int option = JOptionPane.showConfirmDialog(null, "Seguro que deseas Cancelar");

					if(JOptionPane.OK_OPTION == option){
						dispose();
					}
				}
			}
		});

		btnCancelar.setBounds(128, 218, 89, 23);
		PanelPlatillos.add(btnCancelar);

		JButton btnTicket = new JButton("Ticket");
		btnTicket.setBackground(new Color(255, 165, 0));
		btnTicket.setBounds(262, 218, 89, 23);
		btnTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenta.getTicket(traerped);
			}
		});

		PanelPlatillos.add(btnTicket);

		JLabel lblTotal = new JLabel("Total a Pagar");
		lblTotal.setForeground(Color.RED);
		lblTotal.setBounds(169, 193, 83, 14);
		PanelPlatillos.add(lblTotal);

		total = new JTextField();
		total.setEditable(false);
		total.setBounds(262, 191, 112, 20);

		total.setText("$ "+controlVenta.total(traerped)+"");
		PanelPlatillos.add(total);
		total.setColumns(10);

		//Panel que muestra los platillos consumidos en una lista
		JList Platillos = new JList();

		for(int i = 0; i < traerped.size(); i ++)
			System.out.println(traerped.get(i).getPlatillo().getNombrePlatillo() + " " + traerped.get(i).getCantidadPlatillo());
		String [] listaPlatillos = new String[traerped.size()];
		for (int i=0; i<traerped.size(); i++ ){
			listaPlatillos[i] = traerped.get(i).getPlatillo().getNombrePlatillo();
		}

		Platillos.setListData(listaPlatillos);
		Platillos.setBounds(128, 37, 124, 146);
		PanelPlatillos.add(Platillos);

		//Panel que muestra los precios de los platillos consumidos
		JList precio = new JList();
		precio.setBounds(262, 37, 112, 146);

		Double [] listaPrecio = new Double[traerped.size()];
		for (int j=0; j<traerped.size(); j++ ){
			listaPrecio[j] = traerped.get(j).getPlatillo().getPrecio();
		}
		precio.setListData(listaPrecio);

		PanelPlatillos.add(precio);


	}
}
