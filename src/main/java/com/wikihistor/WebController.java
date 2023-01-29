package com.wikihistor;


import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.services.ArticleService;
import com.wikihistor.services.CategoryService;
import com.wikihistor.wikipedia.SearchResults;
import com.wikihistor.wikipedia.WikipediaSearcher;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class WebController {

    @NonNull
    private final CategoryService categoryService;
    @NonNull
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


    @PostMapping("articles/add")
    public String addArticle(Article article, @RequestParam("categoryName") String categoryName) {
        article.setCategory(categoryService.getCategoryMapper().mapToEntity(new CategoryDTO(categoryName)));
        articleService.getArticleRepository().save(article);
        return "redirect:/articles";
    }

    @GetMapping("/articles")
    public String findAll(Model model) {
        model.addAttribute("allArticleList", articleService.getArticlesDTO());
        return "index";
    }

    @GetMapping("addcategory")
    public String addCategoryForm(Category category, Model model){
        model.addAttribute("categories", categoryService.getCategoriesDTO());
        return "addc";
    }

    @PostMapping("addcategory")
    public String addCategory(Category category, @RequestParam("categoryName") String categoryName){
        categoryService.getCategoryRepository().save(category);
        return "redirect:/articles/add";
    }
    @GetMapping("/import")
    public String searchForm(Model model) {
        return "import";
    }

    @PostMapping("/import")
    public String searchSubmit(@RequestParam String phrase, Model model) {
        model.addAttribute("searchResults", new WikipediaSearcher(phrase).searchForArticles().getTitles());
        return "import";
    }
}
