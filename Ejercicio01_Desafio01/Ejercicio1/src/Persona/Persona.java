package Persona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Persona {

    public static void main(String[] args) {
        // Creacion de un objeto Scanner para leer la entrada de los datos que nos brinde el usuario
        Scanner scanner = new Scanner(System.in);

        // ingreso y lectura del  nombre del usuario
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        // ingreso  del género del usuario
        System.out.println("Ingrese su género (masculino/femenino): ");
        String genero = scanner.nextLine().toLowerCase();

        // Ingreso del apellido del usuario
        System.out.println("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        // Ingreso de la fecha de nacimiento del usuario
        System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
        String fechaEntrada = scanner.nextLine();
        Date fechaNacimiento = null;

        // Creacion de un SimpleDateFormat para el formato de la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false); // Para que no acepte fechas inválidas

        try {
            fechaNacimiento = formatoFecha.parse(fechaEntrada);
        } catch (ParseException e) {
            System.out.println("Fecha inválida. Asegúrese de usar el formato dd/MM/yyyy.");
            scanner.close();
            return; // Salir del programa en caso de error de fecha
        }

        // Calcular la edad
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);
        Calendar hoy = Calendar.getInstance();

        int edad = hoy.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);
        if (hoy.get(Calendar.MONTH) + 1 < fechaNacimientoCal.get(Calendar.MONTH) + 1 ||
                (hoy.get(Calendar.MONTH) + 1 == fechaNacimientoCal.get(Calendar.MONTH) + 1 &&
                        hoy.get(Calendar.DAY_OF_MONTH) < fechaNacimientoCal.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        // Saludar al usuario según su edad y género
        if (edad > 30) {
            if (genero.equals("masculino")) {
                System.out.println("Buenos días Mr. " + apellido);
            } else if (genero.equals("femenino")) {
                System.out.println("Buenos días Ms. " + apellido);
            } else {
                System.out.println("Buenos días " + apellido);
            }
        } else {
            if (genero.equals("masculino")) {
                System.out.println("Hola amigo " + nombre);
            } else if (genero.equals("femenino")) {
                System.out.println("Hola amiga " + nombre);
            } else {
                System.out.println("Hola " + nombre);
            }
        }

        // Mostrar la edad actual
        System.out.println("Su edad actual es: " + edad + " años.");

        // Determinar si el año de nacimiento es bisiesto
        int añoNacimiento = fechaNacimientoCal.get(Calendar.YEAR);
        if ((añoNacimiento % 4 == 0 && añoNacimiento % 100 != 0) || (añoNacimiento % 400 == 0)) {
            System.out.println("El año " + añoNacimiento + " es bisiesto.");
        } else {
            System.out.println("El año " + añoNacimiento + " no es bisiesto.");
        }

        // Obtener el día de la semana
        SimpleDateFormat formatoDia = new SimpleDateFormat("EEEE");
        String diaDeLaSemana = formatoDia.format(fechaNacimiento);
        System.out.println("Usted nació en un dia " + diaDeLaSemana + ".");

        // Cerrar el scanner
        scanner.close();
    }
}
