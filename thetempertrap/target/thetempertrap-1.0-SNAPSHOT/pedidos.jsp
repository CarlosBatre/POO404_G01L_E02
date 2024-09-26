<%@ page import="java.util.List" %>
<%@ page import="model.Pedido" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Temper Trap - Gestion de Pedidos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #2c3e50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #2980b9;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        select, input[type="text"], button {
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: calc(100% - 18px);
        }
        button {
            background-color: #2980b9;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #1a5a8c;
        }
    </style>
</head>
<body>

<h1>Despacho de Pedidos</h1>
<table>
    <thead>
    <tr>
        <th>ID Pedido</th>
        <th>Cliente</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="pedido" items="${pedidos}">
        <tr>
            <td>${pedido.idPedido}</td>
            <td>${pedido.cliente.nombreCompleto}</td>
            <td>${pedido.estado}</td>
            <td>
                <form action="pedido" method="post">
                    <input type="hidden" name="idPedido" value="${pedido.idPedido}">
                    <select name="nuevoEstado">
                        <option value="En proceso de elaborar">En proceso de elaborar</option>
                        <option value="Entregado al repartidor">Entregado al repartidor</option>
                        <option value="Entregado al cliente">Entregado al cliente</option>
                    </select>
                    <input type="text" name="comentario" placeholder="Comentario" required>
                    <input type="text" name="idEmpleado" placeholder="ID Empleado" required>
                    <input type="hidden" name="accion" value="cambiarEstado">
                    <button type="submit">Actualizar Estado</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
