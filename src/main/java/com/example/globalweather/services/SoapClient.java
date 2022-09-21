package com.example.globalweather.services;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountry;
import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeather;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;

public interface SoapClient {
    GetCitiesByCountryResponse getCitiesByCountry(GetCitiesByCountry request);

    GetWeatherResponse getWeather(GetWeather request);
}
