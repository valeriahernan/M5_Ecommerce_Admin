package com.ecommerce.servlets;

import com.ecommerce.modelo.Producto;
import com.ecommerce.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class ProductoCrearServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Mostrar formulario para crear producto
        request.getRequestDispatcher("/jsp/producto_form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO producto(nombre, precio) VALUES (?, ?)")) {

            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error al crear producto", e);
        }

        response.sendRedirect(request.getContextPath() + "/admin/producto");
    }
}