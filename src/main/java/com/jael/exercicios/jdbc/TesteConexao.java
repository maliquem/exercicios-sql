package com.jael.exercicios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        final String usuario = "root";
        final String senha = "qwe123";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        System.out.println("Conexão feita com Sucesso!!");

        conexao.close();
    }

}