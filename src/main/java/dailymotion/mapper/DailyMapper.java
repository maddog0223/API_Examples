package dailymotion.mapper;


import dailymotion.model.database.Video;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DailyMapper {

    String INSERT_VIDEO_DETAILS = "INSERT INTO `dailymotion`.`video` (`id`, `title`, `channel`, `owner`)" +
            " VALUES(#{id}, #{title}, #{channel}, #{owner})";

    String GET_BY_ID = "SELECT * FROM `dailymotion`.`video` where id = #{id}";

    String GET_ID_NUMBER= "SELECT * FROM `dailymotion`.`video` where idnumber = #{idnumber}";

    String GET_BY_TITLE = "SELECT * FROM `dailymotion`.`video` where title = #{title}";

    String UPDATE_VIDEO = "UPDATE `dailymotion`.`video` SET id = #{id}, " +
            "title = #{title}, channel = #{channel} WHERE idnumber = #{idnumber}";

    String DELETE_VIDEO_BY_IDNUMBER = "DELETE FROM `dailymotion`.`video` WHERE idnumber = #{idnumber}";

    @Select(GET_BY_ID)
    public Video selectid(String id);

    @Select(GET_BY_TITLE)
    public Video selecttitle(String title);

    @Select(GET_BY_ID)
    public Video selctbyIDNUMBER(int idnumber);

    @Insert(INSERT_VIDEO_DETAILS)
    public int insertvideo(Video video);

    @Update(UPDATE_VIDEO)
    public int updatevideo(Video video);

    @Delete(DELETE_VIDEO_BY_IDNUMBER)
    public int deletevideoBYIDNUMBER(int idnumber);

}