<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Login Empleados - The Temper Trap</title>
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
    }
    form {
      background-color: #2e2e2e;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
      width: 400px;
      display: flex;
      flex-direction: column;
      align-items: center;
      box-sizing: border-box;
      margin-top: 10px;
    }
    h1 {
      color: #ffffff;
      text-align: center;
      margin-bottom: 20px;
      display: inline-block;
    }
    .back-link {
      margin-left: 10px;
      font-size: 14px;
    }
    label {
      margin-bottom: 10px;
      font-size: 14px;
      width: 100%;
      text-align: left;
    }
    input[type="text"], input[type="password"] {
      width: calc(100% - 20px);
      padding: 10px;
      margin-bottom: 20px;
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
      margin-top: 15px;
    }
    input[type="submit"]:hover {
      background-color: #4a73c0;
    }
    img {
      max-width: 120px;
      margin-bottom: 30px;
      display: block;
      margin-left: auto;
      margin-right: auto;
      border-radius: 50%;
    }
  </style>
</head>
<body>

<div class="container">
  <div class="logo-container">
    <h1>The Temper Trap Restaurant</h1>
    <img src="Logo.jpg" alt="Logo de The Temper Trap">
  </div>
  <form action="LoginEmpleadoServlet" method="post">
    <h2>Login de Empleados</h2>
    <a href="index.jsp" class="back-link" style="color: #5c85d6; margin-bottom: 20px">Volver</a>
    <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario" placeholder="Usuario" required>

    <label for="contraseña">Contraseña:</label>
    <input type="password" id="contraseña" name="contraseña" placeholder="Contraseña" required>

    <input type="submit" value="Iniciar Sesión">
  </form>
</div>

</body>
</html>
