<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ecommerce.modelo.Producto, java.util.List, com.ecommerce.modelo.Categoria" %>
<%@ include file="includes/header.jsp" %>

<%
    Producto producto = (Producto) request.getAttribute("producto");

    if (producto == null) {
        response.sendRedirect(request.getContextPath() + "/admin/producto");
        return;
    }

    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>

<h1 class="text-center mb-4">Editar Producto</h1>

<form action="<%= request.getContextPath() %>/admin/producto/edit" method="post">

    <!-- 🔹 ID oculto -->
    <input type="hidden" name="id" value="<%= producto.getId() %>">

    <!-- 🔹 Nombre -->
    <div class="mb-3">
        <label for="name" class="form-label">Nombre</label>
        <input type="text" name="name" id="name" class="form-control"
               value="<%= producto.getName() %>" required>
    </div>

    <!-- 🔹 Precio -->
    <div class="mb-3">
        <label for="price" class="form-label">Precio</label>
        <input type="number" step="0.01" name="price" id="price" class="form-control"
               value="<%= producto.getPrice() %>" required>
    </div>

    <!-- 🔹 Categoría -->
    <div class="mb-3">
        <label for="categoryId" class="form-label">Categoría</label>
        <select name="categoryId" id="categoryId" class="form-select" required>

            <option value="">-- Seleccione una categoría --</option>

            <%
                if (categorias != null && !categorias.isEmpty()) {
                    for (Categoria c : categorias) {
                        boolean selected = c.getId() == producto.getCategoryId();
            %>
                <option value="<%= c.getId() %>" <%= selected ? "selected" : "" %>>
                    <%= c.getName() %>
                </option>
            <%
                    }
                }
            %>

        </select>
    </div>

    <!-- 🔹 Botones -->
    <button type="submit" class="btn btn-primary">Actualizar</button>
    <a href="<%= request.getContextPath() %>/admin/producto" class="btn btn-secondary">Cancelar</a>

</form>

<%@ include file="includes/footer.jsp" %>