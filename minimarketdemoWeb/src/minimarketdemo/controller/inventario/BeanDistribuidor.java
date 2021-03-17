package minimarketdemo.controller.inventario;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.Distribuidore;
import minimarketdemo.model.core.entities.Marca;
import minimarketdemo.model.inventario.managers.ManagerDistribuidor;
import minimarketdemo.model.inventario.managers.ManagerMarca;

@Named
@SessionScoped
public class BeanDistribuidor {
	@EJB
	private ManagerDistribuidor managerDistribuidor;
	private List<Distribuidore> listaDistribuidor;
	private Distribuidore nuevoDistribuidor;
	private Distribuidore edicionDistribuidor;

	public BeanDistribuidor() {
		// TODO Auto-generated constructor stub
	}

	public String actionMenuDistribuidor() {
		listaDistribuidor = managerDistribuidor.findAllDistribuidores();
		return "distribuidores";
	}
	
	public String actionMenuNuevoDistribuidor() {
		nuevoDistribuidor = new Distribuidore();
		return "distribuidor_nuevo";
	}
	
	public void actionListenerInsertarNuevoDistribuidor() {
		try {
			managerDistribuidor.insertarDistribuidor(nuevoDistribuidor);
			listaDistribuidor = managerDistribuidor.findAllDistribuidores();
			JSFUtil.crearMensajeINFO("Distribuidor Creado");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionSeleccionarEdicionDistribuidor(Distribuidore distribuidor) {
		edicionDistribuidor = distribuidor;
		return "distribuidor_edicion";
	}
	
	public void actionListenerActualizarEdicionDistribuidor() {
		try {
			managerDistribuidor.actualizarDistribuidor(edicionDistribuidor);
			listaDistribuidor = managerDistribuidor.findAllDistribuidores();
			JSFUtil.crearMensajeINFO("Distribuidor actualizado");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarDistribuidor(int idDistribuidor) {
		try {
			managerDistribuidor.eliminarDistribuidor(idDistribuidor);
			listaDistribuidor = managerDistribuidor.findAllDistribuidores();
			JSFUtil.crearMensajeINFO("Distribuidor eliminado");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public List<Distribuidore> getListaDistribuidor() {
		return listaDistribuidor;
	}

	public void setListaDistribuidor(List<Distribuidore> listaDistribuidor) {
		this.listaDistribuidor = listaDistribuidor;
	}

	public Distribuidore getNuevoDistribuidor() {
		return nuevoDistribuidor;
	}

	public void setNuevoDistribuidor(Distribuidore nuevoDistribuidor) {
		this.nuevoDistribuidor = nuevoDistribuidor;
	}

	public Distribuidore getEdicionDistribuidor() {
		return edicionDistribuidor;
	}

	public void setEdicionDistribuidor(Distribuidore edicionDistribuidor) {
		this.edicionDistribuidor = edicionDistribuidor;
	}
	
	
	
	
}
