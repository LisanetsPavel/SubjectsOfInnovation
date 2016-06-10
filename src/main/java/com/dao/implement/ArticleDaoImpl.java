package com.dao.implement;

import com.dao.ArticleDao;
import com.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * Created by pc8 on 30.05.16.
 */
@Repository
public class ArticleDaoImpl extends GenericDao implements ArticleDao {
    @Override
    public void setArticle(Article article) {
        set(article);
    }

    @Override
    public Article getArticleById(Long id) {
        return (Article) get(id, Article.class);
    }

}
