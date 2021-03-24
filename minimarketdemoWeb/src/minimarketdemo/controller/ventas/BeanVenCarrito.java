package minimarketdemo.controller.ventas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.ventas.dtos.ProductoDto;
import minimarketdemo.model.ventas.managers.ManagerVenCarrito;

@Named
@SessionScoped
public class BeanVenCarrito implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerVenCarrito mCarrito;
	private List<ProductoDto> listado;
	private List<ProductoDto> carrito;


	@PostConstruct
	public void inicializar() {
		listado = mCarrito.generarDatosProductos();
	}

	public String actionMenuCarrito() {
		return "Carrito";
	}

	public String actionMenuProductos() {

		return "Ventas";
	}

	public void actionListenerAgregerProducto(ProductoDto P) {
		try {
			carrito = mCarrito.agregarProductoCarrito(carrito, P);
			JSFUtil.crearMensajeINFO("Producto agregado al carrito");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();

		}
	}

	public List<ProductoDto> getListado() {
		return listado;
	}

	public void setListado(List<ProductoDto> listado) {
		this.listado = listado;
	}

	public List<ProductoDto> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<ProductoDto> carrito) {
		this.carrito = carrito;
	}


  
}
