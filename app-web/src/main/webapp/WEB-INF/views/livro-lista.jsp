<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Livros</title>
    <link rel="stylesheet" href="css/estiloPaginaListagem.css">
</head>
<body>

<div class="navbar">
    <div class="navbar">
        <div class="nav-container">
            <a href="${pageContext.request.contextPath}/livros" class="logo">📚 LivroLink</a>

            <div class="nav-links">
                <a href="${pageContext.request.contextPath}/livros">Home</a>

                <a href="${pageContext.request.contextPath}/livros?acao=novo">
                    Novo Livro
                </a>

                <a href="${pageContext.request.contextPath}/consulta-livros-reservados">
                    Livros Reservados
                </a>

                <a href="${pageContext.request.contextPath}/consulta-usuarios-por-livro">
                    Usuários por Livro
                </a>

                <a href="${pageContext.request.contextPath}/pagina-reserva">
                    Reservar Livro
                </a>
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
</script>

</body>
</html>
