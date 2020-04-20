package com.nemezis.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * Created by Nemezis on 08.06.2019.
 */
@Entity
@Table(name = "doc_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "text")
    private String text;
}
