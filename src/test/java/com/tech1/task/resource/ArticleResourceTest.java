package com.tech1.task.resource;

import com.tech1.task.config.JWTFilter;
import com.tech1.task.dto.UserArticleByColorDto;
import com.tech1.task.enums.ArticleColor;
import com.tech1.task.service.ArticleService;
import com.tech1.task.service.TokenService;
import com.tech1.task.service.impl.ArticleServiceImpl;
import com.tech1.task.test.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ArticleResource.class)
@ComponentScan(
        basePackageClasses = {
                JWTFilter.class
        })
public class ArticleResourceTest {


    @MockBean(ArticleServiceImpl.class)
    private ArticleService articleService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    protected MockMvc mvc;


    @Test
    public void getArticlesWithColor() throws Exception {
        ArticleColor color = RandomUtils.randomEnum(ArticleColor.class);

        UserArticleByColorDto dto = new UserArticleByColorDto();
        dto.setColor(color);
        List<UserArticleByColorDto> list = Arrays.asList(dto);

        String token = tokenService.createToken(1L);

        given(articleService.getUsersAndArticlesByColor(color)).willReturn(list);

        // Act + Assert
        mvc.perform(get("/article?color=RED")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void unauthRequest() throws Exception {
        mvc.perform(get("/article?color=RED")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}
