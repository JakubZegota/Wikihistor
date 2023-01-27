package com.wikihistor;


import com.wikihistor.mapping.ArticleDTO;
import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.mapping.CategoryMapper;
import com.wikihistor.models.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Controller
public class WebController {

    private final CategoryService categoryService;
    private final ArticleService articleService;
//
//    @GetMapping("/")
//    public String viewHomePage(Model model){
//        model.addAttribute("allArticlesList",articleService.getArticlesDTO());
//        return "index";
//    }
//
//    @GetMapping("/addnew")
//    public String addNewArticle(Model model){
//        ArticleDTO article = new ArticleDTO();
//        model.addAttribute("article", article);
//        return "newarticle";
//
//    }

//    @GetMapping("wikipedia/{searchphrase}")
//    String searchForWikiarticle(){ return "search";}
//
//    @GetMapping("/categories")
//    List<CategoryDTO> findAllCategories() {return categoryService.getCategoriesDTO();}
//
//    @GetMapping("/articles/{id}")
//    ArticleDTO findArticleById(@PathVariable("id") long id) {return articleService.getArticleDTOById(id);}

    @GetMapping("/articles/add")
    public String addArticleForm(Article article, Model model) {
        model.addAttribute("categories", categoryService.getCategoriesDTO());
        return "add";
    }

//    @PostMapping("articles/add")
//    public String addArticle(Article article, Model model){
//        model.addAttribute("article", new Article());
//        model.addAttribute("categories", categoryService.getCategoriesDTO());
//        articleService.getArticleRepository().save(article);
//        model.addAttribute("message", "Article added successfully!");
//        return "redirect:/articles";
//    }
@PostMapping("articles/add")
public String addArticle(Article article, @RequestParam("categoryName") String categoryName){
    article.setCategory(categoryService.getCategoryMapper().mapToEntity(new CategoryDTO(categoryName)));
    articleService.getArticleRepository().save(article);
    return "redirect:/articles";
}
    @GetMapping("/articles")
    String findAll(Model model) {
        model.addAttribute("allArticleList",articleService.getArticlesDTO());
        return "index";}

}
