package pl.mbierut.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mbierut.models.LongWeekendWrapper;
import pl.mbierut.models.Weather;

@Service
public class JSONReader {
    private RestTemplate restTemplate;

    Weather parseToWeatherData(String url){
        return this.restTemplate.getForObject(url, Weather.class);
    }

    LongWeekendWrapper parseToLongWeekendData(String url){
        return this.restTemplate.getForObject(url, LongWeekendWrapper.class);
    }

}