package ficheros.ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EditorEnteros {

    public static void main(String[] args) {

        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("src/ficheros/ejercicio2/Enteros.txt"));


        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Fichero no encontrado");
            System.err.println(e.getMessage());
        }
    }

}
