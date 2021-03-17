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

    
    
    
   public List<Marca> findAllMarca(){
	   return mDAO.findAll(Marca.class, "id_marca");
   }
   
   public Marca insertarMarca(String marc_nombre) throws Exception{
	   Marca nueva = new Marca();
	   nueva.setMarcNombre(marc_nombre);
	   return nueva;
   }
   
   public void actualizarMarca(Marca edicionMarca) throws Exception{
	   Marca marca = (Marca) mDAO.findById(Marca.class, edicionMarca.getIdMarca());
	   marca.setMarcNombre(edicionMarca.getMarcNombre());
   }
   
   public void eliminarMarca(int idMarca) throws Exception{
	   Marca marca = (Marca) mDAO.findById(Marca.class, idMarca);
	   mDAO.eliminar(Marca.class, idMarca);
   }
}
