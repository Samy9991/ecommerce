<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des articles</title>
</head>
<body>
    <h1>Liste des articles</h1>
    <!-- Lien de déconnexion -->
    
    <p>${sessionScope.loggedInUser.name}</p>
  
    <a href="Deconnexion">Déconnexion</a>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prix</th>
            <th>Restant</th>
            <th>Enlever 1 du panier</th>
            <th>Quantité</th>
            <th>Ajouter 1 au panier</th>
        </tr>
        <c:forEach items="${requestScope.ARTICLES_LIST}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.name}</td>
                <td>${article.price}</td>
                <td>${article.nbRestant}</td>
                <td><a href="articles.jsp?action=add&articleId=${article.id}">-</a></td>
                <td></td>
                <td><a href="articles.jsp?action=add&articleId=${article.id}">+</a></td>
            </tr>
        </c:forEach>
    </table>

    <!-- Bouton Afficher le panier -->
    <form method="post" action="panier">
        <input type="submit" value="Afficher le panier"/>
    </form>
</body>
</html>