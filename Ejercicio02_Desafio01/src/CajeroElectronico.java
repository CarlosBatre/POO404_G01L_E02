import java.util.HashMap;
import java.util.Scanner;

public class CajeroElectronico {

    private static HashMap<Integer, Integer> Cuenta = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cuenta.put(1000001, 400);
        Cuenta.put(1000002, 200);
        Cuenta.put(1000004, 500);

        System.out.print("Ingrese el número de cuenta para acceder: ");
        int numeroCuenta = scanner.nextInt();



    }
}
