package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.LivroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/consulta-livros-reservados")
public class ConsultaLivrosReservadosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroDAO dao = new LivroDAO();
        List<String[]> lista = dao.listarLivrosReservados();

        request.setAttribute("lista", lista);
        request.getRequestDispatcher("/WEB-INF/views/consulta-livros-reservados.jsp").forward(request, response);
    }
}