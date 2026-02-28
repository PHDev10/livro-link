package br.edu.ifpb.livrolink.dao;

import br.edu.ifpb.livrolink.model.Sessao;
import br.edu.ifpb.livrolink.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {
    public List<Sessao> listar() {
        List<Sessao> lista = new ArrayList<>();
        String sql = "SELECT id_sessao, generosessao, quantidadelivrosgenero FROM sessao";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sessao s = new Sessao();
                s.setIdSessao(rs.getInt("id_sessao"));
                s.setGeneroSessao(rs.getString("generosessao"));
                s.setQuantidadeDeLivrosGenero(rs.getInt("quantidadelivrosgenero"));

                lista.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Object[]> listarLivrosPorSessao() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT s.generosessao, COUNT(l.cod_livro) AS total_livros FROM sessao s LEFT JOIN livro l ON s.id_sessao = l.id_sessao GROUP BY s.generosessao ORDER BY total_livros DESC";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] linha = new Object[2];
                linha[0] = rs.getString("generosessao");
                linha[1] = rs.getInt("total_livros");
                lista.add(linha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
