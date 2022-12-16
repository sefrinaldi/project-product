package com.sefrinaldi.productservice.configuration;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperFactoryConfiguration {
    public MapperFactoryConfiguration(MapperFactory mapperFactory, List<MapperConfiguration> mapperConfigurations) {
        mapperConfigurations.forEach(mapperConfiguration -> mapperConfiguration.configure(mapperFactory));
    }
}

