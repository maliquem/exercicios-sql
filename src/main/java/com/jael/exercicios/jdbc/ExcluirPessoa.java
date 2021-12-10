package com.jael.exercicios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        Connection conexao = CriarConexao.getConnection();
        String delete = "DELETE FROM pessoas WHERE codigo = ?";
        String select = "SELECT * FROM pessoas WHERE nome LIKE ?";

        System.out.print("Informe o nome da pessoa que quer excluir: ");
        String nome = entrada.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(select);
        stmt.setString(1, nome + "%");
        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa p = null;
        String res = "";

        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String name = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, name));
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getCodigo() + " ==> " + pessoa.getNome());
        }

        System.out.print("Digite o ID da pessoa que você quer deletar: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCodigo() == id) {
                p = new Pessoa(pessoa.getCodigo(), pessoa.getNome());
            }
        }

        if (p != null) {
            System.out.print("Tem certeza que deseja deletar " + p.getNome() + ", com o ID " + p.getCodigo()
                    + "? (Y/n): ");
            res = entrada.nextLine();
            if (res.equalsIgnoreCase("y")) {
                stmt = conexao.prepareStatement(delete);
                stmt.setInt(1, p.getCodigo());
                stmt.execute();
                System.out.println("Pessoa deletada com sucesso!");
            } else {
                System.out.println("Delete cancelado!");
            }
        }

        stmt.close();
        conexao.close();
        entrada.close();

    }

}
