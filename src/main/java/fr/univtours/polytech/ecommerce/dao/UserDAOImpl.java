package fr.univtours.polytech.ecommerce.dao;

import fr.univtours.polytech.ecommerce.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserDAOImpl implements UserDAO {
    
    @PersistenceContext(unitName = "boutique")
    EntityManager entityManager;

    @SuppressWarnings("unchecked")

    /**public List<UserBean> getAllUsers() {
    
        try {
            // Créer une requête JPA pour récupérer tous les articles
            TypedQuery<UserBean> query = entityManager.createNativeQuery("SELECT * FROM USER ", UserBean.class);
            // Exécuter la requête et retourner la liste des articles
            return query.getResultList();
        } finally {
            em.close();
        }
    }**/

    @Override
    public UserBean userLogin(String login, String password) {
        
       
        try {
            // Requête pour récupérer l'utilisateur avec le nom d'utilisateur donné
            UserBean userBean =  (UserBean) entityManager.createNativeQuery("SELECT * FROM User u WHERE u.login = :login AND password= :password", UserBean.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();

            // Vérifier si le mot de passe correspond
            if (userBean != null && userBean.getPassword().equals(password)) {
                return userBean ;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }

}
