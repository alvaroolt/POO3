package ejerciciosPOO3.gestisimal;

import java.util.ArrayList;
import java.util.Scanner;

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
		ArrayList<GESTISIMAL> articulo = new ArrayList<GESTISIMAL>();

		Scanner sc = new Scanner(System.in);

		int opcion;

		do {

			do {
				mostrarMenu();
				System.out.print("Elija una opci�n: ");
				opcion = sc.nextInt();
			} while (opcion > 7 || opcion < 1);

			switch (opcion) {

			// lista
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

			// dar de alta
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

				boolean existe = false;
				for (int i = 0; i < articulo.size(); i++) {
					if (articulo.get(i).getCodigoId().equals(id))
						existe = true;
				}

				if (existe == false) {
					articulo.add(new GESTISIMAL(id, desc, pCom, pVen, stock));
					System.out.println("Art�culo dado de alta correctamente.\n");
				} else if(existe == true){
					System.out.println("Ese art�culo ya existe. Int�ntelo otra vez.");
				}

				break;

			// dar de baja
			case 3:

				System.out.print("Introduce el c�digo identificador del art�culo a eliminar: ");
				String id2 = sc.next();

				for (int i = 0; i < articulo.size(); i++) {
					articulo.removeIf((auxArticulo) -> auxArticulo.getCodigoId().equals(id2));
				}
				System.out.println("Art�culo dado de baja correctamente.\n");

				break;

			case 4:

				System.out.print("Introduce el c�digo identificador del art�culo a modificar: ");
				String id3 = sc.next();

				for (int i = 0; i < articulo.size(); i++) {

					System.out.print("Nuevo c�digo identificador del art�culo: ");
					String nuevoId = sc.next();

					System.out.println("Introduce una breve descripci�n del art�culo:");
					String nuevaDesc = sc.next();

					System.out.print("Precio de compra del art�culo: ");
					double nuevoPCom = sc.nextDouble();

					System.out.print("Precio de venta del art�culo: ");
					double nuevoPVen = sc.nextDouble();

					System.out.print("Cantidad del art�culo en stock: ");
					int nuevoStock = sc.nextInt();
					
				}
				if (!articulo.equals(id3)) {
					System.out.println("Ese c�digo no est� registrado.");
				}
				break;

			case 5:
				break;

			case 6:
				break;

			default:
				System.out.println("Fin de programa.");
				System.exit(0);
			}
		} while (opcion != 7);
	}

	private static void mostrarMenu() {
		System.out.println("ALMACEN" + "\n=========" + "\n1. Listado" + "\n2. Alta" + "\n3. Baja" + "\n4. Modificaci�n"
				+ "\n5. Entrada de mercanc�a" + "\n6. Salida de mercanc�a" + "\n7. Salir" + "\n");
	}
	
}
