package com.wikihistor.mapping;

import com.wikihistor.models.Category;

public class CategoryMapper implements IMapEntities<CategoryDTO, Category> {
    @Override
    public Category mapToEntity(CategoryDTO categoryDTO) {
        return mapToEntity(categoryDTO,new Category());
    }

    @Override
    public Category mapToEntity(CategoryDTO categoryDTO, Category category) {
        category.setCategoryName(categoryDTO.getCategoryName());
        return category; //List of article is a null. It needs to be handled in the service class.
    }

    @Override
    public CategoryDTO mapToDTO(Category category) {
        return mapToDTO(category, new CategoryDTO());
    }

    @Override
    public CategoryDTO mapToDTO(Category category, CategoryDTO categoryDTO) {
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO; //Lacks List<Article> data. Needs to be added.
    }
}
