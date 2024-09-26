<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Menú Principal - The Temper Trap</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #007bff;
        }
        .menu-container {
            display: inline-block;
            text-align: left;
            margin-top: 50px;
        }
        .menu-item {
            background-color: #007bff;
            color: white;
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
            text-decoration: none;
            display: block;
        }
        .menu-item:hover {
            background-color: #0056b3;
        }
        .logout {
            margin-top: 30px;
            color: #007bff;
        }
    </style>
</head>
<body>

<%
    // Obtener la sesión existente
    HttpSession sesionUsuario = request.getSession(false);

    if (sesionUsuario == null || sesionUsuario.getAttribute("usuario") == null) {
        // Si no hay sesión o no hay usuario en sesión, redirigir al login
        response.sendRedirect("index.jsp");
        return; // Evitar que el resto de la página se ejecute
    }

    // Obtener el nombre de usuario desde la sesión
    String usuario = (String) sesionUsuario.getAttribute("usuario");
%>

<h1>Bienvenido, <%= usuario %>!</h1>

<div class="menu-container">
    <h2>Menú Principal</h2>

</div>

</body>
</html>
