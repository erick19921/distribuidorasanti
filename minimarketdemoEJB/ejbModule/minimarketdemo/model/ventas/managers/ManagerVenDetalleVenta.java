package minimarketdemo.model.ventas.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.InvDistribuidore;
import minimarketdemo.model.core.entities.InvMarca;
import minimarketdemo.model.core.entities.InvProducto;
import minimarketdemo.model.core.entities.VenDetalleVenta;
import minimarketdemo.model.core.entities.VenVenta;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerDetalleVenta
 */
@Stateless
@LocalBean
public class ManagerVenDetalleVenta {

    @EJB
    ManagerDAO mDAO;
    public ManagerVenDetalleVenta() {
        // TODO Auto-generated constructor stub
    }


       
     
        public List<VenDetalleVenta> findAllDetalleVentas(){
        	return mDAO.findAll(VenDetalleVenta.class, "idDtVenta");
        }
        public void insertarVentaDetalle(VenDetalleVenta nuevodetalleVenta, int idVenta, int codProducto) throws Exception{
        	
        	VenVenta venta=(VenVenta)mDAO.findById(VenVenta.class, idVenta);
        	InvProducto producto=(InvProducto)mDAO.findById(InvProducto.class,codProducto);
        	nuevodetalleVenta.setInvProducto(producto);
        	nuevodetalleVenta.setVenVenta(venta);


        	mDAO.insertar(nuevodetalleVenta);
        }
      
        public void eliminarVentaDetalle(int IdDtVenta) throws Exception {
        	
         	VenDetalleVenta detalleVenta=(VenDetalleVenta)mDAO.findById(VenDetalleVenta.class, IdDtVenta);
        	mDAO.eliminar(VenDetalleVenta.class,detalleVenta.getIdDtVenta());
        }
        

}
