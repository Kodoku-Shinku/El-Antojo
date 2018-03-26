package MSystem.IS.Servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import MSystem.IS.Datos.DAOAdministracion;
import MSystem.IS.Datos.DatabaseException;
import MSystem.IS.Modelo.Empleado;


public class ServicioAdministracion {
	private DAOAdministracion daoAdmin;
	
	public ServicioAdministracion(DAOAdministracion daoAdmin){
		this.daoAdmin = daoAdmin;
	}
	
	public ArrayList<Empleado> cargarLista(){
		try {
			return daoAdmin.cargarLista();
		} catch (DatabaseException | SQLException e) {
			return null;
		}
	}
	
		// agrega las personas a la base de datos
	public boolean agregarEmpleado (Empleado empleado) throws DatabaseException, SQLException{
		// se crean instancias de tipo personal y se agrega a la base de datos

		boolean añadirPersonal = daoAdmin.createEmpleado(empleado);
		return añadirPersonal;

	}
}
