package com.tech1.task.dto;

import com.tech1.task.enums.ArticleColor;

import java.util.Objects;

public class UserArticleByColorDto {

    private String user_name;
    private String text;
    private ArticleColor color;

    //for AssertJ tests
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserArticleByColorDto that = (UserArticleByColorDto) o;
        return Objects.equals(user_name, that.user_name) &&
                Objects.equals(text, that.text) &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_name, text, color);
    }

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
