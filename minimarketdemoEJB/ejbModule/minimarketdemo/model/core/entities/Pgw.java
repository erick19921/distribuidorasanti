package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pgw database table.
 * 
 */
@Entity
@NamedQuery(name="Pgw.findAll", query="SELECT p FROM Pgw p")
public class Pgw implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pgw")
	private Integer idPgw;

	private String direccion;

	private String titulo;

	//bi-directional many-to-one association to PgwTipopg
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private PgwTipopg pgwTipopg;

	public Pgw() {
	}

	public Integer getIdPgw() {
		return this.idPgw;
	}

	public void setIdPgw(Integer idPgw) {
		this.idPgw = idPgw;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public PgwTipopg getPgwTipopg() {
		return this.pgwTipopg;
	}

	public void setPgwTipopg(PgwTipopg pgwTipopg) {
		this.pgwTipopg = pgwTipopg;
	}

}