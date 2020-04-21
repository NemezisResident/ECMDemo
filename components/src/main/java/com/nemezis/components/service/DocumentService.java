package com.nemezis.components.service;

import com.nemezis.components.controllers.DocumentController;
import com.nemezis.components.dao.DocumentRepository;
import com.nemezis.components.dao.DocumentTypeRepository;
import com.nemezis.components.entity.Document;
import com.nemezis.components.entity.DocumentType;
import com.nemezis.models.DocumentDto;
import com.nemezis.models.DocumentTypeDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Service
 */
@Service
public class DocumentService {

    @Autowired private MapperFacade mapperFacade;
    @Autowired private DocumentRepository documentRepository;
    @Autowired private DocumentTypeRepository documentTypeRepository;


    // DocumentType
    @Transactional(readOnly = true)
    public List<DocumentTypeDto> getDocumentTypes() {
        List<DocumentTypeDto> resultList = mapperFacade.mapAsList(documentTypeRepository.findAll(), DocumentTypeDto.class);

        // set Links
        resultList.forEach(item -> {
            Link selfLink = linkTo(methodOn(DocumentController.class)
                    .getDocumentTypeById(item.getDocumentTypeId())).withSelfRel();
            item.add(selfLink);

            Link documentsLink = linkTo(methodOn(DocumentController.class)
                    .getDocumentsByDocumentTypeId(item.getDocumentTypeId())).withRel("documents");
            item.add(documentsLink);
        });

        return resultList;
    }

    @Transactional(readOnly = true)
    public DocumentTypeDto getDocumentTypeById(Long id) {
        DocumentTypeDto documentTypeDto = mapperFacade.map(documentTypeRepository.getOne(id), DocumentTypeDto.class);

        Link documentsLink = linkTo(methodOn(DocumentController.class)
                .getDocumentsByDocumentTypeId(documentTypeDto.getDocumentTypeId())).withRel("documents");

        documentTypeDto.add(documentsLink);

        return documentTypeDto;
    }

    @Transactional()
    public DocumentType saveDocumentTypes(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    @Transactional()
    public void deleteDocumentTypeById(Long id) {
        documentTypeRepository.deleteById(id);
    }

    // Documents
    @Transactional(readOnly = true)
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @Transactional()
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Transactional(readOnly = true)
    public DocumentDto getDocumentById(Long id) {

        Document document = documentRepository.findById(id).orElse(new Document());
        DocumentDto documentDto = mapperFacade.map(document, DocumentDto.class);

        Link selfLink = linkTo(methodOn(DocumentController.class)
                .getDocumentById(documentDto.getDocumentId())).withSelfRel();

        documentDto.add(selfLink);

        return documentDto;
    }

    @Transactional()
    public void deleteDocumentById(Long id) {
        documentRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<DocumentDto> getDocumentsByDocumentTypeId(Long id) {

        List<DocumentDto> documentDtoList = mapperFacade.mapAsList(documentRepository.findByDocumentTypeId(id), DocumentDto.class);

        documentDtoList.forEach(item -> {
            Link selfLink = linkTo(methodOn(DocumentController.class)
                    .getDocumentById(item.getDocumentId())).withSelfRel();

            item.add(selfLink);
        });

        return documentDtoList;
    }
}
