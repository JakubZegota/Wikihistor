package com.wikihistor.mapping.mappers;

import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapper implements IMapEntities<CategoryDTO, Category> {
    @Override
    public Category mapToEntity(CategoryDTO categoryDTO) {
        return mapToEntity(categoryDTO, new Category());
    }

    @Override
    public Category mapToEntity(CategoryDTO categoryDTO, Category category) {
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }

    @Override
    public CategoryDTO mapToDTO(Category category) {
        return mapToDTO(category, new CategoryDTO());
    }

    @Override
    public CategoryDTO mapToDTO(Category category, CategoryDTO categoryDTO) {
        categoryDTO.setCategoryName(category.getCategoryName());
        List<String> articleNames = new ArrayList<>();
        for (Article article : category.getArticleList()) {
            articleNames.add(article.getTitle());
        }
        categoryDTO.setArticleNames(articleNames);
        return categoryDTO;
    }
}
