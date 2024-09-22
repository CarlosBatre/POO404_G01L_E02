package sv.edu.udb.www.poo_desafio_02_login;
import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuarios{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role; //EL rol definira si sera usuario o empleado

    // Getters y setters definidos por el IDE
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

