package Ejercicio03;

import javax.swing.*;

public class Empleado {
    private String Nombre;
    private Double SalarioBase;
    /*Generar constructor para nombre*/
    public Empleado(String nombre, Double salarioBase) {
        this.Nombre = nombre;
        this.SalarioBase = salarioBase;
    }

    //Retornamos el salario base
    public double calcularSalario(){
        return SalarioBase;
    }

    //mostrar nombre y salario del empleado
    public void mostrarInfo(){
        System.out.println("El nombre es: " + Nombre);
        System.out.println("El salario base es: " + calcularSalario());
    }
}
