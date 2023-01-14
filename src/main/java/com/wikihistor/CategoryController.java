package com.wikihistor;

import com.wikihistor.models.Category;
import com.wikihistor.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/categories")
    List<Category> findAll(){return categoryRepository.findAll();}

}
