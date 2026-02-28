package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.LivroDAO;
import br.edu.ifpb.livrolink.dao.UsuarioDAO;
import br.edu.ifpb.livrolink.model.Livro;
import br.edu.ifpb.livrolink.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.buscarPorCpf(cpf);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);

            response.sendRedirect("livros");
        } else {
            request.setAttribute("erro", "Usuário não encontrado");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
