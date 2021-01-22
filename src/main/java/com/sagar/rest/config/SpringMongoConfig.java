package com.sagar.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class SpringMongoConfig{

	@Autowired
    @Lazy
    private MappingMongoConverter mappingMongoConverter;

    public void afterPropertiesSet() throws Exception {
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }
    
}