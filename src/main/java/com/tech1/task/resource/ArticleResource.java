package com.tech1.task.resource;

import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.entity.ArticleColor;
import com.tech1.task.entity.User;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.form.ArticleForm;
import com.tech1.task.service.impl.ArticleServiceImpl;
import com.tech1.task.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleResource {

    private ArticleServiceImpl articleService;
    private UserServiceImpl userService;



    @Autowired
    public ArticleResource(ArticleServiceImpl articleService, UserServiceImpl userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserArticleByColorDto> getArticlesWithColor(@RequestParam(value = "color") ArticleColor color) {
        return articleService.getUsersAndArticlesByColor(color);
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public void saveArticle(@PathVariable(name = "id") Long id, @RequestBody @Valid ArticleForm articleForm) throws UserNotFoundException {
        User user = userService.getUserById(id);
        articleForm.setUser(user);
        articleService.saveArticle(articleForm);






    }



}
