package pl.rdzienio.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    private final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    public WeatherController(final WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{city}")
    ResponseEntity<Weather> showWeatherForCurrentCity(@PathVariable String city) {
        logger.info("Got request with parameter " + city);
        return ResponseEntity.ok(service.getWeather(city));
    }
}
