package com.ecommerce.servlets;

import com.ecommerce.modelo.Categoria;
import com.ecommerce.modelo.CategoriaDAO;
import com.ecommerce.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/admin/categoria/guardar")
public class CategoriaSaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("name");

        if (nombre == null || nombre.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/admin/categoria/nueva");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {

            CategoriaDAO dao = new CategoriaDAO(conn);

            Categoria c = new Categoria();
            c.setName(nombre);

            dao.insertar(c); // <-- necesitas agregar este método en tu DAO

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error guardando categoría", e);
        }

        // Redirige a la lista de categorías
        response.sendRedirect(request.getContextPath() + "/admin/categorias");
    }
}