package com.nemezis.components.dao;

import com.nemezis.components.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nemezis on 08.06.2019.
 */
@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
