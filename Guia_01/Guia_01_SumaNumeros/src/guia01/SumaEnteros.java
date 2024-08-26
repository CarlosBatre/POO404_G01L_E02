package guia01;

import javax.swing.JOptionPane;

public class SumaEnteros {
    public static void main(String[] args) {
        String primernumero;
        String segundonumero;
        int numero1, numero2, suma;

        System.out.print("Aplicacion para sumar 2 numeros enteros\n");

        primernumero = JOptionPane.showInputDialog("Ingrese el primer numero: ");
        segundonumero = JOptionPane.showInputDialog("Ingrese el segundo numero: ");

        // Convertir los valores ingresados a enteros
        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        // Verificar si alguno de los números es negativo
        if (numero1 < 0 || numero2 < 0) {
            // Mostrar mensaje de advertencia y finalizar la aplicación
            JOptionPane.showMessageDialog(null, "No se pueden ingresar números negativos.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        System.out.println("Los numeros ingresados son: " + numero1 + " y " + numero2);

        suma = numero1 + numero2;

        // Mostrar el resultado de la suma
        JOptionPane.showMessageDialog(null, "La suma de " + numero1 + " y " + numero2 + " es " + suma, "Resultado de la suma", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
