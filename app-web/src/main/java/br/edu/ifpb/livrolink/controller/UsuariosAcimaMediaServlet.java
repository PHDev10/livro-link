package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuarios-acima-media")
public class UsuariosAcimaMediaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO dao = new UsuarioDAO();
        request.setAttribute("lista", dao.listarUsuariosAcimaMedia());
        request.getRequestDispatcher("/WEB-INF/views/usuarios-acima-media.jsp").forward(request, response);
    }
}