package MSystem.IS.Servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Datos.DatabaseException;
import MSystem.IS.Modelo.Producto;

public class ServicioProductos {
	
	private DAOProductos daoProd;
	
	public ServicioProductos(DAOProductos daoProd){
		this.daoProd = daoProd;
	}
	
	/** Metodo que regresa una lista con el contenido de la tabla "ProductosCocina"
	 * @return un arreglo con el contenido de la tabla
	 */
	public ArrayList<Producto> generaLista() {
		try {
			return daoProd.getLista();
		} catch (DatabaseException | SQLException e) {
			return null;
		}
	}

	/** Metodo que permite agregar un elemento a la tabla "ProductosCocina"
	 * @param producto
	 * @return true si se agrego con exito, false de lo contrario
	 */
	public boolean agregarProductoCocina(Producto producto) {
		try {
			return daoProd.agregarProductoCocina(producto);
		} catch (DatabaseException | SQLException e) {
			return false;
		}
	}

	/** Metodo que permite agregar una lista de elementos a la tabla "ProductosF"
	 * @param listaProdFalt
	 * @return true si se agregaron con exito, false de lo contrario
	 */
	public boolean guardaFaltantes(ArrayList<Producto> listaProdFalt) {
		boolean bueno = true;
		for (int i = 0; i < listaProdFalt.size(); i++)
			try {
				bueno = daoProd.guardaFaltantes(listaProdFalt.get(i));
			} catch (DatabaseException | SQLException e) {
				bueno = false;
			}
		return bueno;
	}

	/** Metodo que regresa una lista con el tenido de la tabla "ProductosF"
	 * @return un arreglo con el contenido de la tabla
	 */
	public ArrayList<Producto> muestraFaltantes() {
		try {
			return daoProd.muestraProdFalt();
		} catch (DatabaseException | SQLException e) {
			return null;
		}
	}
	
	//metodo para mostrar los producto
		public ArrayList<Producto> prod(){
					
			return daoProd.producto();
			
		}

		public void actualizaproducto(double cantidad, Producto a) {
			daoProd.ingresarNuevoProd(cantidad,a);
			
		}
		
		public ArrayList<Producto> recuperaProductosF() {
			try {
				return daoProd.muestraProdFalt();
			} catch (DatabaseException | SQLException e) {
				return null;
			}
		}

}
