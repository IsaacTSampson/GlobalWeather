package com.example.globalweather.consumesoap.stub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.globalweather.TestFixtures.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class ObjectFactoryTest {

    @InjectMocks
    ObjectFactory testee;

    @Test
    void createGetWeather() {
        var result = testee.createGetWeather(CITY_NAME, COUNTRY_NAME);

        assertThat(result.getCityName(), is(CITY_NAME));
        assertThat(result.getCountryName(), is(COUNTRY_NAME));
    }

    @Test
    void createGetWeatherResponse() {
        var result = testee.createGetWeatherResponse(GET_WEATHER_RESULT);

        assertThat(result.getGetWeatherResult(), is(GET_WEATHER_RESULT));
    }

    @Test
    void createGetCitiesByCountry() {
        var result = testee.createGetCitiesByCountry(COUNTRY_NAME);

        assertThat(result.getCountryName(), is(COUNTRY_NAME));
    }

    @Test
    void createGetCitiesByCountryResponse() {
        var result = testee.createGetCitiesByCountryResponse(GET_CITIES_BY_COUNTRY_RESULT);

        assertThat(result.getGetCitiesByCountryResult(), is(GET_CITIES_BY_COUNTRY_RESULT));
    }
}
