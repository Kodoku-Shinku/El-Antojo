package MSystem.IS.Datos;


import java.sql.Connection;
import java.sql.Statement;

public class CreadorBaseDeDatos {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		try
		{
			
			Connection connection = ManejadorBD.dameConnection();

			Statement statement = connection.createStatement();

//			//statement.execute("create table Platillos(platilloId INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombrePlatillo varchar(40), tipo varchar(10), precio double precision)"); // Aqu� el identificador es para diferenciar entre bebidas y platillos
//			//statement.execute("DROP TABLE Platillos");
//			System.out.println("Tabla de Platillos creada exitosamente");
//			
//			statement.execute("create table Pedidos(IDPlatillo int, cantidadPlatillo int, noMesa int)"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
//			//statement.execute("DROP TABLE Pedidos");
//			System.out.println("Tabla de Pedidos creada exitosamente");
//			
//			statement.execute("create table PedidosF(IDPlatillo int, cantidadPlatillo int, noMesa int)");
//			System.out.println("Tabla de PedidosF creada exitosamente");
//
//			statement.execute("create table ProductosCocina(Nombre varchar(20), cantidad double)");
//			//statement.execute("DROP TABLE ProductosCocina");
//			System.out.println("Tabla de ProductosCocina creada exitosamente");
//			
//			statement.execute("create table ProductosF(Nombre varchar(20), cantidad double)");
//			//statement.execute("DROP TABLE ProductosF");
//			System.out.println("Tabla de ProductosF creada exitosamente");


			
//			statement.execute("create table ProductosAdmin(nombre varchar(20), cantidad double)");
//			statement.execute("DROP TABLE ProductosAdmin");
//			System.out.println("Tabla de ProductosAdmin creada exitosamente");
			
			
			statement.execute("CREATE TABLE EMPLEADO (noempleado INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre VARCHAR(50), apat VARCHAR(50),amat VARCHAR(50), direccion VARCHAR(100), tel VARCHAR(15), cargo VARCHAR(100))");
			statement.execute("DROP TABLE EMPLEADO");
			System.out.println("Tabla de Agregar Empleado creada exitosamente");
			ManejadorBD.termina();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
