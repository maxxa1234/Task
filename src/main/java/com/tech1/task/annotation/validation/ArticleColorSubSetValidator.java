package com.tech1.task.annotation.validation;

import com.tech1.task.annotation.ArticleColorSubset;
import com.tech1.task.entity.ArticleColor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ArticleColorSubSetValidator implements ConstraintValidator<ArticleColorSubset, ArticleColor> {
    private ArticleColor[] subset;

    @Override
    public void initialize(ArticleColorSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(ArticleColor value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
