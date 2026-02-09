<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Livro</title>
    <link rel="stylesheet" href="css/estiloPaginaForm.css">
</head>

<body>

<div class="navbar">
    <div class="nav-container">
        <a href="livros" class="logo">📚 LivroLink</a>
        <div class="nav-links">
            <a href="livros">Home</a>
            <a href="livros?acao=novo">Novo Livro</a>
        </div>
    </div>
</div>

<div class="container">
    <h2>
        <c:choose>
            <c:when test="${livro != null}">Editar Livro</c:when>
            <c:otherwise>Novo Livro</c:otherwise>
        </c:choose>
    </h2>

    <form action="${pageContext.request.contextPath}/livros" method="post">
        <input type="hidden" name="codLivro" value="${livro.codLivro}" />

        <div class="form-group">
            <label>Nome do Livro</label>
            <input type="text" name="nomeDoLivro" value="${livro.nomeDoLivro}" required />
        </div>

        <div class="form-group">
            <label>Gênero</label>
            <input type="text" name="generoDoLivro" value="${livro.generoDoLivro}" required />
        </div>

        <div class="form-group">
            <label>Autor</label>
            <input type="text" name="autorDoLivro" value="${livro.autorDoLivro}" required />
        </div>

        <div class="form-group">
            <label>Editora</label>
            <input type="text" name="editoraDoLivro" value="${livro.editoraDoLivro}" required />
        </div>

        <div class="form-group">
            <label>Sessão</label>
            <select name="idSessao" required>
                <c:forEach var="s" items="${sessoes}">
                    <option value="${s.idSessao}"
                        <c:if test="${livro != null && livro.idSessao == s.idSessao}">
                            selected
                        </c:if>>
                        ${s.generoSessao}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-actions">
            <button type="submit">Salvar</button>
            <a href="livros" class="botao-secundario">Cancelar</a>
        </div>
    </form>
</div>

</body>

</html>
