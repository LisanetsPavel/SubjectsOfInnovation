package com.service;

import com.dao.ArticleDao;
import com.dao.ScopeDao;
import com.entity.Article;
import com.entity.Scope;
import com.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by pc8 on 28.04.16.
 */
@Service
public class ScopeService {

    @Autowired
    ScopeDao scopeDao;

    @Autowired
    ArticleDao articleDao;

    public void setScope(String name) {

        Scope scope = new Scope();
        scope.setName(name);
        scopeDao.setScope(scope);

    }

    public Scope getSopeByName(String name) {
        return scopeDao.getScopeByName(name);
    }

    public String getAllScopes() {
        return JsonConverter.toJSON(scopeDao.getAllScope());
    }

    public void setArticle(Long id, String articleLink) {

        Scope scope = scopeDao.getScopeById(id);
        Set<Article> articles = scope.getArticles();
        Article article = new Article();
        article.setLink(articleLink);
        article.setScope(scope);
        articleDao.setArticle(article);
        articles.add(article);
        scope.setArticles(articles);
        scopeDao.updateScope(scope);


    }

}
