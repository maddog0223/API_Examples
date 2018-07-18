package dailymotion.controller;

import dailymotion.model.dailymotion.DailyMotionRoot;
import dailymotion.model.dailymotion.List;
import dailymotion.model.database.Video;
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

    //Requesting mapping the get method with "/searchvideo"
    @RequestMapping("/searchvideo")
    public List searchobject_videos(

            //Example = http://localhost:8080/dailymotion/searchvideo?id=<ex:x7123>
            @RequestParam("id") String id) {

        List videoresponse = service.searchvideo(id);

        return videoresponse;

    }
    //Get search
    // DailyMotion root
    @RequestMapping("/searchvideos")
    public DailyMotionRoot searchobject_videos() {

        DailyMotionRoot videoresponse = service.searchvideos();

        return videoresponse;

    }


    //Post mapping the insert_new_video with "/"
    @PostMapping
    // Requesting the body to use the Video class
    public Video create(@RequestBody Video video) {

        return service.insertCustomVideo(video);
        //calling the insert method from the service and inserting the variable name of class Video
    }

    //Put
    @PutMapping
    public Video update(@RequestBody Video video){

        return service.updatebyTitle(video);

    }

    //Delete
    @DeleteMapping("/{idnumber}")
    public Video delete(@PathVariable(value="idnumber")int idnumber){

        return service.deletebyIDnumber(idnumber);


    }
}