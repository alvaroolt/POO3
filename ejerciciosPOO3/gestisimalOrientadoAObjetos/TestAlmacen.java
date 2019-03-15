package ejerciciosPOO3.gestisimalOrientadoAObjetos;

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
 * @version 1.0
 */
public class TestAlmacen {

	public static void main(String[] args) {

		// ArrayList almacen;

		mostrarMenu();
		ejecutaMenu(elegirOpcion());

		// Definici�n de la colecci�n ArrayList
		// ArrayList<Articulo> articulo = new ArrayList<Articulo>();

		// Scanner sc = new Scanner(System.in);
		//
		// int opcion;
		//
		// do {
		//
		// do {
		// mostrarMenu();
		// System.out.print("Elija una opci�n: ");
		// opcion = sc.nextInt();
		// } while (opcion > 7 || opcion < 1);
		//
		// switch (opcion) {
		//
		// // lista
		// case 1:
		//
		// if (articulo.isEmpty()) {
		// System.out.println("El almac�n est� vac�o.\n");
		// } else {
		// System.out.println("Art�culos en el almac�n:");
		// // i es la variable auxiliar que utilizo para recorrer el for each
		// for (Articulo i : articulo) {
		// System.out.println(i + "\n");
		// }
		// }
		// break;
		//
		// // dar de alta
		// case 2:
		//
		// System.out.print("C�digo identificador del art�culo: ");
		// String id = sc.next();
		//
		// System.out.println("Introduce una breve descripci�n del art�culo:");
		// String desc = sc.next();
		//
		// System.out.print("Precio de compra del art�culo: ");
		// double pCom = sc.nextDouble();
		//
		// System.out.print("Precio de venta del art�culo: ");
		// double pVen = sc.nextDouble();
		//
		// System.out.print("Cantidad del art�culo en stock: ");
		// int stock = sc.nextInt();
		//
		// boolean existe = false;
		// for (int i = 0; i < articulo.size(); i++) {
		// if (articulo.get(i).getCodigo().equals(id))
		// existe = true;
		// }
		//
		// if (existe == false) {
		// articulo.add(new Articulo(id, desc, pCom, pVen, stock));
		// System.out.println("Art�culo dado de alta correctamente.\n");
		// } else {
		// System.out.println("Ese art�culo ya existe. Int�ntelo otra vez.");
		// }
		//
		// break;
		//
		// // dar de baja
		// case 3:
		//
		// System.out.print("Introduce el c�digo identificador del art�culo a eliminar:
		// ");
		// String id2 = sc.next();
		//
		// for (int i = 0; i < articulo.size(); i++) {
		// articulo.removeIf((auxArticulo) -> auxArticulo.getCodigo().equals(id2));
		// }
		// System.out.println("Art�culo dado de baja correctamente.\n");
		//
		// break;
		//
		// case 4:
		//
		// System.out.print("Introduce el c�digo identificador del art�culo a modificar:
		// ");
		// String id3 = sc.next();
		//
		// String nuevoId;
		// for (int i = 0; i < articulo.size(); i++) {
		//
		// if (articulo.get(i).getCodigo().equals(id3)) {
		//
		// boolean existeId = false;
		// do {
		// System.out.print("Nuevo c�digo identificador del art�culo: ");
		// nuevoId = sc.next();
		//
		// for (int j = 0; j < articulo.size(); j++) {
		// if (articulo.get(j).getCodigo().equals(nuevoId))
		// existeId = true;
		// }
		//
		// if (existeId == true) {
		// System.out.println("Ese c�digo identificador ya est� en uso. Introduce
		// otro.");
		// }
		// } while (existeId == true);
		//
		// articulo.get(i).setCodigo(nuevoId);
		//
		// System.out.println("Introduce una breve descripci�n del art�culo:");
		// String nuevaDesc = sc.next();
		// articulo.get(i).setDescripcion(nuevaDesc);
		//
		// System.out.print("Precio de compra del art�culo: ");
		// double nuevoPCom = sc.nextDouble();
		// articulo.get(i).setPrecioCompra(nuevoPCom);
		//
		// System.out.print("Precio de venta del art�culo: ");
		// double nuevoPVen = sc.nextDouble();
		// articulo.get(i).setPrecioVenta(nuevoPVen);
		//
		// System.out.print("Cantidad del art�culo en stock: ");
		// int nuevoStock = sc.nextInt();
		// articulo.get(i).setStock(nuevoStock);
		// }
		//
		// // if (!articulo.get(i).getCodigoId().equals(id3)) {
		// // System.out.println("Ese art�culo no se encuentra en el almac�n.");
		// // }
		// }
		//
		// break;
		//
		// case 5:
		// System.out.print("Introduce el c�digo identificador del art�culo a modificar:
		// ");
		// String id4 = sc.next();
		//
		// for (int i = 0; i < articulo.size(); i++) {
		//
		// if (articulo.get(i).getCodigo().equals(id4)) {
		// System.out.print("Introduce el stock nuevo que ha llegado al almac�n: ");
		// int sumaStock = sc.nextInt();
		// articulo.get(i).setStock(articulo.get(i).getStock() + sumaStock);
		// }
		// }
		//
		// break;
		//
		// case 6:
		// System.out.print("Introduce el c�digo identificador del art�culo a modificar:
		// ");
		// String id5 = sc.next();
		//
		// for (int i = 0; i < articulo.size(); i++) {
		//
		// if (articulo.get(i).getCodigo().equals(id5)) {
		// System.out.print("Introduce el stock que ha salido del almac�n: ");
		// int restaStock = sc.nextInt();
		// articulo.get(i).setStock(articulo.get(i).getStock() - restaStock);
		//
		// if(articulo.get(i).getStock() < 0) {
		// System.out.println("Se ha introducido un valor mayor al stock existente. El
		// programa supone que nos hemos quedado sin existencias.");
		// articulo.get(i).setStock(0);
		// }
		// }
		// }
		//
		// break;
		//
		// default:
		// System.out.println("Fin de programa.");
		// System.exit(0);
		// }
		// } while (opcion != 7);
	}

