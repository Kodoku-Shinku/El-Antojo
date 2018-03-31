package MSystem.IS.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MSystem.IS.Modelo.Empleado;

public class DAOAdministracion {

	public ArrayList<Empleado> cargarLista() throws DatabaseException, SQLException {
		ArrayList<Empleado> empleadoTemp = new ArrayList<Empleado>();
		// Crea el statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT * FROM EMPLEADO");

		while (rs.next()) {
			// Crea una nueva instancia del objeto
			Empleado empleado = new Empleado(rs.getString("nombre"), rs.getString("apat"), rs.getString("amat"),
					rs.getString("direccion"), rs.getString("tel"), rs.getString("cargo"), rs.getString("contrasena"));// Van
			// los
			// campos
			empleado.setid(rs.getInt(1));
			empleadoTemp.add(empleado);
		}
		return empleadoTemp;
	}

	public boolean actualizaEmpleado(String campo, String nuevoValor, Empleado empleado) {
		Statement state;
		try {
			state = ManejadorBD.dameConnection().createStatement();
			state.execute(
					"update EMPLEADO set " + campo + " = '" + nuevoValor + "' where noempleado = " + empleado.getid());
			if (campo.equals("nombre"))
				empleado.setNombre(nuevoValor);
			if (campo.equals("apat"))
				empleado.setApellidoPaterno(nuevoValor);
			if (campo.equals("amat"))
				empleado.setApellidoMaterno(nuevoValor);
			if (campo.equals("direccion"))
				empleado.setDireccion(nuevoValor);
			if (campo.equals("tel"))
				empleado.setTelefono(nuevoValor);
			if (campo.equals("contrasena"))
				empleado.setContrasena(nuevoValor);
			return true;

		} catch (DatabaseException | SQLException | NullPointerException e) {
			return false;
		}
	}

	// Se crea la tabla que almacenara los datos del Empleado a Agregr

	public boolean createEmpleado(Empleado empleado) {
		// Para crear conexion a base de Datos
		try {
			// se pide la conexion
			Statement statement = ManejadorBD.dameConnection().createStatement();
			// Envia instruccion SQL, nota el DEFAULT es para insertar el numero
			// de empleado autoincremental
			statement.execute("insert into EMPLEADO values(DEFAULT,'" + empleado.getNombre() + "','"
					+ empleado.getApellidoPaterno() + "','" + empleado.getApellidoMaterno() + "','"
					+ empleado.getDireccion() + "','" + empleado.getTelefono() + "','" + empleado.getCargo() + "','"
					+ empleado.getContrasena() + "')", Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera el numero
															// de
															// empleado******/
			if (rs != null && rs.next()) {
				empleado.setid(rs.getInt(1));
			}
			// cacha la exepcion
		} catch (SQLException excepcion) {
			excepcion.printStackTrace();
		}
		return true;
	}
}
