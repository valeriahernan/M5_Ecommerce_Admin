package com.ecommerce.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private Connection con;

    public ProductoDAO(Connection con) {
        this.con = con;
    }

    // 🔹 Listar productos con categoría
    public List<Producto> listar() throws SQLException {
        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT p.id, p.name, p.price, p.category_id, " +
                     "c.name AS category_name " +
                     "FROM products p " +
                     "LEFT JOIN categories c ON p.category_id = c.id " +
                     "ORDER BY p.id";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = mapearProducto(rs);
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en listar(): " + e.getMessage());
            throw e;
        }

        return lista;
    }

    // 🔹 Crear producto
    public void crear(Producto p) throws SQLException {
        String sql = "INSERT INTO products (name, price, category_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());

            if (p.getCategoryId() <= 0) {
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setInt(3, p.getCategoryId());
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ Error en crear(): " + e.getMessage());
            throw e;
        }
    }

    // 🔹 Obtener producto por ID
    public Producto obtenerPorId(int id) throws SQLException {
        String sql = "SELECT id, name, price, category_id FROM products WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearProducto(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en obtenerPorId(): " + e.getMessage());
            throw e;
        }

        return null;
    }

    // 🔹 Actualizar producto
    public void actualizar(Producto p) throws SQLException {
        String sql = "UPDATE products SET name = ?, price = ?, category_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());

            if (p.getCategoryId() <= 0) {
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setInt(3, p.getCategoryId());
            }

            ps.setInt(4, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ Error en actualizar(): " + e.getMessage());
            throw e;
        }
    }

    // 🔹 Eliminar producto
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ Error en eliminar(): " + e.getMessage());
            throw e;
        }
    }

    // 🔥 MÉTODO PRIVADO (CLAVE) → evita repetir código
    private Producto mapearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();

        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getDouble("price"));

        int categoryId = rs.getInt("category_id");
        if (rs.wasNull()) {
            p.setCategoryId(0);
        } else {
            p.setCategoryId(categoryId);
        }

        // 🔹 Solo existe en listar (por el JOIN)
        try {
            p.setCategoryName(rs.getString("category_name"));
        } catch (SQLException e) {
            // No viene en esta query → ignorar
        }

        return p;
    }
}