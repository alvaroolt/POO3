package ejerciciosPOO3.gestisimalOrientadoAObjetos;

import java.util.ArrayList;
import java.util.Scanner;

import ejerciciosPOO3.gestisimal.GESTISIMAL;

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

public class Almacen {

	// Definici�n de la colecci�n ArrayList
	private ArrayList<Articulo> articulo = new ArrayList<Articulo>();

	public void muestraListado() {

		if (articulo.isEmpty()) {
			System.out.println("El almac�n est� vac�o.\n");
		} else {
			System.out.println("Art�culos en el almac�n:");

			// i es la variable auxiliar que utilizo para recorrer el for each
			for (Articulo i : articulo) {
				System.out.println(i + "\n");
			}
		}
	}
}