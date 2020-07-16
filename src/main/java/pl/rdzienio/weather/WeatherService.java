package pl.rdzienio.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.rdzienio.clothes.ClothesService;


@Service
public class WeatherService {

    private final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private final ClothesService clothesService;
    private final WeatherRepository weatherRepository;

    public WeatherService(final ClothesService clothesService, final WeatherRepository weatherRepository) {
        this.clothesService = clothesService;
        this.weatherRepository = weatherRepository;
    }

    public WeatherForecast getWeatherForecast(String city) {
        return weatherRepository.getWeatherForecastFromConnectionUrl(city);
    }


}
