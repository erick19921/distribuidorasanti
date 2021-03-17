package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distribuidores database table.
 * 
 */
@Entity
@Table(name="distribuidores")
@NamedQuery(name="Distribuidore.findAll", query="SELECT d FROM Distribuidore d")
public class Distribuidore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_distribuidor")
	private Integer idDistribuidor;

	@Column(name="direccion_dist")
	private String direccionDist;

	@Column(name="nombre_dist")
	private String nombreDist;

	@Column(name="telefono_dist")
	private String telefonoDist;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="distribuidore")
	private List<Producto> productos;

	public Distribuidore() {
	}

	public Integer getIdDistribuidor() {
		return this.idDistribuidor;
	}

	public void setIdDistribuidor(Integer idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	public String getDireccionDist() {
		return this.direccionDist;
	}

	public void setDireccionDist(String direccionDist) {
		this.direccionDist = direccionDist;
	}

	public String getNombreDist() {
		return this.nombreDist;
	}

	public void setNombreDist(String nombreDist) {
		this.nombreDist = nombreDist;
	}

	public String getTelefonoDist() {
		return this.telefonoDist;
	}

	public void setTelefonoDist(String telefonoDist) {
		this.telefonoDist = telefonoDist;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setDistribuidore(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setDistribuidore(null);

		return producto;
	}

}