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
                System.out.println("\nSolo se permiten numeros. Intentelo de nuevo. :)");
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

                //procedimientos del menu banca
                switch (opcion) {

                    //consulta saldo
                    case 1:
                        System.out.println("\nSaldo actual de la cuenta #" + numCuenta + " es de $" + saldo);
                        break;

                    //retiro de fondos
                    case 2:
                        try {
                            System.out.print("\nIngrese la cantidad a retirar: ");
                            int retiro = scanner.nextInt();
                            if (retiro <= saldo) {
                                saldo -= retiro;
                                System.out.println("Retiro exitoso. Su saldo actual es: $" + saldo);
                            } else {
                                System.out.println("Lo siento....fondos insuficientes :(.");
                            }
                        } catch (Exception e) {
                            System.out.println("Solo se permiten numeros. Intentelo de nuevo. :)");
                            scanner.nextLine();
                        }
                        break;

                    //Consigna
                    case 3:
                        try {
                            System.out.print("\nIngrese la cantidad para realizar la consigna: ");
                            int consigna = scanner.nextInt();
                            saldo += consigna;
                            System.out.println("Consignación exitosa. Saldo actual: $" + saldo);
                        } catch (Exception e) {
                            System.out.println("Solo se permiten numeros. Intentelo de nuevo. :)");
                            scanner.nextLine();
                        }
                        break;

                    //Transferencias
                    case 4:
                        try {
                            System.out.print("\nNumero de cuenta a transferir: ");
                            int cuentaTransferencia = scanner.nextInt();
                            System.out.print("Ingrese la cantidad a transferir: ");
                            int transferencia = scanner.nextInt();
                            if (transferencia <= saldo) {
                                saldo -= transferencia;
                                System.out.println("Transferencia exitosa. Su saldo actual es: $" + saldo);
                            } else {
                                System.out.println("Lo siento....fondos insuficientes :(.");
                            }
                        } catch (Exception e) {
                            System.out.println("Solo se permiten numeros. Intentelo de nuevo. :)");
                            scanner.nextLine();
                        }
                        break;

                    //Salir
                    case 5:
                        System.out.println("Muchas Gracias por usar nuestros servicios. ¡Hasta luego!ඞ");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        break;
                }

            }   catch (Exception e) {
                System.out.println("Ingrese un número 1-5. Intentarlo de nuevo :).");
                scanner.nextLine();
            }
        }

    }
}
