package MSystem.IS.Principal;

import java.sql.SQLException;

import MSystem.IS.Controles.ControlAdministracion;
import MSystem.IS.Controles.ControlProductos;
import MSystem.IS.Controles.ControlVentas;
import MSystem.IS.Datos.DAOAdministracion;
import MSystem.IS.Datos.DAOProductos;
import MSystem.IS.Datos.DAOVentas;
import MSystem.IS.Datos.DatabaseException;
import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Modelo.Platillo;
import MSystem.IS.Modelo.Producto;
import MSystem.IS.Servicios.ServicioAdministracion;
import MSystem.IS.Servicios.ServicioProductos;
import MSystem.IS.Servicios.ServicioVentas;

public class Principal {

	private DAOVentas controlDBV = new DAOVentas();
	private ServicioVentas servVent = new ServicioVentas(controlDBV);
	private ControlVentas controlVent = new ControlVentas(servVent);
	private DAOProductos controlDBProd = new DAOProductos();
	private ServicioProductos servProd = new ServicioProductos(controlDBProd);
	private ControlProductos controlProd = new ControlProductos(servProd);
	private DAOAdministracion controlDBAdmin = new DAOAdministracion();
	private ServicioAdministracion servAdmin = new ServicioAdministracion(controlDBAdmin);
	private ControlAdministracion controlAdmin = new ControlAdministracion(servAdmin);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal app = new Principal();

		app.inicia();

	}

	public Principal() {

	}

	public void inicia() {
		// System.out.println("La a plicacion ha iniciado");
		// Manda llamar a la ventana principal
//		 Platillo p = new Platillo("Tacos al pastor", "comida", 10);
//		 controlDBV.agregarPlatillo(p);
//		 Platillo p1 = new Platillo("Fanta", "bebida", 10);
//		 controlDBV.agregarPlatillo(p1);
//		 Platillo p2 = new Platillo("Tacos de Gisado", "comida", 12.5);
//		 controlDBV.agregarPlatillo(p2);
//		 Platillo p3 = new Platillo("Sincronizadas", "comida", 6.5);
//		 controlDBV.agregarPlatillo(p3);
//		 Platillo p4 = new Platillo("Nachos", "comida", 15.5);
//		 controlDBV.agregarPlatillo(p4);
//		 Platillo p5 = new Platillo("Maruchan preparada", "comida", 10);
//		 controlDBV.agregarPlatillo(p5);
//		 Platillo p6 = new Platillo("Jumex", "bebida", 9);
//		 controlDBV.agregarPlatillo(p6);
//		 Platillo p7 = new Platillo("Vida", "bebida", 7.5);
//		 controlDBV.agregarPlatillo(p7);
//		 Platillo p8 = new Platillo("Papas a la francesa", "comida", 15.5);
//		 controlDBV.agregarPlatillo(p8);
//		 Platillo p9 = new Platillo("Tacos dorados", "comida", 20.5);
//		 controlDBV.agregarPlatillo(p9);
//		 Platillo p10 = new Platillo("Pozole", "comida", 40);
//		 controlDBV.agregarPlatillo(p10);
//		 Platillo p11 = new Platillo("Quesadillas", "comida", 23.5);
//		 controlDBV.agregarPlatillo(p11);
//		 Platillo p12 = new Platillo("Sopa de verduras", "comida", 50);
//		 controlDBV.agregarPlatillo(p12);
//		 Platillo po = new Platillo("Mole", "comida", 40);
//		 controlDBV.agregarPlatillo(po);
//		 Platillo po1 = new Platillo("Mole verde", "comida", 40);
//		 controlDBV.agregarPlatillo(po1);
//		 Platillo pl = new Platillo("Pepsi", "bebida", 15);
//		 controlDBV.agregarPlatillo(pl);
		// Platillo[] lista = controlVent.mostrarMenu();

		// Pedido pu= new Pedido(2,p,2);
		// try {
		//
		// System.out.println(controlDBV.ActualizaPedidos(pu));
		//
		// } catch (DatabaseException | SQLException e) {
		// e.printStackTrace();
		// }

		// for(int i = 0; i < lista.length; i ++)
		// System.out.print(lista[i] + " ");
		//
		// System.out.println();
		// controlVent.muestraGCuenta(18);
		// Platillo aux = controlVent.buscarPlatillo(p);
		//
		// System.out.println("Platillo encontrado: " + aux);
		// controlVent.iniciaMostrarMenu(5);
		// Pedido[] ped = controlDBV.mostrarPedidos();
		// for(int i = 2; i < ped.length; i ++)
		// System.out.println(ped[i].getPlatillo().getNombrePlatillo() + " " +
		// ped[i].getCantidadPlatillo() + " " + ped[i].getNoMesa());
		// controlVent.muestraGCuenta(5);

		// Producto prod = new Producto("chiles secos", 19);
		// controlProd.agregarProductoCocina(prod);

		// Producto p = new Producto("lo que sea", 12);
		// try {
		// System.out.println(controlDBProd.guardaFaltantes(p));
		// } catch (DatabaseException | SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

//		 controlDBProd.insertaProd("Jitomate", 12);
//		 controlDBProd.insertaProd("Cebolla", 11);
//		 controlDBProd.insertaProd("Chiles", 3);
//		 controlDBProd.insertaProd("Mayonesa", 7);
//		 controlDBProd.insertaProd("Catsup", 4);
//		 controlDBProd.insertaProd("Chuletas", 6);
//		 controlDBProd.insertaProd("Papas", 3);
//		 controlDBProd.insertaProd("Maruchan", 4);
//		 controlDBProd.insertaProd("Tortillas", 5);
//		 controlDBProd.insertaProd("Ajos", 3);
//		 controlDBProd.insertaProd("Pimiento morron", 12);
		//

//		 Producto p = new Producto("Jitomate", 12);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Cebolla", 11);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Chiles", 3);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Mayonesa", 7);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Catsup", 4);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Chuletas", 6);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Papas", 3);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Maruchaan", 4);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Tortillas", 5);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Ajos", 3);
//		 controlProd.agregarProductoCocina(p);
//		 p = new Producto("Pimiento morron", 12);
//		 controlProd.agregarProductoCocina(p);		 
		
		controlAdmin.vistaLogin();

	}
}