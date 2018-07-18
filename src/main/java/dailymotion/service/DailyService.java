package dailymotion.service;

import dailymotion.mapper.DailyMapper;
import dailymotion.model.dailymotion.DailyMotionRoot;
import dailymotion.model.dailymotion.List;
import dailymotion.model.database.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List searchvideo(String id) {

        //the url java gets
    String daily_video_url = "https://api.dailymotion.com/video/" + id;


        List response = restTemplate.getForObject(daily_video_url,List.class);


        return response;


    }


    // A method that combines and iterates a databse and the 3rd party API
    public void insertList(List[] info, String id){
        try {


            for (List list : info) {

                Videos video = new Videos();

                video.setId(id);
                video.setTitle(list.getTitle());
                video.setChannel(list.getChannel());
                video.setOwner(list.getOwner());


                mapper.insertvideo(video);
            }
        }catch (Exception e){

            e.printStackTrace();
        }

    }

    //post insert METHOD
    public Videos insertCustomVideo(Videos video){

        mapper.insertvideo(video);

        return mapper.selecttitle(video.getTitle());

    }

    public DailyMotionRoot searchvideos() {

        String daily_video_url = "https://api.dailymotion.com/videos";

        DailyMotionRoot response = restTemplate.getForObject(daily_video_url,DailyMotionRoot.class);

        return response;

    }

    //update
    public Videos updatebyTitle(Videos video){

        mapper.updatevideo(video);

        return mapper.selecttitle(video.getTitle());

    }

    //delete by IDNUMBER
    public Videos deletebyIDnumber(Videos video){

        mapper.deletevideo(video);
        return mapper.selecttitle(video.getTitle());
    }
}
