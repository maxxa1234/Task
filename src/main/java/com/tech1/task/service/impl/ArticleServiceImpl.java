package com.tech1.task.service.impl;

import com.tech1.task.dao.ArticleDao;
import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.entity.Article;
import com.tech1.task.entity.ArticleColor;
import com.tech1.task.form.ArticleForm;
import com.tech1.task.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;
    private ModelMapper modelMapper;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao, ModelMapper modelMapper) {
        this.articleDao = articleDao;
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
    public void saveArticle(ArticleForm articleForm) {
         articleDao.save(modelMapper.map(articleForm, Article.class));
    }
}
