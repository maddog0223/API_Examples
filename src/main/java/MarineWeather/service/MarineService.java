package MarineWeather.service;

import MarineWeather.mappers.MarineMapper;
import MarineWeather.model.MarineWeather.WWORoot;
import MarineWeather.model.MarineWeather.Weather;
import MarineWeather.model.database.DBSearch;
import MarineWeather.model.database.LocationWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

// The Brains... BRAINS!!
// Autowired into Controller
@Service
public class MarineService {

    // https://developer.worldweatheronline.com/
    // 5e6a5cd41fa34d94b3f232909181207 - API Key (500/day)

    // http://api.worldweatheronline.com/premium/v1/marine.ashx?key=5e6a5cd41fa34d94b3f232909181207&format=json&q=48.834,2.394

    // http://api.worldweatheronline.com/premium/v1/marine.ashx?key= API_KEY &format=json&q= LOCATION (48.834,2.394)

    // linked to runnable "bean" in MarineWeather.Application (run)
    @Autowired
    RestTemplate restTemplate;

    // linked to database mapper.
    @Autowired
    MarineMapper mapper;

    // API Key for access to www.worldweatheronline.com
    private final String API_KEY = "5e6a5cd41fa34d94b3f232909181207";


    // searches Marine weather for location results - - location format: (48.834,2.394).
    public WWORoot searchMW(String location) {
        String url = "http://api.worldweatheronline.com/premium/v1/marine.ashx?key=" + API_KEY + "&format=json&q=" + location;

        // searches for location in URL.
        WWORoot wwoResponse = restTemplate.getForObject(url, WWORoot.class);
        {
            // set results to data.
            fillDatabase(wwoResponse, location);
        }
        return wwoResponse;
    }


    // GET - INPUT'S TEMPERATURE AND LAT/LONG INFO INTO DATABASE
    public void fillDatabase(WWORoot data, String location) {

        // pulls information from Weather array
        for (Weather weather : data.getData().getWeather()) {

            // imports locWeather class to insert new data
            LocationWeather locWeather = new LocationWeather();

            // locWeather variables get/set
            locWeather.setDate(weather.getDate());
            locWeather.setMaxtempF(weather.getMaxtempF());
            locWeather.setMintempF(weather.getMintempF());
            locWeather.setLocation(location);

            // maps variables to database method in Mapper class
            mapper.insertLocationWeathertoDB(locWeather);
        }
    }


    // GET - Searches database by ID
    public DBSearch dbSearch(@RequestParam("id") int id) {

        // import database
        DBSearch returnID = new DBSearch();

        // set DB ID (return ID) to searched "id" (id)
        returnID.setId(id);

        // return values to Location Weather method
        returnID.setLocationWeathers(mapper.selectByID(id));

        // return values
        return returnID;
    }


    // DELETE - Delete from database by ID
    public DBSearch deleteID(int id) {

        // import database
        DBSearch removeID = new DBSearch();

        // compare DB ID (removeID) to searched "id" (id)
        if (removeID.getId() == id); {

            // remove ID from DB
            removeID.setId(mapper.deleteByIDfromDB(id));
        }

        // if no results; return DB ID (remove ID)
        return removeID;
    }


    // POST - inserts new information into database
    public LocationWeather insertNew(LocationWeather data) {

        // pull from insertNew method
        LocationWeather newLoc = new LocationWeather();

        // set new values into database
        newLoc.setDate(data.getDate());
        newLoc.setMaxtempF(data.getMaxtempF());
        newLoc.setMintempF(data.getMintempF());
        newLoc.setLocation(data.getLocation());

        // import all values into database
        mapper.insertLocationWeathertoDB(newLoc);

        // return new values
        return newLoc;
    }


    // PUT - Updates information for existing information
    public LocationWeather updateID(@RequestParam ("id") int id, LocationWeather data) {

        // display ID Results (from dbSearch method)
        LocationWeather newVals = new LocationWeather();

        // set new values into ID
        newVals.setDate(data.getDate());
        newVals.setMaxtempF(data.getMaxtempF());
        newVals.setMintempF(data.getMintempF());
        newVals.setLocation(data.getLocation());
        newVals.setId(id);

        // import new values into ID
        mapper.insertUpdateByID(newVals);

        // return new values
        return newVals;
    }
}