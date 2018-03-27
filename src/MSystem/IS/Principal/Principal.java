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
import MSystem.IS.Modelo.Producto;
import MSystem.IS.Servicios.ServicioAdministracion;
import MSystem.IS.Servicios.ServicioProductos;
import MSystem.IS.Servicios.ServicioVentas;

public class Principal {

	DAOVentas controlDBV = new DAOVentas();
	ServicioVentas servVent = new ServicioVentas(controlDBV);
	ControlVentas controlVent = new ControlVentas(servVent);
	DAOProductos controlDBProd = new DAOProductos();
	ServicioProductos servProd = new ServicioProductos(controlDBProd);
	ControlProductos controlProd = new ControlProductos(servProd);
	DAOAdministracion controlDBAdmin = new DAOAdministracion();
	ServicioAdministracion servAdmin = new ServicioAdministracion(controlDBAdmin);
	ControlAdministracion controlAdmin = new ControlAdministracion(servAdmin);

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
		// Platillo p = new Platillo("Tacos al pastor", "comida", 10);
		// controlDBV.agregarPlatillo(p);
		// Platillo p1 = new Platillo("Fanta", "bebida", 10);
		// controlDBV.agregarPlatillo(p1);
		// Platillo p2 = new Platillo("Tacos de Gisado", "comida", 12.5);
		// controlDBV.agregarPlatillo(p2);
		// Platillo p3 = new Platillo("Sincronizadas", "comida", 6.5);
		// controlDBV.agregarPlatillo(p3);
		// Platillo p4 = new Platillo("Nachos", "comida", 15.5);
		// controlDBV.agregarPlatillo(p4);
		// Platillo p5 = new Platillo("Maruchan preparada", "comida", 10);
		// controlDBV.agregarPlatillo(p5);
		// Platillo p6 = new Platillo("Jumex", "bebida", 9);
		// controlDBV.agregarPlatillo(p6);
		// Platillo p7 = new Platillo("Vida", "bebida", 7.5);
		// controlDBV.agregarPlatillo(p7);
		// Platillo p8 = new Platillo("Papas a la francesa", "comida", 15.5);
		// controlDBV.agregarPlatillo(p8);
		// Platillo p9 = new Platillo("Tacos dorados", "comida", 20.5);
		// controlDBV.agregarPlatillo(p9);
		// Platillo p10 = new Platillo("Pozole", "comida", 40);
		// controlDBV.agregarPlatillo(p10);
		// Platillo p11 = new Platillo("Quesadillas", "comida", 23.5);
		// controlDBV.agregarPlatillo(p11);
		// Platillo p12 = new Platillo("Sopa de verduras", "comida", 50);
		// controlDBV.agregarPlatillo(p12);
		// Platillo po = new Platillo("Mole", "comida", 40);
		// controlDBV.agregarPlatillo(po);
		// Platillo po1 = new Platillo("Mole verde", "comida", 40);
		// controlDBV.agregarPlatillo(po1);
		// Platillo pl = new Platillo("Pepsi", "bebida", 15);
		// controlDBV.agregarPlatillo(pl);
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
		//System.out.println();
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
		
//controlAdmin.muestraVentanaAgregarEmpleado();
		
		// Producto p = new Producto("lo que sea", 12);
		// try {
		// System.out.println(controlDBProd.guardaFaltantes(p));
		// } catch (DatabaseException | SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// controlDBProd.insertaProd("Coca-Cola", 1);
		// controlDBProd.insertaProd("Maruchan", 11);
		// controlDBProd.insertaProd("jitomate", 20);
		// controlDBProd.insertaProd("cebolla", 15);
		//
		// Producto p = new Producto("Jitomate", 12);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Cebolla", 11);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Chiles", 3);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Mayonesa", 7);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Catsup", 4);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Chuletas", 6);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Papas", 3);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Maruchaan", 4);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Tortillas", 5);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Ajos", 3);
		// controlProd.agregarProductoCocina(p);
		// p = new Producto("Pimiento morron", 12);
		// controlProd.agregarProductoCocina(p);
		// controlDBP

		// controlVent.iniciaSeleccionarMesa();
		// controlProd.iniciaActualizarProductos();
		controlProd.VistaAdministrador1();
		//controlAdmin.VistaEmpleado();
//		
//Empleado Empleado = new Empleado ("Marisol","Chavarria","Juarez", "escuadron 201", "5524988748","Admin");
//try {
//	System.out.println(controlAdmin.agregarEmpleado(Empleado));
//} catch (DatabaseException | SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}	
		
		// controlVent.inicia();
		// controlProd.muestraProdAdmin();
		// Pedido[] ped = controlDBV.mostrarPedidosF();
		// for(int i = 2; i < ped.length; i ++)
		// System.out.println(ped[i].getPlatillo().getNombrePlatillo() + " " +
		// ped[i].getCantidadPlatillo() + " " + ped[i].getNoMesa());
		
		controlAdmin.iniciaActl();

	}

	public void mostrarMenu(int noMesa) {
		controlVent.iniciaMostrarMenu(noMesa);
	}

	public void GCuenta(int noMesa) {
		controlVent.muestraGCuenta(noMesa);
	}

	public void ActuslizarProd(int cantidad, Producto a) {
		controlProd.actualizaProd(cantidad, a);
	}

//	public void AgregarEmpleado(int nombre, apellidoPaterno, apellidoMaterno, Direccion,){
//		controlAdmin.agregarEmpleado(Empleado);
//	}
	

}