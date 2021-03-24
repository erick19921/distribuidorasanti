package minimarketdemo.controller.ventas;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.VenCliente;
import minimarketdemo.model.ventas.managers.ManagerVenClientes;

@Named
@SessionScoped
public class BeanVenClientes implements Serializable {
  @EJB
  private ManagerVenClientes managerVenClentes;
	private List<VenCliente> listaVenClientes;
	private VenCliente nuevoCliente;
	private VenCliente edicionCliente;
	public BeanVenClientes() {
		
	}
	//Codigo de implemetacion para naveacion en las vistas
	
	public String actionMenuCliente() {
		listaVenClientes = managerVenClentes.findAllVenClientes();
		return "clientes";
	}
	
	public String actionMenuNuevoCliente() {
		nuevoCliente = new VenCliente();
		return "cliente_nuevo";
	}
	
	public String actionSeleccionarEdicionCliente(VenCliente cliente) {
		edicionCliente = cliente;
		return "cliente_edicion";
	}
	//Codigo de ejecucion para las vistas
	public void actionListenerInsertarNuevoCliente() {
		try {
			managerVenClentes.insertarClientes(nuevoCliente);
			listaVenClientes = managerVenClentes.findAllVenClientes();
			JSFUtil.crearMensajeINFO("Nuevo Cliente Creado"+nuevoCliente.getCliNombre());
			
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerActualizarEdicionCliente() {
		try {
			managerVenClentes.actualizarClientes(edicionCliente);
			listaVenClientes = managerVenClentes.findAllVenClientes();
			JSFUtil.crearMensajeINFO("Actualizada la informacion de cliente"+edicionCliente.getCliNombre());
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarCliente(int idCliente) {
		try {
			managerVenClentes.eliminaCliente(idCliente);
			listaVenClientes = managerVenClentes.findAllVenClientes();
			JSFUtil.crearMensajeINFO("Cliente"+ idCliente+"eliminado correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	///Metodos acesores
	public List<VenCliente> getListaVenClientes() {
		return listaVenClientes;
	}
	public void setListaVenClientes(List<VenCliente> listaVenClientes) {
		this.listaVenClientes = listaVenClientes;
	}
	public VenCliente getNuevoCliente() {
		return nuevoCliente;
	}
	public void setNuevoCliente(VenCliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}
	public VenCliente getEdicionCliente() {
		return edicionCliente;
	}
	public void setEdicionCliente(VenCliente edicionCliente) {
		this.edicionCliente = edicionCliente;
	}

}
