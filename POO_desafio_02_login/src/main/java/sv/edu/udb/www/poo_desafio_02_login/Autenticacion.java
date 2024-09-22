package sv.edu.udb.www.poo_desafio_02_login;

import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Stateless
public class Autenticacion {
    @PersistenceContext(unitName = "restaurantePU")
    private EntityManager em;

    public Usuarios login(String username, String password){
        try {
            Cliente cliente = em.createQuery("SELECT c FROM Cliente c WHERE c.username = :username AND c.password = :password", Cliente.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            cliente.setRole("CLIENTE");
            return cliente;
        } catch (NoResultException e1){
            try{
                Empleado empleado = em.createQuery("SELECT e FROM Empleado e WHERE e.username = :username AND e.password = :password", Empleado.class)
                        .setParameter("username", username)
                        .setParameter("password", password)
                        .getSingleResult();
                empleado.setRole("Empleado");
                return empleado;
            }catch (NoResultException e2){
                return null;
            }
        }
    }
}
