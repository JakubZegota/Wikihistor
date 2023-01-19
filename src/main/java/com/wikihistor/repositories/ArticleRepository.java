package com.wikihistor.repositories;

import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findArticleByTitle(String title);
    List<Article> findArticleByCategory(Category category);
    Optional<Article> findById(long id);
}
