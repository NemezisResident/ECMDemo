package com.nemezis.ecm.controllers;

import com.nemezis.models.Wrapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;


/**
 *
 */
abstract class Client {
    protected final RestTemplate restTemplate;
    private final String serviceFullPath;

    private final static String GATEWAY_PATH = "http://localhost:";
    protected final static String GET_DOC_TYPE = "8082/ECM/components/documentType/";

    Client(final String servicePath) {
        this.restTemplate = new RestTemplate(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        this.serviceFullPath = GATEWAY_PATH + servicePath;
    }

    protected <T extends Wrapper> T get(final String path, final Class<T> type) {
        return restTemplate.getForObject(serviceFullPath + path, type);
    }

//    protected <T extends Result> T get(final String path, final Class<T> type, final String token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(TokenData.TOKEN.getValue(), token);
//        HttpEntity entity = new HttpEntity(headers);
//        return rest.exchange(serviceFullPath + path, HttpMethod.GET, entity, type).getBody();
//    }
//
//    protected <T extends Result, E> T post(final String path, final E object, final Class<T> type) {
//        return rest.postForObject(serviceFullPath + path, object, type);
//    }
//
//    protected <T extends Result, E> T post(final String path, final E object, final Class<T> type, final String token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(TokenData.TOKEN.getValue(), token);
//        HttpEntity<E> entity = new HttpEntity<>(object, headers);
//        return rest.postForObject(serviceFullPath + path, entity, type);
//    }
}