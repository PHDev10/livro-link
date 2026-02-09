package br.edu.ifpb.livrolink.dao;

import br.edu.ifpb.livrolink.model.Sessao;
import br.edu.ifpb.livrolink.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
