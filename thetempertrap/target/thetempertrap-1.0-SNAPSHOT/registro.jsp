<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>The Temper Trap - Registro</title>
    <meta charset="UTF-8">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1e1e1e;
            color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100%;
        }
        form {
            background-color: #2e2e2e;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
            width: 600px;
            display: flex;
            flex-direction: column;
            align-items: center;
            box-sizing: border-box;
            margin-top: 20px;
        }
        h1, h2 {
            text-align: center;
            color: #ffffff;
            margin-bottom: 10px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            padding: 0 20px;
            margin-bottom: 20px;
        }
        .back-to-login {
            background-color: transparent;
            color: #5c85d6;
            border: none;
            cursor: pointer;
            font-size: 14px;
            text-decoration: underline;
            margin-left: 10px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-size: 14px;
            width: 100%;
            text-align: left;
            margin-left: 23px;
        }
        input[type="text"], input[type="password"], input[type="email"], textarea {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 30px;
            background-color: #444;
            border: 1px solid #666;
            border-radius: 5px;
            color: #fff;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 40%;
            padding: 10px;
            background-color: #5c85d6;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #4a73c0;
        }
        textarea {
            resize: none;
            height: 80px;
        }
        img {
            max-width: 120px;
            margin-bottom: 30px;
            display: block;
            margin-left: auto;
            margin-right: auto;
            border-radius: 50%;
        }
        input::placeholder, textarea::placeholder {
            color: #bbb;
        }
        .error-message {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="logo-container">
        <h1>The Temper Trap Restaurant</h1>
        <img src="Logo.jpg" alt="Logo de The Temper Trap">
    </div>

    <form action="RegistrarClienteServlet" method="post">
        <div class="header">
            <h2>Registro de Clientes</h2>
            <button type="button" class="back-to-login" onclick="window.location.href='index.jsp'">Regresar al Login</button>
        </div>

        <!-- Mensaje de error -->
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
        <div class="error-message">
            <%= errorMessage %>
        </div>
        <%
            }
        %>

        <label for="nombreCompleto">Nombre Completo:</label>
        <input type="text" id="nombreCompleto" name="nombreCompleto" placeholder="Ej: Carlos Josue Ruano Batres" required>

        <label for="nombreUsuario">Nombre de Usuario:</label>
        <input type="text" id="nombreUsuario" name="nombreUsuario" placeholder="Ej: Zelda777" required>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" placeholder="********" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Ej: hyrule@gmail.com" required>

        <label for="dui">DUI:</label>
        <input type="text" id="dui" name="dui" placeholder="Ej: 123456789" required>

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" placeholder="Ej: 12345678" required>

        <label for="direccion">Dirección Completa:</label>
        <textarea id="direccion" name="direccion" placeholder="Ej: Departamento, ciudad, calle, casa" required></textarea>

        <input type="submit" value="Registrar">
    </form>
</div>

</body>
</html>
