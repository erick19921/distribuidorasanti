package minimarketdemo.model.ventas.dtos;

public class ProductoDto {
    private int codProducto;
    private String proNombre;
    private String marcaNombre;
    private double proPresio;
    private int stock;
	
	public ProductoDto(int codProducto, String proNombre, String marcaNombre, double proPresio, int stock) {
		super();
		this.codProducto = codProducto;
		this.proNombre = proNombre;
		this.marcaNombre = marcaNombre;
		this.proPresio = proPresio;
		this.stock = stock;
	}
	
	public String getMarcaNombre() {
		return marcaNombre;
	}

	public void setMarcaNombre(String marcaNombre) {
		this.marcaNombre = marcaNombre;
	}

	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public String getProNombre() {
		return proNombre;
	}
	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}
	public double getProPresio() {
		return proPresio;
	}
	public void setProPresio(double proPresio) {
		this.proPresio = proPresio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
    
}
