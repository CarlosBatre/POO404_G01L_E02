-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 28-09-2024 a las 13:09:55
-- Versión del servidor: 8.3.0
-- Versión de PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `thetempertrap`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombreCompleto` varchar(100) NOT NULL,
  `usuario` varchar(120) NOT NULL,
  `contraseña` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(150) NOT NULL,
  `dui` varchar(9) NOT NULL,
  `telefono` int NOT NULL,
  `direccionCompleta` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `dui` (`dui`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nombreCompleto`, `usuario`, `contraseña`, `email`, `dui`, `telefono`, `direccionCompleta`) VALUES
(1, 'a', 'a', 'a', 'a', 'a', 77777777, 'a'),
(3, 'Josue', 'Zelda', '1234', 'wilsonraspy@gmail.com', '12345567', 2132312, 'Soyapango'),
(12, 'Juan Carlos Pérez Rodríguez', 'jcarlos', 'pass123', 'jcarlos@example.com', '123456789', 70347212, 'San Salvador, San Salvador, Calle El Sol, Casa #123'),
(2, 'María Fernanda López Martínez', 'mlopez', 'maria456', 'mlopez@example.com', '987654321', 78902312, 'Santa Ana, Santa Ana, Avenida Libertad, Casa #456'),
(11, 'Carlos Eduardo Gómez Hernández', 'cgomez', 'carlos789', 'cgomez@example.com', '234567890', 73452314, 'La Libertad, Santa Tecla, Calle Las Flores, Casa #789'),
(4, 'Ana Beatriz Torres Ramírez', 'btorres', 'ana123', 'atorres@example.com', '345678901', 73448372, 'San Miguel, San Miguel, Boulevard El Rosario, Casa #321'),
(5, 'Luis Alberto Ramírez Sánchez', 'lramirez', 'luis456', 'lramirez@example.com', '456789012', 78561234, 'Usulután, Usulután, Calle Nueva, Casa #654'),
(6, 'Sofía Elena Martínez Castillo', 'smartinez', 'sofia789', 'smartinez@example.com', '567890123', 71236543, 'Chalatenango, Chalatenango, Colonia Jardines, Casa #987'),
(7, 'Pedro José Castillo López', 'pjcastillo', 'pedro123', 'pjcastillo@example.com', '678901234', 74568876, 'La Libertad, La Libertad, Avenida Libertad, Casa #147'),
(8, 'Gabriela Isabel Vega Flores', 'gvega', 'gabriela456', 'gvega@example.com', '789012345', 73459867, 'Ahuachapán, Ahuachapán, Calle Los Pinos, Casa #258'),
(9, 'Ricardo Antonio Herrera Cruz', 'rherrera', 'ricardo789', 'rherrera@example.com', '890123456', 72349878, 'Sonsonate, Sonsonate, Pasaje Primavera, Casa #369'),
(10, 'Claudia Patricia Reyes Fuentes', 'creyes', 'claudia123', 'creyes@example.com', '901234567', 70127777, 'Cabañas, Sensuntepeque, Boulevard Norte, Casa #753');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_pedido`
--

DROP TABLE IF EXISTS `detalles_pedido`;
CREATE TABLE IF NOT EXISTS `detalles_pedido` (
  `idDetalle` int NOT NULL AUTO_INCREMENT,
  `idPedido` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` int NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idDetalle`),
  KEY `idPedido` (`idPedido`),
  KEY `idProducto` (`idProducto`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `detalles_pedido`
--

INSERT INTO `detalles_pedido` (`idDetalle`, `idPedido`, `idProducto`, `cantidad`, `subtotal`) VALUES
(1, 1, 3, 2, 7.00),
(2, 2, 7, 1, 5.99),
(3, 3, 2, 1, 8.99),
(4, 4, 9, 3, 7.50),
(5, 5, 5, 1, 6.50),
(6, 6, 8, 1, 5.50),
(7, 7, 1, 1, 5.99),
(8, 8, 4, 2, 9.00),
(9, 9, 6, 1, 7.99),
(10, 10, 10, 1, 3.99);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombreCompleto` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `usuario` varchar(120) NOT NULL,
  `contraseña` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(150) NOT NULL,
  `dui` varchar(9) NOT NULL,
  `telefono` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cargo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `dui` (`dui`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`idEmpleado`, `nombreCompleto`, `usuario`, `contraseña`, `email`, `dui`, `telefono`, `cargo`) VALUES
