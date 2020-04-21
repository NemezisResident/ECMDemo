package com.nemezis.components.controllers;

import com.nemezis.components.entity.Document;
import com.nemezis.components.service.DocumentService;
import com.nemezis.components.entity.DocumentType;
import com.nemezis.models.DocumentTypeDto;
import com.nemezis.models.Wrapper;
import ma.glasnost.orika.MapperFacade;
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
    @Autowired private MapperFacade mapperFacade;

    @GetMapping("/documentType")
    public List<DocumentType> getDocumentTypes() {
        return documentService.getDocumentTypes();
    }

    @GetMapping("/documentType/{id}")
    public Wrapper<DocumentTypeDto> getDocumentTypeById(@PathVariable Long id) {
        return Wrapper.create(mapperFacade.map(documentService.getDocumentTypeById(id), DocumentTypeDto.class));
    }

    @GetMapping("/document")
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }

}