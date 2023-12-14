package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Item;
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

    public List<Item> findAllArticles() {
        return articleRepo.findAll();
    }

    public Item saveArticle(Item item) {
        return articleRepo.save(item);
    }
}
