package ejerciciosPOO3.gestisimal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
 *
 */
public class TestGESTISIMAL {

	public static void main(String[] args) {

		// Definici�n de la colecci�n Set
		Set<GESTISIMAL> articulo = new HashSet<GESTISIMAL>();

		Scanner sc = new Scanner(System.in);

		int opcion;
		
		do {

			
			do {
				mostrarMenu();
				System.out.print("Elija una opci�n: ");
				opcion = sc.nextInt();
			} while (opcion > 7 || opcion < 1);

			switch (opcion) {
			case 1:

				if (articulo.isEmpty()) {
					System.out.println("El almac�n est� vac�o.\n");
				} else {
					System.out.println("Art�culos en el almac�n:");
					// i es la variable auxiliar que utilizo para recorrer el for each
					for (GESTISIMAL i : articulo) {
						System.out.println(i + "\n");
					}
				}
				break;

			case 2:

				System.out.print("C�digo identificador del art�culo: ");
				String id = sc.next();

				System.out.println("Introduce una breve descripci�n del art�culo:");
				String desc = sc.next();

				System.out.print("Precio de compra del art�culo: ");
				double pCom = sc.nextDouble();

				System.out.print("Precio de venta del art�culo: ");
				double pVen = sc.nextDouble();

				System.out.print("Cantidad del art�culo en stock: ");
				int stock = sc.nextInt();

				articulo.add(new GESTISIMAL(id, desc, pCom, pVen, stock));
				System.out.println("Art�culo dado de alta correctamente.");

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
		System.out.println("ALMACEN" + "\n=========" + "\n1. Listado" + "\n2. Alta" + "\n3. Baja" + "\n4. Modificaci�n"
				+ "\n5. Entrada de mercanc�a" + "\n6. Salida de mercanc�a" + "\n7. Salir" + "\n");
	}

}
