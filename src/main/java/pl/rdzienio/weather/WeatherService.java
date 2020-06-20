package pl.rdzienio.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.rdzienio.clothes.ClothesService;


@Service
public class WeatherService {

    private final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private final ClothesService clothesService;

    public WeatherService(final ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    public Weather getWeather(String city){
        logger.info("Return forecast to city: " + city);
        return new Weather(city);
    }


}
