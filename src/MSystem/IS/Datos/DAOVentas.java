package MSystem.IS.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MSystem.IS.Modelo.Pedido;
import MSystem.IS.Modelo.Platillo;

public class DAOVentas {

	/**
	 * Metodo que muestra el contenido de la tabla Platillos la base de datos
	 * 
	 * @return un arreglo con el contenido de la base de datos
	 * @throws SQLException
	 * @throws DatabaseException
	 * @throws NullPointerException
	 */
	public Platillo[] mostrarMenu() throws DatabaseException, SQLException, NullPointerException {
		ArrayList<Platillo> platillosTemp = new ArrayList<Platillo>();
		// Crea el statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT * FROM Platillos");

		while (rs.next()) {
			// Crea una nueva instancia del objeto
			Platillo platillo = new Platillo(rs.getString("nombrePlatillo"), rs.getString("tipo"),
					rs.getDouble("precio"));
			platillo.setId(rs.getInt("platilloId"));

			if (platillo.getTipo().equals("comida"))
				platillosTemp.add(0, platillo);
			else
				platillosTemp.add(platillosTemp.size(), platillo);
		}

		// Copia el contenido del ArrayList en un arreglo simple
		Platillo platillosTempArreglo[] = new Platillo[platillosTemp.size()];
		platillosTemp.toArray(platillosTempArreglo);
		return platillosTempArreglo;

	}

	/**
	 * Metodo que sirve para mostrar el contenido de la tabla Pedidos de la base
	 * de datos
	 * 
	 * @return un arreglo con el contenido de la base de datos
	 */
	public Pedido[] mostrarPedidos() {
		ArrayList<Pedido> pedidosTemp = new ArrayList<Pedido>();
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Pedidos");

			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Platillo platillo = buscaPorID(rs.getInt("IDPlatillo"));
				Pedido pedido = new Pedido(rs.getInt("cantidadPlatillo"), platillo, rs.getInt("noMesa"));
				pedidosTemp.add(pedido);
			}

