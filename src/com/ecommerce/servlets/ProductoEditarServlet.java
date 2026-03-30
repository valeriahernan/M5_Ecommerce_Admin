package com.ecommerce.servlets;

import com.ecommerce.modelo.Producto;
import com.ecommerce.modelo.ProductoDAO;
import com.ecommerce.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ProductoEditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConnection.getConnection()) {

            ProductoDAO dao = new ProductoDAO(conn);
            Producto producto = dao.obtenerPorId(id);

            request.setAttribute("producto", producto);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error getting product", e);
        }

        request.getRequestDispatcher("/jsp/producto_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        try (Connection conn = DBConnection.getConnection()) {

            ProductoDAO dao = new ProductoDAO(conn);

            Producto p = new Producto();
            p.setId(id);
            p.setName(name);
            p.setPrice(price);
            p.setCategoryId(categoryId);

            dao.actualizar(p);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error updating product", e);
        }

        response.sendRedirect(request.getContextPath() + "/admin/producto");
    }
}