package com.jael.exercicios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {

    public static Connection getConnection() {

        try {
            final String url = "jdbc:mysql://localhost/curso_java?verifyServerCertificate=false&useSSL=true";
            final String usuario = "root";
            final String senha = "qwe123";

            return DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
