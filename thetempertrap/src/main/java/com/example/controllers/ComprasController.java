package com.example.controllers;

import com.example.dao.CompraDAO;
import model.Compra;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/compras")
public class ComprasController extends HttpServlet {

    private CompraDAO compraDAO = new CompraDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String producto = req.getParameter("producto");
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));

        Compra compra = new Compra(0, producto, cantidad);
        compraDAO.agregarCompra(compra);

        resp.sendRedirect("index.jsp");
    }
}
