package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.LivroDAO;
import br.edu.ifpb.livrolink.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pagina-reserva")
public class PaginaReservaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LivroDAO livroDAO = new LivroDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        request.setAttribute("livros", livroDAO.listarLivrosDisponiveis());
        request.setAttribute("usuarios", usuarioDAO.listar());

        request.getRequestDispatcher("/WEB-INF/views/reserva-livro.jsp").forward(request, response);
    }
}