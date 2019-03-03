package ejerciciosPOO3.gestisimal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
 *
 */
public class TestGESTISIMAL {

	public static void main(String[] args) {

		// Definición de la colección Set
		Set<GESTISIMAL> articulo = new HashSet<GESTISIMAL>();

		Scanner sc = new Scanner(System.in);

		int opcion;
		
		do {

			
			do {
				mostrarMenu();
				System.out.print("Elija una opción: ");
				opcion = sc.nextInt();
			} while (opcion > 7 || opcion < 1);

			switch (opcion) {
			case 1:

				if (articulo.isEmpty()) {
					System.out.println("El almacén está vacío.\n");
				} else {
					System.out.println("Artículos en el almacén:");
					// i es la variable auxiliar que utilizo para recorrer el for each
					for (GESTISIMAL i : articulo) {
						System.out.println(i + "\n");
					}
				}
				break;

			case 2:

				System.out.print("Código identificador del artículo: ");
				String id = sc.next();

				System.out.println("Introduce una breve descripción del artículo:");
				String desc = sc.next();

				System.out.print("Precio de compra del artículo: ");
				double pCom = sc.nextDouble();

				System.out.print("Precio de venta del artículo: ");
				double pVen = sc.nextDouble();

				System.out.print("Cantidad del artículo en stock: ");
				int stock = sc.nextInt();

				articulo.add(new GESTISIMAL(id, desc, pCom, pVen, stock));
				System.out.println("Artículo dado de alta correctamente.");

				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				break;

			default:
				System.out.println("Fin de programa.");
				break;
			}
		} while (opcion != 7);
	}

	private static void mostrarMenu() {
		System.out.println("ALMACEN" + "\n=========" + "\n1. Listado" + "\n2. Alta" + "\n3. Baja" + "\n4. Modificación"
				+ "\n5. Entrada de mercancía" + "\n6. Salida de mercancía" + "\n7. Salir" + "\n");
	}

}
