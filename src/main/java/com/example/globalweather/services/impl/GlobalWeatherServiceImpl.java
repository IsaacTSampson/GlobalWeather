package com.example.globalweather.services.impl;

import com.example.globalweather.consumesoap.stub.*;
import com.example.globalweather.services.GlobalWeatherService;
import org.springframework.stereotype.Service;

@Service
public class GlobalWeatherServiceImpl implements GlobalWeatherService {
    private final SoapClientImpl soapClientImpl;

    public GlobalWeatherServiceImpl(SoapClientImpl soapClientImpl) {
        this.soapClientImpl = soapClientImpl;
    }

    @Override
    public GetCitiesByCountryResponse getCitiesByCountry(String countryName) {
        GetCitiesByCountry request = new ObjectFactory().createGetCitiesByCountry(countryName);
        return soapClientImpl.getCitiesByCountry(request);
    }

    @Override
    public GetWeatherResponse getWeather(String cityName, String countryName) {
        GetWeather request = new ObjectFactory().createGetWeather(cityName, countryName);
        return soapClientImpl.getWeather(request);
    }
}
