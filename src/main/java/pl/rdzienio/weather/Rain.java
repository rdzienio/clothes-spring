package pl.rdzienio.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {

    @JsonProperty("1h") private Double oneHour;
    @JsonProperty("3h") private Double threeHour;

    public Rain() {
    }

    public Double getOneHour() {
        return oneHour;
    }

    public void setOneHour(final Double oneHour) {
        this.oneHour = oneHour;
    }

    public Double getThreeHour() {
        return threeHour;
    }

    public void setThreeHour(final Double threeHour) {
        this.threeHour = threeHour;
    }
}
