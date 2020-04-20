package com.nemezis.components.controllers;

import com.nemezis.components.entity.Document;
import com.nemezis.components.service.DocumentService;
import com.nemezis.components.entity.DocumentType;
import com.nemezis.models.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Главный контроллер
 */
@RestController
public class DocumentController {

    @Autowired private DocumentService documentService;

    @GetMapping("/documentType")
    public List<DocumentType> getDocumentTypes() {
        return documentService.getDocumentTypes();
    }

    @GetMapping("/documentType/{id}")
    public Wrapper<DocumentType> getDocumentTypeById(@PathVariable Long id) {
        return Wrapper.create(documentService.getDocumentTypeById(id));
    }

    @GetMapping("/document")
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }

}