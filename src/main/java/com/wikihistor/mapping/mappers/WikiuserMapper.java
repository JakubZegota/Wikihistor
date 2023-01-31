package com.wikihistor.mapping.mappers;

import com.wikihistor.mapping.WikiuserDTO;
import com.wikihistor.models.Wikiuser;

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
        return dto;
    }
}
