package com.ecommerce.modelo;

import java.io.Serializable;

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    // 🔹 Constructor vacío (necesario para JSP/Beans)
    public Categoria() {}

    // 🔹 Constructor con parámetros
    public Categoria(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 🔹 Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 🔹 toString (útil para debug)
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}