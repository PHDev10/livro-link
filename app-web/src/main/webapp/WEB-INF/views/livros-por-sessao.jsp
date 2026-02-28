<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros por Sessão</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloLivrosPorSessao.css">
</head>
<body>

<div class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/livros" class="logo">📚 LivroLink</a>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/livros">Home</a>
            <a href="${pageContext.request.contextPath}/consulta-livros-reservados">Livros Reservados</a>
            <a href="${pageContext.request.contextPath}/reservas-por-usuario">Reservas por Usuário</a>
        </div>
    </div>
</div>

<h2>Consulta - Livros por Sessão</h2>

<c:choose>
    <c:when test="${not empty lista}">
        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>Sessão (Gênero)</th>
                    <th>Total de Livros</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${lista}">
                    <tr>
                        <td>${item[0]}</td>
                        <td>${item[1]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p style="text-align:center; margin-top:30px;">Nenhuma sessão encontrada.</p>
    </c:otherwise>
</c:choose>

</body>
</html>