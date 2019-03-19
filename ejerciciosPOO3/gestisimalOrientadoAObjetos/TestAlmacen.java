package ejerciciosPOO3.gestisimalOrientadoAObjetos;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import ejerciciosPOO3.gestisimalOrientadoAObjetos.excepciones.ParametroNoNumericoException;
import ejerciciosPOO3.gestisimalOrientadoAObjetos.excepciones.ValorNoPositivoException;

/**
 * Crea el programa GESTISIMAL (GESTI�n SIMplificada de Almac�n) para llevar el
 * control de los art�culos de un almac�n. De cada art�culo se debe saber el
 * c�digo, la descripci�n, el precio de compra, el precio de venta y el stock
 * (n�mero de unidades). La entrada y salida de mercanc�a supone respectivamente
 * el incremento y decremento de stock de un determinado art�culo. Hay que
 * controlar que no se pueda sacar m�s mercanc�a de la que hay en el almac�n.
 * 
 * @author �lvaro Leiva
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

	// m�todo que muestra el men� del almac�n
	private static void mostrarMenu() {

		System.out.println("ALMACEN" + "\n=========" + "\n1. Listado" + "\n2. Alta" + "\n3. Baja" + "\n4. Modificaci�n"
				+ "\n5. Entrada de mercanc�a" + "\n6. Salida de mercanc�a" + "\n7. Salir" + "\n");

	}

	// m�todo que devuelve un entero, el cual define la opci�n del men�
	private static int elegirOpcion() throws ParametroNoNumericoException {

		try {
			System.out.print("\nElige una opci�n: ");
			int opcion = sc.nextInt();
			return opcion;
		} catch (Exception e) {

			System.err.println("Error al introducir el par�metro.");
			sc.nextLine();
			return 0;
		}

	}

	private static void finalizarPrograma() {

		System.out.println("Fin de programa.");
		System.exit(0);

	}

	// m�todo que ejecuta el men� junto a mostrarMenu() y elegirOpcion()
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
				System.out.println("No introdujiste una opci�n correcta. Int�ntalo de nuevo.\n");
				break;
			}
		} while (opcion != 7);

	}

	// m�todo que a�ade un nuevo art�culo al almac�n
	private static void darAlta() {

		try {

			System.out.println("Introduce una breve descripci�n del art�culo:");
			String descripcion = sc.next();

			System.out.print("Precio de compra del art�culo: ");
			double precioCompra = sc.nextDouble();

			System.out.print("Precio de venta del art�culo: ");
			double precioVenta = sc.nextDouble();

			System.out.print("Cantidad del art�culo en stock: ");
			int stock = sc.nextInt();

			if (precioCompra < 0 || precioVenta < 0 || stock < 0) {
				throw new ValorNoPositivoException("Introdujiste alg�n valor negativo.");
			}

			almacen.darAlta(descripcion, precioCompra, precioVenta, stock);
			System.out.println("Art�culo dado de alta correctamente.\n");

		} catch (Exception e) {

			System.err.println("Hubo alg�n problema al a�adir el art�culo.\n");
			sc.nextLine();
			// System.exit(0);
		}
	}

	// m�todo que elimina un art�culo del almac�n
	private static void darBaja() {

		try {

			System.out.print("Introduce el c�digo identificador del art�culo a eliminar: ");
			int codigo = sc.nextInt();

			almacen.darBaja(codigo);

		} catch (Exception e) {

			System.err.println("El art�culo no se encuentra en el almac�n.\n");
			sc.nextLine();

		}

	}

	// m�todo que permite modificar los valores de un art�culo
	private static void modificarArticulo() {

		try {

			System.out.print("Introduce el c�digo identificador del art�culo a modificar: ");
			int codigo = sc.nextInt();
			sc.nextLine();
			Articulo articulo = almacen.getCodigo(codigo);

			System.out.println("Introduce una breve descripci�n del art�culo:");
			String descripcion = sc.nextLine();

			System.out.print("Precio de compra del art�culo: ");
			double precioCompra = sc.nextDouble();

			System.out.print("Precio de venta del art�culo: ");
			double precioVenta = sc.nextDouble();

			System.out.print("Cantidad del art�culo en stock: ");
			int stock = sc.nextInt();

			if (precioCompra < 0 || precioVenta < 0 || stock < 0) {
				throw new ValorNoPositivoException("Introdujiste alg�n valor negativo.");
			}

			almacen.modificarArticulo(articulo, descripcion, precioCompra, precioVenta, stock);

		} catch (Exception e) {

			System.err.println("Hubo alg�n problema al modificar el art�culo.\n");
			sc.nextLine();

		}
	}

	private static void incrementarStock() {

		try {

			System.out.print("Introduce el c�digo identificador del art�culo a aumentar el stock: ");
			int codigo = sc.nextInt();
			sc.nextLine();

			Articulo articulo = almacen.getCodigo(codigo);

			System.out.print("Introduce cu�nto stock nuevo hay en el almac�n (" + articulo.getStock() + " actuales): ");
			int cantidad = sc.nextInt();
			// sc.nextLine();

			almacen.incrementarStock(codigo, cantidad);
			System.out.println("Stock a�adido correctamente.");

			if (cantidad < 0) {

				throw new ValorNoPositivoException("No se pueden a�adir n�meros negativos.");

			}

		} catch (Exception e) {

			System.err.println("Hubo alg�n problema al incrementar el stock.\n");
			sc.nextLine();

		}
	}

	private static void decrementarStock() {

		try {

			System.out.print("Introduce el c�digo identificador del art�culo a disminuir el sotck: ");
			int codigo = sc.nextInt();
			sc.nextLine();

			Articulo articulo = almacen.getCodigo(codigo);

			System.out.println("Introduce cu�nto stock se ha eliminado del almac�n (" + articulo.getStock() + " actuales): ");
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

			System.err.println("Hubo alg�n problema al decrementar el stock.\n");
			sc.nextLine();

		}
	}

}
