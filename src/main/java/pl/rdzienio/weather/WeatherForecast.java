package pl.rdzienio.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
    private Weather[] weather;
    private MainWeather main;
    private Wind wind;
    private Rain rain;
    private Snow snow;

    public WeatherForecast() {
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(final Weather[] weather) {
        this.weather = weather;
    }

    public MainWeather getMain() {
        return main;
    }

    public void setMain(final MainWeather main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(final Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(final Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(final Snow snow) {
        this.snow = snow;
    }
}
