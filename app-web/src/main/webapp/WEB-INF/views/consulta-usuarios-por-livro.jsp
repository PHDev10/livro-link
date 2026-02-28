<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuários que Reservaram o Livro</title>

    <!-- CSS reutilizado da listagem -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloPaginaConsultasUsuariosPorLivros.css">
</head>

<body>

<div class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/livros" class="logo">📚 LivroLink</a>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/livros">Home</a>
            <a href="${pageContext.request.contextPath}/consulta-livros-reservados">Livros Reservados</a>
        </div>
    </div>
</div>

<h2>Consulta - Usuários por Livro</h2>

<c:choose>

    <c:when test="${not empty lista}">

        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>Livro</th>
                    <th>Usuário</th>
                    <th>CPF</th>
                    <th>Data da Reserva</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="item" items="${lista}">
                    <tr>
                        <td>${item[0]}</td>
                        <td>${item[1]}</td>
                        <td>${item[2]}</td>
                        <td>${item[3]}</td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>

    </c:when>

    <c:otherwise>
        <p style="text-align:center; margin-top:30px;">
            Nenhum usuário reservou este livro.
        </p>
    </c:otherwise>

</c:choose>

<p style="text-align:center; margin-top:30px;">
    <a href="${pageContext.request.contextPath}/consultas/reservados">
        ← Voltar para Livros Reservados
    </a>
</p>

</body>
</html>