package utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Teclado {

	/**
	 * Lee un carácter del teclado
	 * 
	 * @return carácter introducido por el usuario
	 * @throws IOException 
	 */
	public static char leerCaracter() throws IOException {
		char caracter;
		try {
			caracter = leerCadena().charAt(0);
		} catch (InputMismatchException e) {
			caracter = 0;
		}
		return caracter;
	}

	/**
	 * Lee un carácter del teclado
	 * 
	 * @param msj: mensaje mostrado al usuario
	 * @return carácter introducido por el usuario
	 * @throws IOException 
	 */
	public static char leerCaracter(String msj) throws IOException {
		System.out.println(msj);
		return leerCaracter();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @param msj: mensaje mostrado al usuario
	 * @return cadena introducida por el usuario
	 * @throws IOException 
	 */
	public static String leerCadena(String msj) throws IOException {
		System.out.println(msj);
		return leerCadena();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @return cadena introducida por el usuario
	 * @throws IOException 
	 */

	public static String leerCadena() throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String cadena;
		try {
			cadena = bReader.readLine(); // Lee una línea de texto (hasta intro)
		} catch (InputMismatchException e) {
			cadena = "";
		}
		return cadena;
	}

	/**
	 * Lee un entero del teclado
	 * 
	 * 
	 * @return entero introducido por el usuario
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static int leerEntero() throws NumberFormatException, IOException {
		int x;
		try {
			x = Integer.parseInt(leerCadena().trim()); // Quita los espacios del String y convierte a int
		} catch (NumberFormatException e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee una entero del teclado
	 * 
	 * @param msj: mensaje mostrado al usuario
	 * @return entero introducida por el usuario
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static int leerEntero(String msj) throws NumberFormatException, IOException {
		System.out.println(msj);
		return leerEntero();
	}

	/**
	 * Lee un decimal del teclado
	 * 
	 * @return decimal introducido por el usuario
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static double leerDecimal() throws NumberFormatException, IOException {
		double x;
		try {
			x = Double.parseDouble(leerCadena().trim()); // Quita los espacios del String y convierte a double
		} catch (InputMismatchException e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee una decimal del teclado
	 * 
	 * @param msj: mensaje mostrado al usuario
	 * @return decimal introducida por el usuario
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static double leerDecimal(String msj) throws NumberFormatException, IOException {//
		System.out.println(msj);
		return leerDecimal();
	}
	/**
	 * Pregunta al usuario si desea continuar con la ejecución del programa
	 * @return falso si el caracter introducido es distinto de S/s
	 * @throws IOException 
	 */
	public static boolean deseaContinuar() throws IOException{
		boolean deseaContinuar;
		char caracterIntroducido = Teclado.leerCaracter("\nDesea continuar? (s/n)");
		if (caracterIntroducido == 's'|| caracterIntroducido == 'S')
		return deseaContinuar = true;
		else
		return deseaContinuar = false;
		}

}