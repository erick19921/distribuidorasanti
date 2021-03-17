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
public class ManagerMarca {
@EJB
ManagerDAO mDAO;
    public ManagerMarca() {
        
    }
    
    //Tabla Marca
    public List<Marca> findAllMarca(){
 	   return mDAO.findAll(Marca.class, "idMarca");
    }
    
    public void insertarMarca(Marca nuevaMarca) throws Exception{
 	   mDAO.insertar(nuevaMarca);
    }
    
    public void actualizarMarca(Marca edicionMarca) throws Exception{
 	   Marca marca = (Marca) mDAO.findById(Marca.class, edicionMarca.getIdMarca());
 	   marca.setMarcNombre(edicionMarca.getMarcNombre());
 	   mDAO.actualizar(marca);
    }
    
    public void eliminarMarca(int idMarca) throws Exception{
 	   mDAO.eliminar(Marca.class, idMarca);
    }

    
    
  
}
