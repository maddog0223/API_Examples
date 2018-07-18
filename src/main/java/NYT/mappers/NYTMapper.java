package NYT.mappers;


import NYT.model.db.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NYTMapper {

    String INSERT_ARTICLE = "INSERT INTO `nyt`.`articles` (`headline`, `snippet`, `url`, `pub_date`)" +
            "VALUES(#{headline}, #{snippet}, #{url},#{pub_date})";

    String ARTICLES_THAT_CONTAIN_KEYWORDS = "SELECT * FROM nyt.articles where snippet like #{keyword} or headline like #{keyword}";

    @Insert(INSERT_ARTICLE)
    public int insertRecord(Article article);


    @Select(ARTICLES_THAT_CONTAIN_KEYWORDS)
    public Article[] selectarticlecontainingkeyword(String keyword);

}