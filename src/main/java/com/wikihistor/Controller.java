package com.wikihistor;

import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.repositories.ArticleRepository;
import com.wikihistor.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Controller {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryOrCreate(String name){
        if (categoryRepository.findCategoryByCategoryName(name)==null){
            categoryRepository.save(new Category(name));
        }
        return categoryRepository.findCategoryByCategoryName(name);
    }

    public void saveArticle(Article article, String categoryName){
        Category categoryOfTheArticle = this.getCategoryOrCreate(categoryName);
        article.setCategory(categoryOfTheArticle);
        articleRepository.save(article);
    }


    public String display() {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (Category category : this.categoryRepository.findAll()){
            stringBuilder1.append(category.getCategoryName());
            stringBuilder1.append("={");
            for (Article article : category.getArticleList()){
            stringBuilder1.append(article.getTitle());
            stringBuilder1.append(",");
            }
            stringBuilder1.append("}");
        }
        return stringBuilder1.toString();
    }
}
