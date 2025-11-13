package com.soundid.catalog.infrastructure.persistence.adapter;

import com.soundid.catalog.domain.repository.SongRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SongRepositoryAdapterConfiguration {
    @Bean
    SongRepository songRepository() {
        return new SongRepositoryAdapter();
    }
}
