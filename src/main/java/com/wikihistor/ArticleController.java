package com.wikihistor;

import com.wikihistor.models.Article;
import com.wikihistor.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ArticleController {
    private final ArticleRepository repository;

    @GetMapping("/articles/{id}")
    Optional<Article> findById(@PathVariable("id") long id){
    return repository.findById(id);
    }

    @GetMapping("/articles")
    List<Article> findAll(){
        return repository.findAll();
    }


}
