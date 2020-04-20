package com.nemezis.components.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Nemezis on 08.06.2019.
 */
@Entity
@Table(name = "documents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doc_type")
    private DocumentType documentType;

    @Column(name = "data1")
    private Date dateFrom;

    @Column(name = "data2")
    private Date dateTo;

    @Column(name = "user")
    private int userId;
}
