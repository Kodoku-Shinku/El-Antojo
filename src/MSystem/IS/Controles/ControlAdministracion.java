package MSystem.IS.Controles;

import java.sql.SQLException;
import java.util.ArrayList;
import MSystem.IS.Datos.DatabaseException;
import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Servicios.ServicioAdministracion;
import MSystem.IS.Vistas.VistaActualizarEmpleado;
import MSystem.IS.Vistas.VistaAdministrador;
import MSystem.IS.Vistas.VistaAgregarEmpleado;
import MSystem.IS.Vistas.VistaEliminarEmpleado;
import MSystem.IS.Vistas.VistaEmpleado;
import MSystem.IS.Vistas.VistaLogin;

public class ControlAdministracion {
	private ServicioAdministracion servAdmin;

	public ControlAdministracion(ServicioAdministracion servAdmin) {
		this.servAdmin = servAdmin;
	}
	
	/** Metodo que muestra la vista para Actualizar
	 */
	public void iniciaActualizarEmpleado() {
		try {
			VistaActualizarEmpleado frame = new VistaActualizarEmpleado(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Metodo que regresa una lista con el contenido de la tabla EMPLEADO
	 * @return un arrayList con el contenido de la tabla
	 */
	public ArrayList<Empleado> cargarLista() {
		return servAdmin.cargarLista();
	}
	

	// se instancia una nueva ventana
	public void muestraVentanaAgregarEmpleado() {

		try {
			VistaAgregarEmpleado frame = new VistaAgregarEmpleado(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void VistaEmpleado() {
		try {
			VistaEmpleado frame = new VistaEmpleado(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// se crea una instancia del servicio y se agrega a un empleado (personal)
	public boolean agregarEmpleado(Empleado Empleado) {

		boolean agregarEmpleado = false;
		try {
			agregarEmpleado = servAdmin.agregarEmpleado(Empleado);
		} catch (DatabaseException | SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return agregarEmpleado;
	}

	public void mustravistaProductos() {

	}

	/** Metodo que permite actualizar los datos de un empleado
	 * @param empl
	 * @param campo
	 * @param nValor
	 * @return true si se pudo actualizar correctamente, false si no
	 */
	public boolean actualiza(Empleado empl, String campo, String nValor) {
		return servAdmin.actualizaEmp(empl, campo, nValor) == true;
	}
	//recupera el empleado para ser eliminado
	public Empleado recuperaEmpleado(String noEmpleado) {
		return servAdmin.recuperaEmpleado(noEmpleado);
		
	}
	//verifica si se elimino el empleado
	public boolean eliminarEmpleado(int empleado) {
		return servAdmin.eliminarEmpleado(empleado);
		
	}
	//metodo para abrir la ventana Eliminar Empleado
	public void inicia() {
		try {
			VistaEliminarEmpleado frame = new VistaEliminarEmpleado();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void vistaAdministrador() {
		try {
			VistaAdministrador frame = new VistaAdministrador();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Metodo que muestra la vista del Logim
	 */
	public void vistaLogin() {
		try {
			VistaLogin frame = new VistaLogin();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Metodo que permite ingresar al sistema
	 * @param contrasena
	 * @param noEmpleado
	 * @return algun empleado que exista en la base de datos
	 */
	public Empleado ingresarAlSistema(String contrasena, int noEmpleado) {
		// TODO Auto-generated method stub
		return servAdmin.ingresarAlSistema(contrasena, noEmpleado);
	}

}