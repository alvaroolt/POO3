package ejerciciosPOO3.gestisimal;

import java.util.ArrayList;
import java.util.Scanner;

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
		ArrayList<GESTISIMAL> articulo = new ArrayList<GESTISIMAL>();

		Scanner sc = new Scanner(System.in);

		int opcion;

		do {

			do {
				mostrarMenu();
				System.out.print("Elija una opción: ");
				opcion = sc.nextInt();
			} while (opcion > 7 || opcion < 1);

			switch (opcion) {

			// lista
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

			// dar de alta
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

				boolean existe = false;
				for (int i = 0; i < articulo.size(); i++) {
					if (articulo.get(i).getCodigoId().equals(id))
						existe = true;
				}

				if (existe == false) {
					articulo.add(new GESTISIMAL(id, desc, pCom, pVen, stock));
					System.out.println("Artículo dado de alta correctamente.\n");
				} else if(existe == true){
					System.out.println("Ese artículo ya existe. Inténtelo otra vez.");
				}

				break;

			// dar de baja
			case 3:

				System.out.print("Introduce el código identificador del artículo a eliminar: ");
				String id2 = sc.next();

				for (int i = 0; i < articulo.size(); i++) {
					articulo.removeIf((auxArticulo) -> auxArticulo.getCodigoId().equals(id2));
				}
				System.out.println("Artículo dado de baja correctamente.\n");

				break;

			case 4:

				System.out.print("Introduce el código identificador del artículo a modificar: ");
				String id3 = sc.next();

				for (int i = 0; i < articulo.size(); i++) {

					System.out.print("Nuevo código identificador del artículo: ");
					String nuevoId = sc.next();

					System.out.println("Introduce una breve descripción del artículo:");
					String nuevaDesc = sc.next();

					System.out.print("Precio de compra del artículo: ");
					double nuevoPCom = sc.nextDouble();

					System.out.print("Precio de venta del artículo: ");
					double nuevoPVen = sc.nextDouble();

					System.out.print("Cantidad del artículo en stock: ");
					int nuevoStock = sc.nextInt();
					
				}
				if (!articulo.equals(id3)) {
					System.out.println("Ese código no está registrado.");
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
		System.out.println("ALMACEN" + "\n=========" + "\n1. Listado" + "\n2. Alta" + "\n3. Baja" + "\n4. Modificación"
				+ "\n5. Entrada de mercancía" + "\n6. Salida de mercancía" + "\n7. Salir" + "\n");
	}
	
}
