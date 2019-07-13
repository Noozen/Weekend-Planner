package pl.mbierut.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mbierut.models.weather.WeatherData;
import pl.mbierut.services.WeekendWeatherService;

import java.util.List;

@Controller
public class CityController {
    private WeekendWeatherService weekendWeatherService;

    private CityController(WeekendWeatherService weekendWeatherService){
        this.weekendWeatherService = weekendWeatherService;
    }

    @GetMapping("/")
    public String sendHome(Model model) {
        model.addAttribute("city", "");
        return "home";
    }

    @GetMapping("/results")
    public String sendBack(){
        return "error";
    }

    @PostMapping("/results")
    public String showResults(@RequestParam String city, Model model) {
        List<WeatherData> weatherData = weekendWeatherService.getWeatherForWeekend(city);
        model.addAttribute("city", city);
        model.addAttribute("data", weatherData);
        return "results";
    }
}
