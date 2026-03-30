package com.ecommerce.servlets;

import com.ecommerce.modelo.Producto;
import com.ecommerce.modelo.ProductoDAO;
import com.ecommerce.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductoListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection conn = DBConnection.getConnection()) {

            // Usamos DAO (MVC correcto)
            ProductoDAO dao = new ProductoDAO(conn);
            List<Producto> productos = dao.listar();

            request.setAttribute("productos", productos);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error listing products", e);
        }

        // Forward a la vista
        request.getRequestDispatcher("/jsp/productos.jsp").forward(request, response);
    }
}