package com.wikihistor.repositories;

import com.wikihistor.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticleByTitle(String title);
    Optional<Article> findById(long id);
}
