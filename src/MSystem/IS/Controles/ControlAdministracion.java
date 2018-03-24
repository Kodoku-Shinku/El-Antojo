package MSystem.IS.Controles;

import java.util.ArrayList;

import MSystem.IS.Modelo.Empleado;
import MSystem.IS.Servicios.ServicioAdministracion;
import MSystem.IS.Vistas.VistaActualizarEmpleado;

public class ControlAdministracion {
	private ServicioAdministracion servAdmin;
	public ControlAdministracion(ServicioAdministracion servAdmin){
		this.servAdmin = servAdmin;
	}

	public void iniciaActl(){
		try {
			VistaActualizarEmpleado frame = new VistaActualizarEmpleado(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Empleado> cargarLista(){
		return servAdmin.cargarLista();
	}
}
