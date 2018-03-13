package MSystem.IS.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Modelo.Productos;
import MSystem.IS.Servicios.ServicioProductos;

public class VistaConsultarFaltantes extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable ProductosF;
	TableModel Tmodel;
	int row,col=0;
	Productos productosf;
	DAOProductos controlDBP = new DAOProductos();
	ServicioProductos servProduct = new ServicioProductos(controlDBP); 
	ControlProductos controlVent = new ControlProductos(servProduct);
	
	public VistaConsultarFaltantes() {
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
