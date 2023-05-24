package ficheros.ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EditorEnteros {

	public static void main(String[] args) {
		// Declaramos las variables
		double suma = 0; // Variable donde guardaremos la suma de los números del fichero
		double media; // Variable donde guardaremos la media de los números del fichero
		int contador = 0; // Variable donde guardaremos el número de números del fichero

		// Creamos el escaner
		Scanner sc = null;
		try {
			
			// Inicializamos el escaner
			sc = new Scanner(new FileReader("src/ficheros/ejercicio2/Enteros.txt"));

			// Mientras haya un número en el fichero
			while (sc.hasNextDouble()) {
				// Los sumamos al total
				suma += sc.nextDouble();

				// Aumentamos en 1 el contador
				contador++;
			}

			// Calculamos la media
			media = suma / contador;

			// Mostramos los resultados
			System.out.println("La suma de los números del fichero es: " + suma);
			System.out.printf("La media de los números del fichero es: %.2f", media);

			// Cerramos escaner
			sc.close();

			// Control de excepcioens
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Fichero no encontrado.");
		}
	}

}
