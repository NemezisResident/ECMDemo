package com.nemezis.ecm.models;

import com.nemezis.models.DocumentDto;
import com.nemezis.models.Wrapper;
import lombok.NoArgsConstructor;

/**
 *
 */
@NoArgsConstructor
public class WrapperDocument extends Wrapper<DocumentDto> {

    public WrapperDocument(String message, DocumentDto data) {
        super(message, data);
    }
}