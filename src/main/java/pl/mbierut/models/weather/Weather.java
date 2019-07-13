package pl.mbierut.models.weather;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Weather {
    List<WeatherData> data;
    String city_name;
    double lon;
    String timezone;
    double lat;
    String country_code;
    int state_code;
}
