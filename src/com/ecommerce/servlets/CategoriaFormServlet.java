package com.ecommerce.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/categoria/nueva")
public class CategoriaFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward al JSP del formulario
        request.getRequestDispatcher("/jsp/categoria-form.jsp").forward(request, response);
    }
}