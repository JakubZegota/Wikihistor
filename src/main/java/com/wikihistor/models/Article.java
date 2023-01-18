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
    private Long id;
    private String title;
    @ManyToOne()
    @JoinColumn(name="category_name")
    private Category category;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
    public Article(String title, Category category, String content) {
        this.title = title;
        this.category = category;
        this.content = content;
    }

}
