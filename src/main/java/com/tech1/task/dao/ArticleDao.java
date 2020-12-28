package com.tech1.task.dao;

import com.tech1.task.entity.Article;
import com.tech1.task.entity.ArticleColor;
import com.tech1.task.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends CrudRepository<Article, Long> {

    List<Article> findByColor(ArticleColor color);

}
