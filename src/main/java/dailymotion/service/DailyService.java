package dailymotion.service;

import dailymotion.mapper.DailyMapper;
import dailymotion.model.dailymotion.DailyMotionRoot;
import dailymotion.model.dailymotion.List;
import dailymotion.model.database.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DailyService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DailyMapper mapper;



    String APIKey="aa00212eb88a4fb616c1";
    String APISecret="edc138008c445e7ec35367b75f80325aa44e3f0c";

    //METHOD to search for the video id (the id for id=<input of the id>)
    public DailyMotionRoot searchvideo(String id) {

        //the url java gets
    String daily_video_url = "https://api.dailymotion.com/video/" + id;

    // More learning to do on this part ****************
        DailyMotionRoot dailyresponse = restTemplate.getForObject(daily_video_url,DailyMotionRoot.class);

        insert(dailyresponse,id);

        return dailyresponse;


    }


    // A method that combines and iterates a databse and the 3rd party API
    public void insert(DailyMotionRoot data, String id){
        try {


            for (List list : data.getList()) {

                Videos video = new Videos();

                video.setId(id);
                video.setTitle(list.getTitle());
                video.setChannel(list.getChannel());
                video.setOwner(list.getOwner());


                mapper.insert_video(video);
            }
        }catch (Exception e){

            e.printStackTrace();
        }

    }

    //post insert METHOD
    public Videos insert(Videos video){

        mapper.insert_video(video);

        return mapper.select_id(video.getId());

    }

}
