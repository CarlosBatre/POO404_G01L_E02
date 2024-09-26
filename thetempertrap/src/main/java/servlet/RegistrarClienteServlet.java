package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrarClienteServlet")
public class RegistrarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCompleto = request.getParameter("nombreCompleto");
        String usuario = request.getParameter("nombreUsuario");
        String contraseña = request.getParameter("contrasena");
        String email = request.getParameter("email");
        String dui = request.getParameter("dui");
        String telefono = request.getParameter("telefono");
        String direccionCompleta = request.getParameter("direccion");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thetempertrap", "root", "");

            // Verificar si el DUI o el usuario ya existen
            String checkQuery = "SELECT * FROM clientes WHERE dui = ? OR usuario = ?";
            ps = con.prepareStatement(checkQuery);
            ps.setString(1, dui);
            ps.setString(2, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Si existe un registro con el mismo DUI o nombre de usuario
                String errorMessage = "";
                if (rs.getString("dui").equals(dui)) {
                    errorMessage += "El DUI ya está registrado. ";
                }
                if (rs.getString("usuario").equals(usuario)) {
                    errorMessage += "El nombre de usuario ya está registrado.";
                }
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                return;
            }

            // Si no existe, proceder a insertar
            String query = "INSERT INTO clientes (nombreCompleto, usuario, contraseña, email, dui, telefono, direccionCompleta) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombreCompleto);
            ps.setString(2, usuario);
            ps.setString(3, contraseña);
            ps.setString(4, email);
            ps.setString(5, dui);
            ps.setString(6, telefono);
            ps.setString(7, direccionCompleta);

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                // Registro exitoso, redirigir al login
                response.sendRedirect("index.jsp");
            } else {
                // Manejar el caso en que no se haya registrado
                request.setAttribute("errorMessage", "Error en el registro. Inténtalo de nuevo.");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error en el registro. " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
