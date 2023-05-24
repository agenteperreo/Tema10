package excepciones.Ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	public static double readDouble(Scanner sc) {

		double num = 0.0;

		try {
			num = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("ERROR: El dato introducido no es del tipo double");
			System.out.println(e.getMessage());
		}

		return num;
	}

	public static int readInt(Scanner sc) {

		int num = 0;

		try {

			num = sc.nextInt();

		} catch (InputMismatchException e) {
			System.err.println("ERROR: El dato introducido no es del tipo int");
			System.out.println(e.getMessage());
		}

		return num;
	}
}
