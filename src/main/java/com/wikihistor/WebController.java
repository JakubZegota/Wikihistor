package com.wikihistor;


import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.mapping.mappers.CategoryMapper;
import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.models.Wikiuser;
import com.wikihistor.services.ArticleService;
import com.wikihistor.services.CategoryService;
import com.wikihistor.services.WikiuserService;
import com.wikihistor.wikipedia.ArticleImport;
import com.wikihistor.wikipedia.WikipediaSearcher;
import jakarta.servlet.http.HttpSession;
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
    private final WikiuserService wikiuserService;

    @GetMapping("/")
    public String defaultPage() {
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLoginPage(Model model, HttpSession session) {
        Wikiuser user = (Wikiuser) session.getAttribute("loggedInUser");
        if (user != null) {
            return "redirect:/articles";
        }
        model.addAttribute("user", new Wikiuser());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute Wikiuser wikiuser, Model model, HttpSession session) {
        model.addAttribute("user", new Wikiuser());
        Wikiuser foundUser = wikiuserService.getWikiuserRepository().findWikiuserByLoginAndPassword(wikiuser.getLogin(), wikiuser.getPassword()).orElse(null);
        if (foundUser != null) {
            session.setAttribute("loggedInUser", foundUser);
            return "redirect:/articles";
        }
        model.addAttribute("errorMessage", "Wrong login or password");
        return "login";
    }

    @GetMapping("/articles/add")
    public String addArticleForm(Article article, Model model, HttpSession session) {
        Wikiuser user = (Wikiuser) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("loggedUser", user.getLogin());

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
    public String findAll(Model model, HttpSession session) {
        Wikiuser user = (Wikiuser) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("loggedUser", user.getLogin());
        var articles = articleService.getArticlesDTO();
        model.addAttribute("allArticleList", articles);

        return "index";
    }

    @GetMapping("addcategory")
    public String addCategoryForm(Category category, Model model, HttpSession session) {
        Wikiuser user = (Wikiuser) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("loggedUser", user.getLogin());
        model.addAttribute("categories", categoryService.getCategoriesDTO());
        return "addc";
    }

    @PostMapping("addcategory")
    public String addCategory(Category category, @RequestParam("categoryName") String categoryName) {
        categoryService.getCategoryRepository().save(category);
        return "redirect:/articles";
    }

    @GetMapping("/import")
    public String searchForm(HttpSession session, Model model) {
        Wikiuser user = (Wikiuser) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("loggedUser", user.getLogin());
        model.addAttribute("categories", categoryService.getCategoriesDTO());
        return "import";
    }


    @PostMapping("/import")
    public String searchSubmit(@RequestParam(defaultValue = "") String phrase,
                               @RequestParam("categoryName") String categoryName, Model model, HttpSession session,
                               @RequestParam(required = false) String selectedResult) {
        Wikiuser user = (Wikiuser) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("loggedUser", user.getLogin());
        model.addAttribute("categories", categoryService.getCategoriesDTO());

        if (selectedResult != null && !selectedResult.isEmpty() && categoryName != null && !categoryName.isEmpty()) {
            model.addAttribute("selectedResult", selectedResult);
            var article = new ArticleImport(selectedResult).searchForArticle();
            article.setCategory(categoryService.getCategoryMapper().mapToEntity(new CategoryDTO(categoryName)));
            articleService.getArticleRepository().save(article);
            this.articleService.getArticleRepository().save(article);
            return "redirect:/articles";
        } else {
            model.addAttribute("searchResults", new WikipediaSearcher(phrase).searchForArticles().getTitles());
        }

        return "import";
    }
}
