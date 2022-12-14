package com.example.globalweather;

import com.example.globalweather.consumesoap.stub.GetCitiesByCountryResponse;
import com.example.globalweather.consumesoap.stub.GetWeatherResponse;
import com.example.globalweather.consumesoap.stub.ObjectFactory;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.oxm.Unmarshaller;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

public class MockUnmarshaller implements Unmarshaller {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public Object unmarshal(Source source) {
        String nodeName = ((DOMSource) source).getNode().getNodeName();
        String data = ((DOMSource) source).getNode().getFirstChild().getTextContent();
        String strippedData = StringEscapeUtils.unescapeXml(
                data.replace("<![CDATA[", "").replace("]]>", "")
        );
        return createResponseFromNodeName(nodeName, strippedData);
    }

    private Object createResponseFromNodeName(String nodeName, String result) {
        if (nodeName.equals("GetCitiesByCountryResponse")){
            return new JAXBElement<>(
                    new QName(nodeName),
                    GetCitiesByCountryResponse.class,
                    new ObjectFactory().createGetCitiesByCountryResponse(result)
            );
        }
        else if (nodeName.equals("GetWeatherResponse")){
            return new JAXBElement<>(
                    new QName(nodeName),
                    GetWeatherResponse.class,
                    new ObjectFactory().createGetWeatherResponse(result)
            );
        }
        throw new IllegalArgumentException("Unknown node name");
    }
}
