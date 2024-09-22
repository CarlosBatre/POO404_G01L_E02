package sv.edu.udb.www.poo_desafio_02_login;

import jakarta.persistence.*;
@Entity
@Table (name = "empleados")
public class Empleado extends Usuarios{
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "dui", unique = true, nullable = false)
    private String dui;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "cargo")
    private String cargo;

    //getters y setters definidos por el IDE

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
