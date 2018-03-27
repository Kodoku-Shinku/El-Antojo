package MSystem.IS.Modelo;

public class Empleado {
	
//	Se declaran los atributos privados para que tenga alta cohesion y bajo acoplamiento mi sistema

    private int id;
	private String Nombre;
	private String ApellidoPaterno;
	private String ApellidoMaterno;
	private String Direccion;
	private String Telefono;
	private String Cargo;

	//		declaro el constructor de clase para inicializar los atributos
	public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, String telefono, String Cargo) {

		this.Nombre = nombre;
		this.ApellidoPaterno = apellidoPaterno;
		this.ApellidoMaterno = apellidoMaterno;
		this.Direccion = direccion;
		this.Telefono = telefono;
		this.Cargo = Cargo;
	}


	//	genero los setters y getters de cada uno de los atributos para despues ser invocados
	
	public int getid() {
		return id;

	}

	public void setid(int id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return Nombre;

	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.ApellidoMaterno = apellidoMaterno;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}
	
	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		this.Cargo = cargo;
	}

	//Permite mostrar la información completa de un objeto Personal(de un empleado)
	@Override
	public String toString() {
		return "Personal [Nombre=" + Nombre + ", ApellidoPaterno=" + ApellidoPaterno
				+ ", ApellidoMaterno=" + ApellidoMaterno + ", Direccion=" + Direccion + ", Telefono="
				+ Telefono + ", Cargo=" + Cargo + "]";
	}

}
