package NYT.model.nyt;


import NYT.model.db.Article;

public class DBsearch {


    String keyword;
    int articlesthatcontainthekeyword;
    int keywordappearance;
    Article[] article;

    public Article[] getArticle() {
        return article;
    }

    public void setArticle(Article[] art) {
        this.article = art;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getArticlesthatcontainthekeyword() {
        return articlesthatcontainthekeyword;
    }

    public void setArticlesthatcontainthekeyword(int articlesthatcontainthekeyword) {

        this.articlesthatcontainthekeyword = articlesthatcontainthekeyword;
    }

    public int getKeywordappearance() {
        return keywordappearance;
    }

    public void setKeywordappearance(int keywordappearance) {

        this.keywordappearance = keywordappearance;
    }


}
