package com.wikihistor.mapping;


import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.mapping.IMapEntities;
import com.wikihistor.models.Category;

public class CategoryMapper implements IMapEntities<CategoryDTO, Category> {
    @Override
    public Category mapToEntity(CategoryDTO categoryDTO) {
        return mapToEntity(categoryDTO,new Category());
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
        return categoryDTO;
    }
}
