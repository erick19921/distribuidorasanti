package minimarketdemo.model.ventas.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.InvDistribuidore;
import minimarketdemo.model.core.entities.VenCliente;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerVenClientes
 */
@Stateless
@LocalBean
public class ManagerVenClientes {
	@EJB
	ManagerDAO mDAO;
    /**
     * Default constructor. 
     */
    public ManagerVenClientes() {
       
    }

  //Tabla Distribuidores
    public List<VenCliente> findAllVenClientes(){
    	return mDAO.findAll(VenCliente.class, "cliNombre");
    }
    
    public void insertarClientes(VenCliente nuevoCliente) throws Exception {
    	mDAO.insertar(nuevoCliente);
    }

    public void actualizarClientes(VenCliente edicionCliente) throws Exception{
    	VenCliente cli = (VenCliente) mDAO.findById(VenCliente.class, edicionCliente.getIdCliente());
    	cli.setCliNombre(edicionCliente.getCliNombre());
    	cli.setCliApellido(edicionCliente.getCliApellido());
    	cli.setCliDireccion(edicionCliente.getCliDireccion());
    	cli.setCliCedula(edicionCliente.getCliCedula());
    	cli.setCliTelefono(edicionCliente.getCliTelefono());
    	mDAO.actualizar(cli);
    }
    
    public void eliminaCliente(int idCliente) throws Exception{
    	mDAO.eliminar(VenCliente.class, idCliente);
    }
    
    public VenCliente buscarClientebyCI(String cedula) throws Exception{
    	VenCliente busqCli = (VenCliente) mDAO.findById(VenCliente.class, cedula);
    	return busqCli;
    }
    
    public VenCliente buscarClientebyID(int idCliente) throws Exception{
    	VenCliente busqCli = (VenCliente) mDAO.findById(VenCliente.class, idCliente);
    	return busqCli;
    }
     
}
