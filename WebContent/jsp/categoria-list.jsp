<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.ecommerce.modelo.Categoria" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Categorías</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Lista de Categorías</h1>

<div class="mb-3 text-end">
    <a href="<%=request.getContextPath()%>/admin/categoria/nueva" class="btn btn-success">Nueva Categoría</a>
</div>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                if (categorias != null && !categorias.isEmpty()) {
                    for (Categoria c : categorias) {
            %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getName() %></td>
            </tr>
            <% 
                    }
                } else { 
            %>
            <tr>
                <td colspan="2" class="text-center">No hay categorías disponibles.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>
</body>
</html>