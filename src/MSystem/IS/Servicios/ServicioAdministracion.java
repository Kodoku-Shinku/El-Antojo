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
	
		// Se agregan los empleados a la base de datos
	public boolean agregarEmpleado (Empleado empleado) throws DatabaseException, SQLException{
		// se crean instancias de tipo personal y se agrega a la base de datos
		boolean anadirPersonal = daoAdmin.createEmpleado(empleado);
		
		return anadirPersonal;

	}

	public boolean actualizaEmp(Empleado empl, String campo, String nValor) {
		if(campo.equals("tel")){
			int i = 0;
			for(i = 0; i < nValor.length(); i ++)
				if(!Character.isDigit(nValor.charAt(i)))
					break;
			if(i == nValor.length())
				return daoAdmin.actualizaEmpleado(campo, nValor, empl);
			else
				return false;
			
		}
		return daoAdmin.actualizaEmpleado(campo, nValor, empl);
		
	}
	
	//Construccor vacio que se utiliza en la prueba JUnit
	public ServicioAdministracion(){
		
	}

	public Empleado recuperaEmpleado(String noEmpleado) {
		return daoAdmin.recuperaEmpleado(noEmpleado);
	}

	public boolean eliminarEmpleado(int empleado) {
		boolean estado = daoAdmin.eliminaEmpleado(empleado);
		
		return estado;
	}
}
