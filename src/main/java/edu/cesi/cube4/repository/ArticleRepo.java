package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Integer> {
}
