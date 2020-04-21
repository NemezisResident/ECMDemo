package com.nemezis.models;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

/**
 * Created by Nemezis on 08.06.2019.
 */
public class DocumentTypeDto{

    private Long documentTypeId;
    private String type;
    private String text;

    public DocumentTypeDto(DocumentTypeDto content, Link... links) {
//        super(content, links);
    }

    public DocumentTypeDto(DocumentTypeDto content, Long documentTypeId, String type, String text, Link... links) {
//        super(content, links);
        this.documentTypeId = documentTypeId;
        this.type = type;
        this.text = text;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
