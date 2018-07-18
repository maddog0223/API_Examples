package dailymotion.controller;

import dailymotion.model.dailymotion.DailyMotionRoot;
import dailymotion.model.dailymotion.List;
import dailymotion.model.database.Videos;
import dailymotion.service.DailyService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// API REST CONTROL
// mapping the call to the API with "/dailymotion"
@RestController
@RequestMapping("/dailymotion")
public class DailyController {

    // @Autowired signals the application the the @Bean
    @Autowired
    DailyService service;

    //Get search

    //Requesting mapping the get method woth "/searchvideo"
    @RequestMapping("/searchvideo")
    public List searchobject_videos(

            //Example = https:localhost8080:dailymotion/search?id=<String id>
            @RequestParam("id") String id) {

        List videoresponse = service.searchvideo(id);

        return videoresponse;

    }
    //Get search
    //DailyMotion root
    @RequestMapping("/searchvideos")
    public DailyMotionRoot searchobject_videos() {

        DailyMotionRoot videoresponse = service.searchvideos();

        return videoresponse;

    }


    //Post mapping the insert_new_video with "/"
    @PostMapping("/")
    // Requesting the body to use the Video class
    public Videos create(@RequestBody Videos video) {

        return service.insertCustomVideo(video);
        //calling the insert method from the service and inserting the variable name of class Video
    }

    //Put
    @PutMapping("/")
    public Videos update(@RequestBody Videos video){

        return service.updatebyTitle(video);

    }

    //Delete
    @Delete("/")
    public Videos delete(@RequestBody Videos video){

        return service.deletebyIDnumber(video);


    }
}