			Pedido pedidosTempArreglo[] = new Pedido[pedidosTemp.size()];
			pedidosTemp.toArray(pedidosTempArreglo);
			return pedidosTempArreglo;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede recuperar el contenido de la base de datos");
			return null;
		}
	}

	/**
	 * Metodo que sirve para buscar un platillo por au ID
	 * 
	 * @param id
	 * @return
	 */
	private Platillo buscaPorID(int id) {
		Platillo plat = null;

		Statement statement;
		try {
			statement = ManejadorBD.dameConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Platillos WHERE platilloId = " + id + "");
			if (rs.next()) {
				plat = new Platillo(rs.getString("nombrePlatillo"), rs.getString("tipo"), rs.getDouble("precio"));
				plat.setId(rs.getInt("platilloId"));
			}

		} catch (NullPointerException | DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error al buscar el platillo especificado");
		}

		return plat;
	}

	/**
	 * Metodo que sirve para agregar un platillo a la base de datos
	 * 
	 * @param platillo
	 * @return true si el platillo se agregï¿½ existosamente, false de lo
	 *         contrario
	 */
	public boolean agregarPlatillo(Platillo platillo) {

		int id = 0;
		try {
			// Crea el Statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar el id
			// autogenerada
			// Se insertan los datos del platillo a agregar en la base de datos
			statement.execute("INSERT INTO Platillos VALUES (DEFAULT, '" + platillo.getNombrePlatillo() + "', '"
					+ platillo.getTipo() + "', " + platillo.getPrecio() + ")", Statement.RETURN_GENERATED_KEYS);

			ResultSet rs = statement.getGeneratedKeys(); // Recupera el folio

			if (rs != null && rs.next()) {
				id = rs.getInt(1);
				// System.out.println("Dentro del metodo agregaplatillo: "+id);
				platillo.setId(id); // Asigna el id al platillo
			}

			return true;

		} catch (SQLException e) {
			// Cacha excepcion
			JOptionPane.showMessageDialog(null, "Error al guardar platillo en la base de datos");
			return false;
		}
	}

	/**
	 * Metodo que sirve para agregar un pedido a la base de datos
	 * 
	 * @param pedido
	 * @return true si fue agregado don exito, false de lo contrario
	 * @throws SQLException
	 * @throws DatabaseException
	 */
	public boolean agregarPedido(Pedido pedido) throws DatabaseException, SQLException {
		// Crea el Statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Envia instruccion SQL, nota el DEFAULT es para insertar el id
		// autogenerada
		// Se insertan los datos del platillo a agregar en la base de datos
		statement.execute("INSERT INTO Pedidos VALUES (" + pedido.getPlatillo().getId() + ", "
				+ pedido.getCantidadPlatillo() + " ," + pedido.getNoMesa() + ")");

		return true;

	}

	/**
	 * Metodo que sirve para buscar un platillo por medio de su nombre
	 * 
	 * @param platillo
	 * @return el platillo encontrado o null si no se encontrï¿½
	 * @throws SQLException,
	 *             NullPointerException
	 * @throws DatabaseException
	 */
	public Platillo buscarPlatillo(Platillo platillo) throws DatabaseException, SQLException, NullPointerException {
		Platillo plat = null;

		Statement statement;
		statement = ManejadorBD.dameConnection().createStatement();
		ResultSet rs = statement
				.executeQuery("SELECT * FROM Platillos WHERE nombrePlatillo = '" + platillo.getNombrePlatillo() + "'");
		if (rs.next()) {
			plat = new Platillo(rs.getString("nombrePlatillo"), rs.getString("tipo"), rs.getDouble("precio"));
			plat.setId(rs.getInt(1));
			System.out.println("Dentro del metodo mostrar menu: " + plat.getId());
		}

		return plat;
	}

	// Envia instruccion SQL
	// Se recuperan los datos del pedido el cual se extrae por medio de la mesa

	public ArrayList<Pedido> obtenerPedido(int mesa) {

		ArrayList<Pedido> cuenta = new ArrayList<>();
		System.out.println("DAOVentas: " + mesa);
		try {
			// Crea el Statement
			Statement statemen = ManejadorBD.dameConnection().createStatement();
			ResultSet rs = statemen.executeQuery("SELECT * FROM Pedidos WHERE noMesa =" + mesa);
			while (rs.next()) {
				Platillo plat = buscaPorID(rs.getInt("IDPlatillo"));
				Pedido pedi = new Pedido(rs.getInt("cantidadPlatillo"), plat, mesa);
				cuenta.add(pedi);
			}

			return (cuenta);

		} catch (SQLException e) {
			// Cacha excepcion
			JOptionPane.showMessageDialog(null, "Error");
			return null;
		}

	}
	
	
// hace una actualizacion añadiendo los platillos realizados a una tabla, eliminando de los pedidos por hacer

public boolean ActualizaPedidos(Pedido pedido) throws DatabaseException, SQLException {
		// Crea el Statement
		Statement statement = ManejadorBD.dameConnection().createStatement();

		// Envia instruccion SQL, nota el DEFAULT es para insertar el id
		// autogenerada
		// Se insertan los datos del platillo a agregar en la base de datos
		statement.execute("INSERT INTO PedidosF VALUES (" + pedido.getPlatillo().getId() + ", "
				+ pedido.getCantidadPlatillo() + " ," + pedido.getNoMesa() + ")");
		
		// statement.execute("DELETE FROM Pedidos WHERE IDPlatillo = pedido.getPlatillo().getId() AND CantidadPlatillo = pedido.getCantidadPlatillo() AND noMesa = pedido.getNoMesa()");

		return true;

	}
//recupera de la base de datos los pedidos realizados
	public Pedido[] mostrarPedidosF() {
		ArrayList<Pedido> pedidosTempF = new ArrayList<Pedido>();
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM PedidosF");

			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Platillo platillo = buscaPorID(rs.getInt("IDPlatillo"));
				Pedido pedidoF = new Pedido(rs.getInt("cantidadPlatillo"), platillo, rs.getInt("noMesa"));
				pedidosTempF.add(pedidoF);
			}

			Pedido pedidosFTempArreglo[] = new Pedido[pedidosTempF.size()];
			pedidosTempF.toArray(pedidosFTempArreglo);
			return pedidosFTempArreglo;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede recuperar el contenido de la base de datos lalala");
			return null;
		}
	}

}
