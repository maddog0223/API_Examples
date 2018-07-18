package dailymotion.mapper;


import dailymotion.model.database.Videos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DailyMapper {

    String INSERT_VIDEO_DETAILS = "INSERT INTO `dailymotion`.`videos` (`id`, `title`, `channel`, `owner`)" +
            " VALUES(#{id}, #{title}, #{channel}, #{owner})";

    String GET_BY_ID = "SELECT * FROM `dailymotion`.`videos` where id = #{id}";

    String GET_BY_TITLE = "SELECT * FROM `dailymotion`.`videos` where title = #{title}";

    @Select(GET_BY_ID)
    public Videos select_id(String id);

    @Select(GET_BY_TITLE)
    public Videos select_title(String title);

    @Insert(INSERT_VIDEO_DETAILS)
    public int insert_video(Videos video);

}