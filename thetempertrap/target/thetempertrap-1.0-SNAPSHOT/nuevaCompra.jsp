<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva Compra</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/scripts.js"></script>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="container">
    <h1>Registrar Nueva Compra</h1>
    <form action="compras" method="post" onsubmit="return confirmPurchase()">
        Producto: <input type="text" name="producto" required><br>
        Cantidad: <input type="number" name="cantidad" required><br>
        <button type="submit">Agregar Compra</button>
    </form>
</div>
</body>
</html>
