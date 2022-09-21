package com.example.globalweather.controller;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;
import com.example.globalweather.services.GlobalWeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/globalWeather")
public class GlobalWeatherController {
    private final GlobalWeatherService globalWeatherService;

    public GlobalWeatherController(GlobalWeatherService globalWeatherService) {
        this.globalWeatherService = globalWeatherService;
    }

    @GetMapping("/getCitiesByCountry")
    public ResponseEntity<GetCitiesByCountryResponse> getCitiesByCountry(@RequestParam(required = false) String countryName) {
        return ResponseEntity.ok(globalWeatherService.getCitiesByCountry(countryName));
    }

    @GetMapping("/getWeather")
    public ResponseEntity<GetWeatherResponse> getWeather(@RequestParam(required = false) String cityName, @RequestParam(required = false) String countryName) {
        return ResponseEntity.ok(globalWeatherService.getWeather(cityName, countryName));
    }
}
