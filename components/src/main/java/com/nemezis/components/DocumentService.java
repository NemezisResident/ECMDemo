package com.nemezis.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service
 */
@Service
public class DocumentService {

    @Autowired private DocumentRepository documentRepository;
    @Autowired private DocumentTypeRepository documentTypeRepository;


    @Transactional(readOnly = true)
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @Transactional()
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Transactional(readOnly = true)
    public List<DocumentType> getDocumentTypes() {
        return documentTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DocumentType getDocumentTypeById(Long id) {
        return documentTypeRepository.getOne(id);
    }

    @Transactional()
    public DocumentType saveDocumentTypes(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }
}
