package minimarketdemo.model.inventario.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.Distribuidore;
import minimarketdemo.model.core.entities.Marca;
import minimarketdemo.model.core.entities.Producto;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerDistribuidores
 */
@Stateless
@LocalBean
public class ManagerInventario {
@EJB
ManagerDAO mDAO;
    public ManagerInventario() {
        
    }
 
    public List<Producto> findAllProductos(){
    	return mDAO.findAll(Producto.class, "proNombre");
    }
    public void insertarProducto(Producto nuevoProducto, int idDistribuidor, int idMarca) throws Exception{
    	Distribuidore distribuidor= (Distribuidore)mDAO.findById(Distribuidore.class, idDistribuidor);
    	Marca marca =(Marca)mDAO.findById(Marca.class, idMarca);
    	nuevoProducto.setMarca(marca);
    	nuevoProducto.setDistribuidore(distribuidor);
    	mDAO.insertar(nuevoProducto);
    }
    public void actualizarProducto(Producto edicionProducto, int idDistribuidor, int idMarca)throws Exception {
    	Distribuidore distribuidor= (Distribuidore)mDAO.findById(Distribuidore.class, idDistribuidor);
    	Marca marca =(Marca)mDAO.findById(Marca.class, idMarca);
    	Producto producto=(Producto)mDAO.findById(Producto.class, edicionProducto.getCodProducto());
    	producto.setDistribuidore(distribuidor);
    	producto.setMarca(marca);
    	producto.setProNombre(edicionProducto.getProNombre());
    	producto.setProPresioAd(edicionProducto.getProPresioAd());
    	producto.setProPrecio(edicionProducto.getProPrecio());
    	producto.setProFechaCompra(edicionProducto.getProFechaCompra());
    	producto.setStock(edicionProducto.getStock());
    	mDAO.actualizar(producto);
    }
 
    public void eliminarProducto(int idProducto) throws Exception {
    	Producto producto=(Producto)mDAO.findById(Producto.class,idProducto);
    	mDAO.eliminar(Producto.class,producto.getCodProducto());
    }
    

    
    
  
}
