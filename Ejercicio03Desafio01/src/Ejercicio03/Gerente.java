package Ejercicio03;

class Gerente extends Empleado {
    private double bono;

    public Gerente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bono;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " (Gerente)");
        System.out.println("Salario Base: $" + salarioBase);
        System.out.println("Bono: $" + bono);
        System.out.println("Salario Total: $" + calcularSalario());
    }
}

