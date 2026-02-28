package br.edu.ifpb.livrolink.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class FiltroAuthenticacao implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        if (uri.contains("/login") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/images/") || uri.contains("/cadastro")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        boolean logado = (session != null && session.getAttribute("usuarioLogado") != null);

        if (logado) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute("erro", "Faça login para ter acesso a essa página.");
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
