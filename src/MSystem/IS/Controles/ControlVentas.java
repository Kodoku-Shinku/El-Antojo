package MSystem.IS.Controles;

import java.util.ArrayList;

import MSystem.IS.Modelo.Pedido;
import MSystem.IS.Modelo.Platillo;
import MSystem.IS.Servicios.ServicioVentas;
import MSystem.IS.Vistas.GenerarCuenta;
import MSystem.IS.Vistas.VistaConsultarFaltantes;
import MSystem.IS.Vistas.VistaConsultarMenu;
import MSystem.IS.Vistas.VistaFinalizarOrden;

public class ControlVentas {

	private ServicioVentas servVent;
	private int noMesa = 0;

	public ControlVentas(ServicioVentas servVent) {
		this.servVent = servVent;
	}

	/**
	 * Metodo que muestra la ventana de la vista Consultar Menu
	 *
	 * @param noMesa
	 */
	public void iniciaMostrarMenu(int noMesa) {
		this.noMesa = noMesa;
		try {
			VistaConsultarMenu frame = new VistaConsultarMenu(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que muestra el numero de mesa
	 *
	 * @return el numero de mesa
	 */
	public int muestraNoMesa() {
		return servVent.muestraNoMesa(noMesa);
	}

	/**
	 * Metodo que agrega un pedido a la base de datos
	 *
	 * @param platillo
	 * @param cantidadPlatillo
	 * @return true si el pedidio se agrego con exito, false de lo contrario
	 */
	public boolean agregarPedido(Platillo platillo, int cantidadPlatillo) {
		Pedido ped = new Pedido(cantidadPlatillo, platillo, noMesa);

		return servVent.agregarPedido(ped) == true;

	}

	/**
	 * Metodo que sirve para buscar un platillo de la base de datos
	 *
	 * @param platillo
	 * @return el platillo encontrado o null de no exitir
	 */
	public Platillo buscarPlatillo(Platillo platillo) {
		return servVent.recuperaPlatillo(platillo);
	}

	/**
	 * Metodo que regresa el contenido de la tabla Platillos
	 *
	 * @return un arreglo con el contenido de la base de datos
	 */
	public Platillo[] mostrarMenu() {
		return servVent.muestraMenu();
	}

	public ArrayList<Pedido> traepedido() {

		System.out.println("ControlVentas: " + noMesa);
		return servVent.ped(noMesa);

	}

	// Constructor de nuestro Generar cuenta
	public void muestraGCuenta(int noMesa) {
		this.noMesa = noMesa;
		try {
			GenerarCuenta frame = new GenerarCuenta(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double total(ArrayList<Pedido> traepedido) {
		return (servVent.muestralTotal(traepedido));
	}

	public void getTicket(ArrayList<Pedido> traepedido) {
		servVent.getTicket(traepedido);

	}
	
	//recupera los pedidos
	public Pedido[] PlatillosPorHacer(){
		return servVent.recuperaPedidos();
		
	}
	
	//metodo que inicia la ventana finalizar orden
	public void inicia() {
		
		try {
			VistaFinalizarOrden frame = new VistaFinalizarOrden();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//agrega los pedidos que ya se realizaron
	
	public boolean FinalizarO(Pedido pedido) {
		int cantidad = pedido.getCantidadPlatillo();
		Platillo platillo = pedido.getPlatillo();
		int noMesa = pedido.getNoMesa();
		Pedido FinalPedido = new Pedido(cantidad,platillo,noMesa);

		return servVent.FinalizarO(pedido) == true;

	}
	//recupera los pedidos realizados para mostrarlo en una nueva tabla
	public Pedido[] PedidosFinalizados(){
		return servVent.recuperaPedidosF();
		
	}
	

}
