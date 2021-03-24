package minimarketdemo.model.ventas.managers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.InvProducto;
import minimarketdemo.model.core.entities.VenCliente;
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
private int posicion;
private int cantidadSumatoria=0;
private int cantidadResultadoEdicion=0;
private int stockResultadoEdicion=0;
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
				posicion=i;
				return listado.get(i);
			}
		}
		return null;
	}
	
	
	
	
    public void eliminarProducto(int codProducto,List<ProductoDto> lista,List<ProductoDto> carrito) throws Exception{
    int cantidad;
    int stock;
    ProductoDto producto=findProductoDtobyCod(carrito, codProducto);
    cantidad=producto.getCantidad();
    stock=producto.getStock();
    System.out.println( producto.getCodProducto());
    carrito.remove(posicion);
    producto=findProductoDtobyCod(lista, codProducto);
    producto.setCantidad(0);
    producto.setStock(stock+cantidad);
    }
    
    public void actualizarCantidad(int cantidadeditado, int codProducto,List<ProductoDto> lista,List<ProductoDto> carrito) throws Exception{
        int cantidad;
      
        ProductoDto producto=findProductoDtobyCod(carrito,codProducto);
        cantidad=producto.getCantidad();


        System.out.println( "Codigo Producto: "+producto.getCodProducto());
        System.out.println( "Cantidad Producto: "+producto.getCantidad());
        System.out.println( "Cantidad ProductoE: "+cantidadeditado);
    	cantidadSumatoria=(producto.getCantidad()-cantidadeditado);
        System.out.println( "Cantidad ProductoS: "+cantidadSumatoria);
        if(cantidadSumatoria<0){
        	cantidadSumatoria=cantidadSumatoria*-1;
            if(carrito.get(posicion).getStock()-cantidadSumatoria>=0) {
            	carrito.get(posicion).setCantidad(cantidadeditado);
            	carrito.get(posicion).setStock(carrito.get(posicion).getStock()-cantidadSumatoria);
            cantidadResultadoEdicion=carrito.get(posicion).getCantidad();
             stockResultadoEdicion=carrito.get(posicion).getStock();
            }else {
            	throw new Exception("Error,No puedes comprar mas de lo que hay en stock.");
            }
        	
        	
        }else {
        	carrito.get(posicion).setCantidad(cantidadeditado);
        	carrito.get(posicion).setStock(cantidadSumatoria+(carrito.get(posicion).getStock()));
        cantidadResultadoEdicion=carrito.get(posicion).getCantidad();
         stockResultadoEdicion=carrito.get(posicion).getStock();
        }
        producto=findProductoDtobyCod(lista, codProducto);
        producto.setCantidad(cantidadResultadoEdicion);
        producto.setStock(stockResultadoEdicion);
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
