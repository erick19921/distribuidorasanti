package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	private Integer idFactura;

	@Column(name="fac_ciudad")
	private String facCiudad;

	@Column(name="fac_cuota_pago")
	private double facCuotaPago;

	@Column(name="fac_iva")
	private double facIva;

	@Column(name="fac_plazo")
	private Integer facPlazo;

	@Column(name="fac_subtotal")
	private double facSubtotal;

	@Column(name="fac_tipo_pago")
	private String facTipoPago;

	@Column(name="fac_total")
	private double facTotal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_factura")
	private Date fechaFactura;

	//bi-directional many-to-one association to DetalleFactura
	@OneToMany(mappedBy="factura")
	private List<DetalleFactura> detalleFacturas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Factura() {
	}

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getFacCiudad() {
		return this.facCiudad;
	}

	public void setFacCiudad(String facCiudad) {
		this.facCiudad = facCiudad;
	}

	public double getFacCuotaPago() {
		return this.facCuotaPago;
	}

	public void setFacCuotaPago(double facCuotaPago) {
		this.facCuotaPago = facCuotaPago;
	}

	public double getFacIva() {
		return this.facIva;
	}

	public void setFacIva(double facIva) {
		this.facIva = facIva;
	}

	public Integer getFacPlazo() {
		return this.facPlazo;
	}

	public void setFacPlazo(Integer facPlazo) {
		this.facPlazo = facPlazo;
	}

	public double getFacSubtotal() {
		return this.facSubtotal;
	}

	public void setFacSubtotal(double facSubtotal) {
		this.facSubtotal = facSubtotal;
	}

	public String getFacTipoPago() {
		return this.facTipoPago;
	}

	public void setFacTipoPago(String facTipoPago) {
		this.facTipoPago = facTipoPago;
	}

	public double getFacTotal() {
		return this.facTotal;
	}

	public void setFacTotal(double facTotal) {
		this.facTotal = facTotal;
	}

	public Date getFechaFactura() {
		return this.fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().add(detalleFactura);
		detalleFactura.setFactura(this);

		return detalleFactura;
	}

	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().remove(detalleFactura);
		detalleFactura.setFactura(null);

		return detalleFactura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}