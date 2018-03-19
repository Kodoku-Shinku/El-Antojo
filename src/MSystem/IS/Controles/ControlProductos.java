package MSystem.IS.Controles;

import java.util.ArrayList;

import MSystem.IS.Modelo.Producto;
import MSystem.IS.Servicios.ServicioProductos;
import MSystem.IS.Vistas.VistaActProd;
import MSystem.IS.Vistas.VistaAdministrador;
import MSystem.IS.Vistas.VistaConsultarFaltantes;
import MSystem.IS.Vistas.VistaNotificarFaltantes;

public class ControlProductos {
	
	private ServicioProductos servProd;
	
	public ControlProductos(ServicioProductos servProd){
		this.servProd = servProd;
	}
	
	/**Metodo que muestra la vista Notificar Faltantes
	 */
	public void iniciaMuestraNotiFalt() {
		try {
			VistaNotificarFaltantes frame = new VistaNotificarFaltantes(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**Metodo que regresa una lista con el contenido de la base de datos
	 * @return un arreglo del tipo ArrayList
	 */
	public ArrayList<Producto> cargaLista() {
		return servProd.generaLista();
	}
	
	/**Metodo que permite agregar un Producto a la lista en la cocine
	 * @param producto
	 * @return true si se agrego con exito, false de lo contrario
	 */
	public boolean agregarProductoCocina(Producto producto){
		return servProd.agregarProductoCocina(producto);
	}

	/**Metodo que permite guardar el contenido de un arreglo en la base de datos
	 * @param listaProdFalt
	 * @return true si se agregaron con exito, false de lo contrario
	 */
	public boolean guardaFaltantes(ArrayList<Producto> listaProdFalt) {
		return servProd.guardaFaltantes(listaProdFalt) == true;
	}
	
	/**Metodo que regresa en un arreglo el contenido de la tabla ProductosF
	 * @return un ArrayList
	 */
	public ArrayList<Producto> muestraFaltantes() {
		return servProd.muestraFaltantes();
  }
	
	public ArrayList<Producto> muestraProdAdmin(){
		return servProd.prod();
		
	}
	
	public void actualizaProd(double cantidad, Producto a) {
		servProd.actualizaproducto(cantidad, a);
		
	}
	
	public void iniciaConcultFalt(){
		try {
			VistaConsultarFaltantes frame = new VistaConsultarFaltantes();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Producto> ProductosFaltantes() {
		return servProd.recuperaProductosF();
	}
	
	public void iniciaActualizarProductos() {
		try {
			VistaActProd frame = new VistaActProd(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void VistaAdministrador1(){
		try {
			VistaAdministrador frame = new VistaAdministrador(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
