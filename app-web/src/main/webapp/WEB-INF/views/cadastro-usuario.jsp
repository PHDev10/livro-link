<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloPaginaCadastroUsuario.css">
</head>
<body>

<div class="container">
    <h2>Criar novo usuário</h2>

    <form action="${pageContext.request.contextPath}/cadastro" method="post" accept-charset="UTF-8">

        <label>Nome</label>
        <input type="text" name="nome" required>

        <label>Idade</label>
        <input type="number" name="idade" required>

        <label>CPF</label>
        <input type="text" name="cpf" maxlength="11" required>

        <label>Sexo</label>
        <select name="sexo">
            <option value="M">Masculino</option>
            <option value="F">Feminino</option>
        </select>

        <div class="form-group botao">
            <button type="submit">Cadastrar</button>
        </div>
    </form>

    <p style="text-align:center;">
        <a href="${pageContext.request.contextPath}/login">Voltar para login</a>
    </p>
</div>

</body>
</html>