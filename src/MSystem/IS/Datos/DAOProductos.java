package MSystem.IS.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
<<<<<<< HEAD

<<<<<<< HEAD
import javax.swing.JOptionPane;

import MSystem.IS.Modelo.Producto;

public class DAOProductos {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Metodo que utiliza el Administrados para Actualizar los Productos de la cocina
=======
import javax.swing.JOptionPane;
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
  
  // Metodo que utiliza el Administrados para Actualizar los Productos de la cocina
>>>>>>> 3549edeb22a79208b55fb60e2cd6c9d1b521c402
	
	public ArrayList <Producto> producto(){
		
		ArrayList <Producto> produc = new ArrayList <Producto> ();
		
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet produc1 = statement.executeQuery("SELECT * FROM Productos");

			while (produc1.next()) {
				// Crea una nueva instancia del objeto
				Producto product = new Producto(produc1.getString("Producto"),produc1.getDouble("Cantidad"));
					produc.add(product); 
				
			}
			
			return produc ;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede recuperar el contenido de la base de datos de productos");
			return null;
				
	}
<<<<<<< HEAD
	
}
=======
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

>>>>>>> a72805ce3eefa948f21d3b19a0a42f91ec1402b4
=======


>>>>>>> 3549edeb22a79208b55fb60e2cd6c9d1b521c402
}
