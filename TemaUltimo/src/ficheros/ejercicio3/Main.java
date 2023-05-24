package ficheros.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		// Declaramos las variables
		String linea = ""; // Variable donde guardaremos cada línea del fichero
		String[] nombres; // Array donde guardaremos los nombres, la edad y la altura de cada alumno
		int sumaEdad = 0; // Variable donde guardaremos la suma de las edades de los alumnos
		int sumaAltura = 0; // Variable donde guardaremos la suma de las alturas de los alumnos
		int contador = 0; // Variable donde guardaremos el número de alumnos

		try {
			// Creamos el buffered para leer el fichero con el FileReader
			BufferedReader br = new BufferedReader(new FileReader("src/ficheros/ejercicio3/Alumnos.txt"));

			// Leemos la primera línea del fichero
			linea = br.readLine();

			// Mientras haya una línea en el fichero
			while (linea != null) {

				// Dividimos la linea y la guardamos en el array
				nombres = linea.split(" ");

				// Mostramos el nombre del alumno
				System.out.println(nombres[0]);

				// Añadimos la edad y la altura a la suma total
				sumaEdad += Integer.parseInt(nombres[1]);
				sumaAltura += Double.parseDouble(nombres[2]);

				// Aumentamos el contador en 1
				contador++;

				// Leemos la siguiente línea del fichero
				linea = br.readLine();
			}

			// Mostramos los resultados
			System.out.println();
			System.out.println("La suma de las edades de los alumnos es de: " + sumaEdad + " años");
			System.out.println("La media de edad de los alumnos es de: " + (double) sumaEdad / contador + " años");
			System.out.println("La suma de las alturas de los alumnos es de: " + sumaAltura + " m");
			System.out.println("La media de altura de los alumnos es de: " + (double) sumaAltura / contador + " m");

			// Cerramos el buffered
			br.close();

			// Control de excepciones
		} catch (FileNotFoundException e) { 
			System.err.println("ERROR: Fichero no encontrado.");
		} catch (IOException e) { 
			System.err.println("ERROR: El fichero está vacío");
		}
	}
}
