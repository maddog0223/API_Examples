package NYT.model.nyt;


import NYT.model.db.Article;

import java.util.ArrayList;
import java.util.HashMap;

public class WordSearch {

    String keyword;
    String[] words_that_are_counted;
    HashMap<String, Integer> total_number_of_words;
    ArrayList<Article> articles;

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String[] getWords_that_are_counted() {
        return words_that_are_counted;
    }

    public void setWords_that_are_counted(String[] words_that_are_counted) {
        this.words_that_are_counted = words_that_are_counted;
    }

    public HashMap<String, Integer> getTotal_number_of_words() {
        return total_number_of_words;
    }

    public void setTotal_number_of_words(HashMap<String, Integer> total_number_of_words) {
        this.total_number_of_words = total_number_of_words;
    }
}