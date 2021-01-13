package com.tech1.task.form;

import com.tech1.task.annotation.ValueOfEnum;
import com.tech1.task.enums.ArticleColor;

import javax.validation.constraints.NotEmpty;

public class ArticleForm {

    @NotEmpty
    private String text;

    @ValueOfEnum(enumClass = ArticleColor.class)
    private String color;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
