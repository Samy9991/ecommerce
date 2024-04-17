package fr.univtours.polytech.ecommerce.model;

import java.io.Serializable;

public class CartItemBean implements Serializable {
    private ArticleBean article;
    private UserBean user;
    private Integer quantity;

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}