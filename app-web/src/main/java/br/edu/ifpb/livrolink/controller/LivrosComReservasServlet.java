package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.LivroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/livros-com-reservas")
public class LivrosComReservasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LivroDAO dao = new LivroDAO();
        request.setAttribute("lista", dao.listarLivrosComReservas());
        request.getRequestDispatcher("/WEB-INF/views/livros-com-reservas.jsp").forward(request, response);
    }
}