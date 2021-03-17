package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contabilidad database table.
 * 
 */
@Entity
@NamedQuery(name="Contabilidad.findAll", query="SELECT c FROM Contabilidad c")
public class Contabilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contabilidad")
	private Integer idContabilidad;

	@Column(name="egresos_con")
	private double egresosCon;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_contabilidad")
	private Date fechaContabilidad;

	@Column(name="ingreso_con")
	private double ingresoCon;

	@Column(name="total_inout")
	private double totalInout;

	public Contabilidad() {
	}

	public Integer getIdContabilidad() {
		return this.idContabilidad;
	}

	public void setIdContabilidad(Integer idContabilidad) {
		this.idContabilidad = idContabilidad;
	}

	public double getEgresosCon() {
		return this.egresosCon;
	}

	public void setEgresosCon(double egresosCon) {
		this.egresosCon = egresosCon;
	}

	public Date getFechaContabilidad() {
		return this.fechaContabilidad;
	}

	public void setFechaContabilidad(Date fechaContabilidad) {
		this.fechaContabilidad = fechaContabilidad;
	}

	public double getIngresoCon() {
		return this.ingresoCon;
	}

	public void setIngresoCon(double ingresoCon) {
		this.ingresoCon = ingresoCon;
	}

	public double getTotalInout() {
		return this.totalInout;
	}

	public void setTotalInout(double totalInout) {
		this.totalInout = totalInout;
	}

}