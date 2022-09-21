package com.example.globalweather.services;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;

public interface GlobalWeatherService {
    GetCitiesByCountryResponse getCitiesByCountry(String countryName);

    GetWeatherResponse getWeather(String cityName, String countryName);
}
