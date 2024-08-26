public class Main {
    public static void main(String[] args) {
        // Verificar si hay suficientes argumentos antes de intentar acceder a ellos
        if (args.length > 0) {
            System.out.println("Parametro 1: " + args[0]);
        } else {
            System.out.println("Parametro 1: No se proporcionó");
        }

        if (args.length > 1) {
            System.out.println("Parametro 2: " + args[1]);
        } else {
            System.out.println("Parametro 2: No se proporcionó");
        }
    }
}
