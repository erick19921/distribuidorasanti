package minimarketdemo.model.ventas.managers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.InvProducto;
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
    /**
     * Default constructor. 
     */
    public ManagerVenCarrito() {
        // TODO Auto-generated constructor stub
    }
    public List<ProductoDto> generarDatosProductos(){
    	List<ProductoDto> listado= new ArrayList<ProductoDto>();
    	List<InvProducto> listadoInventario= mInventario.findAllProductos();
    	InvProducto invproducto;
    	for(int i=0; i<listadoInventario.size();i++) {
    		invproducto=listadoInventario.get(i);
    		listado.add(new ProductoDto(invproducto.getCodProducto(), invproducto.getProNombre(), invproducto.getInvMarca().getMarcNombre(),invproducto.getProPresio(), invproducto.getStock()));
    	}
   return listado;
    
    }
    
    
    
}
