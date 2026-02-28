<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - LivroLink</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloPaginaLogin.css">
</head>
<body>

<div class="login-container">
    <h2>📚 LivroLink</h2>
    <p>Faça login para continuar</p>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="cpf">CPF</label>
        <input type="text" id="cpf" name="cpf" required>

        <button type="submit">Entrar</button>

        <p style="margin-top: 15px; text-align: center;">
            Não tem cadastro?
            <a href="${pageContext.request.contextPath}/cadastro">Criar usuário</a>
        </p>
    </form>

    <c:if test="${not empty erro}">
        <div class="erro">
            ${erro}
        </div>
    </c:if>
</div>

</body>
</html>