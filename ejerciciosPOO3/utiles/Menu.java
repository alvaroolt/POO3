package utiles;

import java.io.IOException;

public class Menu {
	String titulo = null;
	String opciones[] = null;
	int numOpciones = 0;

	/**
	 * 
	 * @param titulo
	 *          título del menu
	 * @param opciones
	 *          opciones del menu
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * Gestiona el menu. Consiste en mostrar las opcines y recoger la opcion
	 * seleccionada por el usuario
	 * 
	 * @return opcion valida del menu
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws NoEsEnteroException
	 */
	public int gestionar() throws NumberFormatException, IOException {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del menu
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("***" + titulo + "***");
		for (String elemento : opciones) {
			System.out.println("(" + (i++) + ") " + elemento);
		}
	}

	/**
	 * Recoge la opcion valida del menu
	 * 
	 * @return opcion valida
	 * @throws NoEsEnteroException
	 */
	private int recogerOpcion() {
		int opcion = -1;
		do {
			System.out.println("Introduce una opción válida [1, " + numOpciones + "]");
			try {
				opcion = Teclado.leerEntero();
			} catch (IOException e) {
				// no hago nada
			}
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}
}