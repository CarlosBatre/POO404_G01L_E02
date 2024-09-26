<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>The Temper Trap - Empleado</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            text-align: center;
            padding: 50px;
        }
        h2 {
            color: #007bff;
        }
    </style>
</head>
<body>

<%
    // Obtener la sesión existente
    HttpSession sesionEmpleado = request.getSession(false);

    if (sesionEmpleado == null || sesionEmpleado.getAttribute("empleado") == null) {
        // Si no hay sesión o no hay usuario en sesión, redirigir al login
        response.sendRedirect("loginEmpleado.jsp");
        return; // Evitar que el resto de la página se ejecute
    }

    // Obtener el nombre de usuario desde la sesión
    String usuario = (String) sesionEmpleado.getAttribute("empleado");
%>

<h2>Bienvenido, <%= usuario %>!</h2>
<p>Este es el panel de control para empleados.</p>

</body>
</html>
