<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Reservar Livro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloReserva.css">
</head>
<body>

<div class="container">
    <h2>Reservar Livro</h2>

    <form action="${pageContext.request.contextPath}/reservar-livro" method="post">

        <label>Selecione o Livro:</label>
        <select name="idLivro" required>
            <c:forEach var="livro" items="${livros}">
                <option value="${livro.codLivro}">
                    ${livro.nomeDoLivro}
                </option>
            </c:forEach>
        </select>

        <label>Selecione o Usuário:</label>
        <select name="idUsuario" required>
            <c:forEach var="usuario" items="${usuarios}">
                <option value="${usuario.idUsuario}">
                    ${usuario.nome}
                </option>
            </c:forEach>
        </select>

        <button type="submit">Confirmar Reserva</button>

    </form>

</div>

</body>
</html>