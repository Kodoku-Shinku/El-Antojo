package MSystem.IS.Servicios;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MSystem.IS.Datos.DAOVentas;
import MSystem.IS.Datos.DatabaseException;
import MSystem.IS.Modelo.Pedido;
import MSystem.IS.Modelo.Platillo;

public class ServicioVentas {

	private DAOVentas controlDAOV;
	// variable para acumular el total de la venta
	double acumulatotal = 0;

	/**
	 * Constructor de la clase ServicioVentas
	 *
	 * @param controlDAOV
	 */
	public ServicioVentas(DAOVentas controlDAOV) {
		this.controlDAOV = controlDAOV;
	}

	/**
	 * Metodo que agrega un pedido a la base de datos. Regresa tru si se agrego
	 * con exito, false de lo contrario
	 *
	 * @param pedido
	 * @return
	 */
	public boolean agregarPedido(Pedido pedido) {
		try {
			return controlDAOV.agregarPedido(pedido) == true;
		} catch (SQLException e) {
			// Cacha excepcion
			JOptionPane.showMessageDialog(null, "Error al guardar pedido en la base de datos");
			return false;
		}
	}

	/**
	 * Metodo que busca un platillo en la base de datos
	 *
	 * @param platillo
	 * @return el platillo que encuentra, null si no existe en la base de datos
	 */
	public Platillo recuperaPlatillo(Platillo platillo) {
		// boolean prob =
		try {
			return controlDAOV.buscarPlatillo(platillo);
		} catch (DatabaseException | NullPointerException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error al buscar platillo");
		}
		return null;

	}

	/**
	 * Metodo que muestra el contenido de la tabla platillos en la base de datos
	 *
	 * @return un arreglo con el contenido de la tabla
	 */
	public Platillo[] muestraMenu() {
		try {
			return controlDAOV.mostrarMenu();
		} catch (DatabaseException | NullPointerException | SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede recuperar el contenido de la base de datos");
			return null;
		}
	}

	/*Metodo que nos permite carlcular el total de la cuenta
	  consumida por un cliente y se acumula en acumulatotal*/

		public  ArrayList<Pedido> ped (int mesa){
		System.out.println("ServicioVentas: " + mesa);
		ArrayList<Pedido> guardacontrol = controlDAOV.obtenerPedido(mesa);

		return (guardacontrol);
		}

	//Metodo donde se Mandan a traer la cantidad de platillos y sus precio para poder sumar el total de lo consumido
		public double muestralTotal (ArrayList<Pedido> guardacontrol){
		System.out.println("serviciototalmuestraTotal "+acumulatotal);
		double acumulatotal=0;

		for(int i=0; i<guardacontrol.size(); i++)
			acumulatotal=acumulatotal+ guardacontrol.get(i).getCantidadPlatillo() * guardacontrol.get(i).getPlatillo().getPrecio();
		return (acumulatotal);
		}
		
	/**Método que nos permite generar un ticket del pedido realizado
	 * por el cliente, se muestra el platillo, cantidad de platillos, y el total a pagar
	 * */	

	public void getTicket(ArrayList<Pedido> traepedido) {
		// Instancia de una tabla que contendra 3 columnas
		PdfPTable table = new PdfPTable(3);
		//La tabla se muestra sin borde
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		Font black = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
		Chunk blackText = new Chunk("", black);
		Paragraph p1 = new Paragraph(blackText);
		Paragraph p2 = new Paragraph(blackText);
		p1.setAlignment(Element.ALIGN_LEFT);
		p2.setAlignment(Element.HEADER);
		p1.add("            ***************************************************");
		p2.add("            El Antojo");
		/*addCell() agrega una celda a la tabla, el cambio de fila
		 ocurre automaticamente al llenar la fila*/
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell("Platillo");
		table.addCell("Cantidad");
		table.addCell("Precio");
		//se llena el documento pdf con una tabla del pedido
		for (int i = 0; i < traepedido.size(); i++) {
			table.addCell(""+traepedido.get(i).getPlatillo().getNombrePlatillo());
			table.addCell(""+traepedido.get(i).getCantidadPlatillo());
			table.addCell("$"+traepedido.get(i).getPlatillo().getPrecio());
		}
		table.addCell("Total a pagar");
		table.addCell("");
		table.addCell("$"+this.muestralTotal(traepedido));

		try {
			OutputStream texto = new FileOutputStream("/Users/kodokushinku/Desktop/arhivo.pdf");
			Document doc = new Document(PageSize.HALFLETTER, 5, 5, 5, 5);
			PdfWriter.getInstance(doc, texto);
			//se crea la instancia de escritura para el pdf  se añade la tabla y se cierra el documento
			doc.open();
			doc.add(p1);
			doc.add(p2);
			doc.add(p1);
			doc.add(table);
			doc.add(p1);
			doc.add(p1);
			doc.close();
			texto.close();
			//se abre el pdf automaticamente una vez creado
			Desktop.getDesktop().open(new File("/Users/kodokushinku/Desktop/arhivo.pdf"));
		} catch (Exception ex) {

		}
	}

	public int muestraNoMesa(int noMesa) {
		return noMesa;
	}
	
	//Recupera los pedidos que seran mostrados 
public Pedido[] recuperaPedidos() {
		try {
			return controlDAOV.mostrarPedidos();
		} catch (DatabaseException | NullPointerException e) {
			JOptionPane.showMessageDialog(null, "No se puede recuperar el contenido de la base de datos");
			return null;
		}
	}
	//agrega los pedidos en la tabla finalizados
	public boolean FinalizarO(Pedido pedido) {
		try {
			return controlDAOV.ActualizaPedidos(pedido) == true;
		} catch (SQLException e) {
			// Cacha excepcion
			JOptionPane.showMessageDialog(null, "Error al guardar pedido en la base de datos");
			return false;
		}
	}
	//recupera los pedidos finalizados
	public Pedido[] recuperaPedidosF() {
		try {
			return controlDAOV.mostrarPedidosF();
		} catch (DatabaseException | NullPointerException e) {
			JOptionPane.showMessageDialog(null, "No se puede recuperar el contenido de la base de datos ");
			return null;
		}
	}

}
