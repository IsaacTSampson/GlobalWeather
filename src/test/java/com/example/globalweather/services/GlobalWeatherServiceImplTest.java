package com.example.globalweather.services;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountry;
import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeather;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;
import com.example.globalweather.services.impl.GlobalWeatherServiceImpl;
import com.example.globalweather.services.impl.SoapClientImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.globalweather.TestFixtures.CITY_NAME;
import static com.example.globalweather.TestFixtures.COUNTRY_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GlobalWeatherServiceImplTest {

    @Mock
    SoapClientImpl soapClientImpl;

    @InjectMocks
    GlobalWeatherServiceImpl testee;

    @Test
    void getCitiesByCountry() {
        GetCitiesByCountryResponse getCitiesByCountryResponse = new GetCitiesByCountryResponse();

        when(soapClientImpl.getCitiesByCountry(any(GetCitiesByCountry.class))).thenReturn(getCitiesByCountryResponse);

        var result = testee.getCitiesByCountry(COUNTRY_NAME);

        assertThat(result, is(getCitiesByCountryResponse));
    }

    @Test
    void getWeather() {
        GetWeatherResponse getWeatherResponse = new GetWeatherResponse();

        when(soapClientImpl.getWeather(any(GetWeather.class))).thenReturn(getWeatherResponse);

        var result = testee.getWeather(CITY_NAME, COUNTRY_NAME);

        assertThat(result, is(getWeatherResponse));
    }
}
