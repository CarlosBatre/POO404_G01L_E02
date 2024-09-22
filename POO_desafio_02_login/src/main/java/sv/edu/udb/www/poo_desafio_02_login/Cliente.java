package sv.edu.udb.www.poo_desafio_02_login;

import jakarta.persistence.*;
@Entity
@Table(name = "clientes")
public class Cliente extends Usuarios{
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "dui", unique = true, nullable = false)
    private String dui;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccionCompleta")
    private String direccionCompleta;

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

    public String getDireccionCompleta() {
        return direccionCompleta;
    }

    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }
}
