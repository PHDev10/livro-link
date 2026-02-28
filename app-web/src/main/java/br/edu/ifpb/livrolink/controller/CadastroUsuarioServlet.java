package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.UsuarioDAO;
import br.edu.ifpb.livrolink.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/views/cadastro-usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setIdade(Integer.parseInt(request.getParameter("idade")));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSexo(String.valueOf(request.getParameter("sexo").charAt(0)));

        UsuarioDAO dao = new UsuarioDAO();
        dao.inserir(usuario);

        response.sendRedirect("login");
    }
}
