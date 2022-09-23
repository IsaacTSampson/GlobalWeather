package com.example.globalweather.services.impl;

import com.example.globalweather.consumesoap.stub.*;
import com.example.globalweather.services.GlobalWeatherService;
import com.example.globalweather.services.SoapClient;
import org.springframework.stereotype.Service;

@Service
public class GlobalWeatherServiceImpl implements GlobalWeatherService {
    private final SoapClient soapClient;

    public GlobalWeatherServiceImpl(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @Override
    public GetCitiesByCountryResponse getCitiesByCountry(String countryName) {
        GetCitiesByCountry request = new ObjectFactory().createGetCitiesByCountry(countryName);
        return soapClient.getCitiesByCountry(request);
    }

    @Override
    public GetWeatherResponse getWeather(String cityName, String countryName) {
        GetWeather request = new ObjectFactory().createGetWeather(cityName, countryName);
        return soapClient.getWeather(request);
    }
}
