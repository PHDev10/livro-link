<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Livros</title>
    <link rel="stylesheet" href="css/estiloPaginaListagem.css">
    <style>
        .nav-links {
            display: flex;
            align-items: center;
            gap: 20px;
        }

        .nav-links > a {
            color: white;
            text-decoration: none;
            font-weight: 500;
            margin-left: 0;
        }

        .nav-links > a:hover {
            text-decoration: underline;
        }

        .dropdown {
            position: relative;
        }

        .dropdown-btn {
            background-color: transparent;
            border: 2px solid white;
            color: white;
            padding: 7px 14px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 0.95rem;
            font-weight: 500;
        }

        .dropdown-btn:hover {
            background-color: rgba(255,255,255,0.15);
        }

        .dropdown-menu {
            display: none;
            position: absolute;
            right: 0;
            top: calc(100% + 10px);
            background-color: #ffffff;
            border-radius: 6px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
            min-width: 200px;
            z-index: 300;
            overflow: hidden;
        }

        .dropdown-menu a {
            display: block;
            padding: 12px 16px;
            color: #333;
            text-decoration: none;
            font-weight: 500;
            border-bottom: 1px solid #f0f0f0;
            margin-left: 0;
        }

        .dropdown-menu a:last-child {
            border-bottom: none;
        }

        .dropdown-menu a:hover {
            background-color: #f0faf7;
            color: #009879;
            text-decoration: none;
        }

        .dropdown.aberto .dropdown-menu {
            display: block;
        }
    </style>
</head>
<body>

<div class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/livros" class="logo">📚 LivroLink</a>

        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/livros">Home</a>
            <a href="${pageContext.request.contextPath}/livros?acao=novo">Novo Livro</a>

            <div class="dropdown">
                <button class="dropdown-btn">☰ Menu</button>
                <div class="dropdown-menu">
                    <a href="${pageContext.request.contextPath}/consulta-livros-reservados">Livros Reservados</a>
                    <a href="${pageContext.request.contextPath}/consulta-usuarios-por-livro">Usuários por Livro</a>
                    <a href="${pageContext.request.contextPath}/pagina-reserva">Reservar Livro</a>
                    <a href="${pageContext.request.contextPath}/livros-por-sessao">Livros por Sessão</a>
                    <a href="${pageContext.request.contextPath}/reservas-por-usuario">Reservas por Usuário</a>
                    <a href="${pageContext.request.contextPath}/livros-com-reservas">Livros com Reservas</a>
                    <a href="${pageContext.request.contextPath}/usuarios-acima-media">Usuários Acima da Média</a>
                </div>
            </div>
        </div>
    </div>
</div>

<h2>Lista de Livros</h2>

<a href="livros?acao=novo" class="estiloBotaoLink">Novo Livro</a>

<table class="tabela-listagem">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Gênero</th>
            <th>Autor</th>
            <th>Editora</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="l" items="${livros}">
            <tr>
                <td>${l.codLivro}</td>
                <td>${l.nomeDoLivro}</td>
                <td>${l.generoDoLivro}</td>
                <td>${l.autorDoLivro}</td>
                <td>${l.editoraDoLivro}</td>
                <td>
                    <a href="livros?acao=editar&id=${l.codLivro}" class="linkEditar">Editar</a>
                    <a href="#" class="linkExcluir" onclick="abrirModal(${l.codLivro})">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div id="modalExcluir" class="modal">
    <div class="modal-conteudo">
        <h3>Confirmação</h3>
        <p>Deseja excluir o livro?</p>
        <div class="modal-acoes">
            <button onclick="fecharModal()">Cancelar</button>
            <a id="confirmarExcluir" class="btn-excluir">Excluir</a>
        </div>
    </div>
</div>

<script>
    function abrirModal(idLivro) {
        const modal = document.getElementById("modalExcluir");
        const link = document.getElementById("confirmarExcluir");
        link.href = "livros?acao=excluir&id=" + idLivro;
        modal.style.display = "block";
    }

    function fecharModal() {
        document.getElementById("modalExcluir").style.display = "none";
    }

    // Fecha o dropdown ao clicar fora dele
    document.addEventListener("click", function(e) {
        const dropdown = document.querySelector(".dropdown");
        if (!dropdown.contains(e.target)) {
            dropdown.classList.remove("aberto");
        }
    });

    document.querySelector(".dropdown-btn").addEventListener("click", function(e) {
        e.stopPropagation();
        document.querySelector(".dropdown").classList.toggle("aberto");
    });
</script>

</body>
</html>