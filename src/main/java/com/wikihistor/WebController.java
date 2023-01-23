package com.wikihistor;


import com.wikihistor.mapping.ArticleDTO;
import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.models.Article;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
public class WebController {

    private final CategoryService categoryService;
    private final ArticleService articleService;

    @GetMapping("wikipedia/{searchphrase}")
    String searchForWikiarticle(){ return "search";}

    @GetMapping("/categories")
    List<CategoryDTO> findAllCategories() {return categoryService.getCategoriesDTO();}

    @GetMapping("/articles/{id}")
    ArticleDTO findArticleById(@PathVariable("id") long id) {return articleService.getArticleDTOById(id);}

    @GetMapping("/articles")
    List<ArticleDTO> findAll() {return articleService.getArticlesDTO();}

}
