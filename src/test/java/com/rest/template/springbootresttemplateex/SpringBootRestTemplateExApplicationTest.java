package com.rest.template.springbootresttemplateex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

public class SpringBootRestTemplateExApplicationTest {
    @Test
    public void testGetRestTemplate() {
        RestTemplate actualRestTemplate = (new SpringBootRestTemplateExApplication()).getRestTemplate();
        assertTrue(actualRestTemplate.getClientHttpRequestInitializers().isEmpty());
        UriTemplateHandler uriTemplateHandler = actualRestTemplate.getUriTemplateHandler();
        assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
        assertTrue(actualRestTemplate
                .getRequestFactory() instanceof org.springframework.http.client.SimpleClientHttpRequestFactory);
        assertTrue(
                actualRestTemplate.getErrorHandler() instanceof org.springframework.web.client.DefaultResponseErrorHandler);
        List<HttpMessageConverter<?>> messageConverters = actualRestTemplate.getMessageConverters();
        assertEquals(7, messageConverters.size());
        assertTrue(actualRestTemplate.getInterceptors().isEmpty());
        assertTrue(((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables().isEmpty());
        assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
                ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
        assertEquals(1, messageConverters.get(2).getSupportedMediaTypes().size());
        assertEquals(2, messageConverters.get(1).getSupportedMediaTypes().size());
        HttpMessageConverter<?> getResult = messageConverters.get(4);
        assertEquals(6, ((AllEncompassingFormHttpMessageConverter) getResult).getPartConverters().size());
        assertEquals(3, getResult.getSupportedMediaTypes().size());
        assertFalse(((Jaxb2RootElementHttpMessageConverter) messageConverters.get(5)).isSupportDtd());
        assertFalse(((Jaxb2RootElementHttpMessageConverter) messageConverters.get(5)).isProcessExternalEntities());
        ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) messageConverters.get(6)).getObjectMapper();
        assertTrue(objectMapper.getSerializerFactory() instanceof com.fasterxml.jackson.databind.ser.BeanSerializerFactory);
        assertNull(objectMapper.getPropertyNamingStrategy());
        assertTrue(objectMapper
                .getPolymorphicTypeValidator() instanceof com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator);
        assertSame(objectMapper.getJsonFactory(), objectMapper.getFactory());
        assertTrue(objectMapper
                .getDeserializationContext() instanceof com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl);
        assertTrue(objectMapper.getDateFormat() instanceof com.fasterxml.jackson.databind.util.StdDateFormat);
        assertTrue(objectMapper
                .getSerializerProviderInstance() instanceof com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl);
        assertTrue(
                objectMapper.getSubtypeResolver() instanceof com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver);
        assertTrue(objectMapper
                .getSerializerProvider() instanceof com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl);
    }
}

