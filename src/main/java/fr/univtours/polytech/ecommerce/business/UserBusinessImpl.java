package fr.univtours.polytech.ecommerce.business;

import fr.univtours.polytech.ecommerce.dao.UserDAO;
import fr.univtours.polytech.ecommerce.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserBusinessImpl implements UserBusiness {
    @Inject
    private UserDAO userDAO;

   /** * @Override
    public List<UserBean> getAllUsers() {
        return userDAO.getAllUsers();
    }**/

    @Override
    public UserBean userLogin(String login, String password){
        return userDAO.userLogin(login, password);
    }


}
