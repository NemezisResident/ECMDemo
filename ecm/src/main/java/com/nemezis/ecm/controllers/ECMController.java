package com.nemezis.ecm.controllers;

import com.nemezis.ecm.models.WrapperDocumentType;
import com.nemezis.models.DocumentTypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Главный контроллер
 */
@RestController
public class ECMController extends Client {


    ECMController() {
        super("");
    }

    @RequestMapping(value = "/document_type", method = RequestMethod.GET)
    public DocumentTypeDto get(String id) {
        return get(GET_DOC_TYPE + id, WrapperDocumentType.class).getData();
    }

    @RequestMapping(value = "/hellow", method = RequestMethod.GET)
    public ResponseEntity<String> get1() {
        return ResponseEntity.ok("Hello World");
    }
}