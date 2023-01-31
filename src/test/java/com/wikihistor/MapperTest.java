package com.wikihistor;

import com.wikihistor.mapping.mappers.ArticleMapper;
import com.wikihistor.mapping.mappers.CategoryMapper;
import com.wikihistor.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class MapperTest {
    @InjectMocks
    private ArticleMapper articleMapper;
    @InjectMocks
    private CategoryMapper categoryMapper;


    @Test
    void testArticleMapper() {
        var User = new Wikiuser("login", "password");
        var article = new Article("Article title", "Article content");
        article.setId(1L);
        article.setCategory(new Category("category"));

        var articleDTO = articleMapper.mapToDTO(article);
        assertEquals("Article title", articleDTO.getTitle());
        assertEquals("Article content", articleDTO.getContent());
        assertEquals("category", articleDTO.getCategoryName());

        var article1 = articleMapper.mapToEntity(articleDTO);
        assertEquals("Article title", article1.getTitle());
        assertEquals("Article content", article1.getContent());

    }

    @Test
    void testCategoryMapper() {
        var category = new Category("Category name");
        var article = new Article("Article title", "Article content");
        article.setId(1L);
        category.addArticle(article);

        var categoryDTO = categoryMapper.mapToDTO(category);
        assertEquals("Category name", categoryDTO.getCategoryName());

        var category1 = categoryMapper.mapToEntity(categoryDTO);
        assertEquals("Category name", category1.getCategoryName());


    }


}
