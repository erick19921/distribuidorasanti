package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_factura database table.
 * 
 */
@Entity
@Table(name="detalle_factura")
@NamedQuery(name="DetalleFactura.findAll", query="SELECT d FROM DetalleFactura d")
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dt_factura")
	private Integer idDtFactura;

	@Column(name="cantidad_dt")
	private Integer cantidadDt;

	@Column(name="total_dt")
	private double totalDt;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="id_factura")
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="cod_producto")
	private Producto producto;

	public DetalleFactura() {
	}

	public Integer getIdDtFactura() {
		return this.idDtFactura;
	}

	public void setIdDtFactura(Integer idDtFactura) {
		this.idDtFactura = idDtFactura;
	}

	public Integer getCantidadDt() {
		return this.cantidadDt;
	}

	public void setCantidadDt(Integer cantidadDt) {
		this.cantidadDt = cantidadDt;
	}

	public double getTotalDt() {
		return this.totalDt;
	}

	public void setTotalDt(double totalDt) {
		this.totalDt = totalDt;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}