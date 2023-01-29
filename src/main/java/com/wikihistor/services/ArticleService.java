package com.wikihistor.services;

import com.wikihistor.mapping.ArticleDTO;
import com.wikihistor.mapping.ArticleMapper;
import com.wikihistor.models.Article;
import com.wikihistor.repositories.ArticleRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@RequiredArgsConstructor
public class ArticleService {
    @NonNull
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper = new ArticleMapper();


    public ArticleDTO getArticleDTOById(long id){
        var article = articleRepository.findById(id).get(); //should be isPresent???
        return articleMapper.mapToDTO(article);
    }

    public List<ArticleDTO> getArticlesDTO(){
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        for (Article article : articleRepository.findAll()){
            articleDTOList.add(articleMapper.mapToDTO(article));
        }
        return articleDTOList;
    }

}
