package com.example.globalweather.consumesoap.stub;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    /**
     * Create an instance of {@link GetWeather }
     */
    public GetWeather createGetWeather(final String cityName, final String countryName) {
        GetWeather getWeather = new GetWeather();
        getWeather.setCityName(cityName);
        getWeather.setCountryName(countryName);
        return getWeather;
    }

    /**
     * Create an instance of {@link GetWeatherResponse }
     */
    public GetWeatherResponse createGetWeatherResponse(String getWeatherResult) {
        GetWeatherResponse getWeatherResponse = new GetWeatherResponse();
        getWeatherResponse.setGetWeatherResult(getWeatherResult);
        return getWeatherResponse;
    }

    /**
     * Create an instance of {@link GetCitiesByCountry }
     */
    public GetCitiesByCountry createGetCitiesByCountry(String countryName) {
        GetCitiesByCountry getCitiesByCountry = new GetCitiesByCountry();
        getCitiesByCountry.setCountryName(countryName);
        return getCitiesByCountry;
    }

    /**
     * Create an instance of {@link GetCitiesByCountryResponse }
     */
    public GetCitiesByCountryResponse createGetCitiesByCountryResponse(String getCitiesByCountryResult) {
        GetCitiesByCountryResponse getCitiesByCountryResponse = new GetCitiesByCountryResponse();
        getCitiesByCountryResponse.setGetCitiesByCountryResult(getCitiesByCountryResult);
        return getCitiesByCountryResponse;
    }
}
