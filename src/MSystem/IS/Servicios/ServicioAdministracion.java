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
	
	/** Metodo que regresa una lista con el contenido de la base de datos
	 * @return un arrayList con el contenido de la base de datos
	 */
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

	/** Metodo que permite actualizar los datos de un empleado
	 * @param empl
	 * @param campo
	 * @param nValor
	 * @return true si se actualizaron correctamente, false si no
	 */
	public boolean actualizaEmp(Empleado empl, String campo, String nValor) {
		// Verifica, si el campo es "tel", entonces debe verificar que el string este compuesto unicamente de digitos
		if(campo.equals("tel")){
			int i = 0;
			// Recorre la cadena
			for(i = 0; i < nValor.length(); i ++)
				if(!Character.isDigit(nValor.charAt(i)))
					break;
			// Si el indice es igual al tamaño, el valor nuevo esta bien escrito
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
	//recupera la informacion del empleado por id
	public Empleado recuperaEmpleado(String noEmpleado) {
		return daoAdmin.recuperaEmpleado(noEmpleado);
	}
	// metodo para eliminar empleado
	public boolean eliminarEmpleado(int empleado) {
		boolean estado = daoAdmin.eliminaEmpleado(empleado);
		
		return estado;
	}

	/** Metodo que permite ingresar al sistema
	 * @param contrasena
	 * @param noEmpleado
	 * @return un empleado que exista en la base de datos
	 */
	public Empleado ingresarAlSistema(String contrasena, int noEmpleado) {
		Empleado empl = daoAdmin.recuperaEmpleado(noEmpleado+"");
		try{
		if(contrasena.equals(empl.getContrasena()))
			return empl;
		} catch (NullPointerException e){
			return null;
		}
		return null;
	}
}
