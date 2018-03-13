package MSystem.IS.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MSystem.IS.Modelo.Producto;

public class DAOProductos {
	
	public boolean agregarProductoCocina(Producto producto) throws DatabaseException, SQLException {
		// Crea el Statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Envia instruccion SQL, nota el DEFAULT es para insertar el id
		// autogenerada
		// Se insertan los datos del platillo a agregar en la base de datos
		statement.execute("INSERT INTO ProductosCocina VALUES ('" + producto.getNombreProducto() + "', "
				+ producto.getCantidadProducto() + ")");

		return true;
	}

	public ArrayList<Producto> getLista() throws DatabaseException, SQLException {
		ArrayList<Producto> productTemp = new ArrayList<Producto>();
		// Crea el statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT * FROM ProductosCocina");

		while (rs.next()) {
			// Crea una nueva instancia del objeto
			Producto producto = new Producto(rs.getString("Nombre"), rs.getDouble("Cantidad"));
			productTemp.add(producto);
		}
		return productTemp;
	}

	public boolean guardaFaltantes(Producto producto) throws DatabaseException, SQLException {
		// Crea el Statement
				Statement statement = ManejadorBD.dameConnection().createStatement();

				// Envia instruccion SQL, nota el DEFAULT es para insertar el id
				// autogenerada
				// Se insertan los datos del platillo a agregar en la base de datos
				statement.execute("INSERT INTO ProductosF VALUES ('" + producto.getNombreProducto() + "', "
						+ producto.getCantidadProducto() + ")");

				return true;
	}
	
	public ArrayList<Producto> muestraProdFalt() throws DatabaseException, SQLException {
		ArrayList<Producto> productFaltTemp = new ArrayList<Producto>();
		// Crea el statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT * FROM ProductosF");

		while (rs.next()) {
			// Crea una nueva instancia del objeto
			Producto producto = new Producto(rs.getString("Nombre"), rs.getDouble("Cantidad"));
			productFaltTemp.add(producto);
		}
		return productFaltTemp;
	}


}
