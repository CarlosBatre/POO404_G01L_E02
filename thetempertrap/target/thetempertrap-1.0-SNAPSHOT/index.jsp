<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>The Temper Trap - Iniciar Sesión</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1e1e1e;
            color: #ffffff;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            margin-bottom: 22px;
        }
        img {
            max-width: 120px;
            margin-bottom: 30px;
            display: block;
            margin-left: auto;
            margin-right: auto;
            border-radius: 50%;
        }
        form {
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
            width: 300px;
            text-align: center;
            background-color: #2e2e2e;
        }
        form>h2 {
            margin-bottom: 50px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            height: 20px;
            margin: 15px 0;
            border-radius: 5px;
            background-color: #444;
            border: 1px solid #666;
            color: #f0f0f0;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px;
            cursor: pointer;
            width: 100%;
            margin-top: 15px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        a {
            color: #00bfff;
            text-decoration: none;
            display: block;
            margin-top: 60px;
        }
        a:hover {
            text-decoration: underline;
        }
        .error-message {
            color: red;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div>
    <h1>The Temper Trap Restaurant</h1>
    <img src="Logo.jpg" alt="Logo de The Temper Trap">
</div>

<!-- Mostrar mensaje de error si existe -->
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<div class="error-message"><%= errorMessage %></div>
<%
    }
%>

<form action="LoginServlet" method="post">
    <h2>Iniciar Sesión</h2>
    <label for="usuario">Nombre de Usuario:</label>
    <input type="text" id="usuario" name="usuario" required>

    <label for="contraseña">Contraseña:</label>
    <input type="password" id="contraseña" name="contraseña" required>

    <input type="submit" value="Iniciar Sesión">

    <a href="registro.jsp">¿No eres Cliente? ¡Regístrate!</a>
    <a href="loginEmpleado.jsp">¿Eres Empleado? ¡Logeate aquí!</a>
</form>

</body>
</html>
