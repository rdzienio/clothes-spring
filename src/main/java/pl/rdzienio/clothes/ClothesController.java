package pl.rdzienio.clothes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rdzienio.weather.WeatherService;

@Controller
@RequestMapping("")
public class ClothesController {

    private final ClothesService clothesService;
    private final WeatherService weatherService;
    Logger logger = LoggerFactory.getLogger(ClothesController.class);


    public ClothesController(ClothesService clothesService, WeatherService weatherService) {
        this.clothesService = clothesService;
        this.weatherService = weatherService;
    }

    @GetMapping
    public String showHomePageWithWeather(Model model)
    {
        model.addAttribute("weatherForWarsaw", weatherService.getWeatherForecast("Warszawa"));
        return "index";
    }

    @GetMapping("clothes")
    public String showClothesList()
    {
        return "clothesList";
    }



}
