package minimarketdemo.controller.inventario;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.Distribuidore;
import minimarketdemo.model.core.entities.Marca;
import minimarketdemo.model.core.entities.Producto;
import minimarketdemo.model.inventario.managers.ManagerDistribuidor;
import minimarketdemo.model.inventario.managers.ManagerInventario;
import minimarketdemo.model.inventario.managers.ManagerMarca;

@Named
@SessionScoped
public class BeanInventario {
	@EJB
	private ManagerInventario mProducto;
	@EJB
	private ManagerDistribuidor mDistribuidor;
	@EJB
	private ManagerMarca mMarca;
	private int idDistribuidor;
	private int idMarca;
	private List<Producto> listaProductos;
	private List<Marca> listaMarcas;
	private List<Distribuidore> listaDistribuidor;
	private Producto nuevoProducto;
	private Producto edicionProducto;
	
	public BeanInventario() {

	}
	
	public String actionMenuProductos() {
		listaProductos=mProducto.findAllProductos();
		return "productos";
	}
	
	
	
	public String actionMenuNuevoProducto() {
		nuevoProducto=new Producto();
		listaMarcas=mMarca.findAllMarca();
		listaDistribuidor=mDistribuidor.findAllDistribuidores();

		return "producto_nuevo";
	}
	
	public void actionListenerInsertarNuevoProducto() {
		try {
			mProducto.insertarProducto(nuevoProducto, idDistribuidor, idMarca);
			listaProductos=mProducto.findAllProductos();
			nuevoProducto=new Producto();
			JSFUtil.crearMensajeINFO("Producto Ingresado Exitosamente.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionSeleccionarEdicionProducto(Producto producto) {
		edicionProducto=producto;
		return "producto_edicion";
	}
	
	public void actionListenerActualizarEdicionProducto() {
		try {
			mProducto.actualizarProducto(edicionProducto, idDistribuidor, idMarca);
			listaProductos=mProducto.findAllProductos();
			JSFUtil.crearMensajeINFO("Producto Actualizado Exitosamente.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarProducto(int idProducto) {
		try {
			mProducto.eliminarProducto(idProducto);
			listaProductos=mProducto.findAllProductos();
			JSFUtil.crearMensajeINFO("Producto Eliminado Exitosamente.");
	
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
