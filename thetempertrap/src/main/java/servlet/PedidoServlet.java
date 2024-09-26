package servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Empleado;
import model.HistorialPedido;
import model.Pedido;

import java.io.IOException;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if ("crear".equals(accion)) {
                Long idCliente = Long.parseLong(request.getParameter("idCliente"));
                crearPedido(idCliente);
                response.sendRedirect("success.jsp");
            } else if ("cambiarEstado".equals(accion)) {
                Long idPedido = Long.parseLong(request.getParameter("idPedido"));
                String nuevoEstado = request.getParameter("nuevoEstado");
                String comentario = request.getParameter("comentario");
                Long idEmpleado = Long.parseLong(request.getParameter("idEmpleado"));
                cambiarEstado(idPedido, nuevoEstado, comentario, idEmpleado);
                response.sendRedirect("success.jsp");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido proporcionado.");
        } catch (EntityNotFoundException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error procesando la solicitud.");
            e.printStackTrace();
        }
    }

    private void crearPedido(Long idCliente) {
        Cliente cliente = em.find(Cliente.class, idCliente);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente no encontrado con id: " + idCliente);
        }
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        em.persist(pedido);
    }

    private void cambiarEstado(Long idPedido, String nuevoEstado, String comentario, Long idEmpleado) {
        Pedido pedido = em.find(Pedido.class, idPedido);
        if (pedido == null) {
            throw new EntityNotFoundException("Pedido no encontrado con id: " + idPedido);
        }

        Empleado empleado = em.find(Empleado.class, idEmpleado);
        if (empleado == null) {
            throw new EntityNotFoundException("Empleado no encontrado con id: " + idEmpleado);
        }

        pedido.setEstado(nuevoEstado);

        HistorialPedido historial = new HistorialPedido();
        historial.setPedido(pedido);
        historial.setEstado(nuevoEstado);
        historial.setComentario(comentario);
        historial.setEmpleado(empleado);

        em.persist(historial);
        em.merge(pedido);
    }
}
