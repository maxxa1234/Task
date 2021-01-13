package com.tech1.task.service;

import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.enums.ArticleColor;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.form.ArticleForm;

import java.util.List;

public interface ArticleService {

    List<UserArticleByColorDto> getUsersAndArticlesByColor(ArticleColor color);
    void saveArticle(ArticleForm articleForm, Long id) throws UserNotFoundException;
}
