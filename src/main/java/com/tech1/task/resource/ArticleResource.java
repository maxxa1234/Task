package com.tech1.task.resource;

import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.enums.ArticleColor;
import com.tech1.task.entity.User;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.form.ArticleForm;
import com.tech1.task.service.ArticleService;
import com.tech1.task.service.UserService;
import com.tech1.task.service.impl.ArticleServiceImpl;
import com.tech1.task.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleResource {

    private ArticleService articleService;



    @Autowired
    public ArticleResource(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserArticleByColorDto> getArticlesWithColor(@RequestParam(value = "color") ArticleColor color) {
        return articleService.getUsersAndArticlesByColor(color);
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public void saveArticle(@PathVariable(name = "id") Long id, @RequestBody @Valid ArticleForm articleForm) throws UserNotFoundException {
        articleService.saveArticle(articleForm, id);
    }



}
