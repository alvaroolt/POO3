package ejerciciosPOO3.gestisimalOrientadoAObjetos;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import ejerciciosPOO3.gestisimalOrientadoAObjetos.excepciones.ParametroNoNumericoException;
import ejerciciosPOO3.gestisimalOrientadoAObjetos.excepciones.ValorNoPositivoException;

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
public class TestAlmacen {

	static Scanner sc = new Scanner(System.in);

	static Almacen almacen = new Almacen();

	public static void main(String[] args) throws ParametroNoNumericoException {

		almacen.darAlta("Coca-Cola", 30, 45, 68);
		almacen.darAlta("Nestea", 22, 35, 40);
		almacen.darAlta("Fanta", 33, 42, 53);

		ejecutaMenu();

	}

	// método que muestra el menú del almacén
	private static void mostrarMenu() {

		System.out.println("ALMACEN" + "\n=========" + "\n1. Listado" + "\n2. Alta" + "\n3. Baja" + "\n4. Modificación"
				+ "\n5. Entrada de mercancía" + "\n6. Salida de mercancía" + "\n7. Salir" + "\n");

	}

	// método que devuelve un entero, el cual define la opción del menú
	private static int elegirOpcion() throws ParametroNoNumericoException {

		try {
			System.out.print("\nElige una opción: ");
			int opcion = sc.nextInt();
			return opcion;
		} catch (Exception e) {

			System.err.println("Error al introducir el parámetro.");
			sc.nextLine();
			return 0;
		}

	}

	private static void finalizarPrograma() {

		System.out.println("Fin de programa.");
		System.exit(0);

	}

	// método que ejecuta el menú junto a mostrarMenu() y elegirOpcion()
	private static void ejecutaMenu() throws ParametroNoNumericoException {

		int opcion;
		do {
			mostrarMenu();
			opcion = elegirOpcion();

			switch (opcion) {

			case 1:
				almacen.muestraListado();
				break;

			case 2:
				darAlta();
				break;

			case 3:
				darBaja();
				break;

			case 4:
				modificarArticulo();
				break;

			case 5:
				incrementarStock();
				break;

			case 6:
				decrementarStock();
				break;

			case 7:
				finalizarPrograma();
				break;

			default:
				System.out.println("No introdujiste una opción correcta. Inténtalo de nuevo.\n");
				break;
			}
		} while (opcion != 7);

	}

	// método que añade un nuevo artículo al almacén
	private static void darAlta() {

		try {

			System.out.println("Introduce una breve descripción del artículo:");
			String descripcion = sc.next();

			System.out.print("Precio de compra del artículo: ");
			double precioCompra = sc.nextDouble();

			System.out.print("Precio de venta del artículo: ");
			double precioVenta = sc.nextDouble();

			System.out.print("Cantidad del artículo en stock: ");
			int stock = sc.nextInt();

			if (precioCompra < 0 || precioVenta < 0 || stock < 0) {
				throw new ValorNoPositivoException("Introdujiste algún valor negativo.");
			}

			almacen.darAlta(descripcion, precioCompra, precioVenta, stock);
			System.out.println("Artículo dado de alta correctamente.\n");

		} catch (Exception e) {

			System.err.println("Hubo algún problema al añadir el artículo.\n");
			sc.nextLine();
			// System.exit(0);
		}
	}

	// método que elimina un artículo del almacén
	private static void darBaja() {

		try {

			System.out.print("Introduce el código identificador del artículo a eliminar: ");
			int codigo = sc.nextInt();

			almacen.darBaja(codigo);

		} catch (Exception e) {

			System.err.println("El artículo no se encuentra en el almacén.\n");
			sc.nextLine();

		}

	}

	// método que permite modificar los valores de un artículo
	private static void modificarArticulo() {

		try {

			System.out.print("Introduce el código identificador del artículo a modificar: ");
			int codigo = sc.nextInt();
			sc.nextLine();
			Articulo articulo = almacen.getCodigo(codigo);

			System.out.println("Introduce una breve descripción del artículo:");
			String descripcion = sc.nextLine();

			System.out.print("Precio de compra del artículo: ");
			double precioCompra = sc.nextDouble();

			System.out.print("Precio de venta del artículo: ");
			double precioVenta = sc.nextDouble();

			System.out.print("Cantidad del artículo en stock: ");
			int stock = sc.nextInt();

			if (precioCompra < 0 || precioVenta < 0 || stock < 0) {
				throw new ValorNoPositivoException("Introdujiste algún valor negativo.");
			}

			almacen.modificarArticulo(articulo, descripcion, precioCompra, precioVenta, stock);

		} catch (Exception e) {

			System.err.println("Hubo algún problema al modificar el artículo.\n");
			sc.nextLine();

		}
	}

	private static void incrementarStock() {

		try {

			System.out.print("Introduce el código identificador del artículo a aumentar el stock: ");
			int codigo = sc.nextInt();
			sc.nextLine();

			Articulo articulo = almacen.getCodigo(codigo);

			System.out.print("Introduce cuánto stock nuevo hay en el almacén (" + articulo.getStock() + " actuales): ");
			int cantidad = sc.nextInt();
			// sc.nextLine();

			almacen.incrementarStock(codigo, cantidad);
			System.out.println("Stock añadido correctamente.");

			if (cantidad < 0) {

				throw new ValorNoPositivoException("No se pueden añadir números negativos.");

			}

		} catch (Exception e) {

			System.err.println("Hubo algún problema al incrementar el stock.\n");
			sc.nextLine();

		}
	}

	private static void decrementarStock() {

		try {

			System.out.print("Introduce el código identificador del artículo a disminuir el sotck: ");
			int codigo = sc.nextInt();
			sc.nextLine();

			Articulo articulo = almacen.getCodigo(codigo);

			System.out.println("Introduce cuánto stock se ha eliminado del almacén (" + articulo.getStock() + " actuales): ");
			int cantidad = sc.nextInt();
			// sc.nextLine();

			if (cantidad < 0) {
				cantidad *= -1;
			}

			if (articulo.getStock() - cantidad < 0) {
				throw new ValorNoPositivoException("El stock no puede ser negativo.");
			}

			almacen.decrementarStock(codigo, cantidad);
			System.out.println("Stock eliminado correctamente.");

		} catch (Exception e) {

			System.err.println("Hubo algún problema al decrementar el stock.\n");
			sc.nextLine();

		}
	}

}
