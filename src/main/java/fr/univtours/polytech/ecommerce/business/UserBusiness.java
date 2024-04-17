package fr.univtours.polytech.ecommerce.business;

import fr.univtours.polytech.ecommerce.model.UserBean;

public interface UserBusiness {
    //List<UserBean> getAllUsers();
    UserBean userLogin(String login, String password);
}
