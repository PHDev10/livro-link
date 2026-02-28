package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.ReservaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/consulta-usuarios-por-livro")
public class ConsultaUsuariosPorLivroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservaDAO dao = new ReservaDAO();
        request.setAttribute("lista", dao.listarUsuariosPorLivro());
        request.getRequestDispatcher("/WEB-INF/views/consulta-usuarios-por-livro.jsp").forward(request, response);
    }
}