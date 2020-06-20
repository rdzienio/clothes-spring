package pl.rdzienio.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class Weather {

    private final Logger logger = LoggerFactory.getLogger(Weather.class);


    private double temperature;
    private double precipitation;
    private double wind;
    private String city;
    private String description;


    public Weather() {
        logger.info("Created forecast with empty param!");
        this.temperature = 0;
        this.precipitation = 0;
        this.wind = 0;
        this.city = "Siedlce";
        this.description = "Clear";
        parseWeather(getWeather());
    }

    public Weather(String city) {
        this.temperature = 0;
        this.precipitation = 0;
        this.wind = 0;
        this.city = city;
        this.description = "Clear";
        logger.info("Created forecast with only city param: " + city);
        parseWeather(getWeather());
    }

    public Weather(double temperature, double precipitation, double wind, String city) {
        logger.info("Created forecast with params: " +temperature+", "+ city);
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.wind = wind;
        this.city = city;
    }

    private String getWeather() {
        StringBuilder result = new StringBuilder();
        String[] urlWeather = {"https://api.openweathermap.org/data/2.5/weather?q=", ",pl&APPID=56f79879af12160401ea01f9b8366e76&units=metric"};
        try {
            String OWTurl = urlWeather[0] + this.city + urlWeather[1];
            URL owtUrl = new URL(OWTurl);
            URLConnection urlConnection = owtUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                result.append(inputLine);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result.toString();
    }


    private void parseWeather(String jsonString) {
        if (Objects.isNull(jsonString)) {
            this.setPrecipitation(Integer.MIN_VALUE);
            this.setTemperature(Integer.MIN_VALUE);
            this.setWind(Integer.MIN_VALUE);
            this.city = "Not Found";
            this.setDescription("none");
            return;
        }
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(jsonString);

        JsonObject jsonObject = jsonTree.getAsJsonObject();
        JsonElement mainEl = jsonObject.get("main");
        if (mainEl != null && mainEl.isJsonObject()) {
            JsonObject jsonObject1 = mainEl.getAsJsonObject();
            /*JsonElement temp = jsonObject1.get("feels_like");
            System.out.println("Temperatura odczuwalna: " + temp);*/
            JsonElement temp = jsonObject1.get("temp");
            System.out.println("Temperatura: " + temp);
            setTemperature(temp.getAsDouble());
        }

        JsonElement precipitationEl = jsonObject.get("rain");
        if (precipitationEl != null && precipitationEl.isJsonObject()) {
            JsonObject jsonObject1 = precipitationEl.getAsJsonObject();
            JsonElement rain = jsonObject1.get("3h");
            if (Objects.nonNull(rain)) {
                System.out.println("Opad deszczu 3h: " + rain);
                setPrecipitation(rain.getAsDouble());
            }
        } else
            setPrecipitation(0);

        JsonElement precipitationEl1 = jsonObject.get("snow");
        if (precipitationEl1 != null && precipitationEl1.isJsonObject()) {
            JsonObject jsonObject1 = precipitationEl1.getAsJsonObject();
            JsonElement snow = jsonObject1.get("3h");
            if (Objects.nonNull(snow)) {
                System.out.println("Opad sniegu 3h: " + snow);
                this.precipitation += snow.getAsDouble();
            }
        }

        JsonElement windEl = jsonObject.get("wind");
        if (windEl != null && windEl.isJsonObject()) {
            JsonObject jsonObject1 = windEl.getAsJsonObject();
            JsonElement wind = jsonObject1.get("speed");
            System.out.println("Predkosc wiatru: " + wind);
            this.setWind(wind.getAsDouble());
        } else
            setWind(0);

        JsonElement desc = jsonObject.get("weather");
        if (desc != null && desc.isJsonObject()) {
            JsonObject jsonObject1 = desc.getAsJsonObject();
            JsonElement wind = jsonObject1.get("description");
            System.out.println(desc);
            this.setDescription(desc.getAsString());
        } else
            setDescription("clear sky");

    }

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    private void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        this.parseWeather(getWeather());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City(PL):" + this.city + " - " + this.description + ", temperature: " + this.getTemperature() + "°C, precipitation: " + this.getPrecipitation() + "mm, wind: " + this.wind + "m/s";
    }
}
