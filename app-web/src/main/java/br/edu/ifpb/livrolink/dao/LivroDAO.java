package br.edu.ifpb.livrolink.dao;

import br.edu.ifpb.livrolink.model.Livro;
import br.edu.ifpb.livrolink.util.Conexao;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public void inserir(Livro livro) {
        String sql = "INSERT INTO livro (nomedolivro, generodolivro, autordolivro, editoradolivro, ocupado, id_sessao) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, livro.getNomeDoLivro());
            statement.setString(2,livro.getGeneroDoLivro());
            statement.setString(3, livro.getAutorDoLivro());
            statement.setString(4, livro.getEditoraDoLivro());
            statement.setBoolean(5, livro.getOcupado());
            statement.setInt(6, livro.getIdSessao());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Livro buscarPorId(int id) {
        String sql = "SELECT * FROM livro WHERE cod_livro = ?";
        Livro l = null;
        try (Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                l = new Livro();
                l.setCodLivro(rs.getInt("cod_livro"));
                l.setNomeDoLivro(rs.getString("nomedolivro"));
                l.setGeneroDoLivro(rs.getString("generodolivro"));
                l.setAutorDoLivro(rs.getString("autordolivro"));
                l.setEditoraDoLivro(rs.getString("editoradolivro"));
                l.setOcupado(rs.getBoolean("ocupado"));
                l.setIdSessao(rs.getInt("id_sessao"));
                l.setIdUsuario((Integer) rs.getObject("id_usuario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;

    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET nomedolivro=?, generodolivro=?, autordolivro=?, editoradolivro=?, id_sessao=? WHERE cod_livro=?";

        try (Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, livro.getNomeDoLivro());
            statement.setString(2, livro.getGeneroDoLivro());
            statement.setString(3, livro.getAutorDoLivro());
            statement.setString(4, livro.getEditoraDoLivro());
            statement.setInt(5, livro.getIdSessao());
            statement.setInt(6, livro.getCodLivro());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listar() {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Livro l = new Livro();
                l.setCodLivro(rs.getInt("cod_livro"));
                l.setNomeDoLivro(rs.getString("nomedolivro"));
                l.setGeneroDoLivro(rs.getString("generodolivro"));
                l.setAutorDoLivro(rs.getString("autordolivro"));
                l.setEditoraDoLivro(rs.getString("editoradolivro"));
                l.setOcupado(rs.getBoolean("ocupado"));
                l.setIdSessao(rs.getInt("id_sessao"));
                l.setIdUsuario((Integer) rs.getObject("id_usuario"));

                lista.add(l);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    public void excluir(int id) {
        String sql = "DELETE FROM livro WHERE cod_livro=?";

        try (Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
