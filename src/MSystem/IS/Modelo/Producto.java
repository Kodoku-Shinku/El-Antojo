package MSystem.IS.Modelo;

public class Producto {
	private String nombreProducto;
	private double cantidadProducto;
	
	public Producto(String nombreProducto, double cantidadProducto){
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
	}
	
	public String getNombreProducto(){
		return nombreProducto;
	}
	
	public double getCantidadProducto(){
		return cantidadProducto;
	}
	
	public void setCantidadProdcuto(double cantidadProducto){
		this.cantidadProducto = cantidadProducto;
	}

}
