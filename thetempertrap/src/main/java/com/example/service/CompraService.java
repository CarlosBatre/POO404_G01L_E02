package com.example.service;

import com.example.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class CompraService {

    // Lista para simular la base de datos de productos
    private List<Producto> productos;

    public CompraService() {
        // Inicializar con algunos productos
        productos = new ArrayList<>();
        productos.add(new Producto(1, "Laptop", 1200.00, 10));
        productos.add(new Producto(2, "Smartphone", 800.00, 15));
        productos.add(new Producto(3, "Tablet", 400.00, 8));
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productos;
    }

    // Obtener un producto por ID
    public Producto getProductoById(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Agregar un producto (simula la compra de un producto)
    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    // Eliminar un producto por ID
    public boolean deleteProductoById(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }

    // Actualizar un producto
    public boolean updateProducto(Producto productoActualizado) {
        for (Producto p : productos) {
            if (p.getId() == productoActualizado.getId()) {
                p.setNombre(productoActualizado.getNombre());
                p.setPrecio(productoActualizado.getPrecio());
                p.setCantidad(productoActualizado.getCantidad());
                return true;
            }
        }
        return false;
    }
}
