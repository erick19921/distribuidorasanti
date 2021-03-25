package minimarketdemo.controller.ventas;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.ventas.managers.ManagerVenDetalleVenta;

@Named
@SessionScoped
public class BeanVenDetalleVenta implements Serializable {

 @EJB
 ManagerVenDetalleVenta mDetalleventa;
 
 
 
 
  public void actionListenerCrearDetalleVenta() {
	  
  }
  
 
 
 
 
 
 
 
 
 
}


