package com.jael.exercicios.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        Connection conexao = CriarConexao.getConnection();

        System.out.println("Conexão feita com Sucesso!!");

        conexao.close();
    }

}