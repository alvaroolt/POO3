package ejerciciosPOO3.gestisimalOrientadoAObjetos;

/**
 * Crea el programa GESTISIMAL (GESTI�n SIMplificada de Almac�n) para llevar el
 * control de los art�culos de un almac�n. De cada art�culo se debe saber el
 * c�digo, la descripci�n, el precio de compra, el precio de venta y el stock
 * (n�mero de unidades). La entrada y salida de mercanc�a supone respectivamente
 * el incremento y decremento de stock de un determinado art�culo. Hay que
 * controlar que no se pueda sacar m�s mercanc�a de la que hay en el almac�n.
 * 
 * Partiendo del enunciado del libro, vamos a planificar el dise�o de la
 * aplicaci�n antes de implementarla:
 * 
 * Necesito una clase Articulo que representa a los art�culos del almac�n. Su
 * estado ser�: c�digo, descripci�n, precio de compra, precio de venta y n�mero
 * de unidades (nunca negativas). Como comportamiento: Considero que el c�digo
 * va a generarse de forma autom�tica en el constructor, as� no puede haber dos
 * art�culos con el mismo c�digo. Esto implica que no puede modificarse el
 * c�digo de un art�culo. S� el resto de las propiedades. Podremos mostrar el
 * art�culo, por lo que necesito una representaci�n del art�culo en forma de
 * cadena (toString) Clase Almacen que realice el alta, baja, modificaci�n,
 * entrada de mercanc�a (incrementa unidades), salida de mercanc�a (decrementa
 * unidades) El estado ser� un ArrayList de art�culos. Esta clase es un
 * envoltorio de un ArrrayList. Su comportamiento ser�: a�adir art�culos (no
 * puede haber dos art�culos iguales), eliminar art�culos, incrementar las
 * existencias de un articulo (se delega en la clase art�culo), decrementar las
 * existencias de un art�culo (nunca por debajo de cero, se delega en la clase
 * art�culo), devolver un art�culo (para mostrarlo). Para listar el almac�n
 * podr�a devolverse una cadena con todos los art�culos del almac�n (toString)
 * Clase TestAlmacen, donde se realiza la comunicaci�n con el usuario (mostrar
 * men� y recuperar opci�n del men�, mostrar errores, listar) y se manipula el
 * almac�n. Debes organizarla en m�todos que deleguen en la clase almac�n
 * (listar, annadir, eliminar... al menos uno por cada una de las opciones del
 * men�).
 * 
 * @author �lvaro Leiva
 * @author Rafael Infante
 * @version 1.0
 */

public class Articulo {

	// variable est�tica que utilizo para obtener el codigo de cada articulo
	private static int contador = 1;

	// atributos del Articulo
	private int codigo;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int stock;

	// constructor
	public Articulo(String descripcion, double precioCompra, double precioVenta, int stock) {

		this.codigo = generaCodigo();
		this.descripcion = descripcion;
		do {
			this.precioCompra = precioCompra;
			this.precioVenta = precioVenta;
		} while (!ventaMayorQueCompra());
		this.stock = stock;
		compruebaStrock();

	}

	// constructor (2)
	public Articulo(int codigo) {
		setCodigo(codigo);
	}

	public int getCodigo() {
		return codigo;
	}

	@SuppressWarnings("unused")
	private void setCodigo(int codigoId) {
		this.codigo = codigoId;
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

	// m�todo que genera un c�digo para cada art�culo de forma autom�tica
	private int generaCodigo() {
		int codigo = contador;
		contador++;
		return codigo;
	}

	// m�todo que comprueba que el precio de venta sea mayor que el de compra (no
	// puede ser al rev�s, el almac�n no obtendr�a beneficios)
	private boolean ventaMayorQueCompra() {
		if (getPrecioVenta() > getPrecioCompra()) {
			return true;
		} else {
			System.out.println("Precio de venta no puede ser menor que precio de compra.");
			return false;
		}
	}

	// m�todo que comprueba que el valor del stock del art�culo no sea negativo. En
	// el caso de serlo devuelve 0
	private void compruebaStrock() {
		if (getStock() < 0) {
			setStock(0);
		}
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

	public void modificarArticulo(String descripcion, double precioCompra, double precioVenta, int stock) {
		setDescripcion(descripcion);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setStock(stock);
	}

	public void incrementarStock(int cantidad) {

		setStock(getStock() + cantidad);

	}

	public void decrementarStock(int cantidad) {

		setStock(getStock() - cantidad);

	}

	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra
				+ "�, precioVenta=" + precioVenta + "�, stock=" + stock + "]";
	}

}
