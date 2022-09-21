package com.example.globalweather.services.impl;

import com.example.globalweather.MockUnmarshaller;
import com.example.globalweather.consumesoap.stub.GetCitiesByCountry;
import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeather;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;
import com.example.globalweather.services.SoapClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
public class SoapClientImpl extends WebServiceGatewaySupport implements SoapClient {

    @Value("${soap.url}")
    private String soapUrl;

    public SoapClientImpl() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.globalweather.consumesoap.stub");

        this.setDefaultUri(soapUrl);
        this.setMarshaller(marshaller);
        this.setUnmarshaller(new MockUnmarshaller());
    }

    @Override
    public GetCitiesByCountryResponse getCitiesByCountry(GetCitiesByCountry request) {
        //Get xml from SOAP service
        return (GetCitiesByCountryResponse) getWebServiceTemplate().marshalSendAndReceive(soapUrl, request);
    }

    @Override
    public GetWeatherResponse getWeather(GetWeather request) {
        //Get xml from SOAP service
        return (GetWeatherResponse) getWebServiceTemplate().marshalSendAndReceive(soapUrl, request);
    }
}
