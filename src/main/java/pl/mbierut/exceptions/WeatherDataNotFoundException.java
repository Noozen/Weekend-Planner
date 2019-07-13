package pl.mbierut.exceptions;

public class WeatherDataNotFoundException extends RuntimeException{

    public WeatherDataNotFoundException(String message) {
        super(message);
    }
}
