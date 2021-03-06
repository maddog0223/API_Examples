package NYT.model.nyt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Legacy {

    String xlarge;
    int xlargewidth;

    public String getXlarge() {
        return xlarge;
    }

    public void setXlarge(String xlarge) {
        this.xlarge = xlarge;
    }

    public int getXlargewidth() {
        return xlargewidth;
    }

    public void setXlargewidth(int xlargewidth) {
        this.xlargewidth = xlargewidth;
    }

    public int getXlargeheight() {
        return xlargeheight;
    }

    public void setXlargeheight(int xlargeheight) {
        this.xlargeheight = xlargeheight;
    }

    int xlargeheight;
}
