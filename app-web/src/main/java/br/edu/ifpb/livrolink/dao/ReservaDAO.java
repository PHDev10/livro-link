package br.edu.ifpb.livrolink.dao;

import br.edu.ifpb.livrolink.util.Conexao;
import java.sql.*;
import java.util.*;

public class ReservaDAO {
    public List<Object[]> listarUsuariosPorLivro() {
        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT l.nomedolivro, u.nome, u.cpf, r.data_reserva FROM reserva r INNER JOIN livro l   ON r.cod_livro = l.cod_livro INNER JOIN usuario u ON r.id_usuario = u.id_usuario ORDER BY l.nomedolivro";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] linha = new Object[4];
                linha[0] = rs.getString("nomedolivro");
                linha[1] = rs.getString("nome");
                linha[2] = rs.getString("cpf");
                linha[3] = rs.getTimestamp("data_reserva");

                lista.add(linha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<String[]> listarLivrosReservados() {
        List<String[]> lista = new ArrayList<>();

        String sql = "SELECT l.cod_livro, l.nomedolivro, l.autordolivro, u.nome AS nome_usuario, u.cpf, s.generosessao FROM livro l INNER JOIN usuario u ON l.id_usuario = u.id_usuario INNER JOIN sessao s ON l.id_sessao = s.id_sessao WHERE l.ocupado = true";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String[] dados = new String[6];
                dados[0] = rs.getString("cod_livro");
                dados[1] = rs.getString("nomedolivro");
                dados[2] = rs.getString("autordolivro");
                dados[3] = rs.getString("nome_usuario");
                dados[4] = rs.getString("cpf");
                dados[5] = rs.getString("generosessao");

                lista.add(dados);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}