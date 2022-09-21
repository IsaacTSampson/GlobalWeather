package com.example.globalweather.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.ws.client.WebServiceIOException;

import java.util.Objects;

import static com.example.globalweather.TestFixtures.EXCEPTION_MESSAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(MockitoExtension.class)
class WebServiceExceptionHandlerTest {

    @InjectMocks
    WebServiceExceptionHandler testee;

    @Test
    void handleWebServiceException() {
        WebServiceIOException e = new WebServiceIOException(EXCEPTION_MESSAGE);

        var result = testee.handleWebServiceException(e);

        assertThat(result.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(Objects.requireNonNull(result.getBody()).getClass(), is(WebServiceException.class));

        WebServiceException exception = (WebServiceException) result.getBody();

        assertThat(exception.getHttpStatus(), is(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(exception.getMessage(), is(EXCEPTION_MESSAGE + " - Check mock SOAP service is running"));
        assertThat(exception.getTimestamp(), notNullValue());
    }
}
