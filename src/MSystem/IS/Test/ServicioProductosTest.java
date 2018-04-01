package MSystem.IS.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Modelo.Producto;
import MSystem.IS.Servicios.ServicioProductos;

public class ServicioProductosTest {
	
	DAOProductos daoProd = new DAOProductos();
	ServicioProductos servProd = new ServicioProductos(daoProd);
	
	static ServicioProductos serv;
	static Producto prod;
	

	@Before
	public void setUp() throws Exception {
		DAOProductos dao = new DAOProductos();
		serv = new ServicioProductos(dao);
		prod = new Producto("", 0);
		prod.setCantidadProdcuto(0);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFaltantes() {
		
		ArrayList<Producto> valor = serv.getFaltantes();
		assertNotNull("Se esperaba devolver la lista de faltantes", valor);
	}

}