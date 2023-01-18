package com.wikihistor;

import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.repositories.ArticleRepository;
import com.wikihistor.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Controller {
    @Getter
    private final ArticleRepository articleRepository;
    @Getter
    private final CategoryRepository categoryRepository;

    public Controller(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryOrCreate(String name){
        if (categoryRepository.findCategoryByCategoryName(name)==null){
            categoryRepository.save(new Category(name));
        }
        return categoryRepository.findCategoryByCategoryName(name);
    }


    public void saveArticle(Article article, String categoryName){
        Category categoryOfTheArticle = this.getCategoryOrCreate(categoryName); //Bierze kategorię lub dodaje jeśli takiej nie ma
       article.setCategory(categoryOfTheArticle);
       //categoryRepository.findCategoryByCategoryName(categoryName).addArticle(article); //powinno dodawać artykuł do kategorii. Nie dodaje.
        articleRepository.save(article);
        var articleWithId = articleRepository.findArticleByTitle(article.getTitle());
        var category = categoryRepository.findCategoryByCategoryName(articleWithId.getCategory().getCategoryName());
        category.addArticle(articleWithId);
        categoryRepository.save(category);
        //categoryRepository.findCategoryByCategoryName(categoryName).addArticle(articleRepository.findArticleByTitle(article.getTitle()));
    }



    public String display() {
        List<Category> categoryList = this.categoryRepository.findAll();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (Category category : categoryList){
            stringBuilder1.append(category.getCategoryName());
            stringBuilder1.append("={");
            List<Article> articleList = category.getArticleList();
            for (Article article : articleList){
            stringBuilder1.append(article.getTitle());
            stringBuilder1.append(",");
            }
            stringBuilder1.append("}");
        }
        return stringBuilder1.toString();
    }

}
