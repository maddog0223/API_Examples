package dailymotion.controller;

import dailymotion.model.dailymotion.DailyMotionRoot;
import dailymotion.model.dailymotion.List;
import dailymotion.model.database.Videos;
import dailymotion.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dailymotion")
public class DailyController {

    @Autowired
    DailyService service;

    //Get search
    @RequestMapping("/searchvideo")
    public DailyMotionRoot searchobject_videos(

            //https:localhost8080:dailymotion/search?video=<String id>
            @RequestParam("id") String id) {
      DailyMotionRoot videoresponse = service.searchvideo(id);

        return videoresponse;

    }

    //post
    @PostMapping("/")
    public Videos insert_new_video(@RequestBody Videos videos) {

        service.insert(videos);

        return videos;

    }

    //Update

    //Delete
}