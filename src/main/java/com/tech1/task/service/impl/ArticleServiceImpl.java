package com.tech1.task.service.impl;

import com.tech1.task.dao.ArticleDao;
import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.entity.Article;
import com.tech1.task.enums.ArticleColor;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.form.ArticleForm;
import com.tech1.task.service.ArticleService;
import com.tech1.task.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;
    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao, UserService userService, ModelMapper modelMapper) {
        this.articleDao = articleDao;
        this.userService =userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserArticleByColorDto> getUsersAndArticlesByColor(ArticleColor color) {
        modelMapper.typeMap(Article.class, UserArticleByColorDto.class).addMapping(src -> src.getUser().getName(), UserArticleByColorDto::setUser_name);
        List<Article> articleList = articleDao.findByColor(color);
        return articleList
                .stream()
                .map(u -> modelMapper.map(u, UserArticleByColorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void saveArticle(ArticleForm articleForm, Long id) throws UserNotFoundException {
        Article article = modelMapper.map(articleForm, Article.class);
        article.setUser(userService.getUserById(id));
         articleDao.save(article);
    }
}
