<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.ecommerce.modelo.Producto" %>
<%@ include file="includes/header.jsp" %>

<h1 class="text-center mb-4">Lista de Productos</h1>

<div class="mb-3 text-end">
    <a href="<%= request.getContextPath() %>/admin/producto/new" 
       class="btn btn-success">Nuevo Producto</a>
</div>

<table class="table table-striped table-hover">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Categoría</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
    <%
        List<Producto> lista = (List<Producto>) request.getAttribute("productos");

        if (lista != null && !lista.isEmpty()) {
            for (Producto p : lista) {
    %>
        <tr class="producto-card">
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td>$<%= String.format("%,.0f", p.getPrice()) %></td>
            <td><%= (p.getCategoryName() != null) ? p.getCategoryName() : "Sin categoría" %></td>
            <td>
                <a href="<%= request.getContextPath() %>/admin/producto/edit?id=<%= p.getId() %>" 
                   class="btn btn-primary btn-sm">Editar</a>
                <a href="<%= request.getContextPath() %>/admin/producto/delete?id=<%= p.getId() %>" 
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('¿Seguro que deseas eliminar este producto?');">
                   Eliminar
                </a>
            </td>
        </tr>
    <%
            }
        } else {
    %>
        <tr>
            <td colspan="5" class="text-center">No hay productos disponibles</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>

<%@ include file="includes/footer.jsp" %>