package fr.univtours.polytech.ecommerce.dao;

import java.util.List;
import fr.univtours.polytech.ecommerce.model.ArticleBean;

public interface ArticleDAO {
    // Méthode pour récupérer tous les articles
    List<ArticleBean> getAllArticles();

    // Méthode pour récupérer un article par son ID
    ArticleBean getArticleById(int id);

    // Méthode pour ajouter un nouvel article
    void addArticle(ArticleBean article);

    // Méthode pour mettre à jour un article
    void updateArticle(ArticleBean article);

    // Méthode pour supprimer un article
    void deleteArticle(int id);
}
