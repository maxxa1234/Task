package com.tech1.task.service;

import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.entity.Article;
import com.tech1.task.entity.ArticleColor;
import com.tech1.task.entity.User;
import com.tech1.task.form.ArticleForm;

import java.util.List;

public interface ArticleService {

    List<UserArticleByColorDto> getUsersAndArticlesByColor(ArticleColor color);
    void saveArticle(ArticleForm articleForm);
}
