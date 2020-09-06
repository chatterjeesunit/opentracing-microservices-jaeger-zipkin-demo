package com.spring.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by "Sunit Chatterjee" created on 06/09/20
 */
@Configuration
public class MapperConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }

}
