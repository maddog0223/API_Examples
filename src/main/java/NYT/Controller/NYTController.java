package NYT.Controller;


import NYT.Service.NYTService;
import NYT.model.nyt.DBsearch;
import NYT.model.nyt.NYTRoot;
import NYT.model.nyt.WordSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nyt")
public class NYTController {

    @Autowired
    NYTService service;

    @RequestMapping("/search")
    public NYTRoot searchNyt(
            @RequestParam("keyword") String keyword,
            @RequestParam("persist") String persist) {

        NYTRoot response = service.searchNYT(keyword, persist);

        return response;
    }


    @RequestMapping("/searchDB")
    public DBsearch searchDB(@RequestParam("keyword") String keyword) {
        return service.searchDB(keyword);
    }


    @RequestMapping("/searchWORDS")
    public WordSearch searchWords(
            @RequestParam("keyword") String keyword,
            @RequestParam("search_words") String[] searchWords) {

        return service.searchWords(keyword, searchWords );
    }

}
