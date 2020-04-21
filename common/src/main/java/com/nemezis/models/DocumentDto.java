package com.nemezis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import java.util.Date;

/**
 * Created by Nemezis on 08.06.2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto extends ResourceSupport {

    private long documentId;
    private DocumentTypeDto documentType;
    private Date dateFrom;
    private Date dateTo;
    private int userId;
}
