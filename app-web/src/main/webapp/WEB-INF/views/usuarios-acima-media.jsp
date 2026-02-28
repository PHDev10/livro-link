<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuários Acima da Média</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloUsuariosAcimaMedia.css">
</head>
<body>

<div class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/livros" class="logo">📚 LivroLink</a>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/livros">Home</a>
            <a href="${pageContext.request.contextPath}/livros-com-reservas">Livros com Reservas</a>
        </div>
    </div>
</div>

<h2>Consulta - Usuários Acima da Média de Reservas</h2>

<c:choose>
    <c:when test="${not empty lista}">
        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>Usuário</th>
                    <th>CPF</th>
                    <th>Total de Reservas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${lista}">
                    <tr>
                        <td>${item[0]}</td>
                        <td>${item[1]}</td>
                        <td>${item[2]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p style="text-align:center; margin-top:30px;">Nenhum usuário acima da média encontrado.</p>
    </c:otherwise>
</c:choose>

</body>
</html>