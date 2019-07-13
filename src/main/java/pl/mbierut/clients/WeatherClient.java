package pl.mbierut.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mbierut.models.weather.Weather;
import pl.mbierut.models.weather.WeatherData;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherClient {

    @Value("${urlWeather}")
    private String weatherServiceUrl;
    @Value("${key}")
    private String weatherServiceApiKey;

    private RestTemplate restTemplate;

    public WeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Weather getRawWeatherData(String cityName){
        String urlWeatherFull = weatherServiceUrl + cityName + weatherServiceApiKey;
        return restTemplate.getForObject(urlWeatherFull, Weather.class);
    }

    public Map<LocalDate, WeatherData> getWeatherData(String cityName){
        List<WeatherData> data = getRawWeatherData(cityName).getData();
        return data.stream().collect(Collectors.toMap(WeatherData::getDatetime, d -> d));
    }
}