package com.nemezis.components.configs;

import com.nemezis.components.entity.Document;
import com.nemezis.models.DocumentDto;
import com.nemezis.models.DocumentTypeDto;
import com.nemezis.components.entity.DocumentType;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ComponentsConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()                                  
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();                                           
    }

    @Bean
    OrikaMapperFactoryConfigurer configureDocumentTypeDto() {
        return mapperFactory -> mapperFactory
                .classMap(DocumentTypeDto.class,
                        DocumentType.class)
                .field("documentTypeId","id")
                .byDefault()
                .register();
    }

    @Bean
    OrikaMapperFactoryConfigurer configureDocumentDto() {
        return mapperFactory -> mapperFactory
                .classMap(DocumentDto.class,
                        Document.class)
                .field("documentId","id")
                .byDefault()
                .register();
    }
}