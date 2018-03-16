package MSystem.IS.Controles;

import java.util.ArrayList;

import MSystem.IS.Modelo.Producto;
import MSystem.IS.Modelo.Productos;
import MSystem.IS.Servicios.ServicioProductos;
import MSystem.IS.Vistas.VistaNotificarFaltantes;

public class ControlProductos {
	
	private ServicioProductos servProd;
	
	public ControlProductos(ServicioProductos servProd){
		this.servProd = servProd;
	}
	
	public void iniciaMuestraNotiFalt() {
		try {
			VistaNotificarFaltantes frame = new VistaNotificarFaltantes(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Producto> cargaLista() {
		return servProd.generaLista();
	}
	
	public boolean agregarProductoCocina(Producto producto){
		return servProd.agregarProductoCocina(producto);
	}

	public boolean guardaFaltantes(ArrayList<Producto> listaProdFalt) {
		return servProd.guardaFaltantes(listaProdFalt) == true;
	}
	
	public ArrayList<Producto> muestraFaltantes() {
		return servProd.muestraFaltantes();
  }

	public ArrayList<Producto> ProductosFaltantes() {
		return servProd.recuperaProductosF();
	}
}
