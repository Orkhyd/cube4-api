package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Article;
import edu.cesi.cube4.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepo articleRepo;

@Autowired
    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public List<Article> findAllArticles(){
        return articleRepo.findAll();
    }
}
