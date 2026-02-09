package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.LivroDAO;
import br.edu.ifpb.livrolink.dao.SessaoDAO;
import br.edu.ifpb.livrolink.model.Livro;
import br.edu.ifpb.livrolink.model.Sessao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/livros")
public class LivroServlet extends HttpServlet {
    private LivroDAO livroDAO = new LivroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if ("novo".equals(acao)) {
            SessaoDAO sessaoDAO = new SessaoDAO();
            List<Sessao> sessoes = sessaoDAO.listar();

            request.setAttribute("sessoes", sessoes);
            request.getRequestDispatcher("/WEB-INF/views/livro-form.jsp").forward(request, response);

        } else if ("editar".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));

            Livro livro = livroDAO.buscarPorId(id);

            SessaoDAO sessaoDAO = new SessaoDAO();
            List<Sessao> sessoes = sessaoDAO.listar();

            request.setAttribute("livro", livro);
            request.setAttribute("sessoes", sessoes);
            request.getRequestDispatcher("/WEB-INF/views/livro-form.jsp").forward(request, response);
        } else if ("excluir".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            livroDAO.excluir(id);
            response.sendRedirect("livros");
        } else {
            List<Livro> livros = livroDAO.listar();
            request.setAttribute("livros", livros);
            request.getRequestDispatcher("/WEB-INF/views/livro-lista.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Livro livro = new Livro();

        String idStr = request.getParameter("codLivro");
        String idSessaoStr = request.getParameter("idSessao");
        if (idSessaoStr == null || idSessaoStr.isEmpty()) {
            throw new RuntimeException("Sessão não encontrada!");
        }
        int idSessao = Integer.parseInt(idSessaoStr);

        livro.setNomeDoLivro(request.getParameter("nomeDoLivro"));
        livro.setGeneroDoLivro(request.getParameter("generoDoLivro"));
        livro.setAutorDoLivro(request.getParameter("autorDoLivro"));
        livro.setEditoraDoLivro(request.getParameter("editoraDoLivro"));
        livro.setIdSessao(idSessao);
        livro.setOcupado(false);

        if (idStr != null && !idStr.isEmpty()) {
            livro.setCodLivro(Integer.parseInt(idStr));
            livroDAO.atualizar(livro);
        } else {
            livroDAO.inserir(livro);
        }

        response.sendRedirect("livros");
    }
}