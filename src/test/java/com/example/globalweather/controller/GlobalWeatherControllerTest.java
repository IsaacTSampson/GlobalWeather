package com.example.globalweather.controller;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;
import com.example.globalweather.services.GlobalWeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static com.example.globalweather.TestFixtures.CITY_NAME;
import static com.example.globalweather.TestFixtures.COUNTRY_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GlobalWeatherControllerTest {

    @Mock
    GlobalWeatherService globalWeatherService;

    @InjectMocks
    GlobalWeatherController testee;

    @Test
    void getCitiesByCountry() {
        GetCitiesByCountryResponse getCitiesByCountryResponse = new GetCitiesByCountryResponse();

        when(globalWeatherService.getCitiesByCountry(COUNTRY_NAME)).thenReturn(getCitiesByCountryResponse);

        var result = testee.getCitiesByCountry(COUNTRY_NAME);

        assertThat(result.getBody(), is(getCitiesByCountryResponse));
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    void getWeather() {
        GetWeatherResponse getWeatherResponse = new GetWeatherResponse();

        when(globalWeatherService.getWeather(CITY_NAME, COUNTRY_NAME)).thenReturn(getWeatherResponse);

        var result = testee.getWeather(CITY_NAME, COUNTRY_NAME);

        assertThat(result.getBody(), is(getWeatherResponse));
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
    }
}
