package pl.rdzienio.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Repository
public class WeatherRepository {

    Logger logger = LoggerFactory.getLogger(WeatherRepository.class);

    private static final String CONNECTION_URL = "https://api.openweathermap.org/data/2.5/weather?q={city},pl&appid={key}&units=metric";

    private final RestTemplate restTemplate;
    private final String applicationKey;


    public WeatherRepository(final RestTemplate restTemplate, @Value("${weather.key}") final String applicationKey) {
        this.restTemplate = restTemplate;
        this.applicationKey = applicationKey;
        logger.info("App key: [{}]", applicationKey);
    }

    public WeatherForecast getWeatherForecastFromConnectionUrl(final String city){
        WeatherForecast result = restTemplate.getForObject(CONNECTION_URL, WeatherForecast.class, Map.of("city", city, "key", applicationKey));
        logger.info("Forecast for [{}] is: [{}]", city, result);
        return result;
    }
}
