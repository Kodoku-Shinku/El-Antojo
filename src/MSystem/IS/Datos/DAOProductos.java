package MSystem.IS.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MSystem.IS.Modelo.Producto;

public class DAOProductos {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Metodo que utiliza el Administrados para Actualizar los Productos de la cocina
	
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
	
}
}
