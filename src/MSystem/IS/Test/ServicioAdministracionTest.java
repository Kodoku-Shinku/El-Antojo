
package MSystem.IS.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import MSystem.IS.Datos.DAOAdministracion;
import MSystem.IS.Datos.DatabaseException;
import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Servicios.ServicioAdministracion;


public class ServicioAdministracionTest {
	
	ServicioAdministracion SA = new ServicioAdministracion();
	DAOAdministracion daoa = new DAOAdministracion();
	ServicioAdministracion SA1 = new ServicioAdministracion(daoa);
	Empleado EM = new Empleado("Marisol", "Chavarria", "Juarez", "UAMI", "5524988748", "Administrador","UAMI");
	
	
	
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
	/*Metodo para probar el agregar Empleado, Se ingresan todos los valores para saber si se esta
	 * almacenando correctamente en la Base de datos*/
	public void testAgregar()  throws DatabaseException, SQLException {
		//System.out.println("Prueba"+EM);
		assertNotNull(EM);
		System.out.println("El Empleado se Agrego Exitosamente    "+SA1.agregarEmpleado(EM));
		assertTrue(SA1.agregarEmpleado(EM));
	}
	
	
	// Caso de Prueba para el metodo actualizaEmpleado: El usuario ingresa un empleado que no existe
	@Test
	public void testActualizaEmp() {
		boolean valor = serv.actualizaEmp(empl, "tel", "55677354");
		assertEquals("Se esperaba un false",valor, true);
	}

}
