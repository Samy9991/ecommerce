package fr.univtours.polytech.ecommerce.business;

import java.util.List;
import fr.univtours.polytech.ecommerce.dao.ArticleDAO;
import fr.univtours.polytech.ecommerce.dao.ArticleDAOImplJPA;
import fr.univtours.polytech.ecommerce.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ArticleServiceImpl implements ArticleService {
    @Inject
    private ArticleDAO articleDAO;

    public ArticleServiceImpl() {
        this.articleDAO = new ArticleDAOImplJPA();

    }

    @Override
    public List<ArticleBean> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    public ArticleBean getArticleById(int id) {
        return articleDAO.getArticleById(id);
    }

    @Override
    public void ajouterAuPanier(int articleId, String login) {
        // Cette méthode est normalement implémentée dans PanierService, pas dans
        // ArticleService
        throw new UnsupportedOperationException("Méthode non prise en charge dans ArticleService");
    }

    @Override
    public void retirerDuPanier(int articleId, String login) {
        // Cette méthode est normalement implémentée dans PanierService, pas dans
        // ArticleService
        throw new UnsupportedOperationException("Méthode non prise en charge dans ArticleService");
    }
}