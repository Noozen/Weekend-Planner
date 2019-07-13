package pl.mbierut.models.weather;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WeatherSubsection {
    String icon;
    int code;
    String description;
}
