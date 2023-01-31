package com.wikihistor.services;

import com.wikihistor.mapping.CategoryDTO;
import com.wikihistor.mapping.mappers.CategoryMapper;
import com.wikihistor.models.Article;
import com.wikihistor.models.Category;
import com.wikihistor.repositories.CategoryRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@RequiredArgsConstructor
public class CategoryService {

    @NonNull
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = new CategoryMapper(); //change to bean???

    public List<CategoryDTO> getCategoriesDTO() { //refactor this
        List<CategoryDTO> listOfCategoriesDTO = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            listOfCategoriesDTO.add(categoryMapper.mapToDTO(category));
        }
        return listOfCategoriesDTO;
    }

    public Category getCategoryOrCreate(String name) {
        return categoryRepository.findCategoryByCategoryName(name).orElseGet(() -> categoryRepository.save(new Category(name)));
    }

    public void saveArticle(Article article, String categoryName) {
        Category categoryOfTheArticle = this.getCategoryOrCreate(categoryName);
        article.setCategory(categoryOfTheArticle);
        categoryOfTheArticle.addArticle(article);
        categoryRepository.save(categoryOfTheArticle);
    }

}
