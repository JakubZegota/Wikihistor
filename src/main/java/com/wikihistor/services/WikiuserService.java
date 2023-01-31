package com.wikihistor.services;

import com.wikihistor.mapping.mappers.WikiuserMapper;
import com.wikihistor.models.Wikiuser;
import com.wikihistor.repositories.WikiuserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
public class WikiuserService {
    private final WikiuserRepository wikiuserRepository;
    private final CategoryService categoryService;
    private final ArticleService articleService;
    private final WikiuserMapper wikiuserMapper = new WikiuserMapper();

    public void saveUser(Wikiuser wikiuser) {
        this.wikiuserRepository.save(wikiuser);
    }

}
