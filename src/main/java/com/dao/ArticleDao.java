package com.dao;

import com.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * Created by pc8 on 30.05.16.
 */
@Repository
public interface ArticleDao {

    void setArticle(Article article);

    Article getArticleById(Long id);

}
