package com.ecommerce.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para manejar la tabla 'categories'.
 */
public class CategoriaDAO {

    private Connection con;

    /**
     * Constructor que recibe la conexión a la base de datos.
     * @param con Conexión activa a la base de datos.
     */
    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    /**
     * Lista todas las categorías de la base de datos.
     * @return List<Categoria> con todas las categorías.
     * @throws SQLException si ocurre un error en la consulta.
     */
    public List<Categoria> listar() throws SQLException {
        List<Categoria> lista = new ArrayList<>();

        String sql = "SELECT id, name FROM categories";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar categorías: " + e.getMessage());
            throw e;
        }

        return lista;
    }

    /**
     * Obtiene una categoría por su ID.
     * @param id Identificador de la categoría.
     * @return Categoria encontrada o null si no existe.
     * @throws SQLException si ocurre un error en la consulta.
     */
    public Categoria obtenerPorId(int id) throws SQLException {
        String sql = "SELECT id, name FROM categories WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Categoria c = new Categoria();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    return c;
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener categoría: " + e.getMessage());
            throw e;
        }

        return null;
    }

    /**
     * Inserta una nueva categoría en la base de datos.
     * @param c Objeto Categoria a insertar.
     * @throws SQLException si ocurre un error al ejecutar la inserción.
     */
    public void insertar(Categoria c) throws SQLException {
        String sql = "INSERT INTO categories (name) VALUES (?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar categoría: " + e.getMessage());
            throw e;
        }
    }
}