package MSystem.IS.Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import MSystem.IS.Datos.DAOAdministracion;
import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Servicios.ServicioAdministracion;
import junit.framework.Assert;

public class ServicioAdministracionTest {
	
	static ServicioAdministracion serv;
	static Empleado empl;
	@BeforeClass
	public static void setUp() throws Exception {
		DAOAdministracion dao = new DAOAdministracion();
		serv = new ServicioAdministracion(dao);
		empl = new Empleado("", "", "", "", "", "", "");
		empl.setid(23122278);
	}

	@AfterClass
	public static void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	// Caso de Prueba para el metodo actualizaEmpleado: El usuario ingresa un empleado que no existe
	@Test
	public void testActualizaEmp() {
		boolean valor = serv.actualizaEmp(empl, "tel", "55677354");
		assertEquals("Se esperaba un false",valor, false);
		
		
	}

}
