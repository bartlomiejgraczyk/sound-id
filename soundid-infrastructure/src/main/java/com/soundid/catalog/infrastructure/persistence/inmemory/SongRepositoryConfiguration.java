package com.soundid.catalog.infrastructure.persistence.inmemory;

import com.soundid.catalog.domain.repository.SongRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SongRepositoryConfiguration {
    @Bean
    SongRepository songRepository() {
        return new InMemorySongRepository();
    }
}
