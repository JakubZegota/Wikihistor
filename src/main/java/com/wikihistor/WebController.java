package com.wikihistor;


import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.services.ArticleService;
import com.wikihistor.services.CategoryService;
import com.wikihistor.services.UserService;
import com.wikihistor.wikipedia.ArticleImport;
import com.wikihistor.wikipedia.WikipediaSearcher;
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
    @NonNull
    private final UserService userService;

    @GetMapping("/users")
    public String chooseUser(Model model){
        model.addAttribute("users", userService.getUsersDTO());
        return "users";
    }

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
    public String addCategoryForm(Category category, Model model) {
        model.addAttribute("categories", categoryService.getCategoriesDTO());
        return "addc";
    }

    @PostMapping("addcategory")
    public String addCategory(Category category, @RequestParam("categoryName") String categoryName) {
        categoryService.getCategoryRepository().save(category);
        return "redirect:/articles/add";
    }

    @GetMapping("/import")
    public String searchForm() {
        return "import";
    }

    @PostMapping("/import")
    public String searchSubmit(@RequestParam(defaultValue = "") String phrase, Model model, @RequestParam(required = false) String selectedResult) {

        if (selectedResult != null && !selectedResult.isEmpty()) {
            model.addAttribute("selectedResult", selectedResult);
            var article = new ArticleImport(selectedResult).searchForArticle();
            article.setCategory(categoryService.getCategoryOrCreate("default"));
            this.articleService.getArticleRepository().save(article);
            return "redirect:/articles";
        } else {
            model.addAttribute("searchResults", new WikipediaSearcher(phrase).searchForArticles().getTitles());
        }

        return "import";
    }
}
