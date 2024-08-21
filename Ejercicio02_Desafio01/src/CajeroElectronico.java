import java.util.Scanner;
public class CajeroElectronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] cuentas = {
                {1000001, 400},
                {1000002, 200},
                {1000004, 500}
        };
        System.out.print("Ingrese el número de cuenta para acceder: ");
        String numCuentaIngreso = scanner.nextLine();
        int numCuenta = Integer.parseInt(numCuentaIngreso);
        int saldo = -1;
        for (int[] cuenta : cuentas) {
            if (cuenta[0] == numCuenta) {
                saldo = cuenta[1];
                System.out.println("BIENVENIDO A LA BANCA ELECTRÓNICA :D");
                break;
            }
        }
        if (saldo == -1) {
            System.out.println("Número de cuenta noenc ontrado. Intentarlo mas tarde!!");
        }
        while (saldo != -1) {}

    }
}
