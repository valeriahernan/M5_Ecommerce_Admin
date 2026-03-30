package com.ecommerce.servlets;

import com.ecommerce.modelo.Categoria;
import com.ecommerce.modelo.CategoriaDAO;
import com.ecommerce.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/categorias")
public class CategoriaListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection conn = DBConnection.getConnection()) {

            // Usamos DAO (patrón MVC)
            CategoriaDAO dao = new CategoriaDAO(conn);
            List<Categoria> categorias = dao.listar();

            request.setAttribute("categorias", categorias);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error listando categorías", e);
        }

        // Forward al JSP que mostrará la lista
        request.getRequestDispatcher("/jsp/categoria-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}