package com.nemezis.components.controllers;

import com.nemezis.components.entity.Document;
import com.nemezis.components.entity.DocumentType;
import com.nemezis.components.service.DocumentService;
import com.nemezis.models.DocumentDto;
import com.nemezis.models.DocumentTypeDto;
import com.nemezis.models.Wrapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Главный контроллер
 */
@RestController
public class DocumentController {

    @Autowired private DocumentService documentService;
    @Autowired private MapperFacade mapperFacade;

    // DocumentType
    @GetMapping("/documentTypes")
    public Wrapper<List<DocumentTypeDto>> getDocumentTypes() {
        return Wrapper.create(documentService.getDocumentTypes());
    }

    @GetMapping("/documentTypes/{id}")
    public Wrapper<DocumentTypeDto> getDocumentTypeById(@PathVariable Long id) {
        return Wrapper.create(documentService.getDocumentTypeById(id));
    }

    @PutMapping("/documentTypes")
    public ResponseEntity putDocumentType(@RequestBody DocumentTypeDto documentTypeDto) {
        return ResponseEntity.ok(documentService.saveDocumentTypes(mapperFacade.map(documentTypeDto, DocumentType.class)));
    }

    @DeleteMapping("/documentTypes/{id}")
    public ResponseEntity deleteDocumentTypeById(@PathVariable Long id) {
        documentService.deleteDocumentTypeById(id);
        return ResponseEntity.ok().build();
    }

    // Documents
    @GetMapping("/documents")
    public Wrapper<List<DocumentDto>> getDocuments() {
        return Wrapper.create(mapperFacade.mapAsList(documentService.getDocuments(), DocumentDto.class));
    }

    @GetMapping("/documents/{id}")
    public Wrapper<DocumentDto> getDocumentById(@PathVariable Long id) {
        return Wrapper.create(documentService.getDocumentById(id));
    }

    @PutMapping("/documents")
    public ResponseEntity putDocument(@RequestBody DocumentDto documentDto) {
        return ResponseEntity.ok(documentService.saveDocument(mapperFacade.map(documentDto, Document.class)));
    }

    @DeleteMapping("/documents/{id}")
    public ResponseEntity deleteDocumentById(@PathVariable Long id) {
        documentService.deleteDocumentById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/documentTypes/{id}/documents")
    public List<DocumentDto> getDocumentsByDocumentTypeId(@PathVariable Long id) {
        return documentService.getDocumentsByDocumentTypeId(id);
    }
}