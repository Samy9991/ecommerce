package fr.univtours.polytech.ecommerce.dao;

import java.util.List;

import fr.univtours.polytech.ecommerce.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ArticleDAOImplJPA implements ArticleDAO {

    @PersistenceContext(unitName = "boutique")
    EntityManager entityManager;

    /*
     * public ArticleDAOImplJPA() {
     * // Créer l'EntityManagerFactory en utilisant le nom de l'unité de persistance
     * définie dans persistence.xml
     * this.emf =
     * Persistence.createEntityManagerFactory("nom_de_l_unite_de_persistance");
     * }
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ArticleBean> getAllArticles() {
        String sqlQuery = "SELECT * FROM ARTICLE";
        Query query = entityManager.createNativeQuery(sqlQuery, ArticleBean.class);
        
        // Exécuter la requête et retourner la liste des articles
        List<ArticleBean> articles = query.getResultList();
        return articles;
    }

    @Override
    public ArticleBean getArticleById(int id) {

        try {
            // Récupérer l'article par son ID en utilisant la méthode find de JPA
            return entityManager.find(ArticleBean.class, id);
        } finally {
            // entityManager.close();
        }
    }

    @Override
    public void addArticle(ArticleBean article) {

        try {
            entityManager.getTransaction().begin();
            // Ajouter l'article à la base de données
            entityManager.persist(article);
            entityManager.getTransaction().commit();
        } finally {
            // entityManager.close();
        }
    }

    @Override
    public void updateArticle(ArticleBean article) {

        try {
            entityManager.getTransaction().begin();
            // Mettre à jour l'article dans la base de données
            entityManager.merge(article);
            entityManager.getTransaction().commit();
        } finally {
            // entityManager.close();
        }
    }

    @Override
    public void deleteArticle(int id) {

        try {
            entityManager.getTransaction().begin();
            // Récupérer l'article par son ID et le supprimer de la base de données
            ArticleBean article = entityManager.find(ArticleBean.class, id);
            entityManager.remove(article);
            entityManager.getTransaction().commit();
        } finally {
            // entityManager.close();
        }
    }

    // Méthode pour fermer l'EntityManagerFactory
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            // entityManager.close();
        }
    }
}
