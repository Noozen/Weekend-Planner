package pl.mbierut.models.weather;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class WeatherData {
    int moonrise_ts;
    String wind_cdir;
    int rh;
    double pres;
    int sunset_ts;
    double ozone;
    double moon_phase;
    double wind_gust_spd;
    int snow_depth;
    int clouds;
    int ts;
    int sunrise_ts;
    double app_min_temp;
    double wind_spd;
    int pop;
    String wind_cdir_full;
    double slp;
    double app_max_temp;
    int vis;
    double dewpt;
    int snow;
    double uv;
    LocalDate valid_date;
    int wind_dir;
    int max_dhi;
    int clouds_dhi;
    int precip;
    WeatherSubsection weather;
    double max_temp;
    int moonset_ts;
    LocalDate datetime;
    double temp;
    double min_temp;
    int clouds_mid;
    int clouds_low;
}
