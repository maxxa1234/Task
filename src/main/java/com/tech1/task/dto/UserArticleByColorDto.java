package com.tech1.task.dto;

import com.tech1.task.entity.ArticleColor;

public class UserArticleByColorDto {

    private String user_name;
    private String text;
    private ArticleColor color;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

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
}
