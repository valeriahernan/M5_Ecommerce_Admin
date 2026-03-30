<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>M5 Ecommerce Admin</title>

    <!-- 🔹 Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

    <!-- 🔹 CSS propio -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<!-- 🔹 Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp">
            M5 Ecommerce
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/admin/producto">
                        Productos
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/admin/categoria">
                        Categorías
                    </a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<!-- 🔹 Contenido -->
<div class="container mt-5">

    <h1 class="text-center mb-4">Panel de Administración</h1>

    <div class="row">

        <!-- 🔹 Productos -->
        <div class="col-md-6 mb-3">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Gestión de Productos</h5>
                    <p class="card-text">
                        Ver, crear, editar o eliminar productos.
                    </p>
                    <a href="<%= request.getContextPath() %>/admin/producto"
                       class="btn btn-primary">
                        Ir a Productos
                    </a>
                </div>
            </div>
        </div>

        <!-- 🔹 Categorías -->
        <div class="col-md-6 mb-3">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Gestión de Categorías</h5>
                    <p class="card-text">
                        Ver, crear o eliminar categorías.
                    </p>
                    <a href="<%= request.getContextPath() %>/admin/categoria"
                       class="btn btn-primary">
                        Ir a Categorías
                    </a>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- 🔹 Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/js/custom.js"></script>

</body>
</html>