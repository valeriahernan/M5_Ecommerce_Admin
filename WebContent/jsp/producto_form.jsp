<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.ecommerce.modelo.Categoria" %>
<%@ include file="includes/header.jsp" %>

<h1 class="text-center mb-4">Crear Producto</h1>

<form action="<%= request.getContextPath() %>/admin/producto/new" method="post">

    <!-- 🔹 Nombre -->
    <div class="mb-3">
        <label for="name" class="form-label">Nombre</label>
        <input type="text" name="name" id="name" class="form-control" required>
    </div>

    <!-- 🔹 Precio -->
    <div class="mb-3">
        <label for="price" class="form-label">Precio</label>
        <input type="number" step="0.01" name="price" id="price" class="form-control" required>
    </div>

    <!-- 🔹 Categoría -->
    <div class="mb-3">
        <label for="categoryId" class="form-label">Categoría</label>
        <select name="categoryId" id="categoryId" class="form-select" required>
            <option value="">-- Seleccione una categoría --</option>

            <%
                List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");

                if (categorias != null && !categorias.isEmpty()) {
                    for (Categoria c : categorias) {
            %>
                <option value="<%= c.getId() %>">
                    <%= c.getName() %>
                </option>
            <%
                    }
                } else {
            %>
                <option disabled>No hay categorías disponibles</option>
            <%
                }
            %>

        </select>
    </div>

    <!-- 🔹 Botones -->
    <button type="submit" class="btn btn-success">Guardar</button>
    <a href="<%= request.getContextPath() %>/admin/producto" class="btn btn-secondary">Cancelar</a>

</form>

<%@ include file="includes/footer.jsp" %>