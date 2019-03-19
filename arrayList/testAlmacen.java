/**Partiendo del enunciado del libro, vamos a planificar el diseño de la  aplicación antes de 
 * implementarla:
 * 
 * Clase TestAlmacen, donde se realiza la comunicación con el usuario  (mostrar menú y recuperar
 * opción del menú, mostrar errores, listar) y se  manipula el almacén.  Debes organizarla en
 * métodos que deleguen en la clase almacén (listar, annadir, eliminar... al menos uno por cada
 * una de las opciones del menú).
 *    
 * @author Rafael Infante
 */
package arrayList;

import java.util.Scanner;

public class testAlmacen {

	public static void main(String[] args) {

		// variables
		int opcion;
		int codigo;
		Articulo articulo;
		int cantidad;

		Almacen almacen = new Almacen();

		Scanner sc = new Scanner(System.in);

	/*	almacen.annadir("finca la cantora", 12.5, 15.6, 10);
		almacen.annadir("finca la cantora", 12.5, 15.6, 10);
		almacen.annadir("hulio", 12.5, 15.6, 10);*/

		// almacen.annadir("hulio2", 23.99, 26.85, 12);

		// almacen.eliminar(2);

		// almacen.modificar(almacen.get(1),"adkls ñladks", 20.5, 26.3, 10);

		// almacen.incrementar(1, 11);

		// almacen.decrementar(1, 11);

		// almacen.listarAlmacen();

		// PROGRAMA PRINCIPAL
		do {
			System.out.println("Menu principal");
			System.out.println("==============\n");

			menuPrincipal(); // mostramos el menu principal
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1: // listar almacen
				almacen.listarAlmacen();
				break;

			case 2: // añadir articulo
				System.out.println("--AÑADIR ARTÍCULO--");
				System.out.println("Introduzca la descripción del artículo:");
				String descripcion = sc.nextLine();
				System.out.println("Introduzca el precio de compra del artículo:");
				double precioCompra = sc.nextDouble();
				System.out.println("Introduzca el precio de venta del artículo:");
				double precioVenta = sc.nextDouble();
				System.out.println("Introduzca el stock del artículo:");
				int stock = sc.nextInt();

				almacen.annadir(descripcion, precioCompra, precioVenta, stock);
				System.out.println("Artículo añadido.");
				break;

			case 3: // dar de baja un articulo
				System.out.println("--BAJA ARTICULO--");
				System.out.println("Introduzca el codigo del articulo a eliminar: ");
				codigo = sc.nextInt();
				sc.nextLine();

				almacen.eliminar(codigo);
				break;

			case 4: // incrementar unidades de stock
				System.out.println("--INCREMENTAR STOCK--");
				System.out.println("Introduce el codigo del articulo para incrementar su stock: ");
				codigo = sc.nextInt();
				sc.nextLine();
				articulo = almacen.get(codigo);
				System.out.println(articulo);

				System.out.println("Introduzca el número de artículos entregados al almacen: ");
				cantidad = sc.nextInt();
				almacen.incrementar(codigo, cantidad);

				almacen.listarAlmacen();
				break;

			case 5: // decrementar el stock
				System.out.println("--DECREMENTAR STOCK--");
				System.out.println("Introduce el codigo del articulo para decrementar su stock: ");
				codigo = sc.nextInt();
				articulo = almacen.get(codigo);
				System.out.println(articulo);

				System.out.println("Introduzca el número de artículos eliminados del almacen.");
				cantidad = sc.nextInt();
				try {
					almacen.decrementar(codigo, cantidad);
				} catch (cantidadNoValida e) {
					System.err.println(e.getMessage());
					//e.printStackTrace();
				}
				break;

			case 6: // modificar articulo
				System.out.println("--MODIFICAR ARTÍCULO--");
				System.out.println("Introduce el codigo del articulo a modificar.");
				codigo = sc.nextInt();
				sc.nextLine();
				articulo = almacen.get(codigo);
				System.out.println(articulo);

				System.out.println("Introduzca la nueva descripción del artículo:");
				descripcion = sc.nextLine();
				System.out.println("Introduzca el nuevo precio de compra del artículo:");
				precioCompra = sc.nextDouble();
				System.out.println("Introduzca el nuevo precio de venta del artículo:");
				precioVenta = sc.nextDouble();
				System.out.println("Introduzca el nuevo stock del artículo:");
				stock = sc.nextInt();

				almacen.modificar(articulo, descripcion, precioCompra, precioVenta, stock);
				break;
			case 7: // salir del programa
				System.out.println("Fin del programa");
				break;

			default:
				System.out.println("No es correcta la opcion insertada.\n");

			}

		} while (opcion != 7);

	}

	/**
	 * metodo vacio que muestra el menu principal
	 * 
	 */
	public static void menuPrincipal() {
		System.out.println("1. Listar almacen.");
		System.out.println("2. Añadir un articulo.");
		System.out.println("3. Dar de baja un articulo");
		System.out.println("4. Incrementar unidades en stock.");
		System.out.println("5. Decrementar unidades de stock.");
		System.out.println("6. Modificar un articulo.");
		System.out.println("7. Salir.");

	}

}
