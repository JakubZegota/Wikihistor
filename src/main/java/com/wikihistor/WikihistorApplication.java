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
    - Category Service is Present
    - Article Service is Present
    - Mapping from entities to dto in WebController ???
    - Adding User, UserDTO, and UserMapper
    - Adding new Articles
    - Some frontend view
    - Fetching data from wikipedia


     */

}
