package br.edu.ifpb.livrolink.controller;

import br.edu.ifpb.livrolink.dao.LivroDAO;
import br.edu.ifpb.livrolink.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/reservar-livro")
public class ReservarLivroServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int codLivro = Integer.parseInt(request.getParameter("codLivro"));

        LivroDAO dao = new LivroDAO();
        dao.reservarLivro(codLivro, usuarioLogado.getIdUsuario());

        response.sendRedirect(request.getContextPath() + "/livros-reservados");
    }
}