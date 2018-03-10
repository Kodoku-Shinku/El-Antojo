package MSystem.IS.Modelo;

public class Platillo {
	private String nombrePlatillo; // El platillo puede ser comida o una bebida
	private double precio;
	private int id;
	private String tipo; // Diferencia entre una bebida y un platillo

	/**
	 * Contructor de la clase Menu. Inicializa los datos del menu
	 * 
	 * @param nombrePlatillo
	 * @param tipo
	 * @param precio
	 */
	public Platillo(String nombrePlatillo, String tipo, double precio) {
		this.nombrePlatillo = nombrePlatillo;
		this.precio = precio;
		this.tipo = tipo;
	}

	public String getNombrePlatillo() {
		return nombrePlatillo;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public void setNombrePlatillo(String nombrePlatillo){
		this.nombrePlatillo = nombrePlatillo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}

	public String toString() {
		return "id: " + id +  " tipo: " + tipo + " " + nombrePlatillo + " | " + precio;
	}

}
