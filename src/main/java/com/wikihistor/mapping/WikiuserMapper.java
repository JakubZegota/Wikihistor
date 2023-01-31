package com.wikihistor.mapping;

import com.wikihistor.models.Article;
import com.wikihistor.models.Wikiuser;

import java.util.stream.Collectors;

public class WikiuserMapper implements IMapEntities<WikiuserDTO, Wikiuser> {
    @Override
    public Wikiuser mapToEntity(WikiuserDTO dto) {
        return mapToEntity(dto, new Wikiuser());
    }

    @Override
    public Wikiuser mapToEntity(WikiuserDTO dto, Wikiuser wikiuser) {
        wikiuser.setLogin(dto.getLogin());
        return wikiuser;
    }

    @Override
    public WikiuserDTO mapToDTO(Wikiuser wikiuser) {
        return mapToDTO(wikiuser, new WikiuserDTO());
    }

    @Override
    public WikiuserDTO mapToDTO(Wikiuser wikiuser, WikiuserDTO dto) {
       dto.setLogin(wikiuser.getLogin());
       dto.setArticleNames(wikiuser.getAssignedArticles().stream().map(Article::getTitle).collect(Collectors.toSet()));

       return dto;
    }
}
