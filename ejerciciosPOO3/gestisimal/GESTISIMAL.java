package ejerciciosPOO3.gestisimal;

/**
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el
 * control de los artículos de un almacén. De cada artículo se debe saber el
 * código, la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades). La entrada y salida de mercancía supone respectivamente
 * el incremento y decremento de stock de un determinado artículo. Hay que
 * controlar que no se pueda sacar más mercancía de la que hay en el almacén.
 * 
 * @author Álvaro Leiva
 * @author Rafael Infante
 * @version 1.0
 */
public class GESTISIMAL {

	// atributos del Articulo
	private String codigoId;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int stock;

	// constructor
	public GESTISIMAL(String codigo, String descripcion, double precioCompra, double precioVenta, int stock) {

		this.codigoId = codigo;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;

	}

	public String getCodigoId() {
		return codigoId;
	}

	public void setCodigoId(String codigoId) {
		this.codigoId = codigoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/*
	 * (non-Javadoc)
	 * El objetivo de hashCode es devolver un número entero que 'identifica' al objeto.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoId == null) ? 0 : codigoId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * Se usa para saber si dos objetos son del mismo tipo y tienen los mismos datos (boolean).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GESTISIMAL other = (GESTISIMAL) obj;
		if (codigoId == null) {
			if (other.codigoId != null)
				return false;
		} else if (!codigoId.equals(other.codigoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Articulo [codigoId=" + codigoId + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra
				+ "€, precioVenta=" + precioVenta + "€, stock=" + stock + "]";
	}

}
