package MSystem.IS.Modelo;

public class Pedido {
	private int cantidadPlatillo;
	private Platillo platillo;
	private int noMesa;
	
	public Pedido(int cantidadPlatillo, Platillo platillo, int noMesa){
		this.cantidadPlatillo = cantidadPlatillo;
		this.platillo = platillo;
		this.noMesa = noMesa;
		
	}
	
	public Platillo getPlatillo(){
		return platillo;
	}
	
	public int getCantidadPlatillo(){
		return cantidadPlatillo;
	}
	
	public int getNoMesa(){
		return noMesa;
	}
	

}
