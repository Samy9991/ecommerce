<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>Login</title>
</head>

<body>
    <form method="post" action="ecommerce">
        <% if (request.getAttribute("erreur") != null) { %>
            <p style="color: red;"><%= request.getAttribute("erreur") %></p>
        <% } %>
        <table>
            <tr>
                <td>${requestScope.USER.login}</td>
            </tr>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Mot de passe</td>
                <td><input type="password" name="mdp" /></td>
            </tr>
            <tr>
                <td></td>
                <td>
                     <button type="submit">Connexion</button>
                </td>
            </tr>
        </table>
    </form>
</body>

</html>