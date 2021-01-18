package com.tech1.task.dao;

import com.tech1.task.entity.Article;
import com.tech1.task.entity.User;
import com.tech1.task.enums.ArticleColor;
import com.tech1.task.test.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ArticleDaoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void findByColor() {
        ArticleColor color = RandomUtils.randomEnum(ArticleColor.class);

        User user = new User();
        user.setPassword("1234");
        user.setLogin("Login");
        user.setName("Name");
        user.setAge(20);
        user = entityManager.persistAndFlush(user);

        Article article = new Article();
        article.setUser(user);
        article.setText("test");
        article.setColor(color);
        article = entityManager.persistAndFlush(article);

        List<Article> foundArticles = articleDao.findByColor(color);

        assertThat(foundArticles.get(0).getColor()).isEqualTo(article.getColor());
    }
}
