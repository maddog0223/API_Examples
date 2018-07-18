package NYT.Service;

import NYT.mappers.NYTMapper;
import NYT.model.db.Article;
import NYT.model.nyt.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class NYTService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    NYTMapper mapper;

    private String API_KEY = "674e2ac7221b4334be05123a3bb1e03e";


    //search NYT method
    public NYTRoot searchNYT(String keyword, String persist) {

        String url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=" + keyword + "&api-key=" + API_KEY;

        NYTRoot response = restTemplate.getForObject(url,NYTRoot.class);

        if (persist.equalsIgnoreCase("true")){
            persistResults(response);

        }

        return response;
    }


  //DB search method
   public DBsearch searchDB(String keyword) {

        DBsearch dbsearch = new DBsearch();
        dbsearch.setKeyword(keyword);


        String keylike= "%" + keyword + "%";


       dbsearch.setArticle(mapper.selectarticlecontainingkeyword(keylike));

       dbsearch.setArticlesthatcontainthekeyword(dbsearch.getArticle().length);

       Article[] articlearray = mapper.selectarticlecontainingkeyword(keylike);


              // if there is no article
               if(articlearray.length < 1){

           searchNYT(keyword,"true");

           dbsearch.setArticle(mapper.selectarticlecontainingkeyword(keylike));

       }

       dbsearch.setArticlesthatcontainthekeyword(articlearray.length);


       return dbsearch;
   }


   //WORDSEARCH method
    public WordSearch searchWords(String keyword, String[] terms) {

        // creating a wordsearch object to have the access to its methods.
        WordSearch wordsearch = new WordSearch();

        wordsearch.setKeyword(keyword);

        NYTRoot root = searchNYT(keyword, "false");

        int count;

        ArrayList<Article> art = new ArrayList<>();

        for (Docs docs : root.getResponse().getDocs()){

            for (String term : terms){

                count = StringUtils.countMatches(docs.getHeadline().getPrint_headline(),term);

//                int example = StringUtils.countMatches("this is an example","is");
                // above will come out as 1
                count += StringUtils.countMatches(docs.getSnippet(), term);

                wordsearch.getTotal_number_of_words().merge(term, count, Integer::sum);

                art.add(new Article(docs.get_id(),docs.getHeadline().getPrint_headline(),docs.getSnippet(),docs.getUrl()));
            }



        }

        wordsearch.setArticles(art);
        return  wordsearch;
    }


    private void persistResults(NYTRoot data){

        for (Docs doc : data.getResponse().getDocs()){

            Article a = new Article();
            a.setHeadline(doc.getHeadline().getMain());
            a.setPub_date(doc.getPub_date());
            a.setSnippet(doc.getSnippet());
            a.setUrl(doc.getWeb_url());

            mapper.insertRecord(a);
        }

    }
}
