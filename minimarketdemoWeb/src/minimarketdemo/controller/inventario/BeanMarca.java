package minimarketdemo.controller.inventario;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.Marca;
import minimarketdemo.model.inventario.managers.ManagerMarca;

@Named
@SessionScoped
public class BeanMarca implements Serializable {

	@EJB
	private ManagerMarca managerMarca;
	private List<Marca> listaMarca;
	private Marca nuevaMarca;
	private Marca edicionMarca;
	
	public BeanMarca() {
		// TODO Auto-generated constructor stub
	}
	
	public String actionMenuNuevaMarca() {
		nuevaMarca = new Marca();
		return "marca_nueva";
	}
	
	public String actionMenuMarca() {
		listaMarca = managerMarca.findAllMarca();
		return "marca";
	}
	
	public void actionListenerInsertarNuevaMarca() {
		try {
			managerMarca.insertarMarca(nuevaMarca);
			listaMarca = managerMarca.findAllMarca();
			nuevaMarca = new Marca();
			JSFUtil.crearMensajeINFO("Marca Creada");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public String actionSeleccionarEdicionMarca(Marca marca) {
		edicionMarca = marca;
		return "marca_edicion";
	}
	
	public void actionListenerActualizarEdicionMarca() {
		try {
			managerMarca.actualizarMarca(edicionMarca);
			listaMarca = managerMarca.findAllMarca();
			JSFUtil.crearMensajeINFO("Marca Actualizada");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void actionListenerEliminarMarca(int idMarca) {
		try {
			managerMarca.eliminarMarca(idMarca);
			listaMarca = managerMarca.findAllMarca();
			JSFUtil.crearMensajeINFO("Marca eliminada");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Marca> getListaMarca() {
		return listaMarca;
	}

	public void setListaMarca(List<Marca> listaMarca) {
		this.listaMarca = listaMarca;
	}

	public Marca getNuevaMarca() {
		return nuevaMarca;
	}

	public void setNuevaMarca(Marca nuevaMarca) {
		this.nuevaMarca = nuevaMarca;
	}

	public Marca getEdicionMarca() {
		return edicionMarca;
	}

	public void setEdicionMarca(Marca edicionMarca) {
		this.edicionMarca = edicionMarca;
	}
	

	
}