(1, 'Carlos Josue Ruano Batres', 'Kayn', '1234', 'hyrule@gmail.com', '12345678', '77777777', 'Jefe Maestro'),
(11, 'Carlos Alberto Gómez Pérez', 'cgomez', 'pass123', 'cgomez@restaurant.com', '123456789', '70341234', 'Repartidor'),
(2, 'María Fernanda López Rodríguez', 'mlopez', 'maria456', 'mlopez@restaurant.com', '987654321', '78905678', 'Cajera'),
(3, 'Pedro José Ramírez Torres', 'pramirez', 'pedro789', 'pramirez@restaurant.com', '234567890', '73452345', 'Chef Principal'),
(4, 'Ana Beatriz Sánchez Hernández', 'asanchez', 'ana123', 'asanchez@restaurant.com', '345678901', '73446789', 'Repartidora'),
(5, 'Luis Alberto Martínez Pérez', 'lmartinez', 'luis456', 'lmartinez@restaurant.com', '456789012', '78567890', 'Supervisor de Cocina'),
(6, 'Gabriela Isabel Vega López', 'gvega', 'gabriela789', 'gvega@restaurant.com', '567890123', '71238901', 'Encargada de Pedidos'),
(7, 'Ricardo Antonio Herrera Cruz', 'rherrera', 'ricardo123', 'rherrera@restaurant.com', '678901234', '74569012', 'Repartidor'),
(8, 'Claudia Patricia Reyes Fuentes', 'creyes', 'claudia456', 'creyes@restaurant.com', '789012345', '73450123', 'Cajera'),
(9, 'José Manuel Gómez Hernández', 'jgomez', 'jose123', 'jgomez@restaurant.com', '890123456', '72342345', 'Ayudante de Cocina'),
(10, 'Sofía Elena Martínez Castillo', 'smartinez', 'sofia123', 'smartinez@restaurant.com', '901234567', '70123456', 'Encargada de Pedidos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_pedidos`
--

DROP TABLE IF EXISTS `historial_pedidos`;
CREATE TABLE IF NOT EXISTS `historial_pedidos` (
  `idHistorial` int NOT NULL AUTO_INCREMENT,
  `idPedido` int NOT NULL,
  `estadoAnterior` varchar(120) DEFAULT NULL,
  `estadoNuevo` varchar(120) DEFAULT NULL,
  `comentario` text,
  PRIMARY KEY (`idHistorial`),
  KEY `idPedido` (`idPedido`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `historial_pedidos`
--

INSERT INTO `historial_pedidos` (`idHistorial`, `idPedido`, `estadoAnterior`, `estadoNuevo`, `comentario`) VALUES
(1, 1, 'En proceso', 'Completado', 'El pedido fue entregado correctamente.'),
(2, 2, 'En espera', 'Completado', 'Pedido entregado sin inconvenientes.'),
(3, 3, 'En proceso', 'Completado', 'El cliente recibió su pedido.'),
(4, 4, 'En espera', 'Cancelado', 'El cliente canceló antes de la entrega.'),
(5, 5, 'En proceso', 'Completado', 'El pedido fue completado a tiempo.'),
(6, 6, 'Completado', 'Cancelado', 'El cliente solicitó cancelación después de la confirmación.'),
(7, 7, 'En espera', 'En proceso', 'El pedido está siendo preparado.'),
(8, 8, 'Completado', 'En proceso', 'Corrección de estado previo, ya está en preparación.'),
(9, 9, 'En proceso', 'Completado', 'Pedido entregado exitosamente.'),
(10, 10, 'En espera', 'En proceso', 'El pedido está en preparación.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(100) NOT NULL,
  `descripcion` text,
  `precio` decimal(10,2) NOT NULL,
  `existencias` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idProducto`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`idProducto`, `nombreProducto`, `descripcion`, `precio`, `existencias`) VALUES
(1, 'Hamburguesa Clásica', 'Hamburguesa de carne de res con lechuga, tomate, cebolla, queso y salsa especial', 5.99, 50),
(2, 'Pizza Pepperoni', 'Pizza de pepperoni con queso mozzarella y salsa de tomate', 8.99, 30),
(3, 'Tacos al Pastor', 'Tacos de cerdo al pastor con piña, cebolla, cilantro y salsa', 3.50, 40),
(4, 'Ensalada César', 'Ensalada fresca con lechuga, crutones, queso parmesano y aderezo César', 4.50, 20),
(5, 'Pollo Frito', 'Pollo frito crujiente con papas fritas y ensalada', 6.50, 25),
(6, 'Sándwich de Pollo', 'Sándwich de pechuga de pollo a la parrilla con lechuga, tomate y mayonesa', 4.99, 35),
(7, 'Lasaña de Carne', 'Lasaña de carne con salsa de tomate, queso ricotta y mozzarella', 7.99, 15),
(8, 'Burrito de Res', 'Burrito de carne de res con arroz, frijoles, queso y guacamole', 5.50, 30),
(9, 'Papas Fritas', 'Papas fritas crujientes con sal', 2.50, 100),
(10, 'Nachos con Queso', 'Nachos de maíz con queso cheddar derretido y jalapeños', 3.99, 50),
(11, 'Pizza Hawaiana', 'Pizza con jamón, piña, queso mozzarella y salsa de tomate', 9.50, 25),
(12, 'Alitas BBQ', 'Alitas de pollo con salsa BBQ, acompañadas de apio y aderezo ranch', 7.25, 40),
(13, 'Torta de Pollo', 'Torta de pollo desmenuzado con aguacate, tomate, cebolla y frijoles', 4.75, 30),
(14, 'Sopa de Mariscos', 'Sopa de mariscos con camarones, calamares y pescado en caldo de tomate', 10.99, 15),
(15, 'Churrasco con Chimichurri', 'Carne de res a la parrilla con chimichurri, acompañada de papas y ensalada', 12.99, 10),
(16, 'Pizza Vegetariana', 'Pizza con champiñones, pimientos, cebolla, espinacas y queso mozzarella', 8.99, 20),
(17, 'Hot Dog Clásico', 'Salchicha a la parrilla con cebolla, mostaza y ketchup en pan suave', 3.25, 50),
(18, 'Bistec Encebollado', 'Bistec de res con cebolla caramelizada, acompañado de arroz y frijoles', 9.99, 18),
(19, 'Empanadas de Pollo', 'Empanadas rellenas de pollo con salsa de tomate', 3.99, 35),
(20, 'Wrap de Vegetales', 'Wrap de tortillas con vegetales frescos, hummus y salsa de yogur', 5.75, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `idPedido` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idProducto` int NOT NULL,
  `fechaPedido` datetime NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `estado` varchar(120) DEFAULT NULL,
  `comentarios` text,
  PRIMARY KEY (`idPedido`),
  KEY `idCliente` (`idCliente`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`idPedido`, `idCliente`, `idProducto`, `fechaPedido`, `total`, `formaPago`, `estado`, `comentarios`) VALUES
(1, 1, 3, '2024-09-28 00:00:00', 10.50, 'Tarjeta de Crédito', 'En proceso', 'Sin comentarios'),
(2, 2, 7, '2024-09-28 00:00:00', 5.99, 'Efectivo', 'Completado', 'Entregado a tiempo'),
(3, 3, 2, '2024-09-28 00:00:00', 8.99, 'Tarjeta de Débito', 'Completado', 'Cliente satisfecho'),
(4, 4, 9, '2024-09-28 00:00:00', 2.50, 'Efectivo', 'En espera', 'Sin comentarios'),
(5, 5, 5, '2024-09-28 00:00:00', 6.50, 'Tarjeta de Crédito', 'Cancelado', 'Cliente canceló el pedido'),
(6, 6, 8, '2024-09-28 00:00:00', 5.50, 'Efectivo', 'Completado', 'Sin comentarios'),
(7, 7, 1, '2024-09-28 00:00:00', 5.99, 'Transferencia', 'En proceso', 'Esperando confirmación'),
(8, 8, 4, '2024-09-28 00:00:00', 4.50, 'Tarjeta de Débito', 'Completado', 'Pedido entregado correctamente'),
(9, 9, 6, '2024-09-28 00:00:00', 7.99, 'Efectivo', 'Completado', 'Cliente agradeció la rapidez'),
(10, 10, 10, '2024-09-28 00:00:00', 3.99, 'Tarjeta de Crédito', 'En espera', 'Esperando confirmación de pago');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
