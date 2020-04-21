package com.nemezis.components.controllers;

import com.nemezis.components.entity.Document;
import com.nemezis.components.entity.DocumentType;
import com.nemezis.components.service.DocumentService;
import com.nemezis.models.DocumentDto;
import com.nemezis.models.DocumentTypeDto;
import com.nemezis.models.Wrapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


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

        List<DocumentTypeDto> resultList = mapperFacade.mapAsList(documentService.getDocumentTypes(), DocumentTypeDto.class);

        resultList.forEach(item -> {
            Link selfLink = linkTo(methodOn(DocumentController.class)
                    .getDocumentTypeById(item.getDocumentTypeId())).withSelfRel();
            item.add(selfLink);
        });

        return Wrapper.create(resultList);
    }

    @GetMapping("/documentTypes/{id}")
    public Wrapper<DocumentTypeDto> getDocumentTypeById(@PathVariable Long id) {
        return Wrapper.create(mapperFacade.map(documentService.getDocumentTypeById(id), DocumentTypeDto.class));
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
        return Wrapper.create(mapperFacade.map(documentService.getDocumentById(id), DocumentDto.class));
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
}