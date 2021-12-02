package com.jael.exercicios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        Connection conexao = CriarConexao.getConnection();
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";

        System.out.print("Pesquisa: ");

        String pesquisa = entrada.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, pesquisa + "%");
        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String name = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, name));
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getCodigo() + " ==> " + pessoa.getNome());
        }

        stmt.close();
        conexao.close();
        entrada.close();

    }

}
