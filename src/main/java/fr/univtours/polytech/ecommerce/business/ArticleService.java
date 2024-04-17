package fr.univtours.polytech.ecommerce.business;

import java.util.List;
import fr.univtours.polytech.ecommerce.model.ArticleBean;

public interface ArticleService {
    List<ArticleBean> getAllArticles();
    ArticleBean getArticleById(int id);
    void ajouterAuPanier(int articleId, String login);
    void retirerDuPanier(int articleId, String login);
}
