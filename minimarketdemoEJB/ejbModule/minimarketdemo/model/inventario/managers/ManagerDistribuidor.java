package minimarketdemo.model.inventario.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.Distribuidore;
import minimarketdemo.model.core.entities.Marca;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerDistribuidores
 */
@Stateless
@LocalBean
public class ManagerDistribuidor {
@EJB
ManagerDAO mDAO;
    public ManagerDistribuidor() {
        
    }
    
  //Tabla Distribuidores
    public List<Distribuidore> findAllDistribuidores(){
    	return mDAO.findAll(Distribuidore.class, "nombreDist");
    }
    
    public void insertarDistribuidor(Distribuidore nuevoDistribuidor) throws Exception {
    	mDAO.insertar(nuevoDistribuidor);
    }

    public void actualizarDistribuidor(Distribuidore edicionDistribuidor) throws Exception{
    	Distribuidore dist = (Distribuidore) mDAO.findById(Distribuidore.class, edicionDistribuidor.getIdDistribuidor());
    	dist.setNombreDist(edicionDistribuidor.getNombreDist());
    	dist.setTelefonoDist(edicionDistribuidor.getTelefonoDist());
    	dist.setDireccionDist(edicionDistribuidor.getDireccionDist());
    	mDAO.actualizar(dist);
    }
    
    public void eliminarDistribuidor(int idDistribuidor) throws Exception{
    	mDAO.eliminar(Distribuidore.class, idDistribuidor);
    }
    
    
  
}
