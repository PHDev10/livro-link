<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Livros Reservados</title>

    <!-- CSS da listagem -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloPaginaListagem.css">
</head>

<body>

<div class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/livros" class="logo">📚 LivroLink</a>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/livros">Home</a>
            <a href="${pageContext.request.contextPath}/livros?acao=novo">Novo Livro</a>
        </div>
    </div>
</div>

<h2>Consulta - Livros Reservados</h2>

<c:choose>
    <c:when test="${not empty lista}">

        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>ID Livro</th>
                    <th>Nome do Livro</th>
                    <th>Autor</th>
                    <th>Usuário</th>
                    <th>CPF</th>
                    <th>Sessão</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="item" items="${lista}">
                    <tr>
                        <td>${item[0]}</td>
                        <td>${item[1]}</td>
                        <td>${item[2]}</td>
                        <td>${item[3]}</td>
                        <td>${item[4]}</td>
                        <td>${item[5]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </c:when>

    <c:otherwise>
        <p style="text-align:center; margin-top:30px;">
            Nenhum livro reservado encontrado.
        </p>
    </c:otherwise>
</c:choose>

</body>
</html>