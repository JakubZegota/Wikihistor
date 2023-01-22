package com.wikihistor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikihistorApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikihistorApplication.class, args);
    }

    /*
    to add:
    - CategoryMapper List<Article> to List<String> converter.
    - Mapping from entities to dto in WebController
    - Adding User, UserDTO, and UserMapper
    - Some frontend view
    - Fetching data from wikipedia


     */

}
