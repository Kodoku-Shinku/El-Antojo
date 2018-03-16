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
	
	public ArrayList<Producto> generaLista() {
		try {
			return daoProd.getLista();
		} catch (DatabaseException | SQLException e) {
			return null;
		}
	}

	public boolean agregarProductoCocina(Producto producto) {
		try {
			return daoProd.agregarProductoCocina(producto);
		} catch (DatabaseException | SQLException e) {
			return false;
		}
	}

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

	public ArrayList<Producto> muestraFaltantes() {
		try {
			return daoProd.muestraProdFalt();
		} catch (DatabaseException | SQLException e) {
			return null;
		}
	}

	public ArrayList<Producto> recuperaProductosF() {
		try {
			return daoProd.muestraProdFalt();
		} catch (DatabaseException | SQLException e) {
			return null;
		}
	}
}
