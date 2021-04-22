package pl.rdzienio.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final WeatherService service;

    private final Logger logger = LoggerFactory.getLogger(WeatherRESTController.class);


    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("weather")
    public String showHomePageForWeather(Model model)
    {
        var weatherForWarsaw= service.getWeatherForecast("Warszawa");
        model.addAttribute("weatherForWarsaw", weatherForWarsaw);
        model.addAttribute("weatherIconForWarsaw", service.getWeatherIconForCity("Warszawa"));
        return "weather";
    }

}
