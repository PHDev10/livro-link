package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.SessaoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/livros-por-sessao")
public class LivrosPorSessaoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SessaoDAO dao = new SessaoDAO();
        request.setAttribute("lista", dao.listarLivrosPorSessao());
        request.getRequestDispatcher("/WEB-INF/views/livros-por-sessao.jsp").forward(request, response);
    }
}