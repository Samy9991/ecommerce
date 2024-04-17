package fr.univtours.polytech.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.ecommerce.model.CartItemBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des articles dans le panier depuis la session
        List<CartItemBean> panier = (List<CartItemBean>) request.getSession().getAttribute("panier");
        
        // Mettre la liste des articles dans le panier dans l'attribut de la requête
        request.setAttribute("panier", panier);
        
        // Afficher la page du contenu du panier
        request.getRequestDispatcher("/panier.jsp").forward(request, response);
    }
}
