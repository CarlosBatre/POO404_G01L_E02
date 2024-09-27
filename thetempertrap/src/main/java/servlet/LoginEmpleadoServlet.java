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
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginEmpleadoServlet")
public class LoginEmpleadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thetempertrap", "root", "");

            String query = "SELECT * FROM empleados WHERE usuario = ? AND contraseña = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession sesionEmpleado = request.getSession();
                sesionEmpleado.setAttribute("empleado", usuario);
                response.sendRedirect("pedidos.jsp");
            } else {
                request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
                request.getRequestDispatcher("loginEmpleado.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
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