	private static void mostrarMenu() {
		System.out.println("ALMACEN" + "\n=========" + "\n1. Listado" + "\n2. Alta" + "\n3. Baja" + "\n4. Modificaci�n"
				+ "\n5. Entrada de mercanc�a" + "\n6. Salida de mercanc�a" + "\n7. Salir" + "\n");
	}

	private static int elegirOpcion() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\nElige una opci�n: ");
		int opcion = sc.nextInt();

		return opcion;
	}

	private static void ejecutaMenu(int opcion) {

		switch (opcion) {

		case 1:
			Almacen.muestraListado();
			break;
		}

	}

	private void darAlta() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce una breve descripci�n del art�culo:");
		String descripcion = sc.next();

		System.out.print("Precio de compra del art�culo: ");
		double precioCompra = sc.nextDouble();

		System.out.print("Precio de venta del art�culo: ");
		double precioVenta = sc.nextDouble();

		System.out.print("Cantidad del art�culo en stock: ");
		int stock = sc.nextInt();

		Articulo.add(articulo.getCodigo(), descripcion, precioCompra, precioVenta, stock);
	}

	private void darBaja() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el c�digo identificador del art�culo a eliminar: ");
		String codigo = sc.next();

		for (int i = 0; i < articulo.size(); i++) {
			articulo.removeIf((auxAlmacen) -> auxAlmacen.getCodigoId().equals(codigo));
		}

		System.out.println("Art�culo dado de baja correctamente.\n");
		break;
	}
	
	private void modificaArticulo() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el c�digo identificador del art�culo a eliminar: ");
		String codigo = sc.next();
	}

}
