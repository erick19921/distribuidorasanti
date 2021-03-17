package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mrea_automovil database table.
 * 
 */
@Entity
@Table(name="mrea_automovil")
@NamedQuery(name="MreaAutomovil.findAll", query="SELECT m FROM MreaAutomovil m")
public class MreaAutomovil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String placa;

	public MreaAutomovil() {
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}