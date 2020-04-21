package com.nemezis;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableConfigurationProperties(OrikaProperties.class)
public class CommonConfiguration {

//    @ConditionalOnMissingBean
//    @Bean
//    public MapperFacade orikaMapperFacade(MapperFactory orikaMapperFactory) {
//        MapperFacade orikaMapperFacade = orikaMapperFactory.getMapperFacade();
//        return orikaMapperFacade;
//    }
}
