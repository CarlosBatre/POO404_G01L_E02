import java.util.Scanner;
public class CajeroElectronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Arreglo con las cuentas y su respectivo saldo
        int[][] cuentas = {
                {1000001, 400},
                {1000002, 200},
                {1000004, 500}
        };
        //Acceso con el numCuenta
        int numCuenta;
        int saldo = -1;
        while (true){
            System.out.print("\nIngrese el número de cuenta para acceder: ");
            String numCuentaIngreso = scanner.nextLine();
            try{
                numCuenta = Integer.parseInt(numCuentaIngreso);
                break;
            } catch (NumberFormatException e){
                System.out.println("\nSolo se permiten numero. Intentelo de nuevo. :)");
            }
        }
        //Comparacion si existe la cuenta
        for (int[] cuenta : cuentas) {
            if (cuenta[0] == numCuenta) {
                saldo = cuenta[1];
                //clear
                System.out.println("BIENVENIDO A LA BANCA ELECTRÓNICA :D");
                break;
            }
        }
        //Manejo de error si no encuentra la cuenta
        if (saldo == -1) {
            System.out.println("\nNúmero de cuenta no encontrado. Intentarlo mas tarde!!");
            return;
        }
        //menu banca electro
        while (true) {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Consulta de saldo");
            System.out.println("2. Retiro de fondos");
            System.out.println("3. Consignaciones");
            System.out.println("4. Transferencias");
            System.out.println("5. Salir");
            int opcion = 0;
            try {
                System.out.print("\nOpción: ");
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese un número válido. I     ntentarlo de nuevo :).");
                scanner.nextLine();
                continue;
            }
            if (opcion == 5) {
                System.out.println("Muchas Gracias por usar nuestros servicios. ¡Hasta luego!ඞ");
                break;
            }

        }

    }
}
