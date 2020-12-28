package com.tech1.task.form;

import com.tech1.task.annotation.ArticleColorSubset;
import com.tech1.task.entity.ArticleColor;
import com.tech1.task.entity.User;

import javax.validation.constraints.NotEmpty;

public class ArticleForm {

    @NotEmpty
    private String text;

    @ArticleColorSubset(anyOf = {ArticleColor.BLUE, ArticleColor.RED, ArticleColor.YELLOW})
    private ArticleColor color;

    private User user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArticleColor getColor() {
        return color;
    }

    public void setColor(ArticleColor color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
