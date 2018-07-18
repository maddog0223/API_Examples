package dailymotion.mapper;


import dailymotion.model.database.Videos;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DailyMapper {

    String INSERT_VIDEO_DETAILS = "INSERT INTO `dailymotion`.`videos` (`id`, `title`, `channel`, `owner`)" +
            " VALUES(#{id}, #{title}, #{channel}, #{owner})";

    String GET_BY_ID = "SELECT * FROM `dailymotion`.`videos` where id = #{id}";

    String GET_ID_NUMBER= "SELECT * FROM `dailymotion`.`videos` where idnumber = #{idnumber}";

    String GET_BY_TITLE = "SELECT * FROM `dailymotion`.`videos` where title = #{title}";

    String UPDATE_VIDEO = "UPDATE `dailymotion`.`videos` SET id = #{id}, " +
            "title = #{title}, channel = #{channel} WHERE idnumber = #{idnumber}";

    String DELETE_VIDEO = "DELETE FROM `dailymotion`.`videos` WHERE title = #{title}";

    @Select(GET_BY_ID)
    public Videos selectid(String id);

    @Select(GET_BY_TITLE)
    public Videos selecttitle(String title);

    @Select(GET_BY_ID)
    public Videos selctbyIDNUMBER(int idnumber);

    @Insert(INSERT_VIDEO_DETAILS)
    public int insertvideo(Videos video);

    @Update(UPDATE_VIDEO)
    public int updatevideo(Videos video);

    @Delete(DELETE_VIDEO)
    public int deletevideo(Videos videos);

}