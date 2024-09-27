package model;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PedidoService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public Pedido crearPedido(Long idCliente) {
        Cliente cliente = em.find(Cliente.class, idCliente);
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        em.persist(pedido);
        return pedido;
    }

    public void cambiarEstado(Long idPedido, String nuevoEstado, String comentario, Long idEmpleado) {
        Pedido pedido = em.find(Pedido.class, idPedido);
        Empleado empleado = em.find(Empleado.class, idEmpleado);
        pedido.setEstado(nuevoEstado);

        HistorialPedido historial = new HistorialPedido();
        historial.setPedido(pedido);
        historial.setEstado(nuevoEstado);
        historial.setComentario(comentario);
        historial.setEmpleado(empleado);

        em.persist(historial);
        em.merge(pedido);
    }

    public List<Pedido> listarPedidos() {
        return em.createQuery("SELECT p FROM Pedidos p", Pedido.class).getResultList();
    }
}
