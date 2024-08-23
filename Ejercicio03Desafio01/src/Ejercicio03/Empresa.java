package Ejercicio03;

public class Empresa {
    public static void main(String[] args) {
        Empleado empleado1 = new Gerente("Laura", 5000, 1500);
        Empleado empleado2 = new Desarrollador("Carlos", 4000, 10);

        System.out.println("=== Información de Empleados ===");
        empleado1.mostrarInfo();
        System.out.println();
        empleado2.mostrarInfo();
}
}
