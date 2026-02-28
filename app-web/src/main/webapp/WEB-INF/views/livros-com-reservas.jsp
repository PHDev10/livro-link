<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros com Reservas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloLivrosComReservas.css">
</head>
<body>

<div class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/livros" class="logo">📚 LivroLink</a>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/livros">Home</a>
            <a href="${pageContext.request.contextPath}/usuarios-acima-media">Usuários Acima da Média</a>
        </div>
    </div>
</div>

<h2>Consulta - Livros com Reservas</h2>

<c:choose>
    <c:when test="${not empty lista}">
        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome do Livro</th>
                    <th>Autor</th>
                    <th>Gênero</th>
                    <th>Usuário que Reservou</th>
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
                        <td>${empty item[5] ? '—' : item[5]}</td>
                        <td>${empty item[4] ? '—' : item[4]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p style="text-align:center; margin-top:30px;">Nenhum livro encontrado.</p>
    </c:otherwise>
</c:choose>

</body>
</html>