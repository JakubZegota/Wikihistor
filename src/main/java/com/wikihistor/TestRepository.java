package com.wikihistor;


import com.wikihistor.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TestRepository implements CommandLineRunner {

    @Autowired
    private Controller controller;

    @Override
    public void run(String... args) throws Exception {

     this.controller.saveArticle(new Article("cell", "The cell is the basic structural and functional unit of life forms."), "biology");
     this.controller.saveArticle(new Article("polymer", "A substance or material consisting of very large molecules called macromolecules, composed of many repeating subunits."), "chemistry");
     this.controller.saveArticle( new Article("mammal", "A group of vertebrate animals characterized by the presence of mammary glands which in females produce milk."), "biology");


    }
}
