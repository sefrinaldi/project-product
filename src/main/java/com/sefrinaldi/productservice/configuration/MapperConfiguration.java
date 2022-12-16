package com.sefrinaldi.productservice.configuration;

import ma.glasnost.orika.MapperFactory;

public interface MapperConfiguration {
    void configure(MapperFactory mapperFactory);
}
