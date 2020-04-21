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

    protected final static String GATEWAY_PATH = "http://localhost:";
    protected final static String URI_DOC_TYPE = "8082/ECM/components/documentTypes";
    protected final static String URI_DOCS = "8082/ECM/components/documents";
    protected final static String URI_USERS = "8081/ECM/users";

    Client(final String servicePath) {
        this.restTemplate = new RestTemplate(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        this.serviceFullPath = GATEWAY_PATH + servicePath;
    }

    protected <T extends Wrapper> T get(final String path, final Class<T> type) {
        return restTemplate.getForObject(serviceFullPath + path, type);
    }
}