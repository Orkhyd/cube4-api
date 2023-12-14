package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Item> getAllArticles() {
        return articleService.findAllArticles();
    }

    @PostMapping
    public ResponseEntity<Item> createArticle(@RequestBody Item item) {
        Item savedItem = articleService.saveArticle(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
}
