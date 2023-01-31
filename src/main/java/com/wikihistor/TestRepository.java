package com.wikihistor;

import com.wikihistor.models.Article;
import com.wikihistor.models.Wikiuser;
import com.wikihistor.services.CategoryService;
import com.wikihistor.services.WikiuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TestRepository implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private WikiuserService wikiuserService;

    @Override
    public void run(String... args) throws Exception {

        this.wikiuserService.saveUser(new Wikiuser("log1", "pas1"));
        this.wikiuserService.saveUser(new Wikiuser("log2", "pas2"));
        this.wikiuserService.saveUser(new Wikiuser("admin", "admin"));

        this.categoryService.saveArticle(new Article("cell", "The cell is the basic structural and functional unit of life forms."), "biology");
        this.categoryService.saveArticle(new Article("polymer", "A substance or material consisting of very large molecules called macromolecules, composed of many repeating subunits."), "chemistry");
        this.categoryService.saveArticle(new Article("mammal", "A group of vertebrate animals characterized by the presence of mammary glands which in females produce milk."), "biology");
        this.categoryService.saveArticle(new Article("comet", "An icy, small Solar System body that, when passing close to the Sun, warms and begins to release gases, a process that is called outgassing."), "astronomy");
        this.categoryService.saveArticle(new Article("black hole", "A region of spacetime where gravity is so strong that nothing, including light or other electromagnetic waves, has enough energy to escape its event horizon."), "astronomy");
        this.categoryService.saveArticle(new Article("galaxy", "A system of stars, stellar remnants, interstellar gas, dust, dark matter, bound together by gravity."), "astronomy");
    }
}
