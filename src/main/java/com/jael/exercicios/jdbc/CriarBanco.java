package com.jael.exercicios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

    public static void main(String[] args) throws SQLException {

        Connection conexao = CriarConexao.getConnection();

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");

        System.out.println("Banco criado com sucesso!");

        conexao.close();
    }

}
