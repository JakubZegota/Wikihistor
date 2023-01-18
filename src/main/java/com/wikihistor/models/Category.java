package com.wikihistor.models;

import com.wikihistor.WebController;
import com.wikihistor.models.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table
@Entity

public class Category {
    @Id
    @NonNull
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Article> articleList = new ArrayList<>();

    public void addArticle(Article article){
        articleList.add(article);
        article.setCategory(this);
    }

}
