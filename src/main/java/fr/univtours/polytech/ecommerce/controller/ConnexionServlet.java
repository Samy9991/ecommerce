package fr.univtours.polytech.ecommerce.controller;

import java.io.IOException;

import fr.univtours.polytech.ecommerce.business.UserBusiness;
import fr.univtours.polytech.ecommerce.model.UserBean;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ConnexionServlet", urlPatterns = { "/ecommerce" })
public class ConnexionServlet extends HttpServlet {

    @Inject
    private UserBusiness userBusiness;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("page1.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        System.out.println("login " + login);
        System.out.println("mdp " + mdp);

        try {
            // Vérifier les informations d'identification
            UserBean userBean = userBusiness.userLogin(login, mdp);

            if (userBean != null) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", userBean);
                response.sendRedirect("articles");
            } else {
                // identifiants incorrects
                request.setAttribute("erreur", "Identifiants incorrects");
                request.getRequestDispatcher("page1.jsp").forward(request, response);
            }
        } catch (NoResultException e) {

            e.printStackTrace();
            // Redirection vers la page de connexion avec un message d'erreur
            request.setAttribute("erreur", "Erreur lors de la connexion");
            request.getRequestDispatcher("page1.jsp").forward(request, response);
        }
    }

}
