package MSystem.IS.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MSystem.IS.Modelo.Empleado;

public class DAOAdministracion {
	
	public ArrayList<Empleado> cargarLista() throws DatabaseException, SQLException{
		ArrayList<Empleado> empleadoTemp = new ArrayList<Empleado>();
		// Crea el statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT * FROM Empleados");

		while (rs.next()) {
			// Crea una nueva instancia del objeto
			Empleado empleado = new Empleado();// Van los campos 
			empleadoTemp.add(empleado);
		}
		return empleadoTemp;
	}
	
	public boolean actualizaEmpleado(String campo, String nuevoValor, Empleado empleado){
		Statement state;
		try {
			state = ManejadorBD.dameConnection().createStatement();
			state.execute("update Empleados set " + campo + " = '" + nuevoValor + "' where idEmpleado = " + empleado); // Mas el nombre
			
		} catch (DatabaseException | SQLException e) {
			return false;
		}
		
		
		return false;
	}

}
