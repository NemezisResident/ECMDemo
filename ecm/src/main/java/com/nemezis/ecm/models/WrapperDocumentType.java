package com.nemezis.ecm.models;

import com.nemezis.models.DocumentTypeDto;
import com.nemezis.models.Wrapper;
import lombok.NoArgsConstructor;

/**
 *
 */
@NoArgsConstructor
public class WrapperDocumentType extends Wrapper<DocumentTypeDto> {

    public WrapperDocumentType(String message, DocumentTypeDto data) {
        super(message, data);
    }
}