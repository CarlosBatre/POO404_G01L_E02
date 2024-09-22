<%--
  Created by IntelliJ IDEA.
  User: rojas
  Date: 21/9/2024
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingresar a la cuenta</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/login_style.css">
</head>
<body>
    <form>
        <outputLabel value="Usuario:" />
        <inputText value="#{Login.username}" />

        <outputLabel value="Contraseña:" />
        <h:inputSecret value="#{Login.password}" />

        <commandButton value="Iniciar Sesión" action="#{Login.login}" />
    </form>
</body>
</html>
