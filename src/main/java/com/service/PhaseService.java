package com.service;

import com.dao.ArticleDao;
import com.dao.PhaseDao;
import com.entity.Article;
import com.entity.Phase;
import com.entity.Scope;
import com.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by pc8 on 28.04.16.
 */
@Service
public class PhaseService {

    @Autowired
    PhaseDao phaseDao;

    @Autowired
    ArticleDao articleDao;

    public void setPhase(String name) {
        Phase phase = new Phase();
        phase.setName(name);
        phaseDao.setPhase(phase);

    }

    public Phase getPhaseByName(String name) {
        return phaseDao.getPhaseByName(name);
    }

    public String getAllPhases() {
        return JsonConverter.toJSON(phaseDao.getAllPhase());
    }

    public void setArticle(Long id, String articleLink) {

        Phase phase = phaseDao.getPhaseById(id);
        Set<Article> articles = phase.getArticles();
        Article article = new Article();
        article.setLink(articleLink);
        article.setPhase(phase);
        articleDao.setArticle(article);
        articles.add(article);
        phase.setArticles(articles);
        phaseDao.updatePhase(phase);


    }

}
