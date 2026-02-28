package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.ReservaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/consulta-livros-reservados")
public class ConsultaLivrosReservadosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>> CONSULTA LIVROS RESERVADOS SERVLET OK <<<");
        ReservaDAO dao = new ReservaDAO();
        request.setAttribute("lista", dao.listarLivrosReservados());

        request.getRequestDispatcher("/WEB-INF/views/consulta-livros-reservados.jsp").forward(request, response);
    }
}