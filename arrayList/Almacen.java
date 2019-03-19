/**Partiendo del enunciado del libro, vamos a planificar el diseño de la  aplicación antes de 
 * implementarla:
 * Clase Almacen que realice el alta, baja, modificación, entrada de  mercancía (incrementa 
 * unidades), salida de mercancía (decrementa unidades).

  El estado será un ArrayList de artículos. Esta clase es un envoltorio de un ArrrayList.
  Su comportamiento será: añadir  artículos (no puede haber dos artículos iguales), eliminar
  artículos,  incrementar las existencias de un articulo (se delega en la clase artículo), 
  decrementar las existencias de un artículo (nunca por debajo de cero, se  delega en la clase
  artículo), devolver un artículo (para mostrarlo). Para  listar el almacén podría devolverse
  una cadena con todos los artículos del almacén (toString).
  
 	@author Rafael Infante
 */
package arrayList;

import java.util.ArrayList;

public class Almacen {

	// variables
	static int i;

	// Creacion de un arraylist para almacenar los objetos tipo Articulo
	ArrayList<Articulo> almacen = new ArrayList<Articulo>();

	/**
	 * metodo que genera la lista de los articulos de mi almacen
	 */
	public void listarAlmacen() {
		if(almacen.isEmpty()) {
			System.out.println("El almacen esta vacio.");
		}
		for (i = 0; i < almacen.size(); i++) {
			System.out.println(almacen.get(i));
		}
	}

	/**
	 * metodo para añadir un objeto articulo al almacen(arraylist).
	 * 
	 * @param codigo
	 * @param descripcion
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 */
	public void annadir(String descripcion, double precioCompra, double precioVenta, int stock) {
		Articulo articulo = new Articulo(descripcion, precioCompra, precioVenta, stock);
		almacen.add(articulo);
	}

	/**
	 * metodo para eliminar un objeto articulo del almacen(arraylist).
	 * 
	 * @param codigo Código del artículo a eliminar
	 */
	public void eliminar(int codigo) {
		codigo--;
		almacen.remove(codigo);
		System.out.println("Codigo eliminado.");
	}

	/**
	 * metodo para modificar un articulo, se puede modificar todo menos el codigo ya
	 * que este nos lo generara automaticamente nuestro arraylist almacen.
	 * 
	 * @param articulo
	 * @param descripcion
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 */
	public void modificar(Articulo articulo, String descripcion, double precioCompra, double precioVenta, int stock) {
		int indice = almacen.indexOf(articulo); // saco el indice con el metodo indexOf
		articulo.modificar(descripcion, precioCompra, precioVenta, stock);
		almacen.set(indice, almacen.get(indice));
	}

	/**
	 * Método get para obtener el codigo del artículo.
	 * A la hora de invocar el metodo modificar es esencial ya que si no no podemos pasar 
	 * un objeto articulo como parametro.
	 * @param codigo
	 * @return
	 */
	public Articulo get(int codigo) {

		return almacen.get(almacen.indexOf(new Articulo(codigo))); // Con get lo que se hace es extraer el código del artículo.
																																
	}



	/**
	 * Método getCodigo para obtener el codigo del artículo.
	 * 
	 * @param codigo
	 * @return a object
	 */
	public Articulo getCodigo(int codigo) {
		return almacen.get(almacen.indexOf(new Articulo(codigo)));

	}

	/**
	 * metodo que incrementa las unidades de stock del articulo
	 * 
	 * @param codigo
	 * @param cantidad
	 */
	public void incrementar(int codigo, int cantidad) {
		Articulo articulo = almacen.get(almacen.indexOf(new Articulo(codigo)));
		articulo.aumentaStock(cantidad);
	}

	/**
	 * metodo que decrementa las unidades de stock del articulo
	 * 
	 * @param codigo
	 * @param cantidad
	 * @throws cantidadNoValida 
	 */
	public void decrementar(int codigo, int cantidad) throws cantidadNoValida {
		Articulo articulo = almacen.get(almacen.indexOf(new Articulo(codigo)));
		if(articulo.getStock()<cantidad) {
			throw new cantidadNoValida("El stock no puede ser menor que 0");
		}
		articulo.decrementaStock(cantidad);
	}
	
	

}// fin clase almacen
