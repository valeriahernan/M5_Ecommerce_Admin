# M5_Ecommerce_Admin

Proyecto Admin Ecommerce desarrollado con **JSP, Servlets, JDBC** y arquitectura **MVC**.  
Permite gestionar productos y categorías mediante formularios web y conexión a MySQL.

---

## 🔹 Tecnologías

- Java EE / Servlets
- JSP + Bootstrap 5
- JDBC con DAO
- MySQL
- Apache Tomcat 9
- Git / GitHub para control de versiones

---

## 🔹 Estructura del proyecto

M5_Ecommerce_Admin/
│
├─ src/ # Código Java (Servlets, DAOs, Modelos)
│ ├─ com.ecommerce.modelo/
│ │ ├─ Categoria.java
│ │ ├─ CategoriaDAO.java
│ │ ├─ Producto.java
│ │ └─ ProductoDAO.java
│ └─ com.ecommerce.servlets/
│ ├─ CategoriaListServlet.java
│ ├─ CategoriaFormServlet.java
│ ├─ CategoriaSaveServlet.java
│ └─ ProductoListServlet.java
│
├─ WebContent/ # Contenido web
│ ├─ jsp/
│ │ ├─ categoria-list.jsp
│ │ ├─ categoria-form.jsp
│ │ └─ productos.jsp
│ └─ WEB-INF/
│ └─ web.xml
│
├─ .gitignore
└─ README.md


---

## 🔹 Rutas principales (Admin)

| Acción                     | Ruta / Servlet |
|-----------------------------|----------------|
| Listar categorías           | `/admin/categorias` |
| Nuevo categoría             | `/admin/categoria/nueva` |
| Guardar categoría           | `/admin/categoria/guardar` |
| Listar productos            | `/admin/products` |
| Nuevo producto              | `/admin/products/new` |
| Guardar producto            | `/admin/products` |
| Editar producto             | `/admin/products/edit?id=...` |
| Actualizar producto         | `/admin/products/update` |
| Eliminar producto           | `/admin/products/delete` |

---

## 🔹 Base de datos MySQL

```sql
-- Crear base de datos
CREATE DATABASE ecommerce;
USE ecommerce;

-- Tabla de categorías
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Tabla de productos
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
