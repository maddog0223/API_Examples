package MarineWeather.model.database;

public class LocationWeather {

    // Location Weather items to import into database
    int id;
    String date;
    int maxtempF;
    int  mintempF;
    String location;


    public LocationWeather() {
    }

    public LocationWeather(String date, int maxtempF, int mintempF, String location) {
        this.date = date;
        this.maxtempF = mintempF;
        this.mintempF = mintempF;
        this.location = location;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(int maxtempF) {
        this.maxtempF = maxtempF;
    }

    public int getMintempF() {
        return mintempF;
    }

    public void setMintempF(int mintempF) {
        this.mintempF = mintempF;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
