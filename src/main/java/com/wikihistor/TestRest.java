package com.wikihistor;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestRest{
    private final Controller controller;

    @GetMapping("/show")
    String show(){
        return controller.display();
    }



}
