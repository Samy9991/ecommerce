package fr.univtours.polytech.ecommerce.dao;

import fr.univtours.polytech.ecommerce.model.UserBean;

public interface UserDAO {
    //List<UserBean> getAllUsers();
    UserBean userLogin(String login, String password);
}
