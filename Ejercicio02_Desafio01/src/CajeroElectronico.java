
import java.util.Scanner;

public class CajeroElectronico {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] cuentas = {
                {1000001, 400},
                {1000002, 200},
                {1000004, 500}
        };
        System.out.print("Ingrese el número de cuenta para acceder: ");
        String numCuentaIngreso = scanner.nextLine();
        int numCuenta = Integer.parseInt(numCuentaIngreso);
        boolean cuentaEncontrada = false;
        for (int[] cuenta : cuentas) {
            if (cuenta[0] == numCuenta) {
                cuentaEncontrada = true;
                System.out.println("BIENVENIDO A LA BANCAELECTRONICA :D");
                break;
            }
        }
        System.out.println("Número de cuenta no encontrado. Intentarlo mas tarde.");
    }
}
