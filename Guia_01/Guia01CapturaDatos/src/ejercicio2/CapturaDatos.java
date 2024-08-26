package ejercicio2;

import java.util.*;

public class CapturaDatos {
    public static void main(String[] argumentos) {
        Scanner reader = new Scanner(System.in);
        String nombre = "";
        int edad = -1;  // Inicializamos edad con un valor no válido.
        System.out.print("Bienvenido Watin\n");
        System.out.print("Ingrese su nombre: ");
        nombre = reader.nextLine();
        // Ciclo para validar que la edad no sea negativa
        while (edad < 0) {
            System.out.print("Ingrese su edad: ");
            if (reader.hasNextInt()) {
                edad = reader.nextInt();
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa. Inténtelo de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                reader.next(); // Limpia la entrada no válida
            }
        }
        System.out.println("Usted se llama: " + nombre + " y tiene " + edad + " años");
    }
}
