package com.jael.exercicios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdatePessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        Connection conexao = CriarConexao.getConnection();
        String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

        System.out.print("Informe o ID para atualizar o nome: ");

        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nome para atualizar: ");

        String nome = entrada.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, id);
        stmt.execute();

        String sql2 = "SELECT * FROM pessoas";

        ResultSet resultado = stmt.executeQuery(sql2);

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
