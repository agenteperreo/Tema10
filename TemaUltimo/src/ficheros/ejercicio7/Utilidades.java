package ficheros.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class Utilidades {

	// Creamos el treemap que almacenará los contactos
	protected static final TreeMap<String, String> contactos = new TreeMap<>();

	// Creamos una constante con la dirección del fichero
	protected static final String FILE = "src/ficheros/ejercicio7/contactos.txt";

	/**
	 * Método que muestra el menú por pantalla.
	 */
	protected static void menu() {
		System.out.println("1. Nuevo contacto.");
		System.out.println("2. Buscar por nombre.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Salir.");
	}

	/**
	 * Metodo para añdir contactos
	 *
	 * @param nombre   nombre del contacto a añadir
	 * @param telefono teléfono del contacto a añadir
	 * @throws MaxSizeException excepción que se lanza cuando la agenda está llena
	 */
	protected static void nuevoContacto(String nombre, String telefono) throws MaxSizeException, NombreIgualException {

		// Si ttiene mas de 25 contactos
		if (contactos.size() > 25) {

			// Lanzamos la excepcion de maximos contactos
			throw new MaxSizeException();

			// Si el treemap contiene el nombre de usuario
		} else if (contactos.containsKey(nombre)) {

			// Lanzamos la excepción de nombre igual
			throw new NombreIgualException();
		} else { // Si no

			// Añadimos el contacto
			contactos.put(nombre, telefono); // Añadimos el contacto a la agenda
		}

	}

	/**
	 * Metodo para buscar el contacto y mostrar los datos
	 *
	 * @param nombre nombre del contacto a buscar
	 */
	protected static void buscarPorNombre(String nombre) {

		// Recorremos el treemap
		for (String nombreContacto : contactos.keySet()) {

			// Si el treemap contiene el nombre
			if (nombreContacto.equals(nombre)) {
				// Mostramos el nombre y el telefono del contacto buscado
				System.out.println("Nombre: " + nombreContacto + " - Teléfono: " + contactos.get(nombreContacto));
			}

		}
	}

	/**
	 * Metodo para leer los datos del fichero
	 */
	protected static void mostrarContactos() {

		// Creamos el buffered y lo dejamos en null
		BufferedReader br = null;

		// Variable para almacenar la linea del archivo
		String linea;

		// Array que almacenará los datos leidos del archivo
		String[] datos;

		try {

			// Inicializamos el buffer de lectura
			br = new BufferedReader(new FileReader(FILE));

			// Leemos la siguiente linea del archivo
			linea = br.readLine();

			// Mientras haya lineas en el archivo y mo esté vacia
			while (linea != null && !linea.equals("")) {

				// Separamos los datos de la línea leída por comas y los almacenamos en el array
				datos = linea.split(" - ");

				// Añadimos el contacto a la agenda
				contactos.put(datos[0], datos[1]);

				// Leemos la siguiente línea del archivo de texto
				linea = br.readLine();
			}

			// Control de excepciones
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: No se ha encontrado el archivo de texto");
		} catch (IOException e) {
			System.out.println("ERROR: No se ha podido leer el fichero");
			System.out.println(e.getLocalizedMessage());
		} finally { // Una vez terminado el try
			try {
				// Si el buffered no esta a null
				if (br != null) {

					// Cerramos el buffered
					br.close();
				}

				// Control de excepciones
			} catch (IOException e) {
				System.err.println("Error al cerrar el fichero");
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	/**
	 * Método que muestra todos los contactos de la agenda.
	 */
	protected static void mostrarTodos() {

		// Recorremos el treemap
		for (String nombreContacto : contactos.keySet()) {

			// Mostramos todos los datos de los contactos
			System.out.println("Nombre: " + nombreContacto + " - Teléfono: " + contactos.get(nombreContacto));
		}
	}

	/**
	 * Método que escribe en un archivo de texto todos los contactos de la agenda.
	 */
	protected static void escribirFichero() {

		// Creamos el buffered para escribir
		BufferedWriter bw = null;

		try {
			// Inicializamos el buffer de escritura
			bw = new BufferedWriter(new FileWriter(FILE));

			// Recorremos el treemap
			for (String nombreContacto : contactos.keySet()) {

				// Escribimos en el archivo de texto el nombre y el teléfono del contacto
				bw.write(nombreContacto + " - " + contactos.get(nombreContacto));

				// Saltamos de linea
				bw.newLine();
			}

			// Limpiamos la caché del buffer
			bw.flush();

			// Control de excepciones
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				// Cerramos el buffered
				bw.close();
				
				// Control de excepciones
			} catch (IOException e) {
				System.err.println("ERROR: Error al cerrar el fichero");
				System.out.println(e.getLocalizedMessage());
			}
		}

	}
}
