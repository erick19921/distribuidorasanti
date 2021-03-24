package minimarketdemo.model.ventas.managers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.InvProducto;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.inventario.managers.ManagerInventario;
import minimarketdemo.model.ventas.dtos.ProductoDto;

/**
 * Session Bean implementation class ManagerVenCarrito
 */
@Stateless
@LocalBean
public class ManagerVenCarrito {
	@EJB
	ManagerInventario mInventario;
	@EJB
	ManagerDAO mDAO;

	/**
	 * Default constructor.
	 */
	public ManagerVenCarrito() {
		// TODO Auto-generated constructor stub
	}

	public List<ProductoDto> generarDatosProductos() {
		List<ProductoDto> listado = new ArrayList<ProductoDto>();
		List<InvProducto> listadoInventario = mInventario.findAllProductos();
		InvProducto invproducto;
		for (int i = 0; i < listadoInventario.size(); i++) {
			invproducto = listadoInventario.get(i);
			listado.add(new ProductoDto(invproducto.getCodProducto(), invproducto.getProNombre(),
					invproducto.getInvMarca().getMarcNombre(), invproducto.getProPresio(), invproducto.getStock()));
		}
		return listado;

	}

	public ProductoDto findProductoDtobyCod(List<ProductoDto> listado, int codProducto) {
		for (int i = 0; i < listado.size(); i++) {
			if (codProducto == listado.get(i).getCodProducto()) {
				return listado.get(i);
			}
		}
		return null;
	}

	public List<ProductoDto> agregarProductoCarrito(List<ProductoDto> carrito, ProductoDto producto) throws Exception {
		if (carrito == null){
			carrito = new ArrayList<ProductoDto>();
			if ((producto.getStock() - producto.getCantidadIngresada()) >= 0) {
				producto.setStock(producto.getStock() - producto.getCantidadIngresada());
				producto.setCantidad(producto.getCantidadIngresada());
				carrito.add(producto);
				producto.setCantidadIngresada(0);
			} else {
				throw new Exception("Error,No puedes comprar mas de lo que hay en stock.");
			}
			return carrito;
		}
		if (findProductoDtobyCod(carrito, producto.getCodProducto()) != null) {
			throw new Exception("Error, Producto ya Ingresado");
		} else {
			if ((producto.getStock() - producto.getCantidadIngresada()) >= 0) {
				producto.setStock(producto.getStock() - producto.getCantidadIngresada());
				producto.setCantidad(producto.getCantidadIngresada());
				carrito.add(producto);
				producto.setCantidadIngresada(0);
			} else {
				throw new Exception("Error,No puedes comprar mas de lo que hay en stock.");
			}
		}

		return carrito;

	}

}
