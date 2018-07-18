package NYT.model.db;

public class Article {

    String id;
    String headline;
    String url;
    String snippet;
    String pub_date;


    public Article(String id, String headline, String snippet, String url){

        this.id = id;
        this.headline = headline;
        this.url = url;
        this.snippet = snippet;
    }

    public Article(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }
}
