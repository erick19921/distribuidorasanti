package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_producto")
	private Integer codProducto;

	@Temporal(TemporalType.DATE)
	@Column(name="pro_fecha_compra")
	private Date proFechaCompra;

	@Column(name="pro_nombre")
	private String proNombre;

	@Column(name="pro_presio")
	private double proPresio;

	@Column(name="pro_presio_ad")
	private double proPresioAd;

	private Integer stock;

	//bi-directional many-to-one association to DetalleFactura
	@OneToMany(mappedBy="producto")
	private List<DetalleFactura> detalleFacturas;

	//bi-directional many-to-one association to Distribuidore
	@ManyToOne
	@JoinColumn(name="id_distribuidor")
	private Distribuidore distribuidore;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="id_marca")
	private Marca marca;

	public Producto() {
	}

	public Integer getCodProducto() {
		return this.codProducto;
	}

	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	public Date getProFechaCompra() {
		return this.proFechaCompra;
	}

	public void setProFechaCompra(Date proFechaCompra) {
		this.proFechaCompra = proFechaCompra;
	}

	public String getProNombre() {
		return this.proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public double getProPresio() {
		return this.proPresio;
	}

	public void setProPresio(double proPresio) {
		this.proPresio = proPresio;
	}

	public double getProPresioAd() {
		return this.proPresioAd;
	}

	public void setProPresioAd(double proPresioAd) {
		this.proPresioAd = proPresioAd;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().add(detalleFactura);
		detalleFactura.setProducto(this);

		return detalleFactura;
	}

	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().remove(detalleFactura);
		detalleFactura.setProducto(null);

		return detalleFactura;
	}

	public Distribuidore getDistribuidore() {
		return this.distribuidore;
	}

	public void setDistribuidore(Distribuidore distribuidore) {
		this.distribuidore = distribuidore;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}