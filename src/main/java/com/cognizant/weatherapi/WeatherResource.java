package com.cognizant.weatherapi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WeatherResource {
    // get method for the weather data
    // get method for the weather data by id
    // post method for the weather data
    // delete method for the weather data

    private WeatherService weatherService;

    public WeatherResource(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // method to return the weather data
    @RequestMapping("/weather") 
    public List<Weather> getWeatherData() {
        return weatherService.getWeatherData();
    }

    // method to return the weather data by id
    @RequestMapping("/weather/{id}")
    public Weather getWeatherDataById(@PathVariable int id) {

        // return not found http code if id is null
        if (weatherService.getWeatherDataById(id) == null
                || weatherService.getWeatherDataById(id).getId() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather data not found");
        }

        return weatherService.getWeatherDataById(id);
    }

    // method to add the weather data from POST request
    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public ResponseEntity<Weather> addWeatherData(@RequestBody Weather weather) {

        // add a new id if id is not present
        if (weather.getId() == 0) {
            weather.setId(weatherService.getWeatherData().size() + 1);
        }
        weatherService.addWeatherData(weather);

        return new ResponseEntity<Weather>(weather, HttpStatus.CREATED);
    }
    
    // method to delete the weather data by id
    @RequestMapping(value = "/weather/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteWeatherData(@PathVariable int id) {
        if (weatherService.deleteWeatherData(id) == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather data not found");
        }
        return ResponseEntity.noContent().build();
    }

}
