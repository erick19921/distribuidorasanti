 package minimarketdemo.controller.ventas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.ventas.dtos.ProductoDto;
import minimarketdemo.model.ventas.managers.ManagerVenCarrito;

@Named
@SessionScoped
public class ControllerCarrito implements Serializable {
private static final long serialVersionUID =1L;
@EJB 
private ManagerVenCarrito mCarrito;
private List<ProductoDto> listado;
@PostConstruct
public void inicializar() {
	 listado=mCarrito.generarDatosProductos();
	 
}
public List<ProductoDto> getListado() {
	return listado;
}
public void setListado(List<ProductoDto> listado) {
	this.listado = listado;
}

}
