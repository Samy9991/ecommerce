package fr.univtours.polytech.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.ecommerce.business.ArticleService;
import fr.univtours.polytech.ecommerce.business.ArticleServiceImpl;
import fr.univtours.polytech.ecommerce.model.ArticleBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="ArticlesServlet", urlPatterns = {"/articles"})
public class ArticlesServlet extends HttpServlet {

    @Inject
    private ArticleService articleService;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des articles depuis la base de données
        List<ArticleBean> articlesList=this.articleService.getAllArticles();
        request.setAttribute("ARTICLES_LIST", articlesList);
                
                // Afficher la page listant les articles
            request.getRequestDispatcher("page2.jsp").forward(request, response);
        
        // Afficher la page listant les articles
        //response.sendRedirect("page2.jsp");
    }
    
    /*private List<ArticleBean> recupererArticles() {
        // Implémenter la récupération des articles depuis la base de données
        // Retourner une liste d'objets ArticleBean représentant les articles
        // (Ici, une liste statique est utilisée à des fins de démonstration)
        return null;
    }*/
}