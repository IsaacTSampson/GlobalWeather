package com.example.globalweather;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountry;
import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeather;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;
import com.example.globalweather.services.impl.SoapClientImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ws.client.core.WebServiceTemplate;

import static com.example.globalweather.TestFixtures.SOAP_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class SoapClientImplTest {
    @Mock
    WebServiceTemplate webServiceTemplate;

    @InjectMocks
    SoapClientImpl testee;

    @BeforeEach
    void init() {
        setField(testee, "soapUrl", SOAP_URL);
    }

    @Test
    void getCitiesByCountry() {
        GetCitiesByCountry request = new GetCitiesByCountry();
        GetCitiesByCountryResponse getCitiesByCountryResponse = new GetCitiesByCountryResponse();

        when(webServiceTemplate.marshalSendAndReceive(SOAP_URL, request)).thenReturn(getCitiesByCountryResponse);

        var result = testee.getCitiesByCountry(request);

        assertThat(result, is(getCitiesByCountryResponse));
    }

    @Test
    void getWeather() {
        GetWeather request = new GetWeather();
        GetWeatherResponse getWeatherResponse = new GetWeatherResponse();

        when(webServiceTemplate.marshalSendAndReceive(SOAP_URL, request)).thenReturn(getWeatherResponse);

        var result = testee.getWeather(request);

        assertThat(result, is(getWeatherResponse));
    }
}
