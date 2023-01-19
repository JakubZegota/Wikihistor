package com.wikihistor.mapping;

import com.wikihistor.models.Article;

public class ArticleMapper implements IMapEntities<ArticleDTO, Article> {

    @Override
    public Article mapToEntity(ArticleDTO articleDTO) {
        return mapToEntity(articleDTO, new Article());
    }

    @Override
    public Article mapToEntity(ArticleDTO articleDTO, Article article) {
        article.setId(articleDTO.getId());
        article.setContent(articleDTO.getContent());
        article.setTitle(articleDTO.getTitle());
        return article; //leaves Category Field as null. Handled in the service class.
    }

    @Override
    public ArticleDTO mapToDTO(Article article) {
        return mapToDTO(article, new ArticleDTO());
    }

    @Override
    public ArticleDTO mapToDTO(Article article, ArticleDTO articleDTO) {
        articleDTO.setId(article.getId());
        articleDTO.setContent(article.getContent());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setCategoryName(article.getCategory().getCategoryName());
        return articleDTO;
    }


}
