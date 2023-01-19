package com.wikihistor;

import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.repositories.ArticleRepository;
import com.wikihistor.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringJoiner;

@Getter
@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public Category getCategoryOrCreate(String name) { //gets category by name or creates it if it does not exist
        return categoryRepository.findCategoryByCategoryName(name).orElseGet(() -> categoryRepository.save(new Category(name)));
    }

    public void saveArticle(Article article, String categoryName) { //saves article and updates the category associated with it
        Category categoryOfTheArticle = this.getCategoryOrCreate(categoryName);
        article.setCategory(categoryOfTheArticle);
        categoryOfTheArticle.addArticle(article);
        categoryRepository.save(categoryOfTheArticle);
    }

    public String display() { //displaying category and its articles in category={article1,article2} format
        List<Category> categoryList = this.categoryRepository.findAll();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (Category category : categoryList) {
            stringBuilder1.append(category.getCategoryName());
            stringBuilder1.append("={");
            StringJoiner joiner = new StringJoiner(",");
            for (Article article : category.getArticleList()) {
                joiner.add(article.getTitle());
            }
            stringBuilder1.append(joiner.toString());
            stringBuilder1.append("}");
        }
        return stringBuilder1.toString();
    }
}
