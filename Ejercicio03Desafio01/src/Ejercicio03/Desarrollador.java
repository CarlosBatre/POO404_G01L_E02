package Ejercicio03;

class Desarrollador extends Empleado {
    private double extraHoras;

    public Desarrollador(String nombre, double salarioBase, double extraHoras) {
        super(nombre, salarioBase);
        this.extraHoras = extraHoras;
    }
    @Override
    public double calcularSalario() {
        return salarioBase + extraHoras * 20; // Ejemplo: pago de $20 por hora extra
    }
    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " (Desarrollador)");
        System.out.println("Salario Base: $" + salarioBase);
        System.out.println("Horas Extras: " + extraHoras + " horas");
        System.out.println("Salario Total: $" + calcularSalario());
    }
}

