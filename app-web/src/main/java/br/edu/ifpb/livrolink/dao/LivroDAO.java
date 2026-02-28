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

    public List<String[]> listarLivrosReservados() {
        List<String[]> lista = new ArrayList<>();
        String sql = "SELECT l.cod_livro, l.nomedolivro, l.autordolivro, u.nome AS nome_usuario, u.cpf,s.generosessao FROM livro l INNER JOIN usuario u ON l.id_usuario = u.id_usuario INNER JOIN sessao s ON l.id_sessao = s.id_sessao WHERE l.ocupado = true";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String[] dados = new String[6];
                dados[0] = resultSet.getString("cod_livro");
                dados[1] = resultSet.getString("nomedolivro");
                dados[2] = resultSet.getString("autordolivro");
                dados[3] = resultSet.getString("nome_usuario");
                dados[4] = resultSet.getString("cpf");
                dados[5] = resultSet.getString("generosessao");

                lista.add(dados);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT l.cod_livro, l.nomedolivro, s.generosessao FROM livro l INNER JOIN sessao s ON l.id_sessao = s.id_sessao WHERE l.ocupado = false";

        try (Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setCodLivro(resultSet.getInt("cod_livro"));
                livro.setNomeDoLivro(resultSet.getString("nomedolivro"));
                livro.setIdSessao(resultSet.getInt("id_sessao"));
                lista.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void reservarLivro(int idLivro, int idUsuario) {
        String sql = "UPDATE livro SET ocupado = true, id_usuario = ? WHERE cod_livro = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, idUsuario);
            statement.setInt(2, idLivro);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
