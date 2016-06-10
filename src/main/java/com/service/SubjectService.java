package com.service;

import com.dao.ArticleDao;
import com.dao.SubjectDao;
import com.entity.Article;
import com.entity.Subject;
import com.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by pc8 on 28.04.16.
 */
@Service
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    ArticleDao articleDao;

    public void setSubject(String name, String url) {
        Subject subject = new Subject();
        subject.setName(name);
        subject.setUrl(url);
        subjectDao.setSubject(subject);

    }

    public void setSubject(Subject subject) {
        subjectDao.setSubject(subject);
    }

    public Subject getSubjectByName(String name) {
        return subjectDao.getSubjectByName(name);

    }

    public String getAllSubjects() {
        return JsonConverter.toJSON(subjectDao.getAllSubject());
    }

    public void setArticle(Long id, String articleLink) {

        Subject subject = subjectDao.getSubjectById(id);
        Set<Article> articles = subject.getArticles();
        Article article = new Article();
        article.setLink(articleLink);
        article.setSubject(subject);
        articleDao.setArticle(article);
        articles.add(article);
        subject.setArticles(articles);
        subjectDao.updateSubject(subject);


    }

}
