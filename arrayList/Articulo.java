/**Partiendo del enunciado del libro, vamos a planificar el diseño de la aplicación antes de 
 * implementarla:
Necesito una clase Articulo que representa a los artículos del almacén.   
Su estado será: código, descripción, precio de compra, precio de venta y  número de unidades 
(nunca negativas). 
Como comportamiento: Considero que el código va a  generarse de forma automática en el 
constructor, así no puede haber dos  artículos con el mismo código. Esto implica que no puede
 modificarse el  código de un artículo. Sí el resto de las propiedades. Podremos mostrar el 
 artículo, por lo que necesito una representación del artículo en forma de  cadena (toString).
 
@author Rafael Infante
*/

package arrayList;

/*falta metodo equals*/

public class Articulo {

	// atributos de clase Articulo
	static int contador = 1;

	// atributos Articulo
	private int codigo; // codigo que identifica al articulo
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int stock; // unidades en stock

	/**1er constructor
	 * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   */
	public Articulo(String descripcion, double precioCompra, double precioVenta, int stock) {
		this.codigo = generaCodigo();
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
	}
	
	/**2º constructor
	 * @param codigo
   */
	public Articulo(int codigo) {
   setCodigo(codigo);
	}

	// getters and setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	/**
	 * metodo toString. devuelve el estado del objeto Articulo convertido a cadena.
	 */
	@Override
	public String toString() {
		return "Articulo [codigoId=" + codigo + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra
				+ "€, precioVenta=" + precioVenta + "€, stock=" + stock + " unidades]";
	}

	/**
	 * método que genera un código para cada artículo de forma automática
	 * 
	 * @return int
	 */
	public int generaCodigo() {
		int codigo = contador;
		contador++;
		return codigo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Articulo other = (Articulo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	/**
	 * Método modificar usado en Almacen para realizar la modificación.
	 * 
	 * @param descripcion
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 * @throws StockNegativoExceptions
	 */
	public void modificar(String descripcion, double precioCompra, double precioVenta, int stock) {
		setDescripcion(descripcion);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setStock(stock);
	}

	/**
	 * metodo que decrementa el Stock
	 * 
	 * @param cantidad
	 */
	public void decrementaStock(int cantidad) {
		if (cantidad > 0) {
			setStock(getStock()-cantidad);
		}else {
			//añadir excepcion
		}
	}
	/**
	 * metodo que aumenta el Stock
	 * 
	 * @param cantidad
	 */
	public void aumentaStock(int cantidad) {
		if (cantidad > 0) {
			setStock(getStock() + cantidad);
		} else {
			// añadir excepcion
		}
	}

} // fin clase Articulo
