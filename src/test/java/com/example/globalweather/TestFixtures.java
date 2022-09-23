package com.example.globalweather;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;
import com.example.globalweather.consumesoap.stub.ObjectFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class TestFixtures {
    public static final String CITY_NAME = "cityName";
    public static final String COUNTRY_NAME = "countryName";
    public static final String GET_WEATHER_RESULT = "getWeatherResult";
    public static final String GET_CITIES_BY_COUNTRY_RESULT = "getCitiesByCountryResult";
    public static final String SOAP_URL = "soapUrl";
    public static final String EXCEPTION_MESSAGE = "exceptionMessage";

    public static JAXBElement<GetWeatherResponse> createJAXBElementGetWeatherResponse(){
        return new JAXBElement<>(
                new QName("GetWeatherResponse"),
                GetWeatherResponse.class,
                new ObjectFactory().createGetWeatherResponse(GET_WEATHER_RESULT)
        );
    }

    public static JAXBElement<GetCitiesByCountryResponse> createJAXBElementGetCitiesByCountryResponse(){
        return new JAXBElement<>(
                new QName("GetCitiesByCountryResponse"),
                GetCitiesByCountryResponse.class,
                new ObjectFactory().createGetCitiesByCountryResponse(GET_CITIES_BY_COUNTRY_RESULT)
        );
    }
}