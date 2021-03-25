package minimarketdemo.model.ventas.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.VenCliente;
import minimarketdemo.model.core.entities.VenVenta;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerVenVenta
 */
@Stateless
@LocalBean
public class ManagerVenVenta {

    /**
     * Default constructor. 
     */
	@EJB
    ManagerDAO mDAO;
    public ManagerVenVenta() {
        // TODO Auto-generated constructor stub
    }

    
    public List<VenVenta> findAllVenta(){
    	return mDAO.findAll(VenVenta.class, "idVenta");
    }
    
    public void insertarCabeceraVenta(VenVenta nuevaVenta, String cedula) throws Exception {
    	VenCliente cliente = (VenCliente)mDAO.findById(VenCliente.class, cedula);
    	nuevaVenta.setVenCliente(cliente);
    	mDAO.insertar(nuevaVenta);
    }
    
    public void eliminarCabeceraVenta(int idVenta) throws Exception{
    	VenVenta cabeceraVenta = (VenVenta)mDAO.findById(VenVenta.class, idVenta);
    	mDAO.eliminar(VenVenta.class, cabeceraVenta.getIdVenta());
    }
    
    public VenVenta findCabeceraVentaById(int idVenta) throws Exception{
    	VenVenta busqVenta = (VenVenta)mDAO.findById(VenVenta.class, idVenta);
    	return busqVenta;
    }
}
