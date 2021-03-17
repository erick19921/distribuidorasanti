package minimarketdemo.model.inventario.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.Distribuidore;
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
    
    public List<Distribuidore> findAllDistribuidores(){
    	return mDAO.findAll(Distribuidore.class, "nombreDist");
    }
    
    public void insertarDistribuidor(String nombreDistribuidor, String telefonoDistribuidor,String DireccionDistribuidor) throws Exception {
    	
    }

}
