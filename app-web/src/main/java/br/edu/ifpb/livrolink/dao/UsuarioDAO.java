package br.edu.ifpb.livrolink.dao;

import br.edu.ifpb.livrolink.model.Usuario;
import br.edu.ifpb.livrolink.util.Conexao;

import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));

                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Usuario buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM usuario WHERE cpf = ?";
        Usuario usuario = null;

        try (Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSexo(resultSet.getString("sexo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, idade, cpf, sexo) VALUES (?, ?, ?, ?)";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, usuario.getNome());
            statement.setInt(2, usuario.getIdade());
            statement.setString(3, usuario.getCpf());
            statement.setString(4, usuario.getSexo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}