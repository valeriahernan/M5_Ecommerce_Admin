package com.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USER = "admin";
	private static final String PASS = ""; // si dejaste sin contraseña

    public static Connection getConnection() throws SQLException {
        try {
            // Carga explícita del driver MySQL 8
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("No se encontró el driver de MySQL", e);
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }
}