package com.nemezis.ecm.controllers;

import com.nemezis.ecm.models.*;
import com.nemezis.models.DocumentDto;
import com.nemezis.models.DocumentTypeDto;
import com.nemezis.models.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Главный контроллер
 */
@RestController
public class ECMController extends Client {


    ECMController() {
        super("");
    }

    // DocumentType
    @RequestMapping(value = "/document_types", method = RequestMethod.GET)
    public List<DocumentTypeDto> getDocumentTypes() {
        return get(URI_DOC_TYPE, WrapperDocumentTypeList.class).getData();
    }

    @RequestMapping(value = "/document_types/{id}", method = RequestMethod.GET)
    public DocumentTypeDto getDocumentTypeById(@PathVariable String id) {
        return get(URI_DOC_TYPE + "/" + id, WrapperDocumentType.class).getData();
    }

    @RequestMapping(value = "/document_types", method = RequestMethod.PUT)
    public ResponseEntity saveDocumentType(@RequestBody DocumentTypeDto documentTypeDto) {
        restTemplate.put(GATEWAY_PATH + URI_DOC_TYPE, documentTypeDto, WrapperDocumentType.class);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/document_types/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDocumentTypeById(@PathVariable String id) {
        restTemplate.delete(GATEWAY_PATH + URI_DOC_TYPE + "/" + id);
        return ResponseEntity.ok().build();
    }

    // Documents
    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public List<DocumentDto> getDocuments() {
        return get(URI_DOCS, WrapperDocumentList.class).getData();
    }

    @RequestMapping(value = "/documents/{id}", method = RequestMethod.GET)
    public DocumentDto getDocumentById(@PathVariable String id) {
        return get(URI_DOCS + "/" + id, WrapperDocument.class).getData();
    }

    @RequestMapping(value = "/documents", method = RequestMethod.PUT)
    public ResponseEntity saveDocument(@RequestBody DocumentDto documentDto) {
        restTemplate.put(GATEWAY_PATH + URI_DOCS, documentDto, WrapperDocument.class);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/documents/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDocumentById(@PathVariable String id) {
        restTemplate.delete(GATEWAY_PATH + URI_DOCS + "/" + id);
        return ResponseEntity.ok().build();
    }

    // Users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return get(URI_USERS, WrapperUserList.class).getData();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDto getUsersById(@PathVariable String id) {
        return get(URI_USERS + "/" + id, WrapperUser.class).getData();
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity saveUsers(@RequestBody UserDto UsersDto) {
        restTemplate.put(GATEWAY_PATH + URI_USERS, UsersDto, WrapperUser.class);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUsersById(@PathVariable String id) {
        restTemplate.delete(GATEWAY_PATH + URI_USERS + "/" + id);
        return ResponseEntity.ok().build();
    }
}