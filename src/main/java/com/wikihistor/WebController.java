package com.wikihistor;


import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.repositories.ArticleRepository;
import com.wikihistor.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
public class WebController {

    private final Controller controller;

    @GetMapping("/categories")
    List<Category> findAllCategories() {return controller.getCategoryRepository().findAll();}

    @GetMapping("/articles/{id}")
    Optional<Article> findArticleById(@PathVariable("id") long id) {return controller.getArticleRepository().findById(id);}

    @GetMapping("/articles")
    List<Article> findAll() {return controller.getArticleRepository().findAll();}

    @GetMapping("/show")
    String show() {return controller.display();}

}
