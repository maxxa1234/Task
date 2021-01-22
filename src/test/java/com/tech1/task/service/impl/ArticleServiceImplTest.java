package com.tech1.task.service.impl;

import com.tech1.task.dao.ArticleDao;
import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.entity.Article;
import com.tech1.task.entity.User;
import com.tech1.task.enums.ArticleColor;
import com.tech1.task.service.ArticleService;
import com.tech1.task.test.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ArticleServiceImplTest {

    private ModelMapper modelMapper = new ModelMapper();

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private ArticleDao articleDao;

    private ArticleService articleService;

    @Before
    public void before() {
        articleService = new ArticleServiceImpl(articleDao, userService, modelMapper);
    }


    @Test
    public void getUsesAndArticlesByColorTest() {
        ArticleColor color = RandomUtils.randomEnum(ArticleColor.class);

        User user = new User();
        user.setId(1L);
        user.setAge(20);
        user.setLogin("Login");
        user.setName("Name");
        user.setPassword("Pass");

        Article article = new Article();
        article.setId(1L);
        article.setColor(color);
        article.setText("test");
        article.setUser(user);
        List<Article> articleList = Arrays.asList(article);

        UserArticleByColorDto dto = new UserArticleByColorDto();
        dto.setUser_name(user.getName());
        dto.setColor(article.getColor());
        dto.setText(article.getText());
        List<UserArticleByColorDto> dtoList = Arrays.asList(dto);


        when(articleDao.findByColor(color)).thenReturn(articleList);


        assertThat(articleService.getUsersAndArticlesByColor(color)).isEqualTo(dtoList);

    }
}
