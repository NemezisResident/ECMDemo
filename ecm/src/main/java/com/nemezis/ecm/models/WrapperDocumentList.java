package com.nemezis.ecm.models;

import com.nemezis.models.DocumentDto;
import com.nemezis.models.Wrapper;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@NoArgsConstructor
public class WrapperDocumentList extends Wrapper<ArrayList<DocumentDto>> {
    public WrapperDocumentList(String message, ArrayList<DocumentDto> data) {
        super(message, data);
    }
}