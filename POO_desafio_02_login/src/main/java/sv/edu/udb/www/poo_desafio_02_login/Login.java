package sv.edu.udb.www.poo_desafio_02_login;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

@ManagedBean
@RequestScoped
public class Login {
    @Inject
    private Autenticacion autenticacion;
    private String username;
    private String password;

    public String login(){
        Usuarios user = autenticacion.login(username, password);
        if(user != null){
            if("CLIENTE".equals(user.getRole())){
                return "menu?faces-redirect=true";//redirigir a la pagina del menu
            }else if ("EMPLEADO".equals(user.getRole())){
                return "pedidos?faces-redirect=true"; //redirigir a la pagina de pedidos
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario o contraseña incorrectos"));
        return null;
    }

    //getters y setters para user y password generados por el IDE


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
}
