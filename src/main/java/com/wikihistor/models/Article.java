package com.wikihistor.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@Table
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Id of the article, generated automatically.
    private String title; //Title of the article.
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category; //Category of the article, e.g. biology, chemistry etc.
    @Column(columnDefinition = "TEXT")
    private String content; //Content of the article: definition, examples etc.

    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
//    public Article(String title, Category category, String content) {
//        this.title = title;
//        this.category = category;
//        this.content = content;
//    }

}
