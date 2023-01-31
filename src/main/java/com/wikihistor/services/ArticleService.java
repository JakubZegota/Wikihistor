package com.wikihistor.services;

import com.wikihistor.mapping.ArticleDTO;
import com.wikihistor.mapping.mappers.ArticleMapper;
import com.wikihistor.models.Article;
import com.wikihistor.repositories.ArticleRepository;
import com.wikihistor.repositories.WikiuserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final WikiuserRepository wikiuserRepository;
    private final ArticleMapper articleMapper = new ArticleMapper();


    public List<ArticleDTO> getArticlesDTO() {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        for (Article article : articleRepository.findAll()) {
            articleDTOList.add(articleMapper.mapToDTO(article));
        }
        return articleDTOList;
    }


}
