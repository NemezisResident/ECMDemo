package com.nemezis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Nemezis on 08.06.2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypeDto {

    private long id;
    private String type;
    private String text;
}
