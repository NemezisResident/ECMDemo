package com.nemezis.ecm.models;

import com.nemezis.models.DocumentTypeDto;
import com.nemezis.models.Wrapper;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@NoArgsConstructor
public class WrapperDocumentTypeList extends Wrapper<ArrayList<DocumentTypeDto>> {
    public WrapperDocumentTypeList(String message, ArrayList<DocumentTypeDto> data) {
        super(message, data);
    }